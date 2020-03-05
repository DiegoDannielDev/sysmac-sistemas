package br.com.servico;

import br.com.model.Usuario;
import br.com.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> findUsuario(Long id) {
        Usuario usuario1 = new Usuario();
        Optional<Usuario> optional = this.usuarioRepository.findById(id);
        if (optional.isPresent()) {
            optional.map(u -> usuario1);
        }
        return optional;
    }
}
