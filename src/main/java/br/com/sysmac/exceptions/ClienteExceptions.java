package br.com.sysmac.exceptions;

public class ClienteExceptions extends RuntimeException {

    private final String msg;

    public ClienteExceptions(String msg) {
        this.msg = msg;
    }

    public ClienteExceptions(String message, String msg) {
        super(message);
        this.msg = msg;
    }

    public ClienteExceptions(String message, Throwable cause, String msg) {
        super(message, cause);
        this.msg = msg;
    }
}
