/**
 * 
 */
package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

/**
 * @author alex
 *
 */
public class NovoProduto {

	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		Produto produto = new Produto("Caixa de lápis colorida ", 33.21);
		dao.incluirAtomico(produto);
		
		System.out.println(
				" Produto ID: "+produto.getId()
				+"\n Nome: "+produto.getNome()
				+"\n Preço: R$ "+produto.getPreco()
				+"\n Mensagem: Produto "+produto.getNome()+", foi adicionado com sucesso na base de dados!");				
	}

}
