package com.doisbitsw.licencas.api.tabela3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Tabela3Repository extends JpaRepository<Tabela3, Long> {

    @Query(value = "select * from tabela3  where tipo_licenca = :licenca and classe = :classe", nativeQuery = true)
    List<Tabela3> findByLicenca(String licenca, String classe);

}
