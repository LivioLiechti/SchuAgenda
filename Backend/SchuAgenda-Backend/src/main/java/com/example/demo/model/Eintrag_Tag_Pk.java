package com.example.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode
public class Eintrag_Tag_Pk implements Serializable {
    int eintrag;
    int tag;
}
