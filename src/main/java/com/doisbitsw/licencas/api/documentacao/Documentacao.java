package com.doisbitsw.licencas.api.documentacao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Documentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String processo;
    private String documento;
    private String titulo;
    private String status;
    private String created;
    private String modified;
    private Boolean ativo;
}

