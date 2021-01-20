package com.doisbitsw.licencas.api.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double ufm;
    private String administrador;
    private String cargo;
    private String celular;
    private String email;
    private String sexo;
    private String cidade;
    private String created;
    private String modified;
    private Boolean ativo;



}

