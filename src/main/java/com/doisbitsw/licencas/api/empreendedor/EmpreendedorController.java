package com.doisbitsw.licencas.api.empreendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empreendedor")
public class EmpreendedorController {
    @Autowired
    private EmpreendedorService service;


    @GetMapping()
    public ResponseEntity get() {
        List<EmpreendedorDTO> empreendedors = service.getCarros();
        return ResponseEntity.ok(empreendedors);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        EmpreendedorDTO empreendedor = service.getCarroById(id);

        return ResponseEntity.ok(empreendedor);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getEmpreendedorByCode(@PathVariable("code") String code) {
        List<EmpreendedorDTO> empreemdedors = service.getEmpreendedorByCode(code);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity getEmpreendedorByCpf(@PathVariable("cpf") String cpf){
        List<EmpreendedorDTO> empreemdedors = service.getEmpreendedorByCpf(cpf);
        return empreemdedors.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(empreemdedors);
    }



    @PostMapping

    public ResponseEntity post(@RequestBody Empreendedor empreendedor) {

        EmpreendedorDTO c = service.insert(empreendedor);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Empreendedor empreendedor) {

        empreendedor.setId(id);

        EmpreendedorDTO c = service.update(empreendedor, id);

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
