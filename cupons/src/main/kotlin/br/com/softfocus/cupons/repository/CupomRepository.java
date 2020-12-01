package br.com.softfocus.cupons.repository;

import br.com.softfocus.cupons.model.Cupom;
import org.springframework.data.repository.CrudRepository;

public interface CupomRepository extends CrudRepository<Cupom, String> {
}
