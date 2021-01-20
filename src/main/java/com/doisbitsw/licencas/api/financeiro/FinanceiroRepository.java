package com.doisbitsw.licencas.api.financeiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {


   // @Query(value = "SELECT fin.* FROM financeiro fin  WHERE fin.code_processo = :codeProcesso", nativeQuery = true)
    List<Financeiro> findByCodeProcesso(String codeProcesso);

}
