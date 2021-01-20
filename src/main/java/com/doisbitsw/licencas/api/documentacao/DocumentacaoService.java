package com.doisbitsw.licencas.api.documentacao;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentacaoService {

    @Autowired

    private DocumentacaoRepository rep;
    public List<DocumentacaoDTO> getCarros() {
        List<DocumentacaoDTO> list = rep.findAll().stream().map(DocumentacaoDTO::create).collect(Collectors.toList());
        return list;
    }

    public DocumentacaoDTO getCarroById(Long id) {
        Optional<Documentacao> carro = rep.findById(id);
        return carro.map(DocumentacaoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public DocumentacaoDTO insert(Documentacao documentacao) {
        Assert.isNull(documentacao.getId(),"Não foi possível inserir o registro");
        return DocumentacaoDTO.create(rep.save(documentacao));
    }

    public DocumentacaoDTO update(Documentacao documentacao, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Documentacao> optional = rep.findById(id);
        if(optional.isPresent()) {
            Documentacao db = optional.get();
            // Copiar as propriedades
            db.setDocumento(documentacao.getDocumento());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return DocumentacaoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<DocumentacaoDTO> getEmpreendimentoByProcesso(String processo) {
        return rep.findByProcesso(processo).stream().map(DocumentacaoDTO::create).collect(Collectors.toList());
    }



}
