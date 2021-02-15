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

    @Query(value = "SELECT COUNT(id) AS totalCart FROM pedido WHERE ischeck = false", nativeQuery = true)
    long findCart();

    @Query(value = "SELECT id FROM pedido order by id desc limit 1", nativeQuery = true)
    long findUltimoId();


    @Query(value = "SELECT id FROM pedido where escola = :escola and iscart = true limit 1", nativeQuery = true)
    long findTemCart(Long escola);

}
