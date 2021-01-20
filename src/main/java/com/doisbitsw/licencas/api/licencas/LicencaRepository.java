package com.doisbitsw.licencas.api.licencas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicencaRepository extends JpaRepository<Licenca, Long> {

    List<Licenca> findByProcesso(String processo);
}
