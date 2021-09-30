package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "eintrag")
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Eintrag {
    @Id
    @Column(name = "EINTRAGID", unique = true)
    @NotNull
    private int eintragID;

    private String titel;

    private String beschreibung;

    private Date startdatum;

    private Date enddatum;

    private String ort;

    @OneToMany(mappedBy = "eintrag")
    private List<Eintrag_Tag> Eintrag;
}
