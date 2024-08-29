CREATE DATABASE ambevy;

USE ambevy;

CREATE TABLE lager (
	id INT PRIMARY KEY AUTO_INCREMENT,
    data_hora DATETIME default current_timestamp,
    maceracao DECIMAL(8,2),
    malteacao_etapa1 DECIMAL(8,2),
    malteacao_etapa2 DECIMAL(8,2),
    malteacao_etapa3 DECIMAL(8,2),
    moagem DECIMAL(8,2),
    brassagem_etapa1 DECIMAL(8,2),
    brassagem_etapa2 DECIMAL(8,2),
    brassagem_etapa3 DECIMAL(8,2),
    fervura DECIMAL(8,2),
    resfriamento_etapa1 DECIMAL(8,2),
    resfriamento_etapa2 DECIMAL(8,2),
    resfriamento_etapa3 DECIMAL(8,2),
    filtragem DECIMAL(8,2),
    pasteurizacao DECIMAL(8,2),
    envase DECIMAL(8,2)
);

select * from lager;
