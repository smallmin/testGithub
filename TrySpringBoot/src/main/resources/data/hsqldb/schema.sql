
drop table User if exists;

create table User(
	id bigint(20) unsigned not null auto_increcement,
	name varchar(100) not null,
	primary key(id)
);
