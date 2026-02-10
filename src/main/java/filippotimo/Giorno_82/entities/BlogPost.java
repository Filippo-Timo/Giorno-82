package filippotimo.Giorno_82.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class BlogPost {

    private long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    public BlogPost(String categoria, String titolo, String contenuto, int tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;

        Random rndm = new Random();
        this.id = rndm.nextLong(1, 100);

        int nRandom1 = rndm.nextInt(500);
        int nRandom2 = rndm.nextInt(500);
        this.cover = "https://picsum.photos/" + nRandom1 + "/" + nRandom2;
    }
}
