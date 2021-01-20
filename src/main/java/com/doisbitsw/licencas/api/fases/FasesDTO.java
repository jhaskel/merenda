package com.doisbitsw.licencas.api.fases;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class FasesDTO {
    private Long id;
    private String nome;
    private Double fator_correcao;
    private Long tipo_licenca;




    public static FasesDTO create(Fases fases) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(fases, FasesDTO.class);
    }
}
