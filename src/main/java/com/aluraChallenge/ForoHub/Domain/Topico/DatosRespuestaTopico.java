package com.aluraChallenge.ForoHub.Domain.Topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico (
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String autor,
        String curso
){
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
