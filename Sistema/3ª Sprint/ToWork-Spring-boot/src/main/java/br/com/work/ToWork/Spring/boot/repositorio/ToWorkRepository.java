package br.com.work.ToWork.Spring.boot.repositorio;

import br.com.work.ToWork.Spring.boot.dominio.Dev;
import br.com.work.ToWork.Spring.boot.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ToWorkRepository extends JpaRepository<Usuario, Integer> {

    Dev findByEmailAndSenha(String email, String senha);

    @Query("update Dev d set d.totalVisualizacoes = ?1 where d.id = ?2")
    public void updateDevWhereById(Integer valorNovo, Integer id);

}