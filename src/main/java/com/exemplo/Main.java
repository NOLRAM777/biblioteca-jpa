package com.exemplo;

import com.exemplo.dao.AlunoDAO;
import com.exemplo.dao.EmprestimoDAO;
import com.exemplo.dao.LivroDAO;
import com.exemplo.model.Aluno;
import com.exemplo.model.Emprestimo;
import com.exemplo.model.Livro;
import com.exemplo.util.PopuladorBanco;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Popula o banco com dados iniciais
        PopuladorBanco.popular();

        AlunoDAO alunoDAO = new AlunoDAO();
        LivroDAO livroDAO = new LivroDAO();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        // Buscar um aluno e um livro para emprestar
        List<Aluno> alunos = alunoDAO.buscarTodos();
        List<Livro> livros = livroDAO.buscarTodos();

        if (!alunos.isEmpty() && !livros.isEmpty()) {
            Emprestimo emprestimo = new Emprestimo(
                    alunos.get(0),
                    livros.get(0),
                    LocalDate.now(),
                    LocalDate.now().plusDays(7)
            );

            emprestimoDAO.salvar(emprestimo);
            System.out.println("Empréstimo salvo com sucesso.");
        } else {
            System.out.println("Não há alunos ou livros disponíveis.");
        }
    }
}

