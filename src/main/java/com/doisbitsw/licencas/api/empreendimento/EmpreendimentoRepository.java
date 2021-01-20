package com.doisbitsw.licencas.api.empreendimento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {


    List<Empreendimento> findByCode(String code);
    List<Empreendimento> findByEmpreendedor(Long empreendedor);
    List<Empreendimento> findByCpf(String cpf);
}
