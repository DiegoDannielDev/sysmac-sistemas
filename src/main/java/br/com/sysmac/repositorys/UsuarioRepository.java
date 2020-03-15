package br.com.sysmac.repositorys;

import br.com.sysmac.entitys.Usuario;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Long> {

//    @Modifying
//    @Query("UPDATE usuario u SET u.email_user= :email , u.login_user= :login, u.nome_user= :nome, u.senha_user= :senha WHERE u.codigo_user= :codigo")
//    void updateUsuario(@Param("email") String email, @Param("login") String login, @Param("nome") String nome, @Param("codigo") Long codigo);

//    @Query("select count(u.codigo_user) + 1 from usuario u")
//     Long findCodigo();
}
