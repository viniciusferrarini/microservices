package br.com.softfocus.produtos.event;

import br.com.softfocus.produtos.model.Produto;
import org.springframework.context.ApplicationEvent;

public class ProdutoPersistEvent extends ApplicationEvent {

    private final Produto produto;

    public ProdutoPersistEvent(Object source, Produto produto) {
        super(source);
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

}
