package tech.ada.bootcamp.arquitetura.cafeservice.loaddata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Plano;
import tech.ada.bootcamp.arquitetura.cafeservice.model.TipoDesconto;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Usuario;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.PlanoRepository;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.UsuarioRepository;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class PlanoLoadData implements CommandLineRunner {
    public static final String INSANO = "Insano";
    private final PlanoRepository planoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        if(planoRepository.count()==0){
            loadDefaultPlanos();
            createDefaultUsuario();
        }

    }

    private void loadDefaultPlanos() {
        planoRepository.saveAll(
        Arrays.asList(planoDeVezEmQuando(),planoQuaseLa(),planoInsano()));

    }

    private Plano planoDeVezEmQuando(){
        Plano plano = new Plano();
        plano.setDescricao("Um tipo de café além de 10 porcento de desconto");
        plano.setNome("De vez em quando");
        plano.setTipoDesconto(TipoDesconto.PORCENTAGEM);
        plano.setDesconto(10.0);
        return plano;
    }

    private Plano planoQuaseLa(){
        Plano plano = new Plano();
        plano.setDescricao("Dois tipos de café além de 20 porcento de desconto");
        plano.setNome("Quase Lá");
        plano.setTipoDesconto(TipoDesconto.PORCENTAGEM);
        plano.setDesconto(20.0);
        return plano;
    }

    private Plano planoInsano(){
        Plano plano = new Plano();
        plano.setDescricao("Três tipos de café além de 50 porcento de desconto");
        plano.setNome(INSANO);
        plano.setTipoDesconto(TipoDesconto.PORCENTAGEM);
        plano.setDesconto(50.0);
        return plano;
    }

    private void createDefaultUsuario() {
        Usuario usuario = new Usuario();
        usuario.setIdentificador("00000000000");
        usuario.setLogin("Joao");
        usuario.setNome("Jose Joao da Silva");
        usuario.setPlano(planoRepository
                .findByNome(INSANO).orElse(null));
        usuarioRepository.save(usuario);
    }
}
