package com.doisbitsw.licencas.api.financeiro;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FinanceiroService {

    @Autowired

    private FinanceiroRepository rep;
    public List<FinanceiroDTO> getFinanceiros() {
        List<FinanceiroDTO> list = rep.findAll().stream().map(FinanceiroDTO::create).collect(Collectors.toList());
        return list;
    }

    public FinanceiroDTO getFinanceiroById(Long id) {
        Optional<Financeiro> financeiro = rep.findById(id);
        return financeiro.map(FinanceiroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Financeiro não encontrado"));
    }



    public FinanceiroDTO insert(Financeiro financeiro) {
        Assert.isNull(financeiro.getId(),"Não foi possível inserir o registro");
        return FinanceiroDTO.create(rep.save(financeiro));
    }

    public FinanceiroDTO update(Financeiro financeiro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o financeiro no banco de dados
        Optional<Financeiro> optional = rep.findById(id);
        if(optional.isPresent()) {
            Financeiro db = optional.get();
            // Copiar as propriedades
            db.setAtivo(financeiro.getAtivo());
            db.setCode(financeiro.getCode());
            db.setCodeProcesso(financeiro.getCodeProcesso());
            db.setValor(financeiro.getValor());
            db.setSituacao(financeiro.getSituacao());

            System.out.println("Financeiro id " + db.getId());

            // Atualiza o financeiros
            rep.save(db);

            return FinanceiroDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<FinanceiroDTO> getFinanceiroByCodeProcesso(String codeProcesso) {
        return rep.findByCodeProcesso(codeProcesso).stream().map(FinanceiroDTO::create).collect(Collectors.toList());
    }



}
