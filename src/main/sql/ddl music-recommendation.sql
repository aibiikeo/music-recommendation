create table author (
	id serial primary key,
	name varchar(50)
);


create table songs(
	id serial primary key,
	title varchar(50),
	genre varchar(50),
	year int,
	author_id int,
	popularity int
);


create table user_info(
	id serial primary key,
	login varchar(20),
	password varchar(10)
);


create table user_playlist(
	s_id int,
	u_id int,
	foreign key(s_id) references songs(id),
	foreign key(u_id) references user_info(id)
);

create table playlist(
	p_id int primary key,
	p_title varchar(50),
	s_id int,
	foreign key(s_id) references songs(id)
);