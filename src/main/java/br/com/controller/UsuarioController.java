package br.com.controller;

import br.com.dao.UsuarioDao;
import br.com.entitys.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @GetMapping("/usuario")
    private ResponseEntity getUsuario() {
        List<Usuario> usuarioList = this.usuarioDao.getUsuario();
        return new ResponseEntity(usuarioList, HttpStatus.OK);
    }
}
