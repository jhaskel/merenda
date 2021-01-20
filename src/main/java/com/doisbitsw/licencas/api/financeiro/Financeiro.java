package com.doisbitsw.licencas.api.financeiro;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Financeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String codeProcesso;
    private Long empreendimento;
    private Double valor;
    private String situacao;
    private String imagem;
    private Boolean ativo;
    private String created;
    private String modified;


}

