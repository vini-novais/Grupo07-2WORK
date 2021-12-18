package br.com.work.ToWork.Spring.boot.repositorio;

import br.com.work.ToWork.Spring.boot.dominio.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer> {

}