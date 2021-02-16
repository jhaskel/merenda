package com.doisbitsw.licencas.api.pedidoItens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/itens")
public class PedidoItensController {
    @Autowired
    private PedidoItensService service;


    @GetMapping()
    public ResponseEntity get() {
        List<PedidoItensDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }
    @GetMapping("/afi")
    public ResponseEntity get2() {
        List<PedidoItensDTO> carros = service.getCarros2();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/pedidos")
    public ResponseEntity get3() {
        List<PedidoItensDTO> carros = service.getCarros3();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        PedidoItensDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }
    @GetMapping("/pedido/{pedido}")
    public ResponseEntity getCarrosByPedido(@PathVariable("pedido") String pedido) {
        List<PedidoItensDTO> carros = service.getCarrosByPedido(pedido);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }


    @GetMapping("/pedidoall/{pedido}")
    public ResponseEntity getCarrosByPedidoAll(@PathVariable("pedido") String pedido) {
        List<PedidoItensDTO> carros = service.getCarrosByPedidoAll(pedido);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }



    @GetMapping("/af/{af}")
    public ResponseEntity getCarrosByAf(@PathVariable("af") Long af) {
        List<PedidoItensDTO> carros = service.getCarrosByAf(af);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/escola/{escola}/{pedido}")
    public ResponseEntity getCarrosByEscola(@PathVariable("escola") Long escola,@PathVariable("pedido") Long pedido) {
        List<PedidoItensDTO> carros = service.getCarrosByEscola(escola,pedido);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/escolar/{escola}/{ano}")
    public ResponseEntity getEscolar(@PathVariable("escola") Long escola,@PathVariable("ano") Long ano) {
        List<PedidoItensDTO> carros = service.getEscolar(escola,ano);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/fornecedor/{fornecedor}")
    public ResponseEntity getByFornecedor(@PathVariable("fornecedor") Long fornecedor) {
        List<PedidoItensDTO> carros = service.getByFornecedor(fornecedor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/escolaAll/{ano}")
    public ResponseEntity getEscolaAll(@PathVariable("ano") Long ano) {
        List<PedidoItensDTO> carros = service.getEscolaAll(ano);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/ano/{ano}")
    public ResponseEntity getItensAno(@PathVariable("ano") Long ano) {
        List<PedidoItensDTO> carros = service.getItensAno(ano);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/total/{ano}")
    public double getTotal(@PathVariable("ano") Long ano) {
        return service.getTotal(ano);
    }



    @GetMapping("/somaAll/{escola}")
    public double getRep(@PathVariable("escola") Long escola) {
        return service.getSoma(escola);
    }

    @GetMapping("/totalAgroEscola/{escola}/{ano}")
    public double getTotalAgroEscola(@PathVariable("escola") Long escola,@PathVariable("ano") Long ano) {
        return service.getTotalAgroEscola(escola,ano);
    }

    @GetMapping("/totalAgroNivel/{escola}/{ano}")
    public double getTotalAgroNivel(@PathVariable("nivel") Long nivel,@PathVariable("ano") Long ano) {
        return service.getTotalAgroNivel(nivel,ano);
    }

    @GetMapping("/totalAgro/{ano}")
    public double getTotalAgro(@PathVariable("ano") Long ano) {
        return service.getTotalAgro(ano);
    }

    @GetMapping("/totalPedido/{pedido}")
    public double getTotalPedido(@PathVariable("pedido") String pedido) {
        return service.getTotalPedido(pedido);
    }

    @GetMapping("/totalAf/{af}")
    public double getTotalAf(@PathVariable("af") Long af) {
        return service.getTotalAf(af);
    }


    @GetMapping("/tradicional/{ano}")
    public double getTradicional(@PathVariable("ano") Long ano) {
        return service.getTradicional(ano);
    }


    @GetMapping("/tradicionalNivel/{nivel}/{ano}")
    public double getTradicionalNivel(@PathVariable("nivel") Long nivel,@PathVariable("ano") Long ano) {
        return service.getTradicionalNivel(nivel,ano);
    }


    @GetMapping("/tradicionalEscola/{escola}/{ano}")
    public double getTradicionalEscola(@PathVariable("escola") Long escola,@PathVariable("ano") Long ano) {
        return service.getTradicionalEscola(escola,ano);
    }






    @PostMapping
    public ResponseEntity post(@RequestBody PedidoItens pedidoItens) {

        PedidoItensDTO c = service.insert(pedidoItens);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody PedidoItens pedidoItens) {
        pedidoItens.setId(id);
        PedidoItensDTO c = service.update(pedidoItens, id);
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
