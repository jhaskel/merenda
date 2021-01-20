package com.doisbitsw.licencas.api.anexo3;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Anexo3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String nome;
    private String potPoluidorGeral;
    private Double porteMinimo;
    private Double portePequeno;
    private String estudoP;
    private Double porteMedio;
    private String estudoM;
    private Double porteGrande;
    private String estudoG;
    private String unidade;
    private String obs;
    private Boolean aua;
    private Boolean auap;
    private Boolean auas;
    private Boolean auam;
    private Boolean ativo;
    private Boolean calculoDiferenciado;



}

