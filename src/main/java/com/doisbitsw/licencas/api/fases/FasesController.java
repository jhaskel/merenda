package com.doisbitsw.licencas.api.fases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fases")
public class FasesController {
    @Autowired
    private FasesService service;


    @GetMapping()
    public ResponseEntity get() {
        List<FasesDTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        FasesDTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }


    @PostMapping

    public ResponseEntity post(@RequestBody Fases fases) {

        FasesDTO c = service.insert(fases);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Fases fases) {

        fases.setId(id);

        FasesDTO c = service.update(fases, id);

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
