package school.sptech.back;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final JdbcTemplate jdbcTemplate;

    public AvaliacaoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listar() {
        String sql = "SELECT * FROM avaliacao";
        List<Avaliacao> lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Avaliacao.class));

        if (lista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Avaliacao avaliacao) {

        if (avaliacao.getNome() == null || avaliacao.getNome().trim().isEmpty() ||
                avaliacao.getObjetivo() == null || avaliacao.getObjetivo().trim().isEmpty() ||
                avaliacao.getPeso() == null || avaliacao.getAltura() == null) {
            return ResponseEntity.status(400).body("Todos os campos são obrigatórios.");
        }

        if (avaliacao.getPeso() <= 20.0 || avaliacao.getPeso() >= 300.0) {
            return ResponseEntity.status(400).body("O peso deve estar entre 20kg e 300kg.");
        }

        if (avaliacao.getAltura() <= 0.80 || avaliacao.getAltura() >= 2.50) {
            return ResponseEntity.status(400).body("A altura deve estar entre 0.80m e 2.50m.");
        }

        double imcCalculado = avaliacao.getPeso() / (avaliacao.getAltura() * avaliacao.getAltura());
        avaliacao.setImc(Math.round(imcCalculado * 100.0) / 100.0);

        // Regra de Negócio: Recomendação de Treino da Academia baseada no IMC
        if (imcCalculado < 18.5) {
            avaliacao.setRecomendacao("Treino de adaptação neuromuscular com foco em ganho de massa magra");
        } else if (imcCalculado < 25.0) {
            avaliacao.setRecomendacao("Treino de hipertrofia moderada ou manutenção e condicionamento");
        } else if (imcCalculado < 30.0) {
            avaliacao.setRecomendacao("Treino combinado de força com blocos metabólicos e aeróbicos");
        } else {
            avaliacao.setRecomendacao("Treino funcional de baixo impacto articular com estímulo cardiovascular");
        }

        String sql = "INSERT INTO avaliacao (nome, peso, altura, objetivo, imc, recomendacao) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                avaliacao.getNome(),
                avaliacao.getPeso(),
                avaliacao.getAltura(),
                avaliacao.getObjetivo(),
                avaliacao.getImc(),
                avaliacao.getRecomendacao()
        );

        return ResponseEntity.status(201).body(avaliacao);
    }
}
