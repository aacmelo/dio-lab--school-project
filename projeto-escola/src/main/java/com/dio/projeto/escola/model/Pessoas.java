package com.dio.projeto.escola.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "tab_pessoas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPessoa;

    @NotBlank(message = "Informe o Nome para Realizar o Cadastro")
    @Size(min = 25, message = "Digite o Nome Completo da Pessoa")
    @Column(name = "Nome", length = 100, nullable = false)
    private String nome;

    @NotBlank(message = "Informe o Telefone com o DDD e o Numero")
    @Size(min = 14, message = "Digite no minino os 14 Caracteres no Campo")
    @Column(name = "Telefone", length = 50, nullable = false)
    private String telefone;

    @NotBlank(message = "Informe o E-mail da Pessoa")
    @Column(name = "E-mail", length = 100, nullable = false)
    private String email;

    @NotBlank(message = "Informe o CPF da Pessoa")
    @Size(min = 14, message = "Digite no Minimo os 14 Caracters no Campo")
    @Column(name = "CPF", length = 14, unique = true, nullable = false)
    private String cpf;

    @NotBlank(message = "Digite o RG da Pessoa")
    @Size(min = 12, message = "Digite no Minimo os 12 Caracteres no Campo")
    @Column(name = "RG", length = 12, unique = true, nullable = false)
    private String rg;

    @NotBlank(message = "Digite a Data de Nascimento da Pessoa")
    @Column(name = "Data de Nascimento", length = 11, nullable = false)
    private String dataNascimento;

    @NotBlank(message = "Informe o CEP da Pessoa")
    @Size(min = 9, message = "Digite no Minimo 9 Caracteres no Campo")
    @Column(name = "CEP", length = 9, nullable = false)
    private String cep;

    @NotBlank(message = "Informe o Endereço da Pessoa")
    @Column(name = "Endereço", length = 100, nullable = false)
    private String endereco;

    @NotBlank(message = "Informe o Numero da Residencia da Pessoa")
    @Column(name = "Numero", length = 50, nullable = false)
    private String numero;

    @NotBlank(message = "Informe o Bairro da Pessoa")
    @Column(name = "Bairro", length = 60, nullable = false)
    private String bairro;

    @NotBlank(message = "Informe a Cidade da Pessoa")
    @Column(name = "Cidade", length = 70, nullable = false)
    private String cidade;

    @NotBlank(message = "Informe o Estado da Pessoa")
    @Column(name = "Estado", length = 50, nullable = false)
    private String estado;
}
