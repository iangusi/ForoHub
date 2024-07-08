<h1 align="center"> API Rest. ForoHub 

![Badge Finalizado](https://img.shields.io/badge/status:-finalizado-blue)</h1>

*[Descripción del proyecto]

El objetivo del proyecto fue desarrollar una API Rest utilizando Spring.
Simulando un Foro: esta API se centra especificamente en los tópicos, permitiendo a los usuarios:
- Crear un nuevo tópico;                path/topicos        [POST]
- Mostrar todos los tópicos creados;    path/topicos        [GET]
- Mostrar un tópico específico;         path/topicos/{id}   [GET]
- Actualizar un tópico;                 path/topicos/{id}   [PUT]
- Eliminar un tópico;                   path/topicos/{id}   [DELETE]

En adición se creó un servicio de autenticación/autorización para restringir el acceso a la información.
Generando un token JWT para cada usuario que se registe en la ruta path/login [POST]

Finalmente la API fue documentada con la ayuda de SpringFox Swagger. Cuya documentacion automática y amigable
es visible en la ruta http://server:port/context-path/swagger-ui.html y http://server:port/context-path/v3/api-docs

*[Tecnologías utilizadas y Caracteristicas]

> Proyecto - Maven       <br/>
> Lenguaje - Java 17     <br/>
> Spring Boot 3.3.1      <br/>
> MySQL Workbench 8.0 CE <br/>
> IntelliJ IDEA 2024.1   <br/>

Desarollado por: Ian Gutiérrez Segura

