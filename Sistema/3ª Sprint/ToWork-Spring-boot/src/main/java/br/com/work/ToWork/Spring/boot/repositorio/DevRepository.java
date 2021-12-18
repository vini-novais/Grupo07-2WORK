package br.com.work.ToWork.Spring.boot.repositorio;

import br.com.work.ToWork.Spring.boot.dominio.Dev;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepository extends JpaRepository<Dev, Integer> {

}