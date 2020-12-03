package br.com.softfocus.produtos.api;


import br.com.softfocus.produtos.model.Produto;
import br.com.softfocus.produtos.repository.ProdutoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("")
public class ProdutoApi {

    @Autowired private ProdutoRepository repository;
    @Autowired private JmsTemplate jmsTemplate;
    @Autowired private ObjectMapper objectMapper;

    @GetMapping
    public List<Produto> all() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Produto> one(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Produto insert(@RequestBody Produto produto) throws JsonProcessingException {
        repository.save(produto);

        var produtoJson = objectMapper.writeValueAsString(produto);
        jmsTemplate.convertAndSend("queue.produto.insert", produtoJson);

        return produto;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        repository.deleteById(id);
    }

}
