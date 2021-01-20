package com.doisbitsw.licencas.api.secundarias;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Secundarias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String processo;
    private String caracterizacao;
    private String atividade;
    private Double quantidade;
    private String unidade;
    private String porte;
    private String potencial;


}

