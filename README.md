
📚 Sistema de Biblioteca com JPA

Este projeto é um sistema simples de gerenciamento de biblioteca feito em Java com JPA (Java Persistence API) e banco de dados H2, simulando operações de CRUD para alunos, livros e empréstimos.


📦 Funcionalidades

 📖 Cadastro de livros
 👩‍🎓 Cadastro de alunos
 🔁 Registro de empréstimos de livros
 📂 Listagem de todos os registros
 🚫 Validações e tratamento de erros
 🧪 Testes unitários com JUnit
 🗃️ População automática do banco de dados para testes
 📝 Logs simples com `System.out.println()`


🛠️ Tecnologias Utilizadas

- Java 17+
- JPA (Hibernate)
- H2 Database (em memória)
- Maven
- JUnit 5


🗂️ Estrutura do Projeto

```bash
biblioteca-jpa/
├── src/
│   ├── main/
│   │   ├── java/com/exemplo/
│   │   │   ├── dao/
│   │   │   │   ├── AlunoDAO.java
│   │   │   │   ├── LivroDAO.java
│   │   │   │   └── EmprestimoDAO.java
│   │   │   ├── model/
│   │   │   │   ├── Aluno.java
│   │   │   │   ├── Livro.java
│   │   │   │   └── Emprestimo.java
│   │   │   ├── util/
│   │   │   │   ├── JPAUtil.java
│   │   │   │   └── PopuladorBanco.java
│   │   │   └── Main.java
│   ├── test/
│   │   └── java/com/exemplo/
│   │       └── dao/
│   │           ├── AlunoDAOTest.java
│   │           ├── LivroDAOTest.java
│   │           └── EmprestimoDAOTest.java
└── resources/
    └── META-INF/persistence.xml
```


▶️ Como Executar

1. Clone ou baixe o repositório.
2. Importe em sua IDE como projeto Maven.
3. Execute a classe `Main.java`.
4. Veja os dados sendo populados e operações feitas no console.

> 💡 O banco de dados H2 é reiniciado a cada execução.


🧪 Executar os Testes

Basta rodar os testes via JUnit na sua IDE ou com Maven:

```bash
mvn test
```

Os testes incluem:

- ✅ Salvamento e busca de alunos, livros e empréstimos
- ❌ Testes de falha para entradas inválidas (ex: nome nulo)


⚠️ Validações Incluídas

- Nome do aluno e título do livro não podem ser nulos ou vazios
- Empréstimo precisa de aluno, livro e datas válidas
- Todas as validações lançam `IllegalArgumentException` em caso de erro


🧠 Observações

- O banco H2 roda em memória e é configurado via `persistence.xml`.
- O console do H2 está ativado e pode ser acessado em:
- Mudei o nome de Publicações pra livro para fins de entendimento e simplificar o termo. 
  ```
  http://localhost:8082
  ```


📌 Autor

Projeto criado por Marlon Henrique Silva da Silva como exemplo de uso de JPA com boas práticas.
