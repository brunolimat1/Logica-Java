/**
 * Sistema para gestão de OS
 * @author Bruno Lima
 */
 
 create database dbsistema;
 drop database dbsistema;
 use dbsistema;
 show tables;
 
delete from usuarios WHERE id = 1;
 
create table usuarios (
	id int primary key auto_increment,
    nome varchar(20) not null,
    login varchar(50) not null,
    senha varchar(15) not null
);

describe usuarios;
select * from usuarios;

insert into usuarios (nome, login, senha)
values ('Jorge','Jorgin1@gmail.com','123jorgin');

update usuarios set login = 'Jorgin1@gmail.com' where id = 1;

