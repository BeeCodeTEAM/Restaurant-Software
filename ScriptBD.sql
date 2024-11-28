create database if not exists BeeFood;
use BeeFood;
#Cliente
create table if not exists usuario (
 id_usuario int auto_increment not null,
 nome_usuario varchar(45),
 senha_usuario varchar(45),
 primary key (id_usuario)

 );
 create table if not exists funcionario (
  id_funcionario int auto_increment not null,
  nome_funcionario varchar(45),
  senha_funcionario varchar (40),
  isFuncionario boolean,
  codeFuncionario int,
  primary key(id_funcionario)
 );
 INSERT INTO funcionario ( codeFuncionario)
 VALUES
 (800),
 (100);

 select * from usuario;