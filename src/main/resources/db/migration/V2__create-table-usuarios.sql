create table usuarios(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    correo varchar(100) not null,
    contraseña varchar(200),
    primary key(id)

);