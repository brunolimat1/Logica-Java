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

create table clientes (
	id int primary key auto_increment,
    nome varchar(50) not null,
    email varchar (50) not null,
    telefone varchar (15) not null,
	cep varchar (50) not null,
    endereco varchar (150) not null
);

describe usuarios;
select * from usuarios;
select * from usuarios where nome = "Jorge";

describe clientes;
select * from clientes;
select * from clientes where nome = "";

insert into usuarios (nome, login, senha)
values ('Troll','brabo','123456');

insert into clientes (nome, email, telefone, nascimento, genero, endereco, estadocivil, cpf, senha)
values ('ricardo','ricardoalmeida@hotmail.com','11965527913','17012000','masculino','rua alameda filho','casado','46898732156','ricardo123');

-- uso do md5() para criptografar uma senha
insert into usuarios (nome, login, senha)
values ('Jorge','admin', md5('admin'));

-- uso do md5() para criptografar uma senha
insert into clientes (nome, email, telefone, nascimento, genero, endereco, estadocivil, cpf, senha)
values ('ricardo','ricardoalmeida@hotmail.com','11965527913','17012000','masculino','rua alameda filho','casado','46898732156',md5('ricardo123'));

update usuarios set nome = 'robson vaamonde' where id = 3;

update clientes set senha = md5('admin') where id = 1;

-- login(autenticação)
select * from usuarios where login = "admin" and senha = md5('admin');
select * from clientes where login = "admin" and senha = md5('admin');

