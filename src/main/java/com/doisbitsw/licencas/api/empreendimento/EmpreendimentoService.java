package com.doisbitsw.licencas.api.empreendimento;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpreendimentoService {

    @Autowired

    private EmpreendimentoRepository rep;
    public List<EmpreendimentoDTO> getCarros() {
        List<EmpreendimentoDTO> list = rep.findAll().stream().map(EmpreendimentoDTO::create).collect(Collectors.toList());
        return list;
    }

    public EmpreendimentoDTO getCarroById(Long id) {
        Optional<Empreendimento> carro = rep.findById(id);
        return carro.map(EmpreendimentoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public EmpreendimentoDTO insert(Empreendimento empreendimento) {
        Assert.isNull(empreendimento.getId(),"Não foi possível inserir o registro");
        return EmpreendimentoDTO.create(rep.save(empreendimento));
    }

    public EmpreendimentoDTO update(Empreendimento empreendimento, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Empreendimento> optional = rep.findById(id);
        if(optional.isPresent()) {
            Empreendimento db = optional.get();
            // Copiar as propriedades
            db.setNome(empreendimento.getNome());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return EmpreendimentoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<EmpreendimentoDTO> getEmpreendimentoByCode(String code) {
        return rep.findByCode(code).stream().map(EmpreendimentoDTO::create).collect(Collectors.toList());
    }


    public List<EmpreendimentoDTO> getEmpreendimentoByEmpreendedor(Long empreendedor) {
        return rep.findByEmpreendedor(empreendedor).stream().map(EmpreendimentoDTO::create).collect(Collectors.toList());
    }


    public List<EmpreendimentoDTO> getEmpreendimentoByCpf(String cpf) {
        return rep.findByCpf(cpf).stream().map(EmpreendimentoDTO::create).collect(Collectors.toList());
    }
}
