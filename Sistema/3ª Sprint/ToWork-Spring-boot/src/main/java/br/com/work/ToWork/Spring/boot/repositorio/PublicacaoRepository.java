package br.com.work.ToWork.Spring.boot.repositorio;

import br.com.work.ToWork.Spring.boot.dominio.Dev;
import br.com.work.ToWork.Spring.boot.dominio.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer> {

}
