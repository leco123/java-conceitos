package teste.umpraum;

import infra.AssentoDAO;
import infra.ClienteDAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {

public static void main(String[] args) {
		
		AssentoDAO assentoDAO = new AssentoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Assento assento = new Assento("4-F");
		Cliente cliente = new Cliente("Marcos da Silva", assento);

		assentoDAO.incluirAtomico(assento);
		clienteDAO.incluirAtomico(cliente);
	}

}
