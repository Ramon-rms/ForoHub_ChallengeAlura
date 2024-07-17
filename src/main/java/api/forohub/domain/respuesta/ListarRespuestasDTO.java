package api.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record ListarRespuestasDTO(Long id,
                                String solucion,
                                Long usuario_Id,
                                Long topico_Id,
                                LocalDateTime creationDate) {
    public ListarRespuestasDTO(Respuesta respuesta){
        this(respuesta.getId(),
                respuesta.getSolucion(),
                respuesta.getAuthor().getId(),
                respuesta.getTopico().getId(),
                respuesta.getCreationDate());
    }
}
