package microservicio.comentarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComentarioService {

    @Autowired
    private RestTemplate restTemplate;

    public String obtenerComentariosUsuario(int usuarioId){
        String usuarioUrl = "http://localhost:8080/usuarioid/"+usuarioId;
        String usuarioData = restTemplate.getForObject(usuarioUrl, String.class);

        String postUrl = "https://jsonplaceholder.typicode.com/posts?userId="+usuarioId;
        String postData = restTemplate.getForObject(postUrl, String.class);

        return "{\"usuario\":" + usuarioData + ",\"post\":" + postData + "}";




    }
    
}
