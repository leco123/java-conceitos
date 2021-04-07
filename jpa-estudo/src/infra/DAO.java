/**
 * 
 */
package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author alex
 * DATA ACCESS OBJECT
 * Somente class que implementarem Entidade vão conseguir usar o Generic do DAO
 * public class DAO<E extends Entidade> 
 */
public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	 /*
	  * Bloco static, carrega junto com a classe
	  * */
	static {
		try {
			emf = Persistence.createEntityManagerFactory("jpa-estudo");
		} catch (Exception e) {
			System.out.println("Opsss!!!! Falha na conexão com a base de dados!!!");
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	/**
	 * Abrir transação e retorna um método encadeado
	 * ex: this.abrirTransacao().abrirTransacao().abrirTransacao()...
	 * quantas vezes for necessário
	 * @return Object DAO<E>
	 */
	public DAO<E> abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}
	
	/**
	 * Fechar transação e retorna um método encadeado
	 * ex: this.fecharTransacao().fecharTransacao().fecharTransacao()...
	 * quantas vezes for necessário
	 * @return Object DAO<E>
	 */
	public DAO<E> fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}
	
	/**
	 * Incluir entidade a ser persistida
	 * @return Object DAO<E>
	 */
	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}
	
	/**
	 * Incluir entidade a ser persistida
	 * @return Object DAO<E>
	 */
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirTransacao()
				   .incluir(entidade)
				   .fecharTransacao();
	}
	
	public E obterPorID(Object id) {
		return em.find(classe, id);
	}
	
	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int qtd, int deslocamento) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		
		String jpql = "select e from "+classe.getName() +" e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtd);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	public List<E> consultar(String nomeConsulta, Object... params) {
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		for (int i = 0; i < params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i+1]);
		}
		return query.getResultList();
	}
	
	public void clearConexao() {
		em.clear();
	}

	public void fecharConexao() {
		em.close();
	}
	
}
