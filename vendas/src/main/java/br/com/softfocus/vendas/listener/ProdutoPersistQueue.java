package br.com.softfocus.vendas.listener;

import br.com.softfocus.vendas.model.Produto;
import org.springframework.context.ApplicationEvent;

public class ProdutoPersistQueue extends ApplicationEvent {

    private final Produto produto;

    public ProdutoPersistQueue(Object source, Produto produto) {
        super(source);
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

}
