package com.exemplo.util;

import com.exemplo.dao.AlunoDAO;
import com.exemplo.dao.LivroDAO;
import com.exemplo.model.Aluno;
import com.exemplo.model.Livro;

public class PopuladorBanco {
    public static void popular() {
        AlunoDAO alunoDAO = new AlunoDAO();
        LivroDAO livroDAO = new LivroDAO();

        System.out.println("Populando banco de dados...");

        alunoDAO.salvar(new Aluno("Carlos Silva"));
        alunoDAO.salvar(new Aluno("Ana Souza"));

        livroDAO.salvar(new Livro("Dom Casmurro"));
        livroDAO.salvar(new Livro("O Cortiço"));

        System.out.println("Banco populado com sucesso!");
    }
}
