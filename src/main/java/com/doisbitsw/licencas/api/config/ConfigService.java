package com.doisbitsw.licencas.api.config;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConfigService {

    @Autowired

    private ConfigRepository rep;
    public List<ConfigDTO> getCarros() {
        List<ConfigDTO> list = rep.findAll().stream().map(ConfigDTO::create).collect(Collectors.toList());
        return list;
    }

    public ConfigDTO getCarroById(Long id) {
        Optional<Config> carro = rep.findById(id);
        return carro.map(ConfigDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public ConfigDTO insert(Config config) {
        Assert.isNull(config.getId(),"Não foi possível inserir o registro");
        return ConfigDTO.create(rep.save(config));
    }

    public ConfigDTO update(Config config, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Config> optional = rep.findById(id);
        if(optional.isPresent()) {
            Config db = optional.get();
            // Copiar as propriedades
            db.setAdministrador(config.getAdministrador());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return ConfigDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }



}
