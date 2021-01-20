package com.doisbitsw.licencas.api.certidao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/certidao")
public class CertidaoController {
    @Autowired
    private CertidaoService service;


    @GetMapping()
    public ResponseEntity get() {
        List<CertidaoDTO> empreendimentos = service.getCarros();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        CertidaoDTO empreendimento = service.getCarroById(id);

        return ResponseEntity.ok(empreendimento);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getEmpreendimentoByCode(@PathVariable("code") String code) {
        List<CertidaoDTO> empreemdedors = service.getEmpreendimentoByCode(code);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }

    @GetMapping("/empreendedor/{empreendedor}")
    public ResponseEntity getEmpreendimentoByEmpreendedor(@PathVariable("empreendedor") Long empreendedor) {
        List<CertidaoDTO> empreemdedors = service.getEmpreendimentoByEmpreendedor(empreendedor);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }

    @GetMapping("/empreendimento/{empreendimento}")
    public ResponseEntity getEmpreendimentoByEmpreendimento(@PathVariable("empreendimento") Long empreendimento) {
        List<CertidaoDTO> empreemdedors = service.getEmpreendimentoByEmpreendimento(empreendimento);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }





    @PostMapping

    public ResponseEntity post(@RequestBody Certidao certidao) {

        CertidaoDTO c = service.insert(certidao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Certidao certidao) {

        certidao.setId(id);

        CertidaoDTO c = service.update(certidao, id);

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
