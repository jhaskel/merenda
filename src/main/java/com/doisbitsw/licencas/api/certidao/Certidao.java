package com.doisbitsw.licencas.api.certidao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Certidao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String code_processo;
    private Long empreendedor;
    private Long empreendimento;
    private String atividade;
    private Double quantidade;
    private String unidade;
    private String local;
    private Double valor;
    private String status;
    private Boolean isento;
    private String created;
    private String modified;
    private Boolean ativo;



}

