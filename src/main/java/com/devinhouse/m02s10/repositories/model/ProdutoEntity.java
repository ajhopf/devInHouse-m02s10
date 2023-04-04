package com.devinhouse.m02s10.repositories.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "produtos")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    String nome;
    @Column
    String descricao;
    @Column
    Date dataLancamento;
    @Column
    Double valor;
}
