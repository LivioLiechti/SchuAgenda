package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Eintrag {
    @Id
    @Column(name = "EINTRAGID", unique = true)
    @NotNull
    private int eintragId;
    private String titel;
    private String beschreibung;
    private Date startDatum;
    private Date endDatum;
    private String ort;

    public Eintrag(String titel, String beschreibung, Date start, Date ende, String ort) {
        eintragTitel = titel;
        eintragBeschreibung = beschreibung;
        eintragStart = start;
        eintragEnde = ende;
        eintragOrt = ort;
    }
  
    public static void main(String [] args) {
        int ID = 0;
        Eintrag ID = new Eintrag(String titel, String beschreibung, Date start, Date ende, String ort);
        ID++;
    }
}