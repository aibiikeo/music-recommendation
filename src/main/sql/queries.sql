--Find most popular somg in playlist, ordered by descending
select id as s_id, title as s_title, popularity from songs
order by popularity desc;

--Get newest/oldest songs
select id as s_id, title as s_title, "year"  from songs s
order by year desc;

select id as s_id, title as s_title, "year" from songs s
order by year asc;

--Get songs with certain genre
select id as s_id, title as s_title, genre from songs
where genre = 'metal';

--Get existing playlists
select title from playlist;

--Get songs from exact playlist
select s.id as s_id, s.title as s_title, p.title as p_title from songs s 
full join song_playlist sp on s.id = sp.s_id
full join playlist p on sp.p_id = p.id
where p.title = 'stress relief';

--Get all genres
select distinct genre from songs;

--Count of songs in each playlist
select p.title , count(*) from playlist p
full join song_playlist sp on p.id = sp.p_id
group by p.title;

--Count of songs with same genre
select genre, count(*) from songs s
group by genre;

--Get song's all information
select s.id as s_id, s.title as s_title, genre, "year", popularity, a."name" as s_author, p.title as p_title from songs s
natural join author a
full join song_playlist sp on s.id = sp.s_id
full join playlist p on sp.p_id = p.id
where s.title = 'vitae';

--Get author's all songs
select a.*, s.title from songs s 
full join author a on s.a_id = a.id
where a."name" = 'Jessy Gerraty';

--Count of songs of each author
select a.*, count(s.*) from songs s 
full join author a on s.a_id = a.id
group by a."name", a.id
order by a.id;