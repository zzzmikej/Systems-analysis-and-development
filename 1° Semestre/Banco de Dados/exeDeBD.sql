create database venda;

use venda;

create table cliente (
idCliente int primary key auto_increment,
nome varchar(45),
email varchar(45),
endereco varchar(100),
indicacaoCliente int,
	constraint fkindicacao foreign key (indicacaoCliente) references
		cliente(idCliente)
);
