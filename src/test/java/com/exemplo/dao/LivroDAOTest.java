package com.exemplo.dao;

import com.exemplo.model.Livro;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LivroDAOTest {

    private static LivroDAO livroDAO;

    @BeforeAll
    static void setup() {
        livroDAO = new LivroDAO();
    }

    @Test
    void testSalvarLivro() {
        Livro livro = new Livro("1984");
        livroDAO.salvar(livro);

        List<Livro> livros = livroDAO.buscarTodos();

        assertFalse(livros.isEmpty(), "Lista de livros não deve estar vazia.");
        Livro encontrado = livros.get(0);

        assertNotNull(encontrado.getId());
        assertEquals("1984", encontrado.getTitulo());
    }
}
