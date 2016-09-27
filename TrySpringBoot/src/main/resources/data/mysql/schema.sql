

--drop table  if exists User;

create table if not exists User (
	id bigint(20) unsigned not null auto_increment,
	name varchar(100) not null,
	primary key(id)
);
