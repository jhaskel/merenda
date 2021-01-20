package com.doisbitsw.licencas.api.licencas;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Licenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String processo;
    private String tipoLicenca;
    private String admin;
    private String status;
    private Long validade;
    private Boolean emitida;
    private Long empreendimento;
    private String created;
    private String modified;
    private Boolean ativo;
}

