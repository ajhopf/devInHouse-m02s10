package com.devinhouse.m02s10.controllers;

import com.devinhouse.m02s10.dto.ProdutoDto;
import com.devinhouse.m02s10.repositories.model.ProdutoEntity;
import com.devinhouse.m02s10.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String gerarFormulario(Model model, ProdutoDto produto) {
        model.addAttribute("produto", produto);
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

    @GetMapping("/delete/{id}")
    public String deletarProduto(@PathVariable("id") Integer id) {
        ProdutoEntity produto = service.getProdutoById(id);
        System.out.println(produto);
        service.deletarProduto(produto);

        return "redirect:/produto";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizarProduto(@PathVariable("id") Integer id, Model model) {
        ProdutoEntity produto = service.getProdutoById(id);
        model.addAttribute("produto", produto);

        return "atualizar_produto";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizProduto(@PathVariable("id") Integer id, ProdutoEntity produto) {
        service.atualizarProduto(produto);
        return "redirect:/produto";
    }
}
