package com.doisbitsw.licencas.api.certidao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertidaoRepository extends JpaRepository<Certidao, Long> {


    List<Certidao> findByCode(String code);
    List<Certidao> findByEmpreendedor(Long empreendedor);
    List<Certidao> findByEmpreendimento(Long empreendimento);
}
