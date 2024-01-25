package org.example.DAO;

import org.example.Classes.Concerto;
import org.example.Classes.Evento;
import org.example.Classes.Genere;
import org.example.Classes.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Concerto> getConcertiInStreaming(boolean bool) {
        TypedQuery<Concerto> concerti = em.createQuery("SELECT concert FROM Concerto concert WHERE concert.streaming=:bool",
                Concerto.class);
        concerti.setParameter("bool", bool);
        return concerti.getResultList();
    }


    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> concerti = em.createQuery("SELECT concert FROM Concerto concert WHERE concert.genere=:genere", Concerto.class);
        concerti.setParameter("genere", genere);
        return concerti.getResultList();
    }


    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        return em.createNamedQuery("partite_vinte_in_casa", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        return em.createNamedQuery("partite_vinte_in_trasferta", PartitaDiCalcio.class).getResultList();


    }

}
