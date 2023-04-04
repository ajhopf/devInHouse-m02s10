package com.devinhouse.m02s10.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProdutoDto {
    private String nome;
    private String descricao;
    private Date dataLancamento;
    private Double valor;
}
