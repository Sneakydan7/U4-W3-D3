package org.example.Classes;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "concerto")
public class Concerto extends Evento {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genere genere;
    @Column(nullable = false)
    private Boolean streaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                    Integer numeroMassimoPartecipanti, Location location, Genere genere, Boolean streaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.streaming = streaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Boolean getStreaming() {
        return streaming;
    }

    public void setStreaming(Boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", streaming=" + streaming +
                "} " + super.toString();
    }
}
