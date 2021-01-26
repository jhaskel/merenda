package com.doisbitsw.licencas.api.nivelEscolar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NivelEscolarRepository extends JpaRepository<NivelEscolar, Long> {

    @Query(value = "select nome from nivel_escolar where id = :id", nativeQuery = true)
    String findNome(Long id);

}
