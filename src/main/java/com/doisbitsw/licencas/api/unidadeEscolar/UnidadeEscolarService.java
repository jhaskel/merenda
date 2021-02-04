package com.doisbitsw.licencas.api.unidadeEscolar;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnidadeEscolarService {

    @Autowired

    private UnidadeEscolarRepository rep;
    public List<UnidadeEscolarDTO> getNivel() {
        List<UnidadeEscolarDTO> list = rep.findAll().stream().map(UnidadeEscolarDTO::create).collect(Collectors.toList());
        return list;
    }

    public UnidadeEscolarDTO getNivelById(Long id) {
        Optional<UnidadeEscolar> carro = rep.findById(id);
        return carro.map(UnidadeEscolarDTO::create).orElseThrow(() -> new ObjectNotFoundException("Nivel não encontrado"));
    }


    public List<UnidadeEscolarDTO> getCarrosById(Long id) {
        return rep.findCarroById(id).stream().map(UnidadeEscolarDTO::create).collect(Collectors.toList());
    }


    public UnidadeEscolarDTO insert(UnidadeEscolar unidadeEscolar) {
        Assert.isNull(unidadeEscolar.getId(),"Não foi possível inserir o registro");
        return UnidadeEscolarDTO.create(rep.save(unidadeEscolar));
    }

    public UnidadeEscolarDTO update(UnidadeEscolar unidadeEscolar, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<UnidadeEscolar> optional = rep.findById(id);
        if(optional.isPresent()) {
            UnidadeEscolar db = optional.get();
            // Copiar as propriedades
            db.setNivelescolar(unidadeEscolar.getNivelescolar());
            db.setNome(unidadeEscolar.getNome());
            db.setAlias(unidadeEscolar.getAlias());
            db.setEndereco(unidadeEscolar.getEndereco());
            db.setBairro(unidadeEscolar.getBairro());
            db.setAlunos(unidadeEscolar.getAlunos());
            db.setModified(unidadeEscolar.getModified());
            db.setCreated(unidadeEscolar.getCreated());
            db.setAtivo(unidadeEscolar.getAtivo());
            System.out.println("Nivel id " + db.getId());
            // Atualiza o carro
            rep.save(db);

            return UnidadeEscolarDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
