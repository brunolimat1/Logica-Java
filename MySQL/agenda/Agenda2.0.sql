/**
 * Sistema para gestão de OS
 * @author Bruno Lima
 */
 
 drop database dbsistema;
 create database dbsistema;
 use dbsistema;
 show tables;
 
delete from usuarios WHERE id = 6;
 
create table usuarios (
	id int primary key auto_increment,
    nome varchar(50) not null,
    login varchar(15) not null,
    senha varchar(250) not null
);

drop table clientes;

create table clientes (
	id int primary key auto_increment,
    nome varchar(50) not null,
    telefone varchar (15) not null,
	cep varchar (50) not null,
    endereco varchar (150) not null,
    numero varchar (50) not null,
    complemento varchar (50) not null,
    bairro varchar (150) not null,
    cidade varchar (150) not null,
    uf varchar (10) not null,
    equipamento varchar (150) not null,
    problema varchar (200) not null
);

describe usuarios;
select * from usuarios;
select * from usuarios where nome = "Jorge";

describe clientes;
select * from clientes;
select * from clientes where nome = "";

insert into usuarios (nome, login, senha)
values ('Troll','brabo','123456');

-- uso do md5() para criptografar uma senha
insert into usuarios (nome, login, senha)
values ('Jorge','admin', md5('admin'));

update usuarios set nome = 'robson vaamonde' where id = 3;

update clientes set nome = 'ricardo' where id = 1;

-- login(autenticação)
select * from usuarios where login = "admin" and senha = md5('admin');

