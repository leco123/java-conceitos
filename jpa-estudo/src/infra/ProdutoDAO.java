package infra;
import modelo.basico.Produto;

public class ProdutoDAO extends DAO<Produto>{
	
	public ProdutoDAO() {
		super(Produto.class);
	}
	
	public double valorTotalDosProdutosListados() {
		return this.obterTodos()
				.stream()
				.map(p -> p.getPreco())
				.reduce(0.0, (t, p) -> t + p)
				.doubleValue();
	}
	
	public void imprimirListaDeProdutos() {
		System.out.println("LISTA DE PRODUTOS NA BASE DE DADOS \n");
		for (Produto prod: this.obterTodos()) {
			System.out.println(prod.getId()+" - "+prod.getNome()+" R$ "+prod.getPreco());
		}
		this.imprimirValorTotalDaListaDeProdutos();
	}
	
	public void imprimirValorTotalDaListaDeProdutos() {
		System.out.println("\n Valor total dos produtos R$ "+this.valorTotalDosProdutosListados());
	}
	

}
