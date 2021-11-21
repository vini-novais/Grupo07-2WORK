package br.com.work.ToWork.Spring.boot.repositorio;

import br.com.work.ToWork.Spring.boot.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToWorkRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmailAndSenha(String email, String senha);

}