package com.aluraChallenge.ForoHub.Controller;

import com.aluraChallenge.ForoHub.Domain.Usuario.DatosRegistroUsuario;
import com.aluraChallenge.ForoHub.Domain.Usuario.Usuario;
import com.aluraChallenge.ForoHub.infra.seguridad.DatosJWTToken;
import com.aluraChallenge.ForoHub.infra.seguridad.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosRegistroUsuario.correo(),
                datosRegistroUsuario.contraseña());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
