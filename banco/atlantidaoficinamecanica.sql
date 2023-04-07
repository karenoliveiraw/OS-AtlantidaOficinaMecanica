/**
 * Sistema OS -  Grupo Atlântida 
 *
 * @authors Celso, Karen e Luiz
 * @version 1.0
 */
 
create database dboficina;

use dboficina;

create table tbusuarios(
	id int primary key auto_increment,
	usuario varchar(15) not null,
    login varchar(15) not null unique,
    senha varchar(150) not null,
    perfil varchar(250) not null
);

insert into tbusuarios(usuario,login,senha,perfil)
values('Administrador','admin',md5('admin'),'admin');

create table tbclientes (
	id int primary key auto_increment,
	nome varchar(50) not null,
	cpf varchar(16) unique, 
	fone varchar (16) not null,
	whatsapp varchar (16),
	cep varchar(10) ,
	email varchar (50) ,
	endereco varchar(100) not null,
	numero varchar (10) not null,
	complemento varchar (20) ,
	bairro varchar (50) not null,
	cidade varchar (50) not null,
	uf char(2) not null
);

insert into tbclientes (nome,cpf,fone,whatsapp,cep,email,endereco,numero,complemento,bairro,cidade,uf)
values ('Leandro','363.256.325-30','2415-0710','90330-8020','76814-852','leandro@gmail.com','Av.Martinopolis','22','igrejinha','Moema','São Paulo','SP');

create table tbos(
	os int primary key auto_increment,
	data_os timestamp default current_timestamp,
    placa varchar(15) not null,
    marca varchar(30) not null,
    modelo varchar(30) not null,
    cor varchar(20) not null,
    ano varchar(4) not null,
    km varchar(30) not null,
    orcamento varchar (50) not null,
    servico varchar (150),
	defeito varchar (150) not null,
    mecanico varchar (20) ,
    status_os varchar  (150) not null,
    valor decimal(10,2) ,
    data_saida varchar (50),
    forma_pagamento varchar (50) ,
    id int not null,
    foreign key(id) references tbclientes(id)
);

-- RELATÓRIOS 
-- relatório 1 (clientes)
select tbclientes.nome as Clientes_cadastrados, tbclientes.email as Email, tbclientes.fone as Contato from tbclientes;

-- relatório 2 (serviços)
select 
tbos.os as OS,date_format(tbos.data_os,'%d/%m/%Y') as data,
tbos.placa,tbos.servico as serviço,tbos.status_os as situação,tbos.valor,
tbclientes.nome as cliente,tbclientes.fone as fone
from tbos inner join tbclientes on tbos.id = tbclientes.id
order by status_os;

-- relatório 3 (pendentes)
select 
tbos.os as OS, tbclientes.nome as Cliente, tbos.modelo as Modelo, tbos.placa as Placa, tbos.Status_OS
from tbos inner join tbclientes on tbos.id= tbclientes.id where status_os = 'Pendente';


-- relatório 4 (entregues)
select
tbos.os as OS, tbclientes.nome as Cliente, tbos.modelo as Modelo, tbos.placa as Placa, tbos.Status_OS
from tbos inner join tbclientes on tbos.id= tbclientes.id where status_os = 'Entregue';

-- IMPRESSÃO DA OS

select 
tbos.os as Ordem_Serviço,date_format(tbos.data_os,'%d/%m/%Y - %H:%i') as Data_Entrada,
tbclientes.nome as Cliente, tbclientes.endereco as Endereço,
 tbos.servico as Serviço,
 tbos.modelo as Modelo, tbos.placa as Placa,  tbos.forma_pagamento as Pagamento,tbos.valor as Valor
from tbos inner join tbclientes on tbos.id= tbclientes.id
where os =2;


select 
tbos.os, date_format(tbos.data_os,'%d/%m/%Y - %H:%i'),tbclientes.nome, tbclientes.endereco, tbos.servico, tbos.modelo , tbos.placa ,  tbos.forma_pagamento , tbos.valor from tbos inner join tbclientes on tbos.id= tbclientes.id where os = '?';