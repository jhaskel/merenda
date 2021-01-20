package com.doisbitsw.licencas.api.documentacao;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DocumentacaoDTO {
    private Long id;
    private String processo;
    private String documento;
    private String titulo;
    private String status;
    private String created;
    private String modified;
    private Boolean ativo;


    public static DocumentacaoDTO create(Documentacao documentacao) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(documentacao, DocumentacaoDTO.class);
    }
}
