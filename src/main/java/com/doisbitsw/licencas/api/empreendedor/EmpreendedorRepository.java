package com.doisbitsw.licencas.api.empreendedor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface EmpreendedorRepository extends JpaRepository<Empreendedor, Long> {


    List<Empreendedor> findByCode(String code);
    List<Empreendedor> findByCpf(String cpf);


}
