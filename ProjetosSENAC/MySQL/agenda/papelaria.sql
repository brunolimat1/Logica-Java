create database papelariadb charset=utf8mb4 collate=utf8mb4_general_ci;
use papelariadb;
create table usuario(
idusuario int auto_increment primary key,
nomeusuario varchar(20) unique not null,
senha varchar(200) not null,
nivelacesso enum('Admin','User','Sales','Operator') 
) engine innodb charset=utf8mb4 collate=utf8mb4_general_ci;

-- ACIMA A TABLE CRIADA PARA O PROJETO PAPELARIA :D

select * from usuario;

insert into usuario(nomeusuario, senha, nivelacesso)
values('roberto',sha('123'), 'Admin');