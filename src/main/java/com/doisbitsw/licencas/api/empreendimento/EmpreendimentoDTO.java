package com.doisbitsw.licencas.api.empreendimento;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EmpreendimentoDTO {
    private Long id;
    private Long empreendedor;
    private String code;
    private String nome;
    private String cpf;
    private String nomefantasia;
    private String matricula;
    private Double latitude;
    private Double longitude;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String celular;
    private String email;
    private String created;
    private String modified;
    private Boolean ativo;
    private String local;



    public static EmpreendimentoDTO create(Empreendimento empreendimento) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(empreendimento, EmpreendimentoDTO.class);
    }
}
