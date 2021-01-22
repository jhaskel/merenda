package com.doisbitsw.licencas.api.unidadeEscolar;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadeEscolarRepository extends JpaRepository<UnidadeEscolar, Long> {

    List<UnidadeEscolar> findByNivelescolar(Long escola);
}
