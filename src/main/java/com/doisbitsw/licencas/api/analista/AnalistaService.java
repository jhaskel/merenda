package com.doisbitsw.licencas.api.analista;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnalistaService {

    @Autowired

    private AnalistaRepository rep;
    public List<AnalistaDTO> getCarros() {
        List<AnalistaDTO> list = rep.findAll().stream().map(AnalistaDTO::create).collect(Collectors.toList());
        return list;
    }

    public AnalistaDTO getCarroById(Long id) {
        Optional<Analista> carro = rep.findById(id);
        return carro.map(AnalistaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public AnalistaDTO insert(Analista analista) {
        Assert.isNull(analista.getId(),"Não foi possível inserir o registro");
        return AnalistaDTO.create(rep.save(analista));
    }

    public AnalistaDTO update(Analista analista, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Analista> optional = rep.findById(id);
        if(optional.isPresent()) {
            Analista db = optional.get();
            // Copiar as propriedades
            db.setConselho(analista.getConselho());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return AnalistaDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }






}
