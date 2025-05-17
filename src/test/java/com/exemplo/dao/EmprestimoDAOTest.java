package com.exemplo.dao;

import com.exemplo.model.Aluno;
import com.exemplo.model.Livro;
import com.exemplo.model.Emprestimo;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoDAOTest {

    private static AlunoDAO alunoDAO;
    private static LivroDAO livroDAO;
    private static EmprestimoDAO emprestimoDAO;

    @BeforeAll
    static void setup() {
        alunoDAO = new AlunoDAO();
        livroDAO = new LivroDAO();
        emprestimoDAO = new EmprestimoDAO();
    }

    @Test
    void testSalvarEmprestimo() {
        Aluno aluno = new Aluno("João Teste");
        Livro livro = new Livro("O Hobbit");

        alunoDAO.salvar(aluno);
        livroDAO.salvar(livro);

        Emprestimo emprestimo = new Emprestimo(aluno, livro, LocalDate.now());
        emprestimoDAO.salvar(emprestimo);

        List<Emprestimo> emprestimos = emprestimoDAO.buscarTodos();

        assertFalse(emprestimos.isEmpty(), "A lista de empréstimos não deveria estar vazia.");
        Emprestimo recuperado = emprestimos.get(0);

        assertNotNull(recuperado.getId());
        assertEquals("João Teste", recuperado.getAluno().getNome());
        assertEquals("O Hobbit", recuperado.getLivro().getTitulo());
    }

    @AfterEach
    void limpar() {
        // Opcional: implementa se quiser remover os dados após cada teste
    }
}
