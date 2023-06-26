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
	idcli int primary key auto_increment,
    nome varchar(50) not null,
    telefone varchar (15) not null,
    cpf varchar (50) not null,
	cep varchar (50) not null,
    endereco varchar (150) not null,
    numero varchar (50) not null,
    complemento varchar (50),
    bairro varchar (150) not null,
    cidade varchar (150) not null,
    uf varchar (10) not null
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
values ('bruno','admin', md5('admin'));

update usuarios set nome = 'robson vaamonde' where id = 3;

update clientes set nome = 'ricardo' where id = 1;

update servicos set os = 1 where id = 6;

-- login(autenticação)
select * from usuarios where login = "admin" and senha = md5('admin');

drop table servicos;

create table servicos (
    os int primary key auto_increment,
    data_os timestamp default current_timestamp,
	equipamentos varchar (100) not null,
    defeito varchar (150) not null,
    valor decimal (10,2),
    id int not null, cliente varchar (50) not null,
    foreign key (id) references clientes(idcli)
);

ALTER TABLE clientes
ADD constraint `id` UNIQUE (`idcli`); 

select * from servicos
inner join clientes
on servicos.id = clientes.idcli;

select * from servicos inner join clientes on servicos.id = clientes.idcli where OS = 1;

select * from servicos inner join clientes on servicos.id = clientes.idcli order by id;

select * from servicos;