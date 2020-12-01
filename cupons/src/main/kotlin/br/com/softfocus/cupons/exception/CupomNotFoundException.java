package br.com.softfocus.cupons.exception;

public class CupomNotFoundException extends RuntimeException {

    public CupomNotFoundException(String message) {
        super(message);
    }

}
