package com.doisbitsw.licencas.api.pedidoItens;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoItensService {

    @Autowired

    private PedidoItensRepository rep;
    public List<PedidoItensDTO> getCarros() {
        List<PedidoItensDTO> list = rep.findAll().stream().map(PedidoItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public List<PedidoItensDTO> getCarros2() {
        List<PedidoItensDTO> list = rep.findAll2().stream().map(PedidoItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public List<PedidoItensDTO> getCarros3() {
        List<PedidoItensDTO> list = rep.findAll3().stream().map(PedidoItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public PedidoItensDTO getCarroById(Long id) {
        Optional<PedidoItens> carro = rep.findById(id);
        return carro.map(PedidoItensDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public List<PedidoItensDTO> getCarrosByPedido(String pedido) {
        return rep.findByPedido(pedido).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getCarrosByPedidoAll(String pedido) {
        return rep.findByPedidoAll(pedido).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getCarrosByAf(Long af) {
        return rep.findByAf(af).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getCarrosByEscola(Long escola, Long pedido) {
        return rep.findByEscola(escola,pedido).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getEscolar(Long escola, Long ano) {
        return rep.findEscolar(escola,ano).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getByFornecedor(Long fornecedor) {
        return rep.findByFornecedor(fornecedor).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getEscolaAll(Long ano) {
        return rep.findEscolaAll(ano).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getItensAno(Long ano) {
        return rep.findItensAno(ano).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }



    public List<PedidoItensDTO> getTotalMes(Long ano) {
        return rep.findTotalMes(ano).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getTotalCategoria(Long ano) {
        return rep.findTotalCategoria(ano).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getTotalEscola(Long ano) {
        return rep.findTotalEscola(ano).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public List<PedidoItensDTO> getMediaAlunos(Long ano) {
        return rep.findMediaAlunos(ano).stream().map(PedidoItensDTO::create).collect(Collectors.toList());
    }


    public double getTotal(Long ano){
        return rep.findTotal(ano);
    }



    public double getTotalNivel(Long nivel,Long ano){
        return rep.findTotalNivel(nivel,ano);
    }







    public double getSoma(Long escola){
        return rep.findSoma(escola);
    }



    public double getTotalAgroEscola(Long escola,Long ano){
        return rep.findTotalAgroEscola(escola,ano);
    }

    public double getTotalAgroNivel(Long nivel,Long ano){
        return rep.findTotalAgroNivel(nivel,ano);
    }


    public double getTotalAgro(Long ano){
        return rep.findTotalAgro(ano);
    }

    public double getTotalPedido(String pedido){
        return rep.findTotalPedido(pedido);
    }

    public double getTotalAf(Long af){
        return rep.findTotalAf(af);
    }

    public double getTradicional(Long ano){
        return rep.findTradicional(ano);
    }


    public double getTradicionalNivel(Long nivel,Long ano){
        return rep.findTradicionalNivel(nivel,ano);
    }


    public double getTradicionalEscola(Long escola,Long ano){
        return rep.findTradicionalEscola(escola,ano);
    }


    public double getDiversos(Long ano){
        return rep.findDiversos(ano);
    }



    public PedidoItensDTO insert(PedidoItens pedidoItens) {
        Assert.isNull(pedidoItens.getId(),"Não foi possível inserir o registro");
        return PedidoItensDTO.create(rep.save(pedidoItens));
    }

    public PedidoItensDTO update(PedidoItens pedidoItens, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<PedidoItens> optional = rep.findById(id);
        if(optional.isPresent()) {
            PedidoItens db = optional.get();
            // Copiar as propriedades
            db.setEscola(pedidoItens.getEscola());
            db.setProduto(pedidoItens.getProduto());
            db.setCategoria(pedidoItens.getCategoria());
            db.setNivel(pedidoItens.getNivel());
            db.setFornecedor(pedidoItens.getFornecedor());
            db.setAno(pedidoItens.getAno());
            db.setAf(pedidoItens.getAf());
            db.setPedido(pedidoItens.getPedido());
            db.setAlias(pedidoItens.getAlias());
            db.setObs(pedidoItens.getObs());
            db.setStatus(pedidoItens.getStatus());
            db.setCreated(pedidoItens.getCreated());
            db.setNomeescola(pedidoItens.getNomeescola());
            db.setNomenivel(pedidoItens.getNomenivel());
            db.setUnidade(pedidoItens.getUnidade());
            db.setQuantidade(pedidoItens.getQuantidade());
            db.setValor(pedidoItens.getValor());
            db.setTotal(pedidoItens.getTotal());
            db.setIsagro(pedidoItens.getIsagro());
            db.setIsautorizado(pedidoItens.getIsautorizado());
            db.setIscheck(pedidoItens.getIscheck());
            db.setCod(pedidoItens.getCod());
            db.setMes(pedidoItens.getMes());
            db.setAtivo(pedidoItens.getAtivo());

            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return PedidoItensDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
