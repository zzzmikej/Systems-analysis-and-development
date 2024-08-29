CREATE DATABASE nome_do_banco_de_dados;
USE nome_do_banco_de_dados;

CREATE TABLE nome_da_tabela (
  idDaTabela INT AUTO_INCREMENT PRIMARY KEY,
  atributo1 CHAR(8) NULL, -- cahr precisa ter exatamente a quantidade de caracteres que voce coloca
  atributo2 VARCHAR(45) NOT NULL, -- varchar pode ter ate a quantidade que voce coloca
  atributo3 VARCHAR(45) NOT NULL,
  atributo4 VARCHAR(45) NOT NULL
);

-- Inserindo dados na tabela Endereco
INSERT INTO nome_da_tabela (atributo1, atributo2, atributo3, atributo4)
VALUES
  ('12345678', 'atributo1', 'atributo2', 'atributo3', 'atributo4');

UPDATE nome_da_tabela SET atributo1 = 'atributo10' WHERE idDaTabela = 1;

SELECT
  nome_da_tabela.atributo1,
  nome_da_tabela.atributo2,
  nome_da_tabela.atributo3,
  nome_da_tabela.atributo4
FROM nome_da_tabela;

