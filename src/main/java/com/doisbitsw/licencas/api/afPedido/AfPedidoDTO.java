package com.doisbitsw.licencas.api.afPedido;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AfPedidoDTO {
    private Long id;
    private Long af;
    private String pedido;

       public static AfPedidoDTO create(AfPedido afPedido) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(afPedido, AfPedidoDTO.class);
    }
}
