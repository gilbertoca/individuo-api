package me.dio.web.individuoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
    RESIDENCIAL("Residencial"),
    CELULAR("Celular"),
    COMERCIAL("Comercial");
    private String descricao;
}
