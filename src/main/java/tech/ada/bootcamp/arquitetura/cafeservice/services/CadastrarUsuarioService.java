package tech.ada.bootcamp.arquitetura.cafeservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.arquitetura.cafeservice.exceptions.NotFoundException;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Plano;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Usuario;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.PlanoRepository;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PlanoRepository planoRepository;
    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void adicionarPlanoAoUsuario(String identificador, Long idPlano){
        Plano plano = planoRepository.findById(idPlano)
                .orElseThrow(()->new NotFoundException("Plano"));
        Usuario usuario = findUsuario(identificador);

        usuario.setPlano(plano);
        usuarioRepository.save(usuario);
    }

    public Usuario findUsuario(String identificador) {
        return usuarioRepository.findById(identificador)
                .orElseThrow(() -> new NotFoundException("Usuario"));
    }
}
