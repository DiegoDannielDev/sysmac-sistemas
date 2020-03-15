package br.com.sysmac.dao;

import br.com.sysmac.entitys.Usuario;
import br.com.sysmac.repositorys.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDao.class);


    UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioDao(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDao() {
    }

    public List<Usuario> getUsuario() {
        List<Usuario> usuarioList;
        usuarioList = this.usuarioRepository.findAll();
        return usuarioList;
    }


    public Usuario saveUsuario(Usuario usuario) {
        Usuario usu = new Usuario(usuario.getNomeUser(), usuario.getLoginUser(), usuario.getEmailUser(),
                usuario.getSenhaUser());
        this.usuarioRepository.save(usu);

        return usu;
    }
}
