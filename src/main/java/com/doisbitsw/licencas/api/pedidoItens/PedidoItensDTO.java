package com.doisbitsw.licencas.api.pedidoItens;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PedidoItensDTO {
    private Long id;
    private String pedido;
    private Long escola;
    private Long nivel;
    private Long produto;
    private String alias;
    private String nomeescola;
    private String nomenivel;
    private Double quantidade;
    private Double valor;
    private Double total;
    private Long af;
    private String obs;
    private String created;
    private Long categoria;
    private Long fornecedor;
    private Boolean ischeck;
    private Boolean isautorizado;


    public static PedidoItensDTO create(PedidoItens pedidoItens) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pedidoItens, PedidoItensDTO.class);
    }
}
