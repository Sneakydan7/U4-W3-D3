package org.example.DAO;

import org.example.Classes.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;


    public LocationDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
    }

    public Location getById(long id) {
        return em.find(Location.class, id);
    }

    public void delete(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(location);
        transaction.commit();
    }
}
