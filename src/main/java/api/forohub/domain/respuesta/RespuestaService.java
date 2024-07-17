package api.forohub.domain.respuesta;

import api.forohub.domain.topico.TopicoRepository;
import api.forohub.domain.usuario.UsuarioRepository;
import api.forohub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RespuestaRepository repository;

    public RespuestaCreadaDTO respuestaCreadaDTO(RespuestaDTO respuestaDTO) {
        if (!usuarioRepository.findById(respuestaDTO.usuario_Id()).isPresent()){
            throw new ValidacionDeIntegridad("ID de usuario no registrado. ");
        }
        if (!topicoRepository.findById(respuestaDTO.topico_Id()).isPresent()){
            throw new ValidacionDeIntegridad("ID de tópico no registrado. ");
        }
        var usuario = usuarioRepository.findById(respuestaDTO.usuario_Id()).get();
        var topico =topicoRepository.findById(respuestaDTO.topico_Id()).get();

        var rVerified= new Respuesta(null,respuestaDTO.solucion(),usuario,topico,respuestaDTO.creationDate());
        repository.save(rVerified);
        return new RespuestaCreadaDTO(rVerified);
    }

}