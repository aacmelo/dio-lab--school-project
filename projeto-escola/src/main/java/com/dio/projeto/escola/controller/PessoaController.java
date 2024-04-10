package com.dio.projeto.escola.controller;

import com.dio.projeto.escola.model.Pessoas;
import com.dio.projeto.escola.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public String telaSistema(){;
        return "/sistema";
    }

    @GetMapping("/sistema")
    public String voltarSistema(){
        return "/sistema";
    }

    @GetMapping("/cadastro-pessoas")
    public String cadastrarPessoa(){
        return "/cadastro-pessoas";
    }

    @PostMapping("/novapessoa")
    public String novaPessoa(Pessoas pessoa, RedirectAttributes attributes){
        pessoaService.savePessoa(pessoa);
        attributes.addFlashAttribute("mensagem","Cadastro Realizado com Sucesso");
        return "redirect:/cadastro-pessoas";
    }
}
