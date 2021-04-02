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
 *  	Gerente das Entidades, que s�o classes mapeadas com ORM, com anota��es para o banco de dados
 *  	Respons�vel por:
 *  	-Inserir
 *  	-Deletar
 *  	-Atualizar
 *  	-Consulta
 *  	 � respons�vel por fazer o CRUD, uma intera��o com o banco de dados
 *  -
 * */
public class NovoUsuario {
	
	public static void main(String[] args) {
		
		// Respons�vel por criar o EntityManager
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
