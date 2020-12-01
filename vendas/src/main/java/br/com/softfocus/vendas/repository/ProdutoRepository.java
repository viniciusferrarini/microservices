package br.com.softfocus.vendas.repository;

import br.com.softfocus.vendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
