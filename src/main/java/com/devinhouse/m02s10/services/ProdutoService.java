package com.devinhouse.m02s10.services;

import com.devinhouse.m02s10.dto.ProdutoDto;
import com.devinhouse.m02s10.repositories.ProdutoRepository;
import com.devinhouse.m02s10.repositories.model.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public List<ProdutoDto> getProdutos() {
        return repository.findAll()
                .stream()
                .map(
                        produtoEntity -> new ProdutoDto(
                                produtoEntity.getId(),
                                produtoEntity.getNome(),
                                produtoEntity.getDescricao(),
                                produtoEntity.getDataLancamento(),
                                produtoEntity.getValor()
                        )
                )
                .toList();
    }

    public ProdutoEntity getProdutoById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de produto inválido: " + id));
    }

    public void criarProduto(ProdutoDto produto) {
        repository.save(
                ProdutoEntity.builder()
                        .nome(produto.getNome())
                        .descricao(produto.getDescricao())
                        .dataLancamento(String.valueOf(produto.getDataLancamento()))
                        .valor(produto.getValor())
                        .build()
        );
    }

    public void deletarProduto(Integer produtoId) {
        repository.deleteById(produtoId);
    }

    public void deletarProduto(ProdutoEntity produto) {
        repository.delete(produto);
    }

    public void atualizarProduto(ProdutoEntity produto) {
        repository.save(produto);
    }

}
