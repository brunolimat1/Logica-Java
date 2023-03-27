/**
*Agenda de contatos/
*/

-- comentarios em linha
-- exibir os bancos

show databases;

-- apaga um banco de dados
drop database dbagenda;

-- criar um banco de dados
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

-- selecionar tudo da tabela
select * from contatos;

-- CRUD Create --------------------------------------------

insert into contatos (nome, fone, email) 
values ('Bruno Lima', '94002-8922', 'MJ@email.com');

insert into contatos (nome, fone)
values ('Voldemort','96667-6666');

insert into contatos (nome, fone)
values ('curupira','96773-5986');

insert into contatos (nome, fone, email)
values ('thai','96557-1246','paodequeijo@gmail.com');

insert into contatos (nome, fone)
values ('poli', '9543-1624');

insert into contatos (nome, fone, email)
values ('thaina','96883-4572', 'famosinhadoinstagram@hotmail.com');

insert into contatos (nome, fone, email)
values ('lucas', '92723-5896', 'Cmaismaisevida@hotmail.com');

insert into contatos (nome, fone, email)
values ('plague', '99999-9999', 'addanikadingirasarkume@gmail.com');

insert into contatos (nome, fone)
values ('irineu', '96457-3156');

insert into contatos (nome, fone, email)
values ('marilene', '94678-5467', 'tainhavinho@hotmail.com');

insert into contatos (nome, fone, email)
values ('zézão', '94658-7812', 'cheirameu@gmail.com');

-- CRUD Read --------------------------------------------

-- selecionar tudo da tabela
select * from contatos;

-- selecionar e ordenar
select * from contatos order by id;
select * from contatos order by nome;
select * from contatos order by nome desc;

-- pesquisas avançadas
select nome from contatos;
select nome, email from contatos;
select * from contatos where nome like 'b%';
select * from contatos where nome = 'thai';
select * from contatos where id = 1;

-- relatórios personalizados com apelidos para os campos
select nome as Contato, fone as Telefone, email as E_mail 
from contatos order by nome;


-- CRUD Update --------------------------------------------
-- CUIDADO !!! (Sempre usar a claúsula where junto a chave primária)

update contatos set fone = '92725-8446' where id = 1;
update contatos set fone = '95734-1943' where id = 2;
update contatos set fone = '92734-7124' where id = 3;
update contatos set fone = '91849-4724' where id = 4;
update contatos set fone = '93754-6479' where id = 5;

update contatos set email = 'harrypotter@hotmail.com' where id = 1;
update contatos set email = 'vindiesel@hotmail.com' where id = 2;
update contatos set email = 'pindamonhagaba@hotmail.com' where id = 3;
update contatos set email = 'sortudamega@hotmail.com' where id = 5;
update contatos set email = 'fazfavor@hotmail.com' where id = 7;

update contatos set fone = '92378-4568', email = 'malandroesambista' where id = 10;
update contatos set fone = '97342-1465', email = 'tudoeculpasua@homail.com' where id = 9;
update contatos set fone = '97342-4678', email = 'paiebrabo@email.com' where id = 1;
update contatos set fone = '91476-1584', email = 'vidalongaorei@gmail.com' where id = 7;
update contatos set fone = '91234-7894', email = 'selococachoeira@hotmail.com' where id = 2;

update contatos set nome = 'plagio', fone = '96894-4579', email = 'logo123@hotmail.com' where id = 2;
update contatos set nome = 'wraith', fone = '96472-9187', email = 'dessejeito234@hotmail.com' where id = 3;
update contatos set nome = 'jason', fone = '97243-4156', email = 'ficanasua765@hotmail.com' where id = 9;
update contatos set nome = 'trapper', fone = '97423-4564', email = 'naruto8765@hotmail.com' where id = 7;
update contatos set nome = 'paulinhooloko', fone = '99487-2473', email = 'pitanguinha123@hotmail.com' where id = 10;


-- CRUD Delete --------------------------------------------
-- CUIDADO !!! (Sempre usar a claúsula where junto a chave primária)

delete from contatos WHERE id = 2;

-- Alterações na estrutura da tabela --------------------------------------------

-- adicionar uma coluna a tabela
alter table contatos add column obs varchar(100);

-- adicionar uma coluna após um local específico
alter table contatos add column fone2 varchar(15) not null after fone;

-- alterando tipo de dados ou validações
-- ATENÇÃO aos dados já cadastrados 

alter table contatos modify fone2 varchar(20);

-- Excluir uma coluna
alter table contatos drop column obs;

-- Excluir a tabela
drop table contatos;

describe contatos;
select * from contatos;

	