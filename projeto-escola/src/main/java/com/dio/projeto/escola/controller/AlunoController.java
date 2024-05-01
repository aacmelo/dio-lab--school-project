package com.dio.projeto.escola.controller;

import com.dio.projeto.escola.exception.AlunoNotFoundException;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.dio.projeto.escola.model.Aluno;
import com.dio.projeto.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/")
    public String telaSistema(){;
        return "/cadastro-aluno";
    }

    @GetMapping("/sistema")
    public String voltarSistema(){
        return "/cadastro-aluno";
    }

    @GetMapping("/cadastro-aluno")
    public String novoAluno(Model model){
        Aluno aluno = new Aluno();
        model.addAttribute("novoAluno", aluno);
        return "/cadastro-aluno";
    }

    @PostMapping("/novoaluno")
    public String salvarAluno(@ModelAttribute("novoAluno") @Valid Aluno aluno ,BindingResult erros, RedirectAttributes attributes){
        if(erros.hasErrors()){
            return "/cadastro-aluno";
        }
        alunoService.saveAluno(aluno);
        attributes.addFlashAttribute("mensagem","Cadastro do Aluno Realizado com Sucesso");
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
        model.addAttribute("listaAlunos", alunos);
        return "/consultar-aluno";
    }

    @GetMapping("/deletar-aluno")
    public String deletarAluno(Model model){
        List<Aluno> alunos = alunoService.consultarTodosAlunos();
        model.addAttribute("listaAlunos", alunos);
        return "/deletar-aluno";
    }

    @PostMapping("/deletar")
    public String consultarAluno(@Param("nome") Model model, String nome){
        if(nome == null){
            return "redirect:/deletar-aluno";
        }
        List<Aluno> alunos = alunoService.consultarAlunoPorNome(nome);
        model.addAttribute("listaAlunos", alunos);
        return "/deletar-aluno";
    }

    @PostMapping("/apagar/{id}")
    public String apagarAluno(Long id, RedirectAttributes attributes){
        try {
            alunoService.apagarAluno(id);
            attributes.addFlashAttribute("mensagemDeletar","Aluno Apagado com Sucesso");
        } catch (AlunoNotFoundException e) {
           attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return"redirect:/deletar-aluno";
    }

    @GetMapping("/atualizar-aluno")
    public String atualizarAluno(Model model){
        List<Aluno> alunos = alunoService.consultarTodosAlunos();
        model.addAttribute("listaAlunos", alunos);
        return "/atualizar-aluno";
    }

    @GetMapping("/editar-aluno/{id}")
    public String editarFormAluno(@PathVariable("id") long id, RedirectAttributes attributes, Model model){
        try{
           Aluno aluno = alunoService.buscarAlunoPorId(id);
           model.addAttribute("objetoAluno", aluno);
           return "/aluno-atualizar";
        }catch (AlunoNotFoundException e){
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "/aluno-atualizar";
    }

    @PostMapping("/editar-aluno/{id}")
    public String editarAluno(@PathVariable("id") long id, @ModelAttribute("objetoAluno") Aluno aluno, RedirectAttributes attributes){
        alunoService.editarAluno(aluno);
        attributes.addFlashAttribute("mensagem","Atualização do Aluno Realizada");
        return "/aluno-atualizar";
    }
}
