package com.aluraChallenge.ForoHub.Domain.Topico.Validaciones;

import com.aluraChallenge.ForoHub.Domain.Topico.DatosRegistroTopico;
import com.aluraChallenge.ForoHub.Domain.Topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoRepetido implements ValidadorTopicos{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DatosRegistroTopico datosRegistroTopico) {
        var topicoRepetido = topicoRepository.existsByTituloAndMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje());
        if(topicoRepetido){
            throw new ValidationException("Este topico y mensaje ya existen.");
        }
    }
}
