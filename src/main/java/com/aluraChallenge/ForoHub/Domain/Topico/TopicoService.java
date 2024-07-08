package com.aluraChallenge.ForoHub.Domain.Topico;

import com.aluraChallenge.ForoHub.Domain.Topico.Validaciones.ValidadorTopicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    List<ValidadorTopicos> validaciones;

    public Topico agregarTopico(DatosRegistroTopico datosRegistroTopico){
        validaciones.forEach(v -> v.validar(datosRegistroTopico));
        var topico = new Topico(datosRegistroTopico);
        return topico;
    }
}
