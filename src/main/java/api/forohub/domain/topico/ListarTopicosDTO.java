package api.forohub.domain.topico;

import java.time.LocalDateTime;

public record ListarTopicosDTO(
        Long id, //CHECAR SI SE OCUPA EL JSON ALIAS
        String title,
        String message,
        Status status,
        Long usuario_Id,
        String curso,
        LocalDateTime date)

{
    public ListarTopicosDTO (Topico topico){
        this(
                topico.getId(),
                topico.getTitle(),
                topico.getMessage(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso(),
                topico.getFecha());

    }
}