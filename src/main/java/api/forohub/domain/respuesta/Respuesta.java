package api.forohub.domain.respuesta;

import api.forohub.domain.topico.Topico;
import api.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity(name="Respuesta")
@Table(name = "respuestas")
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creationDate;
    private String solucion;
    @OneToOne
    @JoinColumn(name="author", referencedColumnName="id")
    private Usuario author;
    @OneToOne
    @JoinColumn(name="topico", referencedColumnName="id")
    private Topico topico;
    private boolean active;

    public Respuesta(Long id, String solucion, Usuario usuario, Topico topico, LocalDateTime creationDate) {
        this.id=id;
        this.solucion = solucion;
        this.author=usuario;
        this.topico=topico;
        this.creationDate=LocalDateTime.now();
    }

    public void respuestaActualizada(RespuestaActualizadaDTO respuestaActualizadaDTO) {
        if (respuestaActualizadaDTO.solucion() != null){
            this.solucion =respuestaActualizadaDTO.solucion();
        }
    }
    public void desactivaResponse(){

        this.active =false;
    }
}