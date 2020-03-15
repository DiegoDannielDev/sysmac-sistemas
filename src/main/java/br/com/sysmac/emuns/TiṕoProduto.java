package br.com.sysmac.emuns;

public enum TiṕoProduto {

    KG("KG"),
    UN("UN"),
    CX("CX"),
    FR("FR");

    private final String msg;

    TiṕoProduto(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
