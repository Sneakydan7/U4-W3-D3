package org.example.Classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "partite_di_calcio")
@NamedQuery(name = "partite_vinte_in_casa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraCasa > p.numeroGolSquadraOspite")
@NamedQuery(name = "partite_vinte_in_trasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraCasa < p.numeroGolSquadraOspite")
public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra_di_casa", nullable = false)
    private String squadraDiCasa;
    @Column(name = "squadra_ospite", nullable = false)
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "numero_gol_casa")
    private int numeroGolSquadraCasa;
    @Column(name = "numero_gol_ospite")
    private int numeroGolSquadraOspite;


    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                           Integer numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;


    }


    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public int getNumeroGolSquadraCasa() {
        return numeroGolSquadraCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }


    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public void setNumeroGolSquadraCasa(int numeroGolSquadraCasa) {
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraCasa=" + numeroGolSquadraCasa +
                ", numeroGolSquadraOspite=" + numeroGolSquadraOspite +
                "} " + super.toString();
    }
}
