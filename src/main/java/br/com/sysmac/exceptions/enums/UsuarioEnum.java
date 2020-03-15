package br.com.sysmac.exceptions.enums;

public enum UsuarioEnum {
    USUARIO_CADASTRADO("Usuario cadastrado com sucesso"),
    USUARIO_INVALIDO("Usuario sem permissao para acessar sistema"),
    USUARIO_NOME_NULLO("Usuario com nome nullo"),
    USUARIO_SENHA_NULLO("Usuario com senha nulla");


    private String msg;

    UsuarioEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
