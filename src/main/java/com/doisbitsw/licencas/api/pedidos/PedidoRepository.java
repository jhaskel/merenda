package com.doisbitsw.licencas.api.pedidos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT *  FROM pedido  order by id desc;", nativeQuery = true)
    List<Pedido> findAll();

    @Query(value = "SELECT *  FROM pedido where code = :code order by id desc;", nativeQuery = true)
    List<Pedido> findByCode(String code);

    @Query(value = "SELECT *  FROM pedido where escola = :escola order by id desc;", nativeQuery = true)
    List<Pedido> findByEscola(Long escola);

}
