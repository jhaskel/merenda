package com.doisbitsw.licencas.api.af;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AfRepository extends JpaRepository<Af, Long> {


    List<Af> findAll();



}
