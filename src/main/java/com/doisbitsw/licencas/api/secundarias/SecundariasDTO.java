package com.doisbitsw.licencas.api.secundarias;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class SecundariasDTO {
    private Long id;
    private String processo;
    private String caracterizacao;
    private String atividade;
    private Double quantidade;
    private String unidade;
    private String porte;
    private String potencial;




    public static SecundariasDTO create(Secundarias secundarias) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(secundarias, SecundariasDTO.class);
    }
}
