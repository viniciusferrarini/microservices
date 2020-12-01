package br.com.softfocus.vendas.api;

import br.com.softfocus.vendas.converter.VendaPersistDtoConverter;
import br.com.softfocus.vendas.dto.VendaPersistDto;
import br.com.softfocus.vendas.model.Venda;
import br.com.softfocus.vendas.repository.VendaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class VendaApi {

    private final VendaPersistDtoConverter converter;

    private final VendaRepository vendaRepository;

    public VendaApi(VendaPersistDtoConverter converter, VendaRepository vendaRepository) {
        this.converter = converter;
        this.vendaRepository = vendaRepository;
    }

    @PostMapping
    public Venda insert(@RequestBody VendaPersistDto dto) {
        var venda = converter.toVenda(dto);
        return vendaRepository.save(venda);
    }

    @GetMapping
    public List<Venda> all() {
        return vendaRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Venda> one(@PathVariable("id") Long id) {
        return vendaRepository.findById(id);
    }

}
