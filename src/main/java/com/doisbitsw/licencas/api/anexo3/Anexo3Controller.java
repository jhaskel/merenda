package com.doisbitsw.licencas.api.anexo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/anexo3")
public class Anexo3Controller {
    @Autowired
    private Anexo3Service service;


    @GetMapping()
    public ResponseEntity get() {
        List<Anexo3DTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Anexo3DTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }



    @GetMapping("/code/{code}")
    public ResponseEntity getEmpreendimentoByCode(@PathVariable("code") String code) {
        List<Anexo3DTO> empreemdedors = service.getEmpreendimentoByCode(code);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }







    @PostMapping

    public ResponseEntity post(@RequestBody Anexo3 anexo3) {

        Anexo3DTO c = service.insert(anexo3);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Anexo3 anexo3) {

        anexo3.setId(id);

        Anexo3DTO c = service.update(anexo3, id);

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
