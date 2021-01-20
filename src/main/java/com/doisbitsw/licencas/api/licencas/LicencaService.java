package com.doisbitsw.licencas.api.licencas;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LicencaService {

    @Autowired

    private LicencaRepository rep;
    public List<LicencaDTO> getCarros() {
        List<LicencaDTO> list = rep.findAll().stream().map(LicencaDTO::create).collect(Collectors.toList());
        return list;
    }

    public LicencaDTO getCarroById(Long id) {
        Optional<Licenca> carro = rep.findById(id);
        return carro.map(LicencaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<LicencaDTO> getCarrosByProcesso(String processo) {
        return rep.findByProcesso(processo).stream().map(LicencaDTO::create).collect(Collectors.toList());
    }

    public LicencaDTO insert(Licenca licenca) {
        Assert.isNull(licenca.getId(),"Não foi possível inserir o registro");
        return LicencaDTO.create(rep.save(licenca));
    }

    public LicencaDTO update(Licenca licenca, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Licenca> optional = rep.findById(id);
        if(optional.isPresent()) {
            Licenca db = optional.get();
            // Copiar as propriedades
            db.setCode(licenca.getCode());
            db.setTipoLicenca(licenca.getTipoLicenca());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return LicencaDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
