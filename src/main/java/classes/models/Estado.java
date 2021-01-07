package classes.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String sigla;

    // um estado pode estar em varios alunos
    @OneToMany(mappedBy = "estado", // mapeado pela atributo de casse 'estado' na classe Aluno
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Aluno> alunos;

    public Estado(String sigla) {
        this.sigla = sigla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}
