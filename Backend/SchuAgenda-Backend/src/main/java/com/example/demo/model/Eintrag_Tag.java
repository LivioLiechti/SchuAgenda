package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "eintrag_tag")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
@IdClass(Eintrag_Tag_Pk.class)
public class Eintrag_Tag {

    @ManyToOne
    @EmbeddedId
    @NotNull
    @JoinColumn(name = "EINTRAGID")
    @Id
    private Eintrag eintrag;

    @ManyToOne
    @EmbeddedId
    @NotNull
    @JoinColumn(name = "TAGID")
    @Id
    private Tag tag;
}





