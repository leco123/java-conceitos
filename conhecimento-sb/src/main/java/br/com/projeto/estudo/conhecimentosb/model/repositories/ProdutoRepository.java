package br.com.projeto.estudo.conhecimentosb.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.projeto.estudo.conhecimentosb.model.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

}
