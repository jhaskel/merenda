package com.doisbitsw.licencas.api.protocolo;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProtocoloService {

    @Autowired

    private ProtocoloRepository rep;
    public List<ProtocoloDTO> getCarros() {
        List<ProtocoloDTO> list = rep.findAll().stream().map(ProtocoloDTO::create).collect(Collectors.toList());
        return list;
    }

    public ProtocoloDTO getCarroById(Long id) {
        Optional<Protocolo> carro = rep.findById(id);
        return carro.map(ProtocoloDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public ProtocoloDTO insert(Protocolo protocolo) {
        Assert.isNull(protocolo.getId(),"Não foi possível inserir o registro");
        return ProtocoloDTO.create(rep.save(protocolo));
    }

    public ProtocoloDTO update(Protocolo protocolo, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Protocolo> optional = rep.findById(id);
        if(optional.isPresent()) {
            Protocolo db = optional.get();
            // Copiar as propriedades
            db.setDescricao(protocolo.getDescricao());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return ProtocoloDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<ProtocoloDTO> getEmpreendimentoByCode(String code) {
        return rep.findByCode(code).stream().map(ProtocoloDTO::create).collect(Collectors.toList());
    }


    public List<ProtocoloDTO> getEmpreendimentoByCodeProcesso(String codeProcesso) {
        return rep.findByCodeProcesso(codeProcesso).stream().map(ProtocoloDTO::create).collect(Collectors.toList());
    }


    public List<ProtocoloDTO> getEmpreendimentoByEmpreendedor(Long empreendedor) {
        return rep.findByEmpreendedor(empreendedor).stream().map(ProtocoloDTO::create).collect(Collectors.toList());
    }




}
