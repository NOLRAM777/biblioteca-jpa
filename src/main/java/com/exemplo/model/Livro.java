package com.exemplo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    public Livro() {}

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}

