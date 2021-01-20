package com.doisbitsw.licencas.api.processo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String protocolo;
    private Long empreendedor;
    private Long empreendimento;
    private String caracterizacao;
    private String atividade;
    private String tipoLicenca;
    private String fase;
    private Double quantidade;
    private String unidade;
    private String local;
    private Double valor;
    private String status;
    private String obs;
    private String porte;
    private String potencial;
    private String classe;
    private Boolean isfatura_paga;
    private Boolean isemitida;
    private Boolean isisento;
    private Boolean issecundarias;
    private String created;
    private String modified;
    private Boolean ativo;
    private String nome_empreendedor;
    private String nome_empreendimento;
}

