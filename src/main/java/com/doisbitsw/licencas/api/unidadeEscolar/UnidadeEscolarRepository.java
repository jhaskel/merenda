package com.doisbitsw.licencas.api.unidadeEscolar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnidadeEscolarRepository extends JpaRepository<UnidadeEscolar, Long> {

    @Query(value = "SELECT *  FROM unidade_escolar order by id;", nativeQuery = true)
    List<UnidadeEscolar> findAll();

    List<UnidadeEscolar> findCarroById(Long escola);

    @Query(value = "SELECT count(id) as quant  FROM unidade_escolar ", nativeQuery = true)
    long findQuantidade();

    @Query(value = "SELECT sum(alunos) as quantAlunos  FROM unidade_escolar ", nativeQuery = true)
    long findQuantAlunos();



}
