package couto.dev.desafio.alura.domin;

import couto.dev.desafio.alura.Enum.StatusSala;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String nomeSala;
    private int capacidade;
    private boolean ativa;
    @Enumerated(EnumType.STRING)
    private StatusSala statusSala;
    @OneToMany(mappedBy = "reserva",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reserva> reserva;

}

