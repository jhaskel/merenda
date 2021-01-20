package com.doisbitsw.licencas.api.anexo3;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Anexo3Service {

    @Autowired

    private Anexo3Repository rep;
    public List<Anexo3DTO> getCarros() {
        List<Anexo3DTO> list = rep.findAll().stream().map(Anexo3DTO::create).collect(Collectors.toList());
        return list;
    }

    public Anexo3DTO getCarroById(Long id) {
        Optional<Anexo3> carro = rep.findById(id);
        return carro.map(Anexo3DTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public Anexo3DTO insert(Anexo3 anexo3) {
        Assert.isNull(anexo3.getId(),"Não foi possível inserir o registro");
        return Anexo3DTO.create(rep.save(anexo3));
    }

    public Anexo3DTO update(Anexo3 anexo3, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Anexo3> optional = rep.findById(id);
        if(optional.isPresent()) {
            Anexo3 db = optional.get();
            // Copiar as propriedades
            db.setCode(anexo3.getCode());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return Anexo3DTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }




    public List<Anexo3DTO> getEmpreendimentoByCode(String code) {
        return rep.findByCode(code).stream().map(Anexo3DTO::create).collect(Collectors.toList());
    }



}
