create table user_info(
  id serial primary key,
  login varchar(20),
  password varchar(10)
);

create table songs(
  id serial primary key,
  title varchar(50),
  genre varchar(50), 
  year int,
  author_id int
);

create table author (
  id serial primary key,
  name varchar(50)
);

create table playlist(
  p_id int,
  p_title varchar(50),
  s_id int,
  foreign key(s_id) references songs(id)
);

create table user_playlist(
  u_id int,
  s_id int,
  foreign key(s_id) references songs(id),
  foreign key(u_id) references user_info(id)
);