create table endereco(
idendereco bigint auto_increment primary key,
tipo enum ('Rua', 'Avenida', 'Alameda', 'Rodovia', 'Viela', 'Estrada', 'Praça'),
logradouro varchar(100) not null,
numero varchar(10) not null,
complemento varchar(50),
cep varchar(10) not null,
bairro varchar(30) not null
) engine innodb charset=utf8mb4 collate=utf8mb4_genidcontatoeral_ci;

create table contato(
idcontato bigint auto_increment primary key,
telefone varchar(20) not null,
email varchar(100) not null
) engine innodb charset=utf8mb4 collate=utf8mb4_general_ci;

create table cliente(
idcliente bigint auto_increment primary key,
nomecliente varchar(50) not null,
cpf varchar (15) not null,
idcontato bigint not null,
idendereco bigint not null, 
idusuario bigint not null
) engine innodb charset=utf8mb4 collate=utf8mb4_general_ci;

/*
Criar relacionamento entre as tables :D
	- Cliente -> Usuario
    - Cliente -> Endereco
    - Cliente -> COntato
    */

/*
Para estabelecer o relacionamento entre as tables cliente e contato, foi necessário alterar a table cliente adicionando uma restrição (constraint)
com o nome fk_cliente_pk_contato e fazendo com que o campo idcontato da tabela cliente seja uma chave estrangeira (foreign key) e estabelecendo uma referência 
a table,a de contato com o campo, que é chave primária, idcontato e, assim receber as informações de contato da tabela contato. Esse tipo de relacionamento é chamado 
de um-para-muitos, ou seja,  um contato para mais de um cliente. 
*/




ALTER TABLE cliente
ADD constraint `fk_cliente_pk_contato`
FOREIGN KEY (`idcontato`)
REFERENCES `contato`(`idcontato`);

ALTER TABLE cliente
ADD constraint `fk_cliente_pk_endereco`
FOREIGN KEY `cliente` (`idendereco`)
REFERENCES `endereco` (`idendereco`);

ALTER TABLE cliente
ADD constraint `id_unico` UNIQUE (`idusuario`); 

ALTER TABLE cliente
ADD constraint `fk_cliente_pk_usuario`
FOREIGN KEY `cliente`(`idusuario`)
REFERENCES `usuario`(`idusuario`);