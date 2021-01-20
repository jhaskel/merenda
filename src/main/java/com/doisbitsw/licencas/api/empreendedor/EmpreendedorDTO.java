package com.doisbitsw.licencas.api.empreendedor;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EmpreendedorDTO {
    private Long id;
    private String nome;
    private String bairro;
    private String celular;
    private String cep;
    private String cidade;
    private String complemento;
    private String cpf;
    private String created;
    private String email;
    private String estado;
    private String logradouro;
    private String modified;
    private String numero;
    private Boolean ativo;
    private String code;



    public static EmpreendedorDTO create(Empreendedor empreendedor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(empreendedor, EmpreendedorDTO.class);
    }
}
