package com.doisbitsw.licencas.api.pedidos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    @Query(value = "SELECT *  FROM pedido WHERE code = :pedido;", nativeQuery = true)
    List<Pedido> findByPedido(String pedido);

}
