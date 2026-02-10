package filippotimo.Giorno_82.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@ToString
public class Author {
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    public Author(String nome, String cognome, String email, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;

        Random rndm = new Random();
        this.id = rndm.nextLong(1, 100);

        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }
}
