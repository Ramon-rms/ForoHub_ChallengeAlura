package api.forohub.domain.topico;

import api.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity(name="Topico")
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "author_id")
    private Usuario autor;
    private String curso;
    private boolean active;

    public Topico(Long id, String title, String message, LocalDateTime fecha, Status status, Usuario usuario, String curso) {
        this.id=id;
        this.title=title;
        this.message = message;
        this.fecha = fecha;
        this.fecha =LocalDateTime.now();
        this.status=status;
        this.autor =usuario;
        this.curso =curso;
    }

    public void topicoActualizado(TopicoActualizadoDTO topicoActualizadoDTO) {
        if (topicoActualizadoDTO.title() !=null){
            this.title= topicoActualizadoDTO.title();
        }
        if (topicoActualizadoDTO.message() != null){
            this.message =topicoActualizadoDTO.message();
        }
        if (topicoActualizadoDTO.status() != null){
            this.status=topicoActualizadoDTO.status();
        }
        if (topicoActualizadoDTO.curso() != null){
            this.curso =topicoActualizadoDTO.curso();
        }
    }
    public void deactivateTopic(){
        this.active=false;
    }
}