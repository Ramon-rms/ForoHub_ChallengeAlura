package api.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroTopicoDTO (
        @NotBlank(message = "El título está en blanco")
        String title,
        @NotBlank(message = "Mensaje en blanco")
        String message,
        @NotBlank(message = "Curso está en blanco")
        String course,
        @NotNull(message = "ID de autor está vacío")
        Long author_id
) {

    public RegistroTopicoDTO(String title, String message, String course, Long author_id){
        this.title = title;
        this.message = message;
        this.course = course;
        this.author_id = author_id;
    }
}