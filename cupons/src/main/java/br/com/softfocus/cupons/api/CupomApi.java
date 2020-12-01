package br.com.softfocus.cupons.api;

import br.com.softfocus.cupons.exception.CupomNotFoundException;
import br.com.softfocus.cupons.model.Cupom;
import br.com.softfocus.cupons.repository.CupomRepository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("")
public class CupomApi {

    private final CupomRepository cupomRepository;

    public CupomApi(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    @PostMapping
    public Cupom save(@RequestParam("desconto") BigDecimal desconto) {
        var cupom = new Cupom(desconto);
        return cupomRepository.save(cupom);
    }

    @GetMapping
    public Iterable<Cupom> findAll() {
        return cupomRepository.findAll();
    }

    @GetMapping("{id}")
    public Cupom findById(@PathVariable("id") String id) {
        return cupomRepository.findById(id)
                .orElseThrow(() -> new CupomNotFoundException(("Cupom de código " + id + " não encontrado")));
    }

}
