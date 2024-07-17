package api.forohub.domain.topico;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record TopicoDTO(
        @NotNull(message = "El título no puede estar vacío")
        String title,
        @NotNull(message = "El mensaje no puede estar vacio. Favor de escribir un texto")
        String message,
        @NotNull(message = "Seleccione un status")
        Status status,
        @NotNull(message = "Escriba su ID")
        Long usuario_Id,
        @NotNull(message = "Seleccione un curso")
        String curso,
        LocalDateTime date
) {
        public String message() {
            return "";
        }
}