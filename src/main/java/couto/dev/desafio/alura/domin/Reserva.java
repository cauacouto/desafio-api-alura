package couto.dev.desafio.alura.domin;

import couto.dev.desafio.alura.Enum.statusReserva;
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
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    @Enumerated(value = EnumType.STRING)
    private statusReserva status;
    @ManyToOne
    @JoinColumn(name = "usuario_Id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "sala_Id")
    private Sala sala;


    public void VerificarSala() {
        if (sala == null ||!sala.isAtiva()) {
            throw new IllegalArgumentException("sala nula ou inativa");

        }
    }

}
