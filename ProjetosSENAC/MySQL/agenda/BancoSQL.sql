/**
 * Sistema para o Banco Eclipse
 * @author Bruno Lima
 */
 
drop database dbsaque;
create database dbsaque;
use dbsaque;
show tables;
 
delete from usuarios WHERE id = 1;
 
create table usuarios (
	id int primary key auto_increment,
    nome varchar(20) not null,
    login varchar(50) not null,
    senha varchar(15) not null,
    saldo varchar(50) not null
);

describe usuarios;
select * from usuarios;

insert into usuarios (nome, login, senha, saldo)
values ('Ryan','Ryan2007','1998','R$2.000');
