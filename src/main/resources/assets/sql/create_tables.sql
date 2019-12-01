CREATE TABLE players (
	name VARCHAR(30) NOT NULL
);

CREATE TABLE battlelogs (
	playerone VARCHAR(30) NOT NULL,
	playertwo VARCHAR(30) NOT NULL,
	playeronedamas INT NOT NULL,
	playertwodamas INT NOT NULL,
	winner VARCHAR(30) NOT NULL,
	date BIGINT NOT NULL
);

insert into players values('EverNife');
insert into players values('Xablau');
insert into players values('Xablengs');
insert into players values('Xablings');

insert into battlelogs values('EverNife', 'Xablau',1,2,'EverNife', 0);
insert into battlelogs values('Xablau', 'EverNife',2,2,'EverNife', 86400000);
insert into battlelogs values('EverNife', 'Xablengs',3,0,'EverNife', 172800000);
insert into battlelogs values('Xablengs', 'Xablings',1,1,'Xablengs', 259200000);
insert into battlelogs values('Xablings', 'Xablengs',1,1,'Xablings', 345600000);
insert into battlelogs values('Xablau', 'Xablengs',3,0,'Xablau', 691200000);