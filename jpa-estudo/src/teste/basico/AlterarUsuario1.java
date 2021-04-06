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
 *
 */
public class AlterarUsuario1 {

	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-estudo");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Alex de Carvalho");
		usuario.setEmail("alexcarvalho31@gmail.com");
		
		// Merge é responsavel por fazer update
		em.merge(usuario);
		em.getTransaction().commit();		
		
		System.out.println("Informações Atualizadas => Nome: "+usuario.getNome()+" E-mail: "+usuario.getEmail());
		em.close();
		emf.close();
	}

}
