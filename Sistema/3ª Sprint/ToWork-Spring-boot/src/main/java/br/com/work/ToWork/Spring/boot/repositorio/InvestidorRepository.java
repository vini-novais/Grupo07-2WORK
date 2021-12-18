package br.com.work.ToWork.Spring.boot.repositorio;

import br.com.work.ToWork.Spring.boot.dominio.Investidor;
import br.com.work.ToWork.Spring.boot.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestidorRepository extends JpaRepository<Usuario, Integer> {

    Investidor findByEmailAndSenha(String email, String senha);

}