package com.doisbitsw.licencas.api.processo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {


    List<Processo> findByCode(String code);
    List<Processo> findByEmpreendedor(Long empreendedor);

}
