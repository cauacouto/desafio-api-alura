package couto.dev.desafio.alura.domin;

import com.fasterxml.jackson.annotation.JsonFormat;
import couto.dev.desafio.alura.Enum.statusReserva;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataInicio;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFim;
    @Enumerated(value = EnumType.STRING)
    private statusReserva status;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;


    public void VerificarSala() {
        if (sala == null ||!sala.isAtiva()) {
            throw new IllegalArgumentException("sala nula ou inativa");

        }
    }

}
