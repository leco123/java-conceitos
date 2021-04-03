package teste.umpraum;

import infra.AssentoDAO;
import infra.ClienteDAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class ObterClienteAssento {

	public static void main(String[] args) {
		
		ClienteDAO daoCliente = new ClienteDAO();
		AssentoDAO daoAssento = new AssentoDAO();
		
		Cliente cliente = daoCliente.obterPorID(1L);
		System.out.println("Cliente: "+cliente.getNome());
		
		Assento assento = daoAssento.obterPorID(1L);
		System.out.println("Assento: "+assento.getNome());
		
		daoCliente.fecharConexao();
		daoAssento.fecharConexao();
	}

}
