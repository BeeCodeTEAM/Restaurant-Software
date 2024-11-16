create database if not exists Login;
use Login;

create table if not exists usuario (

 id_usuario int auto_increment not null,
 nome_usuario varchar(45),
 senha_usuario varchar(45),
 primary key (id_usuario)
 
 );

 select * from usuario;