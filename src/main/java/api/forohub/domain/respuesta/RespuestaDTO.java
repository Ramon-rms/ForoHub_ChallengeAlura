package api.forohub.domain.respuesta;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespuestaDTO(
        @NotBlank
        String solucion,
        @NotNull
        @Valid
        Long usuario_Id,
        @NotNull
        @Valid
        Long topico_Id,
        LocalDateTime creationDate) {
}