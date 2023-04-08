package com.devinhouse.m02s10.controllers;

import com.devinhouse.m02s10.dto.ProdutoDto;
import com.devinhouse.m02s10.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoService service;
    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String gerarFormulario(Model model, ProdutoDto produtoDto) {
        model.addAttribute("produtoDto", produtoDto);
        List<ProdutoDto> produtosList = service.getProdutos();
        model.addAttribute("produtosList", produtosList);

        return "incluir_produto";
    }

    @PostMapping
    public String salvarProduto(Model model, ProdutoDto produto) {
        service.criarProduto(produto);
        System.out.println("Criou produto!");
        System.out.println(service.getProdutos());

        return "redirect:produto";
    }
}
