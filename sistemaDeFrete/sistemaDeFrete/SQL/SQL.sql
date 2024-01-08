create database sistemaDeFrete;

use sistemaDeFrete;

create table Frete (
	id bigint primary key,
    nome varchar(200),
    tipoVeiculo varchar(200),
	valorFrete double,
    valorTaxa double,
    statusFrete varchar(200),
    distanciaEndereco double,
    entregador varchar(200),
    valorEntregador double
);