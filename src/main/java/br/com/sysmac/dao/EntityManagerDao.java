package br.com.sysmac.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerDao {

    @PersistenceContext
    protected EntityManager entityManager;


    protected void addAnd(StringBuilder queryStr) {
        if (queryStr.toString().toUpperCase().contains(" WHERE ")) {
            queryStr.append(" AND ");
        } else {
            queryStr.append(" WHERE ");
        }
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
