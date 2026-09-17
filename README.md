# Sistema de Avaliação Física

Aplicação full-stack desenvolvida para cadastro, cálculo automatizado de IMC, geração de recomendações e gerenciamento do histórico de avaliações físicas.

---

## Tecnologias Utilizadas

- **Back-end:** Java 17, Spring Boot, Spring JDBC (JdbcTemplate), H2 Database / MySQL
- **Front-end:** React (Vite), JavaScript, CSS Modules
- **Controle de Versão:** Git e GitHub

---

## Estrutura de Diretórios

```text
Projeto-Individual-3-Semestre/
│
├── back/                           # Aplicação Back-end (Spring Boot)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/school/sptech/back/
│   │   │   │   ├── Avaliacao.java           # Modelo de dados da avaliação
│   │   │   │   ├── AvaliacaoController.java # Controladora REST (endpoints HTTP)
│   │   │   │   └── BackApplication.java    # Classe principal de inicialização
│   │   │   └── resources/
│   │   │       ├── application.properties   # Configurações do Spring e banco de dados
│   │   │       └── schema.sql               # Script de criação de tabelas DDL
│   │   └── test/                            # Testes unitários e de integração
│   ├── mvnw / mvnw.cmd                      # Executáveis do Maven Wrapper
│   └── pom.xml                              # Gerenciador de dependências Maven
│
├── front/                          # Aplicação Front-end (React + Vite)
│   ├── public/                     # Arquivos estáticos e ícones públicos
│   ├── src/
│   │   ├── assets/                 # Imagens, vetores e mídias da interface
│   │   ├── components/             # Componentes reutilizáveis (botões, cards)
│   │   ├── App.jsx                 # Componente raiz e integração das telas
│   │   ├── App.css / index.css     # Folhas de estilo da aplicação
│   │   └── main.jsx                # Ponto de entrada do React no DOM
│   ├── index.html                  # Arquivo HTML base da aplicação SPA
│   ├── package.json                # Dependências e scripts do Node.js
│   └── vite.config.js              # Configurações do empacotador Vite
│
└── README.md                       # Documentação técnica do projeto
```

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
   ```
2. Execute a aplicação via Maven Wrapper ou direto pela IDE na classe `BackApplication.java`:
   ```bash
   ./mvnw spring-boot:run
   ```
3. A API responderá em: `http://localhost:8080`.

### Executando o Front-end
1. Em outro terminal, acesse o diretório `front`:
   ```bash
   cd front
   ```
2. Instale os pacotes:
   ```bash
   npm install
   ```
3. Inicie o ambiente de desenvolvimento:
   ```bash
   npm run dev
   
   ```
4. Abra o navegador no endereço indicado no console (ex: `http://localhost:5173`).