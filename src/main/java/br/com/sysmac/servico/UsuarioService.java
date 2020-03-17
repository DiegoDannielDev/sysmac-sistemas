package br.com.sysmac.servico;

import br.com.sysmac.entitys.Usuario;
import br.com.sysmac.exceptions.UsuarioExceptions;
import br.com.sysmac.exceptions.emuns.UsuarioEnum;
import br.com.sysmac.repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.swing.*;
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
        JOptionPane.showMessageDialog(null, UsuarioEnum.USUARIO_CADASTRADO.getMsg());
        return usuarioRepository.save(usuario);
    }


    public boolean deleteUsuario(Long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            this.usuarioRepository.deleteById(id);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Código do usuario não encontrado");
            return false;
        }

    }

    public Long findCodigo() {
        return this.usuarioRepository.count() + 1;
    }

//    public void updateUsuario(Usuario usuario) {
//        this.usuarioRepository.updateUsuario(usuario.getEmailUser(), usuario.getLoginUser(), usuario.getNomeUser(), usuario.getCodigoUser());
//    }
}
