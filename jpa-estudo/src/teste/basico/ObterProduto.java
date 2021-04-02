package teste.basico;

import infra.ProdutoDAO;

public class ObterProduto {
	
	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		dao.imprimirListaDeProdutos();
	}

}
