package classes.models;

import javax.persistence.*;

@Entity(name = "aluno") // essa classe tem uma tabela Aluno no banco de dados
public class Aluno {

    @Id // obrigatorio
    @GeneratedValue(strategy = GenerationType.IDENTITY) // o id vai ser gerado pelo banco
    private int id;
    private String nome;
    private int idade;

    @ManyToOne(fetch = FetchType.LAZY) // vario alunos podem morar em um estado
    private Estado estado;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Aluno(String nome, int idade, Estado estado) {
        this(nome, idade);
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", estado=" + estado +
                '}';
    }
}
