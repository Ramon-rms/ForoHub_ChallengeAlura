package api.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record RespuestaCreadaDTO(
        Long id,
        String solucion,
        Long usuario_Id,
        Long topico_Id,
        LocalDateTime creationDate
) {
    public RespuestaCreadaDTO(Respuesta rVerified) {
        this(rVerified.getId(),rVerified.getSolucion(),rVerified.getAuthor().getId(),rVerified.getTopico().getId(),rVerified.getCreationDate());
    }
}