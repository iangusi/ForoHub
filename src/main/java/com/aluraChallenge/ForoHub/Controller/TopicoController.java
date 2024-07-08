package com.aluraChallenge.ForoHub.Controller;

import com.aluraChallenge.ForoHub.Domain.Topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private  TopicoRepository topicoRepository;
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> RegistrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        var topico = topicoService.agregarTopico(datosRegistroTopico);
        topicoRepository.save(topico);

        var uri = URI.create("http://localhost/topicos/"+topico.getId());
        return ResponseEntity.created(uri).body(new DatosRespuestaTopico(topico));
    }
    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> ListarTopicos(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacion) {
        var page = topicoRepository.findAll(paginacion).map(DatosRespuestaTopico::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> DetallarTopicos(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> ActualizarTopico(@PathVariable Long id,@RequestBody DatosRegistroTopico datosRegistroTopico) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizar(datosRegistroTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity EliminarTopico(@PathVariable Long id) {
        var topico = topicoRepository.findById(id);
        if(topico.isEmpty())
            throw new EntityNotFoundException();

        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
