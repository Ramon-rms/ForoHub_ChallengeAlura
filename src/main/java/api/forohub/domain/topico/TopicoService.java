package api.forohub.domain.topico;

import api.forohub.domain.usuario.UsuarioRepository;
import api.forohub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public RespuestaTopicoDTO topicoCreado(TopicoDTO TopicoDTO){
        if (!usuarioRepository.findById(TopicoDTO.usuario_Id()).isPresent()){
            throw new ValidacionDeIntegridad("Este ID de usuario no está registrado en la base de datos.");
        }
        var title= TopicoDTO.title();
        if (title != null && topicoRepository.existsByTitleIgnoreCase(title)){
            throw new ValidacionDeIntegridad("Este título ya está presente en la base de datos. Por favor revise el tópico existente.");
        }
        String message = TopicoDTO.message();
        if (message != null && topicoRepository.existsByMessageIgnoreCase(message)){
            throw new ValidacionDeIntegridad("Este mensaje ya está presente en la base de datos. Por favor revise el tópico existente.");
        }
        var usuario = usuarioRepository.findById(TopicoDTO.usuario_Id()).get();
        var topicoId= new Topico(null,title,message,TopicoDTO.date(),TopicoDTO.status(),usuario,TopicoDTO.curso());
        topicoRepository.save(topicoId);
        return new RespuestaTopicoDTO(topicoId);
    }
}