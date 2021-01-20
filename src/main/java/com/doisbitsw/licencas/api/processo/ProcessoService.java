package com.doisbitsw.licencas.api.processo;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessoService {

    @Autowired

    private ProcessoRepository rep;
    public List<ProcessoDTO> getCarros() {
        List<ProcessoDTO> list = rep.findAll().stream().map(ProcessoDTO::create).collect(Collectors.toList());
        return list;
    }

    public ProcessoDTO getCarroById(Long id) {
        Optional<Processo> carro = rep.findById(id);
        return carro.map(ProcessoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public ProcessoDTO insert(Processo processo) {
        Assert.isNull(processo.getId(),"Não foi possível inserir o registro");
        return ProcessoDTO.create(rep.save(processo));
    }

    public ProcessoDTO update(Processo processo, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Processo> optional = rep.findById(id);
        if(optional.isPresent()) {
            Processo db = optional.get();
            // Copiar as propriedades
            db.setAtividade(processo.getAtividade());
            db.setStatus(processo.getStatus());
            db.setAtivo(processo.getAtivo());
            db.setCaracterizacao(processo.getCaracterizacao());
            db.setClasse(processo.getClasse());
            db.setModified(processo.getModified());
            db.setFase(processo.getFase());
            db.setIssecundarias(processo.getIssecundarias());
            db.setLocal(processo.getLocal());
            db.setObs(processo.getObs());
            db.setPorte(processo.getPorte());
            db.setQuantidade(processo.getQuantidade());
            db.setUnidade(processo.getUnidade());
            db.setPotencial(processo.getPotencial());
            db.setTipoLicenca(processo.getTipoLicenca());
            db.setValor(processo.getValor());



            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return ProcessoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<ProcessoDTO> getEmpreendimentoByCode(String code) {
        return rep.findByCode(code).stream().map(ProcessoDTO::create).collect(Collectors.toList());
    }


    public List<ProcessoDTO> getEmpreendimentoByEmpreendedor(Long empreendedor) {
        return rep.findByEmpreendedor(empreendedor).stream().map(ProcessoDTO::create).collect(Collectors.toList());
    }



}
