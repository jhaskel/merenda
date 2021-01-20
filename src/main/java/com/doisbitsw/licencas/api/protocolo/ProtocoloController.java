package com.doisbitsw.licencas.api.protocolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/protocolo")
public class ProtocoloController {
    @Autowired
    private ProtocoloService service;


    @GetMapping()
    public ResponseEntity get() {
        List<ProtocoloDTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ProtocoloDTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getEmpreendimentoByCode(@PathVariable("code") String code) {
        List<ProtocoloDTO> empreemdedors = service.getEmpreendimentoByCode(code);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }

    @GetMapping("/processo/{codeProcesso}")
    public ResponseEntity getEmpreendimentoByCodeProcesso(@PathVariable("codeProcesso") String codeProcesso) {
        List<ProtocoloDTO> empreemdedors = service.getEmpreendimentoByCodeProcesso(codeProcesso);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }

    @GetMapping("/empreendedor/{empreendedor}")
    public ResponseEntity getEmpreendimentoByEmpreendedor(@PathVariable("empreendedor") Long empreendedor) {
        List<ProtocoloDTO> empreemdedors = service.getEmpreendimentoByEmpreendedor(empreendedor);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }






    @PostMapping

    public ResponseEntity post(@RequestBody Protocolo protocolo) {

        ProtocoloDTO c = service.insert(protocolo);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Protocolo protocolo) {

        protocolo.setId(id);

        ProtocoloDTO c = service.update(protocolo, id);

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
