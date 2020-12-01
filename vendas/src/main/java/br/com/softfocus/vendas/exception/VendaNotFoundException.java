package br.com.softfocus.vendas.exception;

public class VendaNotFoundException extends RuntimeException {

    public VendaNotFoundException(Long id) {
        super("Venda código " + id + " não encontrada");
    }

}
