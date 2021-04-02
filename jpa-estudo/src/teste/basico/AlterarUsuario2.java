/**
 * 
 */
package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

/**
 * @author alex
 * Exemplo de estado gerenciavel
 */
public class AlterarUsuario2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-estudo");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Alex de Carvalho Alterado");
		usuario.setEmail("alexcarvalho31@gmail.com");
		// mesmo comentando a linha abaixo será possivel salvar a 
		// informação na base de dados porque a conexão esta em um estado gerenciavel
		// em.merge(usuario);
		em.getTransaction().commit();		
		
		System.out.println("Informações Atualizadas => Nome: "+usuario.getNome()+" E-mail: "+usuario.getEmail());
		em.close();
		emf.close();

	}

}
