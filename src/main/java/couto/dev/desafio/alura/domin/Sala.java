package couto.dev.desafio.alura.domin;

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
    @OneToMany
    private List<Reserva> reserva;

}

