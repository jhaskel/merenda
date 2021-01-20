package com.doisbitsw.licencas.api.documentacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/documentacao")
public class DocumentacaoController {
    @Autowired
    private DocumentacaoService service;


    @GetMapping()
    public ResponseEntity get() {
        List<DocumentacaoDTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        DocumentacaoDTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }

    @GetMapping("/processo/{processo}")
    public ResponseEntity getEmpreendimentoByProcesso(@PathVariable("processo") String processo) {
        List<DocumentacaoDTO> empreemdedors = service.getEmpreendimentoByProcesso(processo);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }




    @PostMapping

    public ResponseEntity post(@RequestBody Documentacao documentacao) {

        DocumentacaoDTO c = service.insert(documentacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Documentacao documentacao) {

        documentacao.setId(id);

        DocumentacaoDTO c = service.update(documentacao, id);

        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
