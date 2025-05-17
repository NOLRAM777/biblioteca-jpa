package com.exemplo.dao;

import com.exemplo.model.Aluno;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoDAOTest {

    private static AlunoDAO alunoDAO;

    @BeforeAll
    static void setup() {
        alunoDAO = new AlunoDAO();
    }

    @Test
    void testSalvarAluno() {
        Aluno aluno = new Aluno("Maria Teste");
        alunoDAO.salvar(aluno);

        List<Aluno> alunos = alunoDAO.buscarTodos();

        assertFalse(alunos.isEmpty(), "Lista de alunos não deve estar vazia.");
        Aluno encontrado = alunos.get(0);

        assertNotNull(encontrado.getId());
        assertEquals("Maria Teste", encontrado.getNome());
    }
}
