package br.com.servico;

import br.com.entitys.Usuario;
import br.com.exceptions.UsuarioExceptions;
import br.com.exceptions.enums.UsuarioEnum;
import br.com.repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

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

    public Usuario findById(Long id) {
        Optional<Usuario> byId = this.usuarioRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new UsuarioExceptions("Usuario não encontrado");
        }

    }

    public Usuario save(Usuario usuario) {
        if (usuario.getNomeUser().equals(null)) {
            throw new UsuarioExceptions(UsuarioEnum.USUARIO_NOME_NULLO.getMsg());
        }
        if (usuario.getSenhaUser().equals(null)) {
            throw new UsuarioExceptions(UsuarioEnum.USUARIO_SENHA_NULLO.getMsg());
        }
        return usuarioRepository.save(usuario);
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }


}
