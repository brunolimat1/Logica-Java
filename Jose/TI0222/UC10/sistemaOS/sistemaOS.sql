/**
 * Sistema para gestão de OS
 * @author Professor José de Assis
 */
 
 create database dbsistema;
 use dbsistema; 
 
 -- unique (não permite valores duplicados no campo)
 create table usuarios (
	id int primary key auto_increment,
    nome varchar(50) not null,
    login varchar(15) not null unique,
    senha varchar(250) not null
);

describe usuarios;

-- uso do md5() para criptografar uma senha
insert into usuarios(nome,login,senha)
values('Administrador','admin', md5('admin'));

select * from usuarios;
select * from usuarios where nome = "Administrador";
select * from usuarios where login = "admin";

-- login(autenticação)
select * from usuarios where login = 'admin' and senha = md5('admin');

drop table clientes;

create table clientes (
	idcli int primary key auto_increment,
    nome varchar(50) not null,
    fone varchar(15) not null,
    cep varchar(10),
    endereco varchar(50) not null,
    numero varchar(10) not null,
    complemento varchar(20),
    bairro varchar(30) not null,
    cidade varchar(30) not null,
    uf char(2) not null
);
    
    
    