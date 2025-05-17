package com.exemplo.dao;

import com.exemplo.model.Aluno;
import com.exemplo.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AlunoDAO {

    public void salvar(Aluno aluno) {
        if (aluno == null || aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do aluno não pode ser nulo ou vazio.");
        }

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Aluno> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
        } finally {
            em.close();
        }
    }
}
