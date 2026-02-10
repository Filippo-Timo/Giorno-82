package filippotimo.Giorno_82.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class NewUserPayload {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
}
