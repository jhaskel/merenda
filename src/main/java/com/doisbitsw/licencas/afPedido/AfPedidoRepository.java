package com.doisbitsw.licencas.afPedido;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AfPedidoRepository extends JpaRepository<AfPedido, Long> {
    @Query(value = "SELECT * FROM af WHERE ativo = TRUE ORDER BY id desc", nativeQuery = true)

    List<AfPedido> findAll();

    @Query(value = "SELECT * FROM af_pedido\n" +
            " WHERE af = :af ", nativeQuery = true)
    List<AfPedido> findByAf(Long af);

    @Query(value = "SELECT COUNT(id) as total FROM af WHERE ativo = TRUE AND isautorizado = false", nativeQuery = true)
    long findAf();


}
