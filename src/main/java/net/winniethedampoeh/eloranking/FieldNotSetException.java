package net.winniethedampoeh.eloranking;

public class FieldNotSetException extends NullPointerException{
    protected FieldNotSetException() {
        this("");
    }

    protected FieldNotSetException(String s) {
        super("Make sure all fields are filled in before trying to access them. " + s);
    }
}
