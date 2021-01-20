package com.doisbitsw.licencas.api.analista;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AnalistaDTO {
    private Long id;
    private Long user;
    private String conselho;
    private String registro;
    private String titulo;
    private String nome;
    private String email;
    private Boolean ativo;

    public static AnalistaDTO create(Analista analista) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(analista, AnalistaDTO.class);
    }
}
