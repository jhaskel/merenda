package com.doisbitsw.licencas.api.tabela3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tabela3")
public class Tabela3Controller {
    @Autowired
    private Tabela3Service service;


    @GetMapping()
    public ResponseEntity get() {
        List<Tabela3DTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Tabela3DTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }



    @GetMapping("/licenca/{tipoLicenca}/classe/{classe}")
    public ResponseEntity getEmpreendimentoByLicenca(@PathVariable("tipoLicenca") String tipoLicenca,@PathVariable("classe") String classe) {
        List<Tabela3DTO> empreemdedors = service.getEmpreendimentoByLicenca(tipoLicenca,classe);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }







    @PostMapping

    public ResponseEntity post(@RequestBody Tabela3 tabela3) {

        Tabela3DTO c = service.insert(tabela3);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Tabela3 tabela3) {

        tabela3.setId(id);

        Tabela3DTO c = service.update(tabela3, id);

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
