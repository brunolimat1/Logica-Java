create database bancoacesso charset=utf8mb4 collate=utf8mb4_general_ci;
use bancoacesso;
create table cliente(
idcliente int auto_increment primary key,
nomecliente varchar(100) not null,
email varchar(100) not null,
cpf varchar(20) not null unique,
telefone varchar(15) not null,
idade int not null
)engine innodb charset=utf8mb4 collate=utf8mb4_general_ci;
