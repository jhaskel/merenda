package com.doisbitsw.licencas.api.empreendedor;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpreendedorService {

    @Autowired

    private EmpreendedorRepository rep;
    public List<EmpreendedorDTO> getCarros() {
        List<EmpreendedorDTO> list = rep.findAll().stream().map(EmpreendedorDTO::create).collect(Collectors.toList());
        return list;
    }

    public EmpreendedorDTO getCarroById(Long id) {
        Optional<Empreendedor> carro = rep.findById(id);
        return carro.map(EmpreendedorDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreeendedor não encontrado"));
    }





    public EmpreendedorDTO insert(Empreendedor empreendedor) {
        Assert.isNull(empreendedor.getId(),"Não foi possível inserir o registro");
        return EmpreendedorDTO.create(rep.save(empreendedor));
    }

    public EmpreendedorDTO update(Empreendedor empreendedor, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Empreendedor> optional = rep.findById(id);
        if(optional.isPresent()) {
            Empreendedor db = optional.get();
            // Copiar as propriedades
            db.setNome(empreendedor.getNome());

            System.out.println("Empreendedor id " + db.getId());

            // Atualiza o empreendedor
            rep.save(db);

            return EmpreendedorDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<EmpreendedorDTO> getEmpreendedorByCode(String code) {
        return rep.findByCode(code).stream().map(EmpreendedorDTO::create).collect(Collectors.toList());
    }


    public List<EmpreendedorDTO> getEmpreendedorByCpf(String cpf) {
        return rep.findByCpf(cpf).stream().map(EmpreendedorDTO::create).collect(Collectors.toList());
    }
}
