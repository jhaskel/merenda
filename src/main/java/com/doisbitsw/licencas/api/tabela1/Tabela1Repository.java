package com.doisbitsw.licencas.api.tabela1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tabela1Repository extends JpaRepository<Tabela1, Long> {


    List<Tabela1> findByFase(Long fase);

}
