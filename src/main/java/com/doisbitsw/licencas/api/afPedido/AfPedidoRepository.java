package com.doisbitsw.licencas.api.afPedido;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AfPedidoRepository extends JpaRepository<AfPedido, Long> {

    List<AfPedido> findAll();


}
