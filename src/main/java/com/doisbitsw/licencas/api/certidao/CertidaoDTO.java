package com.doisbitsw.licencas.api.certidao;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CertidaoDTO {
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



    public static CertidaoDTO create(Certidao certidao) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(certidao, CertidaoDTO.class);
    }
}
