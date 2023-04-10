/**
 * Sistema para gestão de OS
 * @author Bruno Lima
 */
 
 drop database dbsistema;
 create database dbsistema;
 use dbsistema;
 show tables;
 
delete from usuarios WHERE id = 1;
 
create table usuarios (
	id int primary key auto_increment,
    nome varchar(50) not null,
    login varchar(15) not null,
    senha varchar(250) not null
);

describe usuarios;
select * from usuarios;

insert into usuarios (nome, login, senha)
values ('Troll','brabo','123456');

-- uso do md5() para criptografar uma senha
insert into usuarios (nome, login, senha)
values ('Jorge','admin', md5('123jorgin'));


update usuarios set nome = 'Troll' where id = 2;

