package com.doisbitsw.licencas.api.tabela1;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class Tabela1DTO {
    private Long id;
    private Long fase;
    private String nome;
    private Double valor;



    public static Tabela1DTO create(Tabela1 tabela1) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tabela1, Tabela1DTO.class);
    }
}
