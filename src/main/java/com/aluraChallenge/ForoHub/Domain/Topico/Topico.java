package com.aluraChallenge.ForoHub.Domain.Topico;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String autor;

    private String curso;

    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = Status.ABIERTO;
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }

    public void actualizar(DatosRegistroTopico datosRegistroTopico) {
        if(datosRegistroTopico.titulo() != null && !datosRegistroTopico.titulo().isEmpty())
            this.titulo = datosRegistroTopico.titulo();
        if(datosRegistroTopico.mensaje() != null && !datosRegistroTopico.mensaje().isEmpty())
            this.mensaje = datosRegistroTopico.mensaje();
        if(datosRegistroTopico.autor() != null && !datosRegistroTopico.autor().isEmpty())
            this.autor = datosRegistroTopico.autor();
        if(datosRegistroTopico.curso() != null && !datosRegistroTopico.curso().isEmpty())
            this.curso = datosRegistroTopico.curso();
    }
}
