create table topic(
	id int(11) not null auto_increment,
	title varchar(255) not null,
	description text null,
	created datetime not null,
	primary key (id)	
);
