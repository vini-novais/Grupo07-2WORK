create database 2work;
use 2work;

create table desenvolvedor(
idDesenvolvedor int primary key auto_increment,
cpfDesenvolvedor varchar(11) not null,
nomeDesenvolvedor varchar(50) not null,
emailDesenvolvedor varchar(50) not null,
senhaDesenvolvedor varchar(50) not null,
competencia varchar(50) not null,
biografia varchar(255) not null
)auto_increment = 1000;

create table investidor(
idInvestidor int primary key auto_increment,
cpfInvestidor varchar(11) not null,
cnpj varchar(50) not null,
nomeInvestidor varchar(50) not null,
emailInvestidor varchar(50) not null,
senhaInvestidor varchar(50) not null,
biografia varchar(255)
)auto_increment = 2000;

create table publicacao(
idPublicacao int primary key auto_increment,
classificacaoTotal tinyint,
dataHoraPostada datetime not null,
totalCurtidas int not null,
totalComentarios int not null,
fkDesenvolvedor int,
foreign key (fkDesenvolvedor) references  desenvolvedor(idDesenvolvedor)
);

create table interacao(
idInteracao int primary key auto_increment,
dataHoraInteracao datetime not null,
curtiuPostagem boolean not null,
classificacao tinyint not null,
comentario varchar(255) not null,
totalCurtidas int not null,
fkDesenvolvedor int,
foreign key (fkDesenvolvedor) references desenvolvedor(idDesenvolvedor),
fkinvestidor int,
foreign key (fkInvestidor) references investidor(idInvestidor),
fkPublicacao int,
foreign key (fkPublicacao) references publicacao(idPublicacao)
)auto_increment = 10000;


insert into desenvolvedor values (
null , '00011122233' , 'Luiz Gustavo' , 'luiz@gmail.com' , 'luiz1234' , 'Alta plataforma' , 'Pipipi popopo'
);

insert into investidor values (
null , '11122233344' , '00011122233344455' , 'Gustavo Luiz' , 'gustavo@gmail.com' , 'gustavo1234' , 'Popopo pipipi'
);

insert into publicacao values (
null , null , '2021-09-22 20:00:00' , 1 , 2 , 1000
);

insert into interacao values (
null , '2021-09-22 20:30:00' , true , 5 , 'Muito bom, estamos interessados' , 0 , null , 2000 , 1
);

select * from desenvolvedor;
select * from investidor;
select * from publicacao
left join desenvolvedor on fkDesenvolvedor = idDesenvolvedor;

select * from interacao
join investidor on fkInvestidor = idInvestidor
join publicacao on fkPublicacao = idPublicacao;

drop database 2work;