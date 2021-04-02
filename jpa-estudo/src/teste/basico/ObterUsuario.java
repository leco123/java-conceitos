package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsuario {

	public static void main(String[] args) {
		// Responsável por criar o EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-estudo");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 3L);
		System.out.println(usuario.getNome());
	
		em.close();
		emf.close();
	}

}
