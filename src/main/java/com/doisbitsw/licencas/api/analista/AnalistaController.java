package com.doisbitsw.licencas.api.analista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/analista")
public class AnalistaController {
    @Autowired
    private AnalistaService service;


    @GetMapping()
    public ResponseEntity get() {
        List<AnalistaDTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        AnalistaDTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }






    @PostMapping

    public ResponseEntity post(@RequestBody Analista analista) {

        AnalistaDTO c = service.insert(analista);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Analista analista) {

        analista.setId(id);

        AnalistaDTO c = service.update(analista, id);

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
