/**
 * Agenda de contatos
 * @author Professor José de Assis
 */

-- comentários em linha

-- exibir os bancos
show databases;

-- apagar um banco de dados
drop database dbagenda;

-- criar um novo banco de dados
create database dbagenda;

-- selecionar o banco de dados a ser trabalhado
use dbagenda;

-- exibir tabelas do banco de dados
show tables;

-- criando uma tabela no banco de dados
-- int (tipo de dados: número inteiro)
-- primary key (chave primária)
-- auto_increment (numeração automática)
-- varchar (tipo de dados: String)
-- not null (campo obrigatório)

create table contatos (
	id int primary key auto_increment,
    nome varchar(50) not null,
    fone varchar(15) not null,
    email varchar(50)
);

-- descrever a tabela
describe contatos;

-- CRUD Create ----------------------------------------------
insert into contatos (nome,fone,email)
values ('José de Assis','99999-1234','ze@email.com');
-- simulando um erro
insert into contatos(nome,email)
values('Robson Vaamonde','vava@email.com');
-- preenchendo apenas os campos obrigatórios
insert into contatos (nome,fone)
values ('Bill Gates','99999-2222');
insert into contatos (nome,fone,email)
values ('João da Silva','99999-3333','joao@email.com');
insert into contatos (nome,fone,email)
values ('Joana Prado','99999-4444','joanaprado@email.com');
insert into contatos (nome,fone,email)
values ('Anitta Macedo','99999-5555','anitta@email.com');
insert into contatos (nome,fone,email)
values ('Bruce Dickinson','99999-6666','ironmaiden@gmail.com');
insert into contatos (nome,fone,email)
values ('Tony Stark','99999-7777','ironman@gmail.com');
insert into contatos (nome,fone,email)
values ('Bruce Wayne','99999-8888','batman@email.com');
insert into contatos (nome,fone,email)
values('Robson Vaamonde','99999-9999','vava@email.com');
insert into contatos (nome,fone,email)
values('Leandro Ramos','88888-9876','leandro@email.com');

-- CRUD Read -----------------------------------------------

-- selecionar tudo da tabela
select * from contatos;

-- selecionar e ordenar
select * from contatos order by nome;
select * from contatos order by nome desc;

-- pesquisas avançadas
select nome from contatos;
select nome,email from contatos;
select * from contatos where nome like 'jo%';
select * from contatos where nome = 'José de Assis';
select * from contatos where id = 1;

-- relatórios personalizados com apelidos para os campos
select nome as Contato, fone as Telefone, email as E_mail
from contatos order by nome;

-- CRUD Update --------------------------------------------
-- CUIDADO !!! (Sempre usar a claúsula where junto a chave primária)

update contatos set fone = '99999-1234' where id = 1;

update contatos set fone = '99999-4321', email = 'sisa@email.com'
where id = 10;

update contatos set nome = 'Willian Gates', fone = '50 909001234',
email = 'bill@outlook.com' where id = 2;

-- CRUD Delete -------------------------------------------------
-- CUIDADO !!! (Sempre usar a claúsula where junto a chave primária)

delete from contatos where id = 3;

-- Alterações na estrutura da tabela ----------------------------

-- adicionar uma coluna a tabela
alter table contatos add column obs varchar(100);

-- adicionar uma coluna após um local específico
alter table contatos add column fone2 varchar(15) not null after fone;

-- alterando tipo de dados ou validações
-- ATENÇÃO aos dados já cadastrados!
alter table contatos modify fone2 varchar(20);

-- Excluir uma coluna
alter table contatos drop column obs;

-- Excluir a tabela
drop table contatos;

describe contatos;
select * from contatos;




