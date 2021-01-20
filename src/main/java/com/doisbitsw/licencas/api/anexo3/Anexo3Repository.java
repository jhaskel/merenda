package com.doisbitsw.licencas.api.anexo3;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Anexo3Repository extends JpaRepository<Anexo3, Long> {


    List<Anexo3> findByCode(String code);

}
