import { useState, useEffect } from 'react';
import styles from './App.module.css';

function App() {
  const [avaliacoes, setAvaliacoes] = useState([]);
  const [nome, setNome] = useState('');
  const [peso, setPeso] = useState('');
  const [altura, setAltura] = useState('');
  const [objetivo, setObjetivo] = useState('');

  const URL_API = 'http://localhost:8080/avaliacoes';

  async function carregarAvaliacoes() {
    try {
      const resposta = await fetch(URL_API);
      if (resposta.status === 200) {
        const dados = await resposta.json();
        setAvaliacoes(dados);
      } else if (resposta.status === 204) {
        setAvaliacoes([]);
      }
    } catch (erro) {
      console.error('Erro ao buscar avaliações:', erro);
    }
  }

  useEffect(() => {
    carregarAvaliacoes();
  }, []);

  async function cadastrar(evento) {
    evento.preventDefault();

    const novaAvaliacao = {
      nome,
      peso: parseFloat(peso),
      altura: parseFloat(altura),
      objetivo
    };

    try {
      const resposta = await fetch(URL_API, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(novaAvaliacao)
      });

      if (resposta.status === 201) {
        setNome('');
        setPeso('');
        setAltura('');
        setObjetivo('');
        carregarAvaliacoes();
      } else {
        alert('Erro ao cadastrar. Verifique os valores informados.');
      }
    } catch (erro) {
      console.error('Erro ao enviar avaliação:', erro);
    }
  }

  async function limparHistorico() {
    if (avaliacoes.length === 0) {
      alert('O histórico já está vazio.');
      return;
    }

    try {
      const resposta = await fetch(URL_API, {
        method: 'DELETE'
      });

      if (resposta.status === 204) {
        setAvaliacoes([]);
      } else if (resposta.status === 404) {
        alert('Nenhum registro encontrado para excluir.');
      } else {
        alert('Erro ao limpar histórico.');
      }
    } catch (erro) {
      console.error('Erro ao deletar histórico:', erro);
    }
  }

  return (
    <div className={styles.container}>
      <h1 className={styles.titulo}>Avaliação Física - Academia</h1>

      <form onSubmit={cadastrar} className={styles.formulario}>
        <input
          className={styles.input}
          type="text"
          placeholder="Nome do Aluno"
          value={nome}
          onChange={(e) => setNome(e.target.value)}
          required
        />
        <input
          className={styles.input}
          type="number"
          step="0.1"
          placeholder="Peso (kg) ex: 75.5"
          value={peso}
          onChange={(e) => setPeso(e.target.value)}
          required
        />
        <input
          className={styles.input}
          type="number"
          step="0.01"
          placeholder="Altura (m) ex: 1.75"
          value={altura}
          onChange={(e) => setAltura(e.target.value)}
          required
        />

        <select
          className={styles.input}
          value={objetivo}
          onChange={(e) => setObjetivo(e.target.value)}
          required
        >
          <option value="" disabled>Selecione o seu objetivo...</option>
          <option value="Hipertrofia">Hipertrofia (Ganho de Massa)</option>
          <option value="Emagrecimento">Emagrecimento (Perda de Gordura)</option>
          <option value="Condicionamento">Condicionamento Físico / Resistência</option>
          <option value="Saude">Qualidade de Vida e Saúde</option>
        </select>
        <button type="submit" className={styles.botao}>
          Cadastrar e Gerar Treino
        </button>
        <button onClick={limparHistorico} type='button' className={styles.botaob}>
          Limpar Histórico
        </button>
      </form>

      <h2>Histórico de Avaliações</h2>
      {avaliacoes.length === 0 ? (
        <p>Nenhuma avaliação cadastrada até o momento.</p>
      ) : (
        <table className={styles.tabela}>
          <thead>
            <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Peso</th>
              <th>Altura</th>
              <th>Objetivo</th>
              <th>IMC</th>
              <th>Recomendação</th>
            </tr>
          </thead>
          <tbody>
            {avaliacoes.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.nome}</td>
                <td>{item.peso} kg</td>
                <td>{item.altura} m</td>
                <td>{item.objetivo}</td>
                <td>{item.imc}</td>
                <td>{item.recomendacao}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default App;