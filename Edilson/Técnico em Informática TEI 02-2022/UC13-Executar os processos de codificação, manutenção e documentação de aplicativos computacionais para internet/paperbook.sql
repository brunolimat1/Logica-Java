-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 01-Ago-2023 às 18:50
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `paperbook`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE `cargo` (
  `idcargo` int(11) NOT NULL,
  `titulocargo` varchar(45) NOT NULL,
  `salario` decimal(10,2) NOT NULL,
  `beneficio` text NOT NULL,
  `cargahoraria` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`idcargo`, `titulocargo`, `salario`, `beneficio`, `cargahoraria`) VALUES
(1, 'Programador Junior', '3000.00', 'Bolsa Estudo', '40h semanais');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL,
  `nomecategoria` varchar(255) NOT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `nomecategoria`, `descricao`) VALUES
(1, 'TI', 'Produtos de tecnologia'),
(2, 'Material Escritório', 'Produtos de papelaria para escritório'),
(3, 'Material de Limpeza', 'Material de Limpeza');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nomecliente` varchar(50) NOT NULL,
  `cpfcliente` varchar(15) NOT NULL,
  `rgcliente` varchar(20) NOT NULL,
  `sexocliente` enum('Masculino','Feminino') NOT NULL,
  `datanascimentocliente` date NOT NULL,
  `idendereco` int(11) NOT NULL,
  `idcontato` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nomecliente`, `cpfcliente`, `rgcliente`, `sexocliente`, `datanascimentocliente`, `idendereco`, `idcontato`, `idusuario`) VALUES
(1, 'André Paz', '4574545754', '45787545', 'Masculino', '1976-02-10', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

CREATE TABLE `contato` (
  `idcontato` int(11) NOT NULL,
  `telefonecelular` varchar(20) DEFAULT NULL,
  `telefoneresidencial` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `contato`
--

INSERT INTO `contato` (`idcontato`, `telefonecelular`, `telefoneresidencial`, `email`) VALUES
(1, '11-96852-9655', '11-5682-9658', 'admin@admin.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `detalhepedido`
--

CREATE TABLE `detalhepedido` (
  `iddetalhepedido` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `precounitario` decimal(7,2) NOT NULL,
  `valortotal` decimal(7,2) NOT NULL,
  `idpedido` int(11) NOT NULL,
  `idproduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `detalhepedido`
--

INSERT INTO `detalhepedido` (`iddetalhepedido`, `quantidade`, `precounitario`, `valortotal`, `idpedido`, `idproduto`) VALUES
(1, 4, '35.00', '140.00', 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idendereco` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `logradouro` varchar(50) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `cep` varchar(10) NOT NULL,
  `referencia` varchar(50) DEFAULT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idendereco`, `tipo`, `logradouro`, `numero`, `complemento`, `cep`, `referencia`, `bairro`, `cidade`, `estado`) VALUES
(1, 'Rua', 'Padre Marcos', '23A', 'Apto 122 bloco 2', '03105-050', 'Poste azul', 'Jardim Novo', 'São Paulo', 'SP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `idfornecedor` int(11) NOT NULL,
  `razaosocial` varchar(45) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  `tipoproduto` varchar(45) NOT NULL,
  `idendereco` int(11) NOT NULL,
  `idcontato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`idfornecedor`, `razaosocial`, `cnpj`, `tipoproduto`, `idendereco`, `idcontato`) VALUES
(1, 'THYLtda', '10245410001254', 'Tecnologia', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `nomefuncionario` varchar(45) NOT NULL,
  `cpffuncionario` varchar(20) NOT NULL,
  `rgfuncionario` varchar(20) NOT NULL,
  `sexofuncionario` enum('Feminino','Masculino') NOT NULL,
  `datanascimentofuncionario` date NOT NULL,
  `superior` int(11) DEFAULT 1,
  `idcargo` int(11) NOT NULL,
  `idendereco` int(11) NOT NULL,
  `idcontato` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='	';

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idfuncionario`, `nomefuncionario`, `cpffuncionario`, `rgfuncionario`, `sexofuncionario`, `datanascimentofuncionario`, `superior`, `idcargo`, `idendereco`, `idcontato`, `idusuario`) VALUES
(10, 'Marcos Oliveira', '45784545', '878754578', '', '1999-10-05', 0, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `lote`
--

CREATE TABLE `lote` (
  `idlote` int(11) NOT NULL,
  `numerolote` varchar(45) NOT NULL,
  `fabricacao` date NOT NULL,
  `validade` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `lote`
--

INSERT INTO `lote` (`idlote`, `numerolote`, `fabricacao`, `validade`) VALUES
(1, '12454', '2023-01-10', '2029-10-02');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL,
  `loja` enum('Física','Virtual') NOT NULL,
  `unidadeloja` varchar(45) NOT NULL,
  `numeroprotocolo` varchar(45) NOT NULL,
  `formapagamento` varchar(45) NOT NULL,
  `parcelas` int(11) NOT NULL,
  `valorparcela` decimal(7,2) NOT NULL,
  `valortotalpedido` decimal(10,2) NOT NULL,
  `datahora` datetime NOT NULL DEFAULT current_timestamp(),
  `idfuncionario` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`idpedido`, `loja`, `unidadeloja`, `numeroprotocolo`, `formapagamento`, `parcelas`, `valorparcela`, `valortotalpedido`, `datahora`, `idfuncionario`, `idcliente`) VALUES
(2, 'Física', 'Tatuapé', '4512454', 'Cartão de Crédito', 2, '70.00', '140.00', '2023-07-20 17:06:00', 10, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL,
  `nomeproduto` varchar(45) NOT NULL,
  `descricaoproduto` text NOT NULL,
  `codigobarras` varchar(45) NOT NULL,
  `preco` decimal(7,2) NOT NULL,
  `observacao` text NOT NULL,
  `idcategoria` int(11) NOT NULL,
  `idfornecedor` int(11) NOT NULL,
  `idlote` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idproduto`, `nomeproduto`, `descricaoproduto`, `codigobarras`, `preco`, `observacao`, `idcategoria`, `idfornecedor`, `idlote`) VALUES
(1, 'Mouse', 'Mouse sem fio', '1245100F', '32.00', 'Mouse ótimo', 1, 1, 1),
(2, 'Teclado', 'Teclado sem fio', '44457811MF', '100.00', 'Teclado Egonomico', 1, 1, 1),
(3, 'Mouse Pad', 'Mouse Pad Rosa', '77454414', '20.00', 'Mouse Pad Importado', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `nivelacesso` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idusuario`, `login`, `senha`, `nivelacesso`) VALUES
(1, 'admin', '202cb962ac59075b964b07152d234b70', 'admin');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idcargo`);

--
-- Índices para tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idcategoria`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD UNIQUE KEY `cpfcliente_UNIQUE` (`cpfcliente`),
  ADD UNIQUE KEY `rgcliente_UNIQUE` (`rgcliente`),
  ADD KEY `fk_cliente_pk_contato_idx` (`idcontato`),
  ADD KEY `fk_cliente_pk_endereco_idx` (`idendereco`),
  ADD KEY `fk_cliente_pk_usuario_idx` (`idusuario`);

--
-- Índices para tabela `contato`
--
ALTER TABLE `contato`
  ADD PRIMARY KEY (`idcontato`),
  ADD UNIQUE KEY `telefonecelular_UNIQUE` (`telefonecelular`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- Índices para tabela `detalhepedido`
--
ALTER TABLE `detalhepedido`
  ADD PRIMARY KEY (`iddetalhepedido`),
  ADD KEY `fk_detalhe_pk_pedido_idx` (`idpedido`),
  ADD KEY `fk_detalhe_pk_produto_idx` (`idproduto`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idendereco`);

--
-- Índices para tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`idfornecedor`),
  ADD UNIQUE KEY `razaosocial_UNIQUE` (`razaosocial`),
  ADD UNIQUE KEY `cnpj_UNIQUE` (`cnpj`),
  ADD KEY `fk_fornecedor_idx` (`idendereco`),
  ADD KEY `fk_fornecedor_pk_contato_idx` (`idcontato`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfuncionario`),
  ADD UNIQUE KEY `cpffuncionario_UNIQUE` (`cpffuncionario`),
  ADD UNIQUE KEY `rgfuncionario_UNIQUE` (`rgfuncionario`),
  ADD KEY `fk_func_pk_cargo_idx` (`idcargo`),
  ADD KEY `idendereco_idx` (`idendereco`),
  ADD KEY `fk_func_pk_contato_idx` (`idcontato`),
  ADD KEY `fk_func_pk_usuario_idx` (`idusuario`);

--
-- Índices para tabela `lote`
--
ALTER TABLE `lote`
  ADD PRIMARY KEY (`idlote`),
  ADD UNIQUE KEY `numerolote_UNIQUE` (`numerolote`);

--
-- Índices para tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idpedido`),
  ADD UNIQUE KEY `numeroprotocolo_UNIQUE` (`numeroprotocolo`),
  ADD KEY `fk_pedido_pk_funcionario_idx` (`idfuncionario`),
  ADD KEY `fk_pedido_pk_cliente_idx` (`idcliente`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idproduto`),
  ADD UNIQUE KEY `codigobarras_UNIQUE` (`codigobarras`),
  ADD KEY `fk_produto_pk_categoria_idx` (`idcategoria`),
  ADD KEY `fk_produto_pk_fornecedor_idx` (`idfornecedor`),
  ADD KEY `fk_produto_pk_lote_idx` (`idlote`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `login_UNIQUE` (`login`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idcargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idcategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `contato`
--
ALTER TABLE `contato`
  MODIFY `idcontato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `detalhepedido`
--
ALTER TABLE `detalhepedido`
  MODIFY `iddetalhepedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idendereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `idfornecedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `lote`
--
ALTER TABLE `lote`
  MODIFY `idlote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idpedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `idproduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_pk_contato` FOREIGN KEY (`idcontato`) REFERENCES `contato` (`idcontato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cliente_pk_endereco` FOREIGN KEY (`idendereco`) REFERENCES `endereco` (`idendereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cliente_pk_usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `detalhepedido`
--
ALTER TABLE `detalhepedido`
  ADD CONSTRAINT `fk_detalhe_pk_pedido` FOREIGN KEY (`idpedido`) REFERENCES `pedido` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalhe_pk_produto` FOREIGN KEY (`idproduto`) REFERENCES `produto` (`idproduto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fk_fornecedor_pk_contato` FOREIGN KEY (`idcontato`) REFERENCES `contato` (`idcontato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_fornecedor_pk_endereco` FOREIGN KEY (`idendereco`) REFERENCES `endereco` (`idendereco`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_func_pk_cargo` FOREIGN KEY (`idcargo`) REFERENCES `cargo` (`idcargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_func_pk_contato` FOREIGN KEY (`idcontato`) REFERENCES `contato` (`idcontato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_func_pk_endereco` FOREIGN KEY (`idendereco`) REFERENCES `endereco` (`idendereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_func_pk_usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_pedido_pk_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_pk_funcionario` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `fk_produto_pk_categoria` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produto_pk_fornecedor` FOREIGN KEY (`idfornecedor`) REFERENCES `fornecedor` (`idfornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produto_pk_lote` FOREIGN KEY (`idlote`) REFERENCES `lote` (`idlote`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
