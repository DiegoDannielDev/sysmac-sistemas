package br.com.sysmac.dao;

import br.com.sysmac.repositorys.VendaItemRepository;

public class VendaItemDao {


    EntityManagerDao em;

    private VendaItemRepository vendaItemRepository;

    public VendaItemDao(EntityManagerDao em, VendaItemRepository vendaItemRepository) {
        this.em = em;
        this.vendaItemRepository = vendaItemRepository;
    }

//    public boolean deleteById(){
//
//    }
}
