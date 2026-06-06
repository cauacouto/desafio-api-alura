package couto.dev.desafio.alura.domin;

import couto.dev.desafio.alura.Enum.status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private LocalDateTime dataIncio;
    private LocalDateTime dataFim;
    @Enumerated(value = EnumType.STRING)
    private status status;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Sala sala;


    public void VerificarSala() {
        if (sala == null ||!sala.isAtiva()) {
            throw new IllegalArgumentException("sala nula ou inativa");

        }
    }

}
