package org.example.DAO;

import org.example.Classes.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;


    public EventoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(evento);
        transaction.commit();
    }


}
