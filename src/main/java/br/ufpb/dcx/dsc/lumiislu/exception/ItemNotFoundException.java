package br.ufpb.dcx.dsc.lumiislu.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException() {
        super("Item not found");
    }

}
