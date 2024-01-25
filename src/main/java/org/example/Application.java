package org.example;

import org.example.Classes.*;
import org.example.DAO.EventoDAO;
import org.example.DAO.LocationDAO;
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
            EventoDAO ed = new EventoDAO(em);
            PersonaDAO pd = new PersonaDAO(em);

            Persona persona1 = new Persona("Daniele", "Cagnoni", "daniele.010@hotmail.it", LocalDate.of(1996, 7, 23), Sesso.M);

            Location location1 = new Location("Bar angelini", "Roma");
            Location location2 = new Location("Pala lottomatica", "Roma");
            Location location3 = new Location("Auditorium", "Roma");


            PartitaDiCalcio partita1 = new PartitaDiCalcio("Un'altra partita", LocalDate.now().plusDays(1), "Bellissima!", TipoEvento.PUBBLICO, 800000, location1, "SquadraA", "SquadraB");
            PartitaDiCalcio partita2 = new PartitaDiCalcio("Ancora un'altra partita", LocalDate.now().plusDays(2), "Bella partita", TipoEvento.PUBBLICO, 900000, location2, "SquadraX", "SquadraY");
            PartitaDiCalcio partita3 = new PartitaDiCalcio("Classico del calcio", LocalDate.now().plusDays(3), "Sfida classica", TipoEvento.PUBBLICO, 950000, location3, "SquadraDiCasa", "SquadraOspite");
            partita1.setNumeroGolSquadraCasa(5);
            partita1.setNumeroGolSquadraOspite(4);
            partita1.setSquadraVincente("SquadraA");
            partita2.setNumeroGolSquadraCasa(2);
            partita2.setNumeroGolSquadraOspite(5);
            partita2.setSquadraVincente("SquadraY");
            partita3.setNumeroGolSquadraCasa(0);
            partita3.setNumeroGolSquadraCasa(0);


            Concerto concerto1 = new Concerto("Max Pezzali", LocalDate.now().plusDays(1), "Concertone", TipoEvento.PUBBLICO, 20000, location2, Genere.ROCK, true);
            Concerto concerto2 = new Concerto("Vasco Rossi", LocalDate.now().plusDays(3), "Live 2024", TipoEvento.PUBBLICO, 25000, location3, Genere.ROCK, true);
            Concerto concerto3 = new Concerto("Laura Pausini", LocalDate.now().plusDays(5), "Inedito Tour", TipoEvento.PUBBLICO, 18000, location1, Genere.POP, true);
            Concerto concerto4 = new Concerto("Eros Ramazzotti", LocalDate.now().plusDays(7), "Vita Nova", TipoEvento.PUBBLICO, 22000, location3, Genere.POP, false);

            GaraDiAtletica gara1 = new GaraDiAtletica("Gara di salti", LocalDate.now().plusDays(1), "Grande gara", TipoEvento.PUBBLICO, 1000, location1);
            GaraDiAtletica gara2 = new GaraDiAtletica("Gara di mani", LocalDate.now().plusDays(2), "Grande gara", TipoEvento.PUBBLICO, 1000, location1);

            pd.save(persona1);


            ld.save(location1);
            ld.save(location2);
            ld.save(location3);


            ed.save(partita1);
            ed.save(partita2);
            ed.save(partita3);


            ed.save(concerto1);
            ed.save(concerto2);
            ed.save(concerto3);
            ed.save(concerto4);

            ed.save(gara1);
            ed.save(gara2);

            System.out.println("--------partite vinte in casa--------");
            ed.getPartiteVinteInCasa().forEach(System.out::println);
            System.out.println("--------partite vinte in trasferta--------");
            ed.getPartiteVinteInTrasferta().forEach(System.out::println);

            System.out.println("------concerti per genere-----");
            ed.getConcertiPerGenere(Genere.POP).forEach(System.out::println);
            System.out.println("------concerti in streamingsss-----");
            ed.getConcertiInStreaming(true).forEach(System.out::println);


        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
