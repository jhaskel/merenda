package com.doisbitsw.licencas.api.af;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AfRepository extends JpaRepository<Af, Long> {


    List<Af> findAll();

    @Query(value = "SELECT * FROM af\n" +
            " WHERE fornecedor = :fornecedor AND ativo = TRUE AND isautorizado = true ", nativeQuery = true)
    List<Af> findByFornecedor(Long fornecedor);



}
