package com.dio.projeto.escola.controller;

import org.springframework.ui.Model;
import com.dio.projeto.escola.model.Aluno;
import com.dio.projeto.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/")
    public String telaSistema(){;
        return "/sistema";
    }

    @GetMapping("/sistema")
    public String voltarSistema(){
        return "/sistema";
    }

    @GetMapping("/cadastro-aluno")
    public String cadastrarAluno(){
        return "/cadastro-aluno";
    }

    @PostMapping("/novoaluno")
    public String novoAluno(Aluno aluno , RedirectAttributes attributes){
        alunoService.saveAluno(aluno);
        attributes.addFlashAttribute("mensagem","Cadastro Realizado com Sucesso");
        return "redirect:/cadastro-aluno";
    }

    @GetMapping("/consultar-aluno")
    public String consultarTodosAlunos(Model model){
        List<Aluno> alunos = alunoService.consultarTodosAlunos();
        model.addAttribute("listaAlunos", alunos);
        return "/consultar-aluno";
    }

    @PostMapping("/consultar")
    public String consultarEstudante(@Param("nome") Model model, String nome){
        if(nome == null){
            return "redirect:/consultar-aluno";
        }
        List<Aluno> alunos = alunoService.consultarAlunoPorNome(nome);
        model.addAttribute("listaAlunos",alunos);
        return "/consultar-aluno";
    }
}
