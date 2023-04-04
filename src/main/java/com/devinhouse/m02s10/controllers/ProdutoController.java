package com.devinhouse.m02s10.controllers;

import com.devinhouse.m02s10.dto.ProdutoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @GetMapping
    public String getProduto(Model model) {
        ProdutoDto produto = new ProdutoDto();

        produto.setNome("Caneca");
        produto.setDataLancamento(new Date());
        produto.setDescricao("Melhor caneca já feita");
        produto.setValor(100.30);

        model.addAttribute("produto", produto);
        return "produto";
    }
}
