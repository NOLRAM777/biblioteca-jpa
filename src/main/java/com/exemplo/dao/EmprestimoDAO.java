package com.exemplo.dao;

import com.exemplo.model.Emprestimo;
import com.exemplo.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class EmprestimoDAO {

    public void salvar(Emprestimo emprestimo) {
        if (emprestimo == null) {
            throw new IllegalArgumentException("O empréstimo não pode ser nulo.");
        }
        if (emprestimo.getAluno() == null) {
            throw new IllegalArgumentException("O aluno do empréstimo não pode ser nulo.");
        }
        if (emprestimo.getLivro() == null) {
            throw new IllegalArgumentException("O livro do empréstimo não pode ser nulo.");
        }
        if (emprestimo.getDataEmprestimo() == null || emprestimo.getDataDevolucao() == null) {
            throw new IllegalArgumentException("As datas do empréstimo não podem ser nulas.");
        }

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(emprestimo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Emprestimo> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Emprestimo e", Emprestimo.class).getResultList();
        } finally {
            em.close();
        }
    }
}
