package com.doisbitsw.licencas.api.config;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ConfigDTO {
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



    public static ConfigDTO create(Config config) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(config, ConfigDTO.class);
    }
}
