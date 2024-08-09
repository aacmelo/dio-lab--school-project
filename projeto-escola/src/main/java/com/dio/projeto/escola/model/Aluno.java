package com.dio.projeto.escola.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import lombok.*;

@Entity
@DynamicUpdate
@Table(name = "tab_aluno")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdAluno;

    @NotBlank(message = "Cadastro Não Realizado Informe o Nome do Aluno no Campo Nome")
    @Size(min = 25, message = "Digite no minino 25 Caracteres no Campo Nome")
    @Column(name = "Nome", length = 100, nullable = false)
    private String nome;

    @NotBlank(message = "Cadastro Não Realizado Informe o Telefone com o DDD e o Numero no Campo Telefone")
    @Size(min = 14, message = "Digite no minino os 14 Caracteres no Campo Telefone")
    @Column(name = "Telefone", length = 50, nullable = false)
    private String telefone;

    @NotBlank(message = "Cadastro Não Realizado Informe o E-mail do Aluno no Campo E-mail")
    @Column(name = "E-mail", length = 100, nullable = false)
    private String email;

    @NotBlank(message = "Cadastro Não Realizado Informe o CPF do Aluno no Campo CPF")
    @Size(min = 14, message = "Digite no Minimo os 14 Caracters no Campo CPF")
    @Column(name = "CPF", length = 14, unique = true, nullable = false)
    private String cpf;

    @NotBlank(message = "Cadastro Não Realizado Informe o RG do Aluno no Campo RG")
    @Size(min = 12, message = "Digite no Minimo os 12 Caracteres no Campo RG")
    @Column(name = "RG", length = 12, unique = true, nullable = false)
    private String rg;

    @NotBlank(message = "Cadastro Não Realizado Informe a Data de Nascimento do Aluno no Campo Data de Nascimento")
    @Column(name = "Data de Nascimento", length = 11, nullable = false)
    private String dataNascimento;

    @NotBlank(message = "Cadastro Não Realizado Informe o CEP do Aluno no Campo CEP")
    @Size(min = 9, message = "Digite no Minimo 9 Caracteres no Campo CEP")
    @Column(name = "CEP", length = 9, nullable = false)
    private String cep;

    @NotBlank(message = "Cadastro Não Realizado Informe o Endereço do Aluno no Campo Endereço")
    @Column(name = "Endereço", length = 100, nullable = false)
    private String endereco;

    @NotBlank(message = "Cadastro Não Realizado Informe o Numero do Endereço do Aluno no Campo Numero")
    @Column(name = "Numero", length = 50, nullable = false)
    private String numero;

    @NotBlank(message = "Cadastro Não Realizado Informe o Bairro do Aluno no Campo Bairro")
    @Column(name = "Bairro", length = 60, nullable = false)
    private String bairro;

    @NotBlank(message = "Cadastro Não Realizado Informe a Cidade do Aluno no Campo Cidade")
    @Column(name = "Cidade", length = 70, nullable = false)
    private String cidade;

    @NotBlank(message = "Cadastro Não Realizado Informe o Estado do Aluno no Campo Estado")
    @Column(name = "Estado", length = 50, nullable = false)
    private String estado;
}