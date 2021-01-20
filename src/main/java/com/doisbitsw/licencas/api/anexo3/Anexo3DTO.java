package com.doisbitsw.licencas.api.anexo3;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class Anexo3DTO {
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

    public static Anexo3DTO create(Anexo3 anexo3) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(anexo3, Anexo3DTO.class);
    }
}
