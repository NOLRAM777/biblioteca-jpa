package com.exemplo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    public Aluno() {}

    public Aluno(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
