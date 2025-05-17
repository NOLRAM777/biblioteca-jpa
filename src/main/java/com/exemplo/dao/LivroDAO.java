package com.exemplo.dao;

import com.exemplo.model.Livro;
import com.exemplo.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class LivroDAO {

    public void salvar(Livro livro) {
        if (livro == null || livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O título do livro não pode ser nulo ou vazio.");
        }

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(livro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Livro> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
        } finally {
            em.close();
        }
    }
}
