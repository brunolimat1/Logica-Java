CREATE DATABASE produtosdb
	DEFAULT CHARACTER SET = 'utf8mb4';

use produtosdb;

create table produtos(
	idproduto INT AUTO_INCREMENT PRIMARY KEY,
    nomeproduto VARCHAR(100),
    descricao TEXT,
    categoria VARCHAR(50),
    lote VARCHAR(20),
    datafabricacao VARCHAR(20),
    datavalidade VARCHAR(20),
    preco DECIMAL(10,2),
    imagemproduto VARCHAR(200)
);