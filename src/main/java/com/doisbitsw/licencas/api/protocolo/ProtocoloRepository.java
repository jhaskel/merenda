package com.doisbitsw.licencas.api.protocolo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long> {


    List<Protocolo> findByCode(String code);
    List<Protocolo> findByCodeProcesso(String codeProcesso);
    List<Protocolo> findByEmpreendedor(Long empreendedor);


}
