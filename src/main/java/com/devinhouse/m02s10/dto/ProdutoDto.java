package com.devinhouse.m02s10.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
    private Integer id;
    private String nome;
    private String descricao;
    private String dataLancamento;
    private Double valor;
}
