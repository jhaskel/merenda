package com.doisbitsw.licencas.api.tabela3;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Tabela3Service {

    @Autowired

    private Tabela3Repository rep;
    public List<Tabela3DTO> getCarros() {
        List<Tabela3DTO> list = rep.findAll().stream().map(Tabela3DTO::create).collect(Collectors.toList());
        return list;
    }

    public Tabela3DTO getCarroById(Long id) {
        Optional<Tabela3> carro = rep.findById(id);
        return carro.map(Tabela3DTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public Tabela3DTO insert(Tabela3 tabela3) {
        Assert.isNull(tabela3.getId(),"Não foi possível inserir o registro");
        return Tabela3DTO.create(rep.save(tabela3));
    }

    public Tabela3DTO update(Tabela3 tabela3, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Tabela3> optional = rep.findById(id);
        if(optional.isPresent()) {
            Tabela3 db = optional.get();
            // Copiar as propriedades
            db.setClasse(tabela3.getClasse());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return Tabela3DTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }




    public List<Tabela3DTO> getEmpreendimentoByLicenca(String licenca,String classe) {
        return rep.findByLicenca(licenca,classe).stream().map(Tabela3DTO::create).collect(Collectors.toList());
    }



}
