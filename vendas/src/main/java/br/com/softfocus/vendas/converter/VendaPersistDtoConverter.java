package br.com.softfocus.vendas.converter;

import br.com.softfocus.vendas.dto.VendaItemPersistDto;
import br.com.softfocus.vendas.dto.VendaPersistDto;
import br.com.softfocus.vendas.external.CupomService;
import br.com.softfocus.vendas.model.Produto;
import br.com.softfocus.vendas.model.Venda;
import br.com.softfocus.vendas.model.VendaItem;
import br.com.softfocus.vendas.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class VendaPersistDtoConverter {

    private final ProdutoRepository produtoRepository;

    private final CupomService cupomService;

    public VendaPersistDtoConverter(ProdutoRepository produtoRepository,
                                    CupomService cupomService) {
        this.produtoRepository = produtoRepository;
        this.cupomService = cupomService;
    }

    public Venda toVenda(VendaPersistDto dto) {

        Set<VendaItem> vendaItemList = new HashSet<>(dto.getItens().size());
        for (VendaItemPersistDto itemDto: dto.getItens()) {
            var optional = produtoRepository.findById(itemDto.getProduto());
            if (optional.isPresent()) {
                Produto produto = optional.get();
                var vendaItem = new VendaItem(produto, itemDto.getQuantidade(), itemDto.getValor());
                vendaItemList.add(vendaItem);
            }
        }

        BigDecimal desconto = BigDecimal.ZERO;
        if (dto.getCupom().isPresent()) {
            desconto = cupomService.getDescontoByCupom(dto.getCupom().get());
        }

        return new Venda(vendaItemList, BigDecimal.ZERO, dto.getEmail());

    }

}
