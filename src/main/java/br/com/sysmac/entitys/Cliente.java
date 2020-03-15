package br.com.sysmac.entitys;

import br.com.sysmac.emuns.ClienteTipoEmun;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String endereco;
    private ClienteTipoEmun tipoEmun;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ClienteTipoEmun getTipoEmun() {
        return tipoEmun;
    }

    public void setTipoEmun(ClienteTipoEmun tipoEmun) {
        this.tipoEmun = tipoEmun;
    }
}