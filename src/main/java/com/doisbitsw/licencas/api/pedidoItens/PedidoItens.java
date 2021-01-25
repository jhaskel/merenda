package com.doisbitsw.licencas.api.pedidoItens;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class PedidoItens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pedido;
    private Long escola;
    private Long nivel;
    private Long produto;
    private String alias;
    private Double quantidade;
    private Double valor;
    private Double total;
    private Boolean isaf;
    private String obs;
    private String created;
    private Long categoria;
    private Long fornecedor;
    private Boolean ischeck;






}

