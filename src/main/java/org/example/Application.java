package org.example;

import org.example.Classes.*;
import org.example.DAO.EventoDAO;
import org.example.DAO.LocationDAO;
import org.example.DAO.PartecipazioneDAO;
import org.example.DAO.PersonaDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {

            LocationDAO ld = new LocationDAO(em);
            PartecipazioneDAO pd = new PartecipazioneDAO(em);
            PersonaDAO persd = new PersonaDAO(em);
            EventoDAO ed = new EventoDAO(em);

            Location location1 = new Location("Bar angelini", "Roma");

            LocalDate annoDiNascita = LocalDate.of(1996, 07, 23);
            Persona persona1 = new Persona("Daniele", "Cagnoni", "daniele.010@hotmail.it", annoDiNascita, Sesso.M);


            LocalDate eventDate = LocalDate.of(1996, 1, 23);
            Evento evento1 = new Evento("Paperino e Squirtols", eventDate, "Una bella rimpatriata", TipoEvento.PRIVATO, 100, location1);

            Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, Stato.CONFERMATA);
            persd.save(persona1);
            ld.save(location1);
            ed.save(evento1);
            pd.save(partecipazione1);

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
