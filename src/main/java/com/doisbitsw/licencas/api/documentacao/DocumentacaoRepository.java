package com.doisbitsw.licencas.api.documentacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentacaoRepository extends JpaRepository<Documentacao, Long> {


    List<Documentacao> findByProcesso(String processo);

}
