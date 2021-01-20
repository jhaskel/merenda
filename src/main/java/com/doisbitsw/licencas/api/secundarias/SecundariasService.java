package com.doisbitsw.licencas.api.secundarias;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SecundariasService {

    @Autowired

    private SecundariasRepository rep;
    public List<SecundariasDTO> getCarros() {
        List<SecundariasDTO> list = rep.findAll().stream().map(SecundariasDTO::create).collect(Collectors.toList());
        return list;
    }

    public SecundariasDTO getCarroById(Long id) {
        Optional<Secundarias> carro = rep.findById(id);
        return carro.map(SecundariasDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public SecundariasDTO insert(Secundarias secundarias) {
        Assert.isNull(secundarias.getId(),"Não foi possível inserir o registro");
        return SecundariasDTO.create(rep.save(secundarias));
    }

    public SecundariasDTO update(Secundarias secundarias, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Secundarias> optional = rep.findById(id);
        if(optional.isPresent()) {
            Secundarias db = optional.get();
            // Copiar as propriedades
            db.setCaracterizacao(secundarias.getCaracterizacao());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return SecundariasDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }




    public List<SecundariasDTO> getEmpreendimentoByProcesso(String processo) {
        return rep.findByProcesso(processo).stream().map(SecundariasDTO::create).collect(Collectors.toList());
    }


}
