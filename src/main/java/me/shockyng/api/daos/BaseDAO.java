package me.shockyng.api.daos;

import jakarta.persistence.*;

import java.util.List;

public abstract class BaseDAO<E, ID extends Number> {

    private final EntityManager entityManager;
    protected Class<E> entityClass;

    public BaseDAO(Class<E> entityClass) {
        this.entityClass = entityClass;
        this.entityManager = Persistence.createEntityManagerFactory("rentacar-pu").createEntityManager();
    }

    public E findOneById(ID id) {
        return entityManager.find(entityClass, id);
    }

    public List<E> findAll() {
        return entityManager
                .createQuery(String.format("select e from %s e", entityClass.getName()), entityClass)
                .getResultList();
    }

    public E save(E entity) {
        beginTransaction();
        entityManager.persist(entity);
        commitTransaction();
        return entity;
    }

    public void delete(ID id) {
        E entity = findOneById(id);
        beginTransaction();
        entityManager.remove(entity);
        commitTransaction();
    }

    private void beginTransaction() {
        try {
            entityManager.getTransaction().begin();
        } catch (IllegalStateException e) {
            rollBackTransaction();
        }
    }

    private void commitTransaction() {
        try {
            entityManager.getTransaction().commit();
        } catch (IllegalStateException | RollbackException e) {
            rollBackTransaction();
        }
    }

    private void rollBackTransaction() {
        try {
            entityManager.getTransaction().rollback();
        } catch (IllegalStateException | PersistenceException e) {
            e.printStackTrace();
        }
    }
}
