package com.doisbitsw.licencas.api.tabela1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tabela1")
public class Tabela1Controller {
    @Autowired
    private Tabela1Service service;


    @GetMapping()
    public ResponseEntity get() {
        List<Tabela1DTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Tabela1DTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }



    @GetMapping("/fase/{fase}")
    public ResponseEntity getEmpreendimentoByFase(@PathVariable("fase") Long fase) {
        List<Tabela1DTO> empreemdedors = service.getEmpreendimentoByFase(fase);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }







    @PostMapping

    public ResponseEntity post(@RequestBody Tabela1 tabela1) {

        Tabela1DTO c = service.insert(tabela1);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Tabela1 tabela1) {

        tabela1.setId(id);

        Tabela1DTO c = service.update(tabela1, id);

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
