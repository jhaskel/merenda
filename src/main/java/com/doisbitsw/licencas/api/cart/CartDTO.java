package com.doisbitsw.licencas.api.cart;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CartDTO {
    private Long id;
    private Long escola;
    private Long comprador;
    private Long produto;
    private String alias;
    private Double quantidade;
    private Double valor;
    private Double total;
    private String obs;
    private Long alunos;
    private String unidade;
    private String created;
    private Boolean ativo;
    private Long categoria;
    private Long fornecedor;

    public static CartDTO create(Cart cart) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cart, CartDTO.class);
    }
}
