package com.doisbitsw.licencas.api.secundarias;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecundariasRepository extends JpaRepository<Secundarias, Long> {



    List<Secundarias> findByProcesso(String empreendedor);

}
