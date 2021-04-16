package br.com.projeto.estudo.conhecimentosb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.projeto.estudo.conhecimentosb.model.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {
	
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	public Iterable<Produto> findByPrecoContaining(double preco);
	
	public Iterable<Produto> findByDescontoContaining(double desconto);
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
}
