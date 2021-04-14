package br.com.projeto.estudo.conhecimentosb.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.estudo.conhecimentosb.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
