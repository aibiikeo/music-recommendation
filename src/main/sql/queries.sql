--popular
select * from songs 
order by popularity desc;


--new
select * from songs s 
order by year desc;


--old 
select * from songs s 
order by year asc;

--genre
select * from songs 
where genre = ?;

select * from songs 
where genre = 'metal';



