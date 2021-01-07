package classes;

import classes.models.Aluno;
import classes.models.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-basico");
        EntityManager entityManager = factory.createEntityManager();

        Estado estado = new Estado("RJ");
        Aluno aluno1 = new Aluno("Joseph", 25, estado);
        Aluno aluno2 = new Aluno("Martha", 21, estado);
        Aluno aluno3 = new Aluno("Mary", 26, estado);


        entityManager.getTransaction().begin(); // eh obrigatorio iniciar uma transacao

        entityManager.persist(estado);
        entityManager.persist(aluno1);
        entityManager.persist(aluno2);
        entityManager.persist(aluno3);

        entityManager.getTransaction().commit(); // faz a transacao

        // recuperando as informacoes
        System.out.println(entityManager.find(Aluno.class, 1));
        System.out.println(entityManager.find(Aluno.class, 2));



        /* ==========================================
           | Utilizando o JPQL para fazer consultas |
           ========================================== */

        // consultas em SQL:
        // SELECT * FROM aluno WHERE nome='Mary'

        String jpql = "SELECT a FROM aluno a WHERE a.nome = :nome";
        Aluno alunoJpql = entityManager
                .createQuery(jpql, Aluno.class)
                .setParameter("nome", "Mary")
                .getSingleResult();
        System.out.println("Busca por Mary: " + alunoJpql);

        String jqplList = "SELECT a FROM aluno a";
        List<Aluno> alunoJqplList = entityManager
                .createQuery(jqplList, Aluno.class)
                .getResultList();
        System.out.println("Buscando tudo:" + alunoJqplList);

        jqplList = "SELECT a FROM aluno a WHERE a.estado.sigla = :siglaEstado";
        List<Aluno> alunoList = entityManager
                .createQuery(jqplList, Aluno.class)
                .setParameter("siglaEstado", "RJ")
                .getResultList();
        System.out.println("Filtrado por estado: " + alunoList);

        // fechando as conexoes
        entityManager.close();
        factory.close();
    }
}
