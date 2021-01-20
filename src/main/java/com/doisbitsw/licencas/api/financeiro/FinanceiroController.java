package com.doisbitsw.licencas.api.financeiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/financeiro")
public class FinanceiroController {
    @Autowired
    private FinanceiroService service;


    @GetMapping()
    public ResponseEntity get() {
        List<FinanceiroDTO> financeiros = service.getFinanceiros();
        return ResponseEntity.ok(financeiros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        FinanceiroDTO financeiro = service.getFinanceiroById(id);

        return ResponseEntity.ok(financeiro);
    }

    @GetMapping("/code/{codeProcesso}")
    public ResponseEntity getFinanceiroByCodeProcesso(@PathVariable("codeProcesso") String codeProcesso) {
        List<FinanceiroDTO> financeiro = service.getFinanceiroByCodeProcesso(codeProcesso);
        return financeiro.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(financeiro);
    }

   
   

    @PostMapping

    public ResponseEntity post(@RequestBody Financeiro financeiro) {

        FinanceiroDTO c = service.insert(financeiro);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Financeiro financeiro) {

        financeiro.setId(id);

        FinanceiroDTO c = service.update(financeiro, id);

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
