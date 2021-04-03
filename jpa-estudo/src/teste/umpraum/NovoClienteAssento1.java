package teste.umpraum;

import infra.AssentoDAO;
import infra.ClienteDAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {

	public static void main(String[] args) {
		
		AssentoDAO assentoDAO = new AssentoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Assento assento = new Assento("18-A");
		Cliente cliente = new Cliente("Alex de Carvalho", assento);
					
		// assim acontece erro porque precisa ser incluido primiro o assento e depois o cliente
		// bject references an unsaved transient instance - save the transient instance before
		//clienteDAO.incluirAtomico(cliente);
		//assentoDAO.incluirAtomico(assento);
		
		// assim é o correto
		assentoDAO.incluirAtomico(assento);
		clienteDAO.incluirAtomico(cliente);
	}

}
