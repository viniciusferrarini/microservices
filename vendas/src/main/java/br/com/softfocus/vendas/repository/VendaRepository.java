package br.com.softfocus.vendas.repository;

import br.com.softfocus.vendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
