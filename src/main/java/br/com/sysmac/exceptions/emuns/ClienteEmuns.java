package br.com.sysmac.exceptions.emuns;

public enum ClienteEmuns {

    CLIENTE_NULL("Cliente está em branco"),
    CLIENTE_BLOQUEADO("Cliente está bloqueado para compras");

    private final String msg;

    ClienteEmuns(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
