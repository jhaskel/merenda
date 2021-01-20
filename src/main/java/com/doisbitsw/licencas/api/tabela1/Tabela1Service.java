package com.doisbitsw.licencas.api.tabela1;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Tabela1Service {

    @Autowired

    private Tabela1Repository rep;
    public List<Tabela1DTO> getCarros() {
        List<Tabela1DTO> list = rep.findAll().stream().map(Tabela1DTO::create).collect(Collectors.toList());
        return list;
    }

    public Tabela1DTO getCarroById(Long id) {
        Optional<Tabela1> carro = rep.findById(id);
        return carro.map(Tabela1DTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public Tabela1DTO insert(Tabela1 tabela1) {
        Assert.isNull(tabela1.getId(),"Não foi possível inserir o registro");
        return Tabela1DTO.create(rep.save(tabela1));
    }

    public Tabela1DTO update(Tabela1 tabela1, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Tabela1> optional = rep.findById(id);
        if(optional.isPresent()) {
            Tabela1 db = optional.get();
            // Copiar as propriedades
            db.setFase(tabela1.getFase());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return Tabela1DTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }




    public List<Tabela1DTO> getEmpreendimentoByFase(Long fase) {
        return rep.findByFase(fase).stream().map(Tabela1DTO::create).collect(Collectors.toList());
    }



}
