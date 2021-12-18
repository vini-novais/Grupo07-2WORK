package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Interacao {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInteracao;
    private ZonedDateTime dataInteracao;
    private String nomeDeQuemInteragiu;
    @ManyToOne
    private Publicacao publicacao;
    private String Comentario;

}