package br.com.exceptions;

import br.com.exceptions.enums.UsuarioEnum;


public class UsuarioExceptions extends RuntimeException {

    private static final UsuarioEnum usuarioEnum = null;
    private static final String msg = null;

    public UsuarioExceptions(String message) {
        super(message);
    }

    public UsuarioEnum getUsuarioEnum() {
        return usuarioEnum;
    }

    public String getMsg() {
        return msg;
    }
}
