package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {

public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Assento assento = new Assento("4-F");
		Cliente cliente = new Cliente("Marcos da Silva", assento);
		
		dao.abrirTransacao()
			.incluir(assento)
			.incluir(cliente)
			.fecharTransacao()
			.fecharConexao();
	}

}
