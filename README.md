Markdown
# Sistema de Avaliação Física

Aplicação full-stack desenvolvida para cadastro, cálculo automatizado de IMC, geração de recomendações e gerenciamento do histórico de avaliações físicas.

---

## Tecnologias Utilizadas

- **Back-end:** Java 17, Spring Boot, Spring JDBC (JdbcTemplate), H2 Database / MySQL
- **Front-end:** React (Vite), JavaScript, CSS Modules
- **Controle de Versão:** Git e GitHub

---

## Funcionalidades

- **Cadastro de Avaliações:** Formulário dinâmico para coleta de dados antropométricos e metas do aluno.
- **Cálculo de IMC e Recomendações:** Processamento no back-end para classificação do IMC e regras de negócio com diretrizes de saúde.
- **Histórico em Tempo Real:** Consulta e renderização assíncrona das avaliações cadastradas.
- **Exclusão de Registros:** Limpeza completa do histórico por meio de endpoint REST dedicado com status HTTP padronizados.

---

## Endpoints da API (/avaliacoes)

| Método | Endpoint | Descrição | Resposta de Sucesso |
|---|---|---|---|
| GET | /avaliacoes | Retorna a lista de avaliações cadastradas | 200 OK |
| POST | /avaliacoes | Realiza o cálculo e persiste nova avaliação | 201 Created |
| DELETE | /avaliacoes | Remove todo o histórico de avaliações | 204 No Content / 404 Not Found |

---

## Instruções de Execução

### Pré-requisitos
- JDK 17 ou superior
- Node.js (versão 18+) e npm

### Executando o Back-end
1. Acesse o diretório `back`:
   ```bash
   cd back
Execute a aplicação via Maven Wrapper ou direto pela IDE na classe BackApplication.java:

Bash
./mvnw spring-boot:run
A API responderá em: http://localhost:8080.

Executando o Front-end
Em outro terminal, acesse o diretório front:

Bash
cd front
Instale os pacotes:

Bash
npm install
Inicie o ambiente de desenvolvimento:

Bash
npm run dev
Abra o navegador no endereço indicado no console (ex: http://localhost:5173).
