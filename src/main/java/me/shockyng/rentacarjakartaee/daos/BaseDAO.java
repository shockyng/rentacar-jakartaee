package me.shockyng.rentacarjakartaee.daos;

import jakarta.persistence.*;
import me.shockyng.rentacarjakartaee.exceptions.NoDataAtTheDataBaseException;

import java.util.List;
import java.util.Objects;

public abstract class BaseDAO<E, ID extends Number> {

    private final EntityManager entityManager;
    protected Class<E> entityClass;

    public BaseDAO(Class<E> entityClass) {
        this.entityClass = entityClass;
        Persistence.createEntityManagerFactory("rentacar-pu");
        this.entityManager = Persistence.createEntityManagerFactory("rentacar-pu").createEntityManager();
    }

    public E findOneById(ID id) {
        E entity = entityManager.find(entityClass, id);
        verifyIfEntityNull(entity, id);
        return entity;
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
        verifyIfEntityNull(entity, id);
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

    private void verifyIfEntityNull(E entity, ID id) {
        if (Objects.isNull(entity)) throw new NoDataAtTheDataBaseException(entityClass, id);
    }

    public List<E> searchByName(String name) {
        return entityManager
                .createQuery(
                        String.format(
                                "select e from %s e where e.name like :name",
                                entityClass.getName()),
                        entityClass
                )
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
