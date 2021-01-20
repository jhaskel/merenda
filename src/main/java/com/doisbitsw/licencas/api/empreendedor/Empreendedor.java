package com.doisbitsw.licencas.api.empreendedor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Empreendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String bairro;
    private String celular;
    private String cep;
    private String cidade;
    private String complemento;
    private String cpf;
    private String created;
    private String email;
    private String estado;
    private String logradouro;
    private String modified;
    private String numero;
    private String code;
    private Boolean ativo;



}

