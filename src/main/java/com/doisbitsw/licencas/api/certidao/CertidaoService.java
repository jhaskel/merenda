package com.doisbitsw.licencas.api.certidao;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CertidaoService {

    @Autowired

    private CertidaoRepository rep;
    public List<CertidaoDTO> getCarros() {
        List<CertidaoDTO> list = rep.findAll().stream().map(CertidaoDTO::create).collect(Collectors.toList());
        return list;
    }

    public CertidaoDTO getCarroById(Long id) {
        Optional<Certidao> carro = rep.findById(id);
        return carro.map(CertidaoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendimento não encontrado"));
    }



    public CertidaoDTO insert(Certidao certidao) {
        Assert.isNull(certidao.getId(),"Não foi possível inserir o registro");
        return CertidaoDTO.create(rep.save(certidao));
    }

    public CertidaoDTO update(Certidao certidao, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Certidao> optional = rep.findById(id);
        if(optional.isPresent()) {
            Certidao db = optional.get();
            // Copiar as propriedades
            db.setAtividade(certidao.getAtividade());

            System.out.println("Empreendimento id " + db.getId());

            // Atualiza o empreendimento
            rep.save(db);

            return CertidaoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<CertidaoDTO> getEmpreendimentoByCode(String code) {
        return rep.findByCode(code).stream().map(CertidaoDTO::create).collect(Collectors.toList());
    }


    public List<CertidaoDTO> getEmpreendimentoByEmpreendedor(Long empreendedor) {
        return rep.findByEmpreendedor(empreendedor).stream().map(CertidaoDTO::create).collect(Collectors.toList());
    }


    public List<CertidaoDTO> getEmpreendimentoByEmpreendimento(Long empreendimento) {
        return rep.findByEmpreendimento(empreendimento).stream().map(CertidaoDTO::create).collect(Collectors.toList());
    }
}
