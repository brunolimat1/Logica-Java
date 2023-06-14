/**
 * Sistema para gestão de OS
 * @author Professor José de Assis
 */
 
 create database dbsistemaOSprof;
 use dbsistemaOSprof;
   
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

-- busca avançada pelo nome (estilo google)
select nome from usuarios where nome like 'r%' order by nome;

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

insert into clientes(nome,fone,cep,endereco,numero,complemento,bairro,cidade,uf)
values ('Kelly Cristina','99999-1234','03307000','Rua Tuiuti','2769','apt 23',
'Tatuapé','São Paulo','SP');
insert into clientes(nome,fone,cep,endereco,numero,complemento,bairro,cidade,uf)
values ('Sirlene Sanches','99999-1111','03307000','Rua Tuiuti','2769','apt 23',
'Tatuapé','São Paulo','SP');

select * from clientes;
delete from clientes where idcli = 1;
    
/* Relacionamento de tabelas 1 - N */

-- timestamp default current_timestamp (data e hora autmática)
-- decimal (números não inteiros) 10,2 (dígitos,casas decimais)
-- foreign key(FK) chave estrangeira
-- 1 (FK) ------- N (PK)
create table servicos (
	os int primary key auto_increment,
	dataOS timestamp default current_timestamp,
    equipamento varchar(200) not null,
    defeito varchar(200) not null,
    valor decimal(10,2),
    idcli int not null,
    foreign key(idcli) references clientes(idcli)
);
    
insert into servicos (equipamento,defeito,valor,idcli)
values ('Notebook LeNovo G90','Troca da fonte',250,1);

select * from servicos;

-- selecionando o conteúdo de 2 ou mais tabelas
select * from servicos
inner join clientes
on servicos.idcli = clientes.idcli;

/** RELATÓRIOS **/
-- clientes
select nome,fone from clientes order by nome;

-- servicos
select
servicos.os,servicos.dataOS,servicos.equipamento,servicos.defeito,
servicos.valor,
clientes.nome
from servicos
inner join clientes
on servicos.idcli = clientes.idcli;





    