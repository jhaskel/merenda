package com.doisbitsw.licencas.api.fases;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FasesService {

    @Autowired

    private FasesRepository rep;
    public List<FasesDTO> getCarros() {
        List<FasesDTO> list = rep.findAll().stream().map(FasesDTO::create).collect(Collectors.toList());
        return list;
    }

    public FasesDTO getCarroById(Long id) {
        Optional<Fases> carro = rep.findById(id);
        return carro.map(FasesDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public FasesDTO insert(Fases fases) {
        Assert.isNull(fases.getId(),"Não foi possível inserir o registro");
        return FasesDTO.create(rep.save(fases));
    }

    public FasesDTO update(Fases fases, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Fases> optional = rep.findById(id);
        if(optional.isPresent()) {
            Fases db = optional.get();
            // Copiar as propriedades
            db.setNome(fases.getNome());
            db.setFator_correcao(fases.getFator_correcao());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return FasesDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }





}
