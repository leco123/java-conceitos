package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

/*
 *  Interagir com as class do JPA para fazer o crud
 *  
 *  Precisa trabalhar com 2(dois) objetos
 *  - EntityManager
 *  	Gerente das Entidades, que são classes mapeadas com ORM, com anotações para o banco de dados
 *  	Responsável por:
 *  	-Inserir
 *  	-Deletar
 *  	-Atualizar
 *  	-Consulta
 *  	 é responsável por fazer o CRUD, uma interação com o banco de dados
 *  -
 * */
public class NovoUsuario {
	
	public static void main(String[] args) {
		
		// Responsável por criar o EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-estudo");
		EntityManager em = emf.createEntityManager();
		
		Usuario novoUsuario = new Usuario("Alex de Carvalho", "alex@lanche.com.br");
		
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		System.out.println("O Id gerado foi: "+novoUsuario.getId());
		
		em.close();
		emf.close();
		
		 
	}

}
