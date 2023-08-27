package tech.ada.bootcamp.arquitetura.cafeservice.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.ada.bootcamp.arquitetura.cafeservice.exceptions.NotFoundException;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Plano;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Usuario;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.PlanoRepository;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.UsuarioRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarUsuarioServiceTest {
    @InjectMocks
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private PlanoRepository planoRepository;

    @Test
    void shouldInsertUsuarioWithNoErrors(){
        Usuario usuario = mock(Usuario.class);
        Assertions.assertDoesNotThrow(()->cadastrarUsuarioService.salvarUsuario(usuario));
        verify(usuarioRepository, times(1))
                .save(any(Usuario.class));

    }

    @Test
    void shouldAddAnPlanoToUsuario(){
        Usuario usuario = mock(Usuario.class);
        Plano plano = mock(Plano.class);
        when(usuarioRepository.findById(anyString()))
                .thenReturn(Optional.of(usuario));
        when(planoRepository.findById(anyLong()))
                .thenReturn(Optional.of(plano));
        Assertions.assertDoesNotThrow(()->cadastrarUsuarioService.adicionarPlanoAoUsuario("0000", 1L));
        verify(usuarioRepository, times(1))
                .save(any(Usuario.class));
    }

    @Test
    void shouldNotAddPlanoWithNoPlanoFound(){
        when(planoRepository.findById(anyLong()))
                .thenReturn(Optional.empty());
        NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () -> cadastrarUsuarioService.adicionarPlanoAoUsuario("0000", 1L));
        Assertions.assertEquals("Plano", notFoundException.getEntityNotFound());
        verify(usuarioRepository, never())
                .save(any(Usuario.class));
    }

    @Test
    void shouldNotAddUsuarioAoPlanoComUsuarioInvalido(){
        Plano plano = mock(Plano.class);
        when(usuarioRepository.findById(anyString()))
                .thenReturn(Optional.empty());
        when(planoRepository.findById(anyLong()))
                .thenReturn(Optional.of(plano));
        NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () -> cadastrarUsuarioService.adicionarPlanoAoUsuario("0000", 1L));
        Assertions.assertEquals("Usuario", notFoundException.getEntityNotFound());
        verify(usuarioRepository, never())
                .save(any(Usuario.class));
    }
}
