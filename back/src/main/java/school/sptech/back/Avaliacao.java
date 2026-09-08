package school.sptech.back;

public class Avaliacao{

    private Integer id;
    private String nome;
    private Double peso;
    private Double altura;
    private String objetivo;
    private Double imc;
    private String recomendacao;

    public Avaliacao() {
    }

    public Avaliacao(Integer id, String nome, Double peso, Double altura, String objetivo, Double imc, String recomendacao) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.objetivo = objetivo;
        this.imc = imc;
        this.recomendacao = recomendacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }
}
