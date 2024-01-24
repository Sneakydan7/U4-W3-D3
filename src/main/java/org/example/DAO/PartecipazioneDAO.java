package org.example.DAO;

import org.example.Classes.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;


    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void delete(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(partecipazione);
        transaction.commit();
    }
}
