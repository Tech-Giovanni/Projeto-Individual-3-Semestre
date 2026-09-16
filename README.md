# Projeto-Individual-3-Semestre
Olá! Este repositório é um pequeno projeto meu relacionado á um desafio da faculdade com intuito de integrar duas disciplinas que aprendi na SPTECH, sendo elas, a matéria de Frontend com uso  de React , e no Backend  com o uso de Java


Markdown
#  Sistema de Avaliação Física & Prescrição de Treino

Projeto individual semestral desenvolvido para o curso de Análise e Desenvolvimento de Sistemas da **SPTech**. O sistema integra um back-end robusto em Java com persistência relacional a uma interface web reativa em React, processando dados biométricos e gerando recomendações personalizadas.

---

##  Sobre a Aplicação

A plataforma permite que academias ou personal trainers realizem avaliações físicas cadastrando peso, altura e objetivo do aluno. O back-end recebe as informações, calcula o **IMC (Índice de Massa Corporal)** e determina de forma automatizada uma **recomendação de treino** personalizada de acordo com as faixas de composição corporal e objetivos informados.


## Diretórios
Projeto-Individual-3-Semestre/
├── back/                      
│   ├── src/main/java/         
│   ├── src/main/resources/    
│   └── pom.xml                
│
├── front/                     
│   ├── src/
│   │   ├── App.jsx            
│   │   ├── App.module.css     
│   │   └── main.jsx           
│   └── package.json           
│
├── .gitignore
└── README.md


---

##  Tecnologias Utilizadas

### Back-end
- **Java 17+**
- **Spring Boot 3**
- **Spring JDBC (`JdbcTemplate`)**: consultas e comandos SQL puros, sem ORM pesado.
- **H2 Database**: banco de dados relacional em memória com scripts de inicialização (`schema.sql`).
- **Maven**: gerenciamento de dependências.

### Front-end
- **React** (via **Vite**)
- **JavaScript (ES6+)**
- **CSS Modules (`App.module.css`)**: isolamento de escopo de estilização.
- **Fetch API nativa**: comunicação assíncrona com os endpoints REST da aplicação.

---

## 📡 Endpoints da API REST

| Método | Rota | Descrição | Status de Sucesso | Status Vazio/Erro |
|---|---|---|---|---|
| `GET` | `/avaliacoes` | Lista todas as avaliações cadastradas | `200 OK` (JSON Array) | `204 No Content` |
| `POST` | `/avaliacoes` | Processa os cálculos, prescreve treino e persiste os dados | `201 Created` (JSON Object) | `400 Bad Request` |

### Exemplo de Payload de Requisição (POST `/avaliacoes`):
```json
{
  "nome": "Giovanni",
  "peso": 75.5,
  "altura": 1.69,
  "objetivo": "Emagrecimento"
}
Exemplo de Resposta do Back-end (201 Created):
JSON
{
  "id": 1,
  "nome": "Giovanni",
  "peso": 75.5,
  "altura": 1.69,
  "objetivo": "Emagrecimento",
  "imc": 26.43,
  "recomendacao": "Treino combinado de força com blocos metabólicos e aeróbicos"
}
 Como Executar o Projeto Localmente
1. Pré-requisitos
Java JDK 17+ instalado e configurado nas variáveis de ambiente.

Node.js (versão 18 ou superior) com o gerenciador npm.

Git instalado.

2. Rodando o Back-end (Java / Spring Boot)
Abra a pasta back em sua IDE de preferência (ex: IntelliJ IDEA ou Eclipse).

Deixe o Maven importar todas as dependências do pom.xml.

Execute a classe principal anotada com @SpringBootApplication.

O servidor inicializará e estará ouvindo na porta padrão:

Plaintext
http://localhost:8080
(Opcional) O console web do banco H2 pode ser acessado em:

Plaintext
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:avaliacaodb
User Name: sa
Password: (vazio)
3. Rodando o Front-end (React / Vite)
Abra o terminal integrado e entre na pasta do front-end:

Bash
cd front
Instale as dependências do projeto:

Bash
npm install
Inicie o servidor de desenvolvimento:

Bash
npm run dev
Abra a URL fornecida no terminal no seu navegador (geralmente http://localhost:5173).

Demonstração de Funcionamento
Formulário preenchido com dados do aluno e tabela preenchida com o cálculo e recomendação retornados pelo Java:

(Dica: salve seu print dentro da pasta front/src/assets com o nome evidencia_tela.png para aparecer aqui no GitHub)

Autor:
Desenvolvido por Giovanni

Faculdade de Tecnologia São Paulo Tech School - SPTech
