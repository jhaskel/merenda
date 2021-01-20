package com.doisbitsw.licencas.api.licencas;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class LicencaDTO {
    private Long id;
    private String code;
    private String processo;
    private String tipoLicenca;
    private String admin;
    private String status;
    private Long validade;
    private Boolean emitida;
    private Long empreendimento;
    private String created;
    private String modified;
    private Boolean ativo;



    public static LicencaDTO create(Licenca licenca) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(licenca, LicencaDTO.class);
    }
}
