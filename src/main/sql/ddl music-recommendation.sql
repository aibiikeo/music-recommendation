create table user_info(
  id serial primary key,
  login varchar(20),
  password varchar(10)
);

create table author (
  id serial primary key,
  name varchar(50)
);

create table playlist(
  id int primary key,
  title varchar(50)
);

create table songs(
  id serial primary key,
  title varchar(50),
  genre varchar(50),
  year int,
  a_id int references author(id),
  popularity int
);

create table user_songs(
	s_id int,
	u_id int,
	foreign key(s_id) references songs(id),
	foreign key(u_id) references user_info(id),
	primary key (s_id, u_id)
);

create table song_playlist(
	s_id int,
	p_id int,
	foreign key(s_id) references songs(id),
	foreign key(p_id) references playlist(id),
	primary key (s_id, p_id)
);