package com.doisbitsw.licencas.api.tabela3;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class Tabela3DTO {
    private Long id;
    private String tipoLicenca;
    private String classe;
    private Double valor;



    public static Tabela3DTO create(Tabela3 tabela3) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tabela3, Tabela3DTO.class);
    }
}
