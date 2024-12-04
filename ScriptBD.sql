create database if not exists Login;
use Login;

CREATE TABLE IF NOT EXISTS usuario (
    id_usuario INT AUTO_INCREMENT NOT NULL,
    nome_usuario VARCHAR(45) NOT NULL,
    senha_usuario VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_usuario)
);

insert into usuario (nome_usuario,senha_usuario) 
values 
("ian","1234");

 select * from usuario;