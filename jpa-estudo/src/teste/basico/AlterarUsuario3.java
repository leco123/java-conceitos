package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-estudo");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, 7L);
		// define que o objeto "n�o esta no estado gerenci�vel", 
		// tamb�m � considerado o melhor e mais comum m�todo de se trabalhar com update
		em.detach(usuario);
		usuario.setNome("Alex de Carvalho Alterado 000");
		usuario.setEmail("alexcarvalho31@gmail.com");
		// pega o usu�rio que n�o esta no estado gerenci�vel e 
		// torna ele em um estado gerenci�vel e faz o update/marge
		em.merge(usuario);
		em.getTransaction().commit();		
		
		System.out.println("Informa��es Atualizadas => Nome: "+usuario.getNome()+" E-mail: "+usuario.getEmail());
		em.close();
		emf.close();

	}
}
