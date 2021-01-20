package com.doisbitsw.licencas.api.empreendimento;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Empreendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long empreendedor;
    private String code;
    private String nome;
    private String cpf;
    private String nomefantasia;
    private String matricula;
    private Double latitude;
    private Double longitude;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String celular;
    private String email;
    private String created;
    private String modified;
    private Boolean ativo;
    private String local;



}

