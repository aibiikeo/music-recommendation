--Find most popular somg in playlist, ordered by descending
select * from songs
order by popularity desc;

--Get newest/oldest songs
select * from songs s
order by year desc;

select * from songs s
order by year asc;

--Get songs with certain genre
select * from songs
where genre = 'metal';

--Get existing playlists
select distinct p_title from playlist;

--Get songs from exact playlist
select s.id, s.title, p.p_title from songs s natural join playlist p
where s.id = p.s_id and p.p_title = 'stress relief';

--Get all genres
select distinct genre from songs;

--Count of songs in each playlist
select p_title, count(*) from playlist p
group by p_title;

--Count of songs with same genre
select genre, count(*) from songs s
group by genre;

--Get all songs information
select s.*, a.name, p.p_title
from songs s
join author a on s.author_id = a.id
join playlist p on s.id=p.s_id
where s.title = 'vitae';

--Get author's all songs
select a."name" , s.title from author a, songs s
where a.id = s.author_id
order by a.name;

--Count of songs of each author
select a."name" , count(s.title) from author a, songs s
where a.id = s.author_id
group by a."name"
order by a.name;