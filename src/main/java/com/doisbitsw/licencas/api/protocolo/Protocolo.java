package com.doisbitsw.licencas.api.protocolo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Protocolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String codeProcesso;
    private String autor;
    private Long empreendedor;
    private Long empreendimento;
    private String descricao;
    private String created;


}

