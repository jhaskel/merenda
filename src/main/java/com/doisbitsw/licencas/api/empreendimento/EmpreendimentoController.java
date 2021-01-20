package com.doisbitsw.licencas.api.empreendimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empreendimento")
public class EmpreendimentoController {
    @Autowired
    private EmpreendimentoService service;


    @GetMapping()
    public ResponseEntity get() {
        List<EmpreendimentoDTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        EmpreendimentoDTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getEmpreendimentoByCode(@PathVariable("code") String code) {
        List<EmpreendimentoDTO> empreemdedors = service.getEmpreendimentoByCode(code);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }

    @GetMapping("/empreendedor/{empreendedor}")
    public ResponseEntity getEmpreendimentoByEmpreendedor(@PathVariable("empreendedor") Long empreendedor) {
        List<EmpreendimentoDTO> empreemdedors = service.getEmpreendimentoByEmpreendedor(empreendedor);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity getEmpreendimentoByCpf(@PathVariable("cpf") String cpf) {
        List<EmpreendimentoDTO> empreemdedors = service.getEmpreendimentoByCpf(cpf);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }





    @PostMapping

    public ResponseEntity post(@RequestBody Empreendimento empreendimento) {

        EmpreendimentoDTO c = service.insert(empreendimento);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Empreendimento empreendimento) {

        empreendimento.setId(id);

        EmpreendimentoDTO c = service.update(empreendimento, id);

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
