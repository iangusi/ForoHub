package com.aluraChallenge.ForoHub.Domain.Usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String correo,
        @NotBlank
        String contraseña
) {}
