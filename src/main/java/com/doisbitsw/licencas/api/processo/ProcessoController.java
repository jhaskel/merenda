package com.doisbitsw.licencas.api.processo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/processo")
public class ProcessoController {
    @Autowired
    private ProcessoService service;


    @GetMapping()
    public ResponseEntity get() {
        List<ProcessoDTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ProcessoDTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getEmpreendimentoByCode(@PathVariable("code") String code) {
        List<ProcessoDTO> empreemdedors = service.getEmpreendimentoByCode(code);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }

    @GetMapping("/empreendedor/{empreendedor}")
    public ResponseEntity getEmpreendimentoByEmpreendedor(@PathVariable("empreendedor") Long empreendedor) {
        List<ProcessoDTO> empreemdedors = service.getEmpreendimentoByEmpreendedor(empreendedor);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }






    @PostMapping

    public ResponseEntity post(@RequestBody Processo processo) {

        ProcessoDTO c = service.insert(processo);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Processo processo) {

        processo.setId(id);

        ProcessoDTO c = service.update(processo, id);

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
