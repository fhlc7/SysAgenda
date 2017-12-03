DROP DATABASE IF EXISTS dbagenda;

CREATE DATABASE dbagenda;

USE dbagenda;

CREATE TABLE `contato` (`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, `nome` varchar(255) NOT NULL, `fone` varchar(20) DEFAULT NULL, `email` varchar(255) DEFAULT NULL, `endereco` blob );

INSERT INTO `contato` (`id`, `nome`, `fone`, `email`, `endereco`) VALUES (1, 'Maria', '(99) 99999-9999', 'maria@gmail.com', NULL), (2, 'João', '(88) 88888-8888', 'joao@hotmai.com', NULL), (3, 'Pedro', '(77) 77777-7777', 'pedro@outlook.com', NULL), (4, 'Davi', '(99) 91234-5678', 'davi@gmail.com', 0x5275616c2064652043696d61);
