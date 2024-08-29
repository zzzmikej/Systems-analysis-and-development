package school.sptech.projetojpadto.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class UsuarioCriacaoDto {

    @Size(min = 3, max = 255)
    private String nome;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 6, max = 20)
    private String senha;
    @CPF
    @NotBlank
    private String cpf;
    @Past
    @NotNull
    private LocalDate dataNascimento;

    // GERAR GETTER E SETTER

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
