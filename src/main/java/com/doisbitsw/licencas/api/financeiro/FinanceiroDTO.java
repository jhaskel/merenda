package com.doisbitsw.licencas.api.financeiro;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class FinanceiroDTO {
    private Long id;
    private String code;
    private String codeProcesso;
    private Long empreendimento;
    private Double valor;
    private String situacao;
    private String imagem;
    private Boolean ativo;
    private String created;
    private String modified;





    public static FinanceiroDTO create(Financeiro financeiro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(financeiro, FinanceiroDTO.class);
    }
}
