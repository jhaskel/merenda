package com.doisbitsw.licencas.api.pedidos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PedidoDTO {
    private Long id;
    private String code;
    private String nomeescola;
    private Long escola;
    private Long nivel;
    private Double total;
    private Long comprador;
    private String status;
    private Long semana;
    private Boolean isaf;
    private String created;
    private String modified;
    private Boolean ativo;
    private Boolean ischeck;
    private Boolean iscart;

    private Long totalCart;
    private Long temCart;


    public static PedidoDTO create(Pedido pedido) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pedido, PedidoDTO.class);
    }
}
