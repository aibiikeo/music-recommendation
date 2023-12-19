--drop table author cascade;
--drop table songs cascade;
--drop table user_info cascade;
--drop table user_playlist cascade;
--drop table playlist cascade;
--drop table song_playlist cascade;

insert into user_info (login, password) values ('aaaa', '1111');
insert into user_info (login, password) values ('bbbb', '2222');
insert into user_info (login, password) values ('cccc', '3333');

insert into author (id, name) values (1, 'Kanya Cordy');
insert into author (id, name) values (2, 'Carol Harris');
insert into author (id, name) values (3, 'Arielle Luetchford');
insert into author (id, name) values (4, 'Jess Kneller');
insert into author (id, name) values (5, 'Mozelle Cours');
insert into author (id, name) values (6, 'Agnese Vautier');
insert into author (id, name) values (7, 'Karna Cockrem');
insert into author (id, name) values (8, 'Ron Puffett');
insert into author (id, name) values (9, 'Florry Tadd');
insert into author (id, name) values (10, 'Uta Bodemeaid');
insert into author (id, name) values (11, 'Nathaniel Raper');
insert into author (id, name) values (12, 'Andriana Bate');
insert into author (id, name) values (13, 'Silvain Macon');
insert into author (id, name) values (14, 'Flinn Wilstead');
insert into author (id, name) values (15, 'Daphna Lage');
insert into author (id, name) values (16, 'Carmon Geydon');
insert into author (id, name) values (17, 'Sawyer Kenney');
insert into author (id, name) values (18, 'Rebekkah Corpes');
insert into author (id, name) values (19, 'Jordan Duprey');
insert into author (id, name) values (20, 'Oralla Warboys');
insert into author (id, name) values (21, 'Lisetta Caddell');
insert into author (id, name) values (22, 'Viviyan Vittery');
insert into author (id, name) values (23, 'Nikola Kach');
insert into author (id, name) values (24, 'Conant Formilli');
insert into author (id, name) values (25, 'Chuck Mort');
insert into author (id, name) values (26, 'Jessy Gerraty');
insert into author (id, name) values (27, 'Theodore Mounter');
insert into author (id, name) values (28, 'Corabel Oehm');
insert into author (id, name) values (29, 'Alessandra Kundt');
insert into author (id, name) values (30, 'Margaretta Foskett');
insert into author (id, name) values (31, 'Joleen Oolahan');
insert into author (id, name) values (32, 'Melessa Demead');
insert into author (id, name) values (33, 'Yolanda Cruddace');
insert into author (id, name) values (34, 'Madelina McKay');
insert into author (id, name) values (35, 'Gallagher Flintiff');
insert into author (id, name) values (36, 'Nissy Sturdy');
insert into author (id, name) values (37, 'Dillon Thunnercliffe');
insert into author (id, name) values (38, 'Pansy Rawcliffe');
insert into author (id, name) values (39, 'Kerrin Grundy');
insert into author (id, name) values (40, 'Billie Jacomb');
insert into author (id, name) values (41, 'Celine Smalley');
insert into author (id, name) values (42, 'Dominique Marjanski');
insert into author (id, name) values (43, 'Gardy Broomhall');
insert into author (id, name) values (44, 'Alair Manifould');
insert into author (id, name) values (45, 'Van Warlton');
insert into author (id, name) values (46, 'Ara Edsell');
insert into author (id, name) values (47, 'Ardra Avory');
insert into author (id, name) values (48, 'Garret Colaton');
insert into author (id, name) values (49, 'Brooke Stevani');
insert into author (id, name) values (50, 'Jamie Danilchenko');

insert into playlist values
(1,'chillout lounge'),
(2,'christmas hits'),
(3,'lofi beats'),
(4,'peacefull piano'),
(5,'stress relief');

insert into songs (id, title, genre, year, a_id, popularity) values (1, 'quam suspendisse', 'rock', 2009, 38, 2724);
insert into songs (id, title, genre, year, a_id, popularity) values (2, 'amet', 'classical', 2005, 26, 2638);
insert into songs (id, title, genre, year, a_id, popularity) values (3, 'maecenas', 'jazz', 2008, 1, 392);
insert into songs (id, title, genre, year, a_id, popularity) values (4, 'posuere', 'jazz', 1995, 6, 2360);
insert into songs (id, title, genre, year, a_id, popularity) values (5, 'velit id', 'rock', 2013, 23, 6);
insert into songs (id, title, genre, year, a_id, popularity) values (6, 'vestibulum', 'pop', 2008, 44, 2873);
insert into songs (id, title, genre, year, a_id, popularity) values (7, 'etiam', 'pop', 1999, 12, 893);
insert into songs (id, title, genre, year, a_id, popularity) values (8, 'nisi', 'folk', 2002, 25, 3721);
insert into songs (id, title, genre, year, a_id, popularity) values (9, 'ac consequat', 'rock', 2001, 21, 2046);
insert into songs (id, title, genre, year, a_id, popularity) values (10, 'aliquet at', 'reggae', 2010, 40, 2050);
insert into songs (id, title, genre, year, a_id, popularity) values (11, 'vitae', 'rock', 1994, 7, 3215);
insert into songs (id, title, genre, year, a_id, popularity) values (12, 'semper sapien', 'jazz', 1988, 26, 4933);
insert into songs (id, title, genre, year, a_id, popularity) values (13, 'porttitor pede', 'rock', 2009, 13, 917);
insert into songs (id, title, genre, year, a_id, popularity) values (14, 'a suscipit', 'reggae', 2009, 15, 1459);
insert into songs (id, title, genre, year, a_id, popularity) values (15, 'ligula', 'folk', 1994, 28, 3412);
insert into songs (id, title, genre, year, a_id, popularity) values (16, 'lobortis vel', 'metal', 1992, 34, 4798);
insert into songs (id, title, genre, year, a_id, popularity) values (17, 'penatibus et', 'jazz', 2006, 14, 379);
insert into songs (id, title, genre, year, a_id, popularity) values (18, 'metus vitae', 'electronic', 1997, 44, 4406);
insert into songs (id, title, genre, year, a_id, popularity) values (19, 'abuti', 'jazz', 2006, 39, 1809);
insert into songs (id, title, genre, year, a_id, popularity) values (20, 'morbi', 'electronic', 2006, 39, 2214);
insert into songs (id, title, genre, year, a_id, popularity) values (21, 'nulla ac', 'hip hop', 2000, 36, 4843);
insert into songs (id, title, genre, year, a_id, popularity) values (22, 'pharetra', 'electronic', 1970, 8, 2327);
insert into songs (id, title, genre, year, a_id, popularity) values (23, 'bibendum', 'folk', 2009, 45, 4834);
insert into songs (id, title, genre, year, a_id, popularity) values (24, 'molestie sed', 'country', 2009, 25, 1932);
insert into songs (id, title, genre, year, a_id, popularity) values (25, 'dui', 'country', 1987, 47, 665);
insert into songs (id, title, genre, year, a_id, popularity) values (26, 'tort', 'pop', 2001, 50, 2592);
insert into songs (id, title, genre, year, a_id, popularity) values (27, 'vel', 'rock', 1996, 20, 2141);
insert into songs (id, title, genre, year, a_id, popularity) values (28, 'nullam molestie', 'country', 2008, 38, 3260);
insert into songs (id, title, genre, year, a_id, popularity) values (29, 'est', 'electronic', 1996, 41, 4167);
insert into songs (id, title, genre, year, a_id, popularity) values (30, 'magnis dis', 'country', 2006, 28, 631);
insert into songs (id, title, genre, year, a_id, popularity) values (31, 'justo maecenas', 'folk', 2007, 24, 4279);
insert into songs (id, title, genre, year, a_id, popularity) values (32, 'sit', 'rock', 2011, 43, 2994);
insert into songs (id, title, genre, year, a_id, popularity) values (33, 'ipsum', 'rock', 2010, 26, 1272);
insert into songs (id, title, genre, year, a_id, popularity) values (34, 'velit', 'classical', 2001, 3, 115);
insert into songs (id, title, genre, year, a_id, popularity) values (35, 'primis', 'pop', 2003, 33, 1882);
insert into songs (id, title, genre, year, a_id, popularity) values (36, 'metus sapien', 'electronic', 1999, 28, 812);
insert into songs (id, title, genre, year, a_id, popularity) values (37, 'quiq', 'classical', 2006, 27, 240);
insert into songs (id, title, genre, year, a_id, popularity) values (38, 'ultrices', 'country', 1989, 12, 1407);
insert into songs (id, title, genre, year, a_id, popularity) values (39, 'prasent', 'folk', 2006, 41, 1143);
insert into songs (id, title, genre, year, a_id, popularity) values (40, 'nam', 'metal', 2007, 33, 384);
insert into songs (id, title, genre, year, a_id, popularity) values (41, 'amet consectetuer', 'metal', 2006, 40, 3965);
insert into songs (id, title, genre, year, a_id, popularity) values (42, 'idi', 'electronic', 2000, 20, 996);
insert into songs (id, title, genre, year, a_id, popularity) values (43, 'donec', 'country', 2012, 38, 62);
insert into songs (id, title, genre, year, a_id, popularity) values (44, 'integer', 'electronic', 2012, 27, 1970);
insert into songs (id, title, genre, year, a_id, popularity) values (45, 'nunc nisl', 'electronic', 2011, 25, 2782);
insert into songs (id, title, genre, year, a_id, popularity) values (46, 'rutrum ac', 'folk', 2002, 13, 4543);
insert into songs (id, title, genre, year, a_id, popularity) values (47, 'tristique tortor', 'classical', 2007, 50, 2325);
insert into songs (id, title, genre, year, a_id, popularity) values (48, 'quis turpis', 'pop', 2004, 34, 1520);
insert into songs (id, title, genre, year, a_id, popularity) values (49, 'sed tristique', 'rock', 2003, 16, 259);
insert into songs (id, title, genre, year, a_id, popularity) values (50, 'nisl', 'rock', 2008, 33, 2917);
insert into songs (id, title, genre, year, a_id, popularity) values (51, 'aliquam non', 'electronic', 1997, 18, 4848);
insert into songs (id, title, genre, year, a_id, popularity) values (52, 'eleifend', 'classical', 2011, 32, 2823);
insert into songs (id, title, genre, year, a_id, popularity) values (53, 'molestie lorem', 'country', 1995, 49, 719);
insert into songs (id, title, genre, year, a_id, popularity) values (54, 'in', 'metal', 1993, 19, 761);
insert into songs (id, title, genre, year, a_id, popularity) values (55, 'curabitur gravida', 'country', 1985, 43, 162);
insert into songs (id, title, genre, year, a_id, popularity) values (56, 'vivamus', 'pop', 2000, 47, 3789);
insert into songs (id, title, genre, year, a_id, popularity) values (57, 'amed', 'jazz', 1997, 39, 834);
insert into songs (id, title, genre, year, a_id, popularity) values (58, 'velik', 'hip hop', 2005, 4, 3626);
insert into songs (id, title, genre, year, a_id, popularity) values (59, 'vel est', 'rock', 1998, 27, 3763);
insert into songs (id, title, genre, year, a_id, popularity) values (60, 'libero', 'country', 2002, 34, 4404);
insert into songs (id, title, genre, year, a_id, popularity) values (61, 'daynek', 'country', 2003, 30, 4085);
insert into songs (id, title, genre, year, a_id, popularity) values (62, 'sid', 'folk', 1988, 17, 934);
insert into songs (id, title, genre, year, a_id, popularity) values (63, 'sup', 'metal', 2012, 16, 2700);
insert into songs (id, title, genre, year, a_id, popularity) values (64, 'pellentesque', 'rock', 2003, 24, 1490);
insert into songs (id, title, genre, year, a_id, popularity) values (65, 'tortor eu', 'classical', 2005, 39, 4223);
insert into songs (id, title, genre, year, a_id, popularity) values (66, 'amet eros', 'classical', 1988, 30, 465);
insert into songs (id, title, genre, year, a_id, popularity) values (67, 'condimentum', 'pop', 1967, 24, 4989);
insert into songs (id, title, genre, year, a_id, popularity) values (68, 'aenean fermentum', 'reggae', 2011, 36, 2352);
insert into songs (id, title, genre, year, a_id, popularity) values (69, 'quim', 'rock', 2002, 12, 4424);
insert into songs (id, title, genre, year, a_id, popularity) values (70, 'bibi', 'jazz', 2012, 25, 593);
insert into songs (id, title, genre, year, a_id, popularity) values (71, 'muspi', 'hip hop', 1962, 7, 2197);
insert into songs (id, title, genre, year, a_id, popularity) values (72, 'pyot', 'folk', 2004, 21, 2016);
insert into songs (id, title, genre, year, a_id, popularity) values (73, 'aliquet maecenas', 'metal', 2000, 13, 4232);
insert into songs (id, title, genre, year, a_id, popularity) values (74, 'convallis', 'reggae', 2012, 21, 4252);
insert into songs (id, title, genre, year, a_id, popularity) values (75, 'non velit', 'pop', 2007, 40, 2815);
insert into songs (id, title, genre, year, a_id, popularity) values (76, 'mauris vulputate', 'classical', 1995, 2, 2075);
insert into songs (id, title, genre, year, a_id, popularity) values (77, 'morbi odio', 'electronic', 1997, 20, 971);
insert into songs (id, title, genre, year, a_id, popularity) values (78, 'justo', 'rock', 2011, 35, 4994);
insert into songs (id, title, genre, year, a_id, popularity) values (79, 'curae donec', 'electronic', 1996, 48, 654);
insert into songs (id, title, genre, year, a_id, popularity) values (80, 'pede lobortis', 'electronic', 1964, 28, 3383);
insert into songs (id, title, genre, year, a_id, popularity) values (81, 'donec ut', 'electronic', 2006, 16, 1366);
insert into songs (id, title, genre, year, a_id, popularity) values (82, 'in imperdiet', 'reggae', 2009, 4, 1911);
insert into songs (id, title, genre, year, a_id, popularity) values (83, 'id luctus', 'country', 2003, 13, 2951);
insert into songs (id, title, genre, year, a_id, popularity) values (84, 'inb', 'jazz', 2006, 46, 2449);
insert into songs (id, title, genre, year, a_id, popularity) values (85, 'vestibule', 'metal', 1994, 29, 4388);
insert into songs (id, title, genre, year, a_id, popularity) values (86, 'et commodo', 'country', 1986, 25, 4290);
insert into songs (id, title, genre, year, a_id, popularity) values (87, 'eto', 'jazz', 2008, 25, 582);
insert into songs (id, title, genre, year, a_id, popularity) values (88, 'a feugiat', 'folk', 2002, 2, 4363);
insert into songs (id, title, genre, year, a_id, popularity) values (89, 'sem duis', 'jazz', 2006, 34, 4535);
insert into songs (id, title, genre, year, a_id, popularity) values (90, 'lacinia', 'rock', 2010, 8, 2179);
insert into songs (id, title, genre, year, a_id, popularity) values (91, 'consequat in', 'folk', 2002, 29, 1404);
insert into songs (id, title, genre, year, a_id, popularity) values (92, 'erar', 'rock', 2001, 21, 4200);
insert into songs (id, title, genre, year, a_id, popularity) values (93, 'vitaet', 'hip hop', 2009, 29, 3416);
insert into songs (id, title, genre, year, a_id, popularity) values (94, 'eraq', 'metal', 2010, 9, 2112);
insert into songs (id, title, genre, year, a_id, popularity) values (95, 'ante vivamus', 'pop', 2008, 19, 3668);
insert into songs (id, title, genre, year, a_id, popularity) values (96, 'at lorem', 'reggae', 2004, 49, 3568);
insert into songs (id, title, genre, year, a_id, popularity) values (97, 'et magnis', 'folk', 2008, 50, 2696);
insert into songs (id, title, genre, year, a_id, popularity) values (98, 'inr', 'folk', 2009, 38, 1799);
insert into songs (id, title, genre, year, a_id, popularity) values (99, 'natoque', 'classical', 1984, 17, 3887);
insert into songs (id, title, genre, year, a_id, popularity) values (100, 'vestibul', 'rock', 1999, 36, 4313);
insert into songs (id, title, genre, year, a_id, popularity) values (101, 'sociis natoque', 'hip hop', 2006, 27, 3832);
insert into songs (id, title, genre, year, a_id, popularity) values (102, 'sapien', 'electronic', 1986, 29, 4408);
insert into songs (id, title, genre, year, a_id, popularity) values (103, 'siti', 'metal', 1955, 31, 1804);
insert into songs (id, title, genre, year, a_id, popularity) values (104, 'lazania', 'electronic', 1999, 48, 1732);
insert into songs (id, title, genre, year, a_id, popularity) values (105, 'cursus', 'rock', 2008, 46, 2510);
insert into songs (id, title, genre, year, a_id, popularity) values (106, 'mattis', 'folk', 1989, 28, 4411);
insert into songs (id, title, genre, year, a_id, popularity) values (107, 'sapien a', 'pop', 2012, 46, 1128);
insert into songs (id, title, genre, year, a_id, popularity) values (108, 'erap', 'classical', 1993, 7, 4123);
insert into songs (id, title, genre, year, a_id, popularity) values (109, 'dui vel', 'pop', 1993, 30, 3844);
insert into songs (id, title, genre, year, a_id, popularity) values (110, 'nunc', 'metal', 2012, 25, 3095);
insert into songs (id, title, genre, year, a_id, popularity) values (111, 'present', 'electronic', 1985, 45, 2774);
insert into songs (id, title, genre, year, a_id, popularity) values (112, 'nulla eget', 'electronic', 2008, 33, 3747);
insert into songs (id, title, genre, year, a_id, popularity) values (113, 'erat', 'reggae', 1956, 17, 3681);
insert into songs (id, title, genre, year, a_id, popularity) values (114, 'euqen', 'rock', 2005, 20, 3015);
insert into songs (id, title, genre, year, a_id, popularity) values (115, 'tortor', 'pop', 2003, 16, 3888);
insert into songs (id, title, genre, year, a_id, popularity) values (116, 'duis consequat', 'metal', 1992, 1, 2463);
insert into songs (id, title, genre, year, a_id, popularity) values (117, 'augue', 'metal', 1995, 4, 3973);
insert into songs (id, title, genre, year, a_id, popularity) values (118, 'inw', 'electronic', 2006, 24, 1812);
insert into songs (id, title, genre, year, a_id, popularity) values (119, 'praesent blandit', 'metal', 1986, 31, 3057);
insert into songs (id, title, genre, year, a_id, popularity) values (120, 'idu', 'reggae', 2000, 37, 3747);
insert into songs (id, title, genre, year, a_id, popularity) values (121, 'suscipit', 'classical', 1995, 2, 4905);
insert into songs (id, title, genre, year, a_id, popularity) values (122, 'diam', 'pop', 1994, 21, 1118);
insert into songs (id, title, genre, year, a_id, popularity) values (123, 'vulput', 'jazz', 1999, 31, 4048);
insert into songs (id, title, genre, year, a_id, popularity) values (124, 'rutrum at', 'rock', 1993, 17, 1244);
insert into songs (id, title, genre, year, a_id, popularity) values (125, 'pellentesque volutpat', 'hip hop', 1999, 15, 2068);
insert into songs (id, title, genre, year, a_id, popularity) values (126, 'inq', 'reggae', 2006, 34, 1725);
insert into songs (id, title, genre, year, a_id, popularity) values (127, 'pide', 'electronic', 2000, 7, 3674);
insert into songs (id, title, genre, year, a_id, popularity) values (128, 'nullam porttitor', 'metal', 1995, 23, 4226);
insert into songs (id, title, genre, year, a_id, popularity) values (129, 'integer a', 'jazz', 1997, 16, 1373);
insert into songs (id, title, genre, year, a_id, popularity) values (130, 'volutpat', 'rock', 2007, 33, 4360);
insert into songs (id, title, genre, year, a_id, popularity) values (131, 'vel ipsum', 'electronic', 1998, 32, 1812);
insert into songs (id, title, genre, year, a_id, popularity) values (132, 'ligula vehicula', 'reggae', 1999, 44, 3656);
insert into songs (id, title, genre, year, a_id, popularity) values (133, 'volutpat dui', 'pop', 1998, 47, 4796);
insert into songs (id, title, genre, year, a_id, popularity) values (134, 'sollicitudin', 'jazz', 1987, 42, 4465);
insert into songs (id, title, genre, year, a_id, popularity) values (135, 'eu nibh', 'folk', 2011, 7, 4436);
insert into songs (id, title, genre, year, a_id, popularity) values (136, 'quip', 'jazz', 1989, 40, 1741);
insert into songs (id, title, genre, year, a_id, popularity) values (137, 'fusce', 'pop', 2008, 11, 3765);
insert into songs (id, title, genre, year, a_id, popularity) values (138, 'nisi eu', 'reggae', 1985, 48, 1258);
insert into songs (id, title, genre, year, a_id, popularity) values (139, 'sit amet', 'jazz', 2004, 43, 3449);
insert into songs (id, title, genre, year, a_id, popularity) values (140, 'amet justo', 'folk', 1999, 44, 1643);
insert into songs (id, title, genre, year, a_id, popularity) values (141, 'orci', 'electronic', 1999, 22, 2559);
insert into songs (id, title, genre, year, a_id, popularity) values (142, 'pidee', 'metal', 2003, 7, 1647);
insert into songs (id, title, genre, year, a_id, popularity) values (143, 'varius', 'jazz', 1998, 44, 1602);
insert into songs (id, title, genre, year, a_id, popularity) values (144, 'pedee', 'hip hop', 1994, 49, 800);
insert into songs (id, title, genre, year, a_id, popularity) values (145, 'felis', 'hip hop', 2008, 37, 1616);
insert into songs (id, title, genre, year, a_id, popularity) values (146, 'dis parturient', 'classical', 2009, 2, 3762);
insert into songs (id, title, genre, year, a_id, popularity) values (147, 'aliquam augue', 'folk', 2009, 24, 4914);
insert into songs (id, title, genre, year, a_id, popularity) values (148, 'svd', 'rock', 2000, 23, 619);
insert into songs (id, title, genre, year, a_id, popularity) values (149, 'in faucibus', 'reggae', 2001, 18, 3931);
insert into songs (id, title, genre, year, a_id, popularity) values (150, 'lero', 'country', 1978, 7, 4353);
insert into songs (id, title, genre, year, a_id, popularity) values (151, 'scelerisque mauris', 'metal', 2007, 24, 1107);
insert into songs (id, title, genre, year, a_id, popularity) values (152, 'aliquet pulvinar', 'electronic', 1997, 38, 3532);
insert into songs (id, title, genre, year, a_id, popularity) values (153, 'felis ut', 'rock', 2002, 34, 1690);
insert into songs (id, title, genre, year, a_id, popularity) values (154, 'ametist', 'rock', 2011, 45, 1771);
insert into songs (id, title, genre, year, a_id, popularity) values (155, 'at', 'electronic', 2010, 46, 252);
insert into songs (id, title, genre, year, a_id, popularity) values (156, 'accumsan felis', 'reggae', 1975, 29, 1132);
insert into songs (id, title, genre, year, a_id, popularity) values (157, 'at dolor', 'rock', 2006, 43, 591);
insert into songs (id, title, genre, year, a_id, popularity) values (158, 'pede', 'hip hop', 2002, 29, 2360);
insert into songs (id, title, genre, year, a_id, popularity) values (159, 'suspendisse', 'metal', 2012, 38, 880);
insert into songs (id, title, genre, year, a_id, popularity) values (160, 'lacus curabitur', 'metal', 2003, 4, 599);
insert into songs (id, title, genre, year, a_id, popularity) values (161, 'in sapien', 'metal', 1992, 8, 1971);
insert into songs (id, title, genre, year, a_id, popularity) values (162, 'scelerisque', 'metal', 2000, 36, 4862);
insert into songs (id, title, genre, year, a_id, popularity) values (163, 'praesent', 'metal', 2003, 37, 3708);
insert into songs (id, title, genre, year, a_id, popularity) values (164, 'ina', 'country', 1997, 6, 2128);
insert into songs (id, title, genre, year, a_id, popularity) values (165, 'a', 'metal', 2011, 21, 3517);
insert into songs (id, title, genre, year, a_id, popularity) values (166, 'rutrum nulla', 'jazz', 1998, 45, 1525);
insert into songs (id, title, genre, year, a_id, popularity) values (167, 'leo', 'folk', 2006, 16, 4466);
insert into songs (id, title, genre, year, a_id, popularity) values (168, 'etiam justo', 'rock', 1998, 18, 4070);
insert into songs (id, title, genre, year, a_id, popularity) values (169, 'sed magna', 'reggae', 1994, 6, 3496);
insert into songs (id, title, genre, year, a_id, popularity) values (170, 'morbi sem', 'reggae', 2001, 39, 2822);
insert into songs (id, title, genre, year, a_id, popularity) values (171, 'libro', 'jazz', 1998, 7, 668);
insert into songs (id, title, genre, year, a_id, popularity) values (172, 'ridiculus mus', 'metal', 2007, 15, 4387);
insert into songs (id, title, genre, year, a_id, popularity) values (173, 'duis', 'jazz', 1993, 27, 830);
insert into songs (id, title, genre, year, a_id, popularity) values (174, 'nibh', 'metal', 2003, 47, 995);
insert into songs (id, title, genre, year, a_id, popularity) values (175, 'in hac', 'reggae', 2006, 27, 2401);
insert into songs (id, title, genre, year, a_id, popularity) values (176, 'et', 'reggae', 1985, 12, 669);
insert into songs (id, title, genre, year, a_id, popularity) values (177, 'ut', 'classical', 2005, 17, 372);
insert into songs (id, title, genre, year, a_id, popularity) values (178, 'vulputate', 'folk', 2010, 30, 4395);
insert into songs (id, title, genre, year, a_id, popularity) values (179, 'eleifend donec', 'jazz', 2011, 39, 2947);
insert into songs (id, title, genre, year, a_id, popularity) values (180, 'diam id', 'folk', 1967, 32, 2032);
insert into songs (id, title, genre, year, a_id, popularity) values (181, 'maece', 'jazz', 2006, 38, 1461);
insert into songs (id, title, genre, year, a_id, popularity) values (182, 'nisi at', 'classical', 2006, 14, 4718);
insert into songs (id, title, genre, year, a_id, popularity) values (183, 'vitae nisl', 'classical', 1985, 11, 2706);
insert into songs (id, title, genre, year, a_id, popularity) values (184, 'cnun', 'pop', 1996, 40, 2614);
insert into songs (id, title, genre, year, a_id, popularity) values (185, 'sed', 'hip hop', 2007, 47, 3097);
insert into songs (id, title, genre, year, a_id, popularity) values (186, 'sed augue', 'metal', 1995, 13, 1526);
insert into songs (id, title, genre, year, a_id, popularity) values (187, 'nunc rhoncus', 'electronic', 1994, 2, 3186);
insert into songs (id, title, genre, year, a_id, popularity) values (188, 'in tempor', 'hip hop', 1994, 42, 467);
insert into songs (id, title, genre, year, a_id, popularity) values (189, 'liber', 'metal', 1988, 31, 4244);
insert into songs (id, title, genre, year, a_id, popularity) values (190, 'eget massa', 'rock', 2005, 2, 2311);
insert into songs (id, title, genre, year, a_id, popularity) values (191, 'idesh', 'rock', 2008, 46, 4956);
insert into songs (id, title, genre, year, a_id, popularity) values (192, 'neque', 'folk', 2008, 3, 3723);
insert into songs (id, title, genre, year, a_id, popularity) values (193, 'mus', 'rock', 1970, 31, 296);
insert into songs (id, title, genre, year, a_id, popularity) values (194, 'consequat morbi', 'electronic', 2006, 11, 602);
insert into songs (id, title, genre, year, a_id, popularity) values (195, 'in quam', 'jazz', 1989, 47, 1411);
insert into songs (id, title, genre, year, a_id, popularity) values (196, 'inu', 'rock', 2009, 48, 144);
insert into songs (id, title, genre, year, a_id, popularity) values (197, 'quam', 'reggae', 1987, 1, 1024);
insert into songs (id, title, genre, year, a_id, popularity) values (198, 'dolor', 'folk', 2011, 38, 4029);
insert into songs (id, title, genre, year, a_id, popularity) values (199, 'magna', 'metal', 1990, 13, 3639);
insert into songs (id, title, genre, year, a_id, popularity) values (200, 'quis', 'country', 2011, 49, 416);

insert into user_songs (u_id, s_id) values (1, 121);
insert into user_songs (u_id, s_id) values (1, 114);
insert into user_songs (u_id, s_id) values (2, 174);
insert into user_songs (u_id, s_id) values (3, 179);
insert into user_songs (u_id, s_id) values (1, 108);
insert into user_songs (u_id, s_id) values (1, 38);
insert into user_songs (u_id, s_id) values (1, 146);
insert into user_songs (u_id, s_id) values (2, 147);
insert into user_songs (u_id, s_id) values (2, 143);
insert into user_songs (u_id, s_id) values (3, 89);

insert into song_playlist (p_id, s_id) values
(1,1),
(1,7),
(1,13),
(1,18),
(1,29),
(1,33),
(1,42),
(1,63),
(1,68),
(1,75),
(1,89),
(1,95),
(1,99),
(1,103),
(1,105),
(1,111),
(1,116),
(1,117),
(1,122),
(1,132),
(1,140),
(1,142),
(1,146),
(1,152),
(1,156),
(1,160),
(1,173),
(1,174),
(1,177),
(1,178),
(1,180),
(1,183),
(1,186),
(1,196),
(1,199),
(2,2),
(2,6),
(2,8),
(2,17),
(2,23),
(2,28),
(2,34),
(2,46),
(2,47),
(2,49),
(2,53),
(2,58),
(2,60),
(2,61),
(2,65),
(2,70),
(2,94),
(2,107),
(2,112),
(2,120),
(2,121),
(2,124),
(2,126),
(2,134),
(2,136),
(2,149),
(2,150),
(2,153),
(2,157),
(2,162),
(2,168),
(2,172),
(2,179),
(2,187),
(2,192),
(3,3),
(3,4),
(3,5),
(3,9),
(3,10),
(3,12),
(3,14),
(3,20),
(3,21),
(3,27),
(3,36),
(3,37),
(3,38),
(3,41),
(3,45),
(3,48),
(3,51),
(3,52),
(3,54),
(3,55),
(3,62),
(3,64),
(3,69),
(3,76),
(3,77),
(3,79),
(3,85),
(3,88),
(3,90),
(3,109),
(3,110),
(3,115),
(3,119),
(3,123),
(3,129),
(3,130),
(3,139),
(3,143),
(3,144),
(3,147),
(3,158),
(3,169),
(3,170),
(3,171),
(3,185),
(3,191),
(3,193),
(3,195),
(4,15),
(4,16),
(4,19),
(4,22),
(4,25),
(4,26),
(4,31),
(4,32),
(4,35),
(4,39),
(4,43),
(4,44),
(4,56),
(4,57),
(4,59),
(4,66),
(4,67),
(4,78),
(4,82),
(4,83),
(4,84),
(4,92),
(4,93),
(4,100),
(4,101),
(4,106),
(4,118),
(4,125),
(4,128),
(4,131),
(4,133),
(4,138),
(4,154),
(4,159),
(4,165),
(4,166),
(4,175),
(4,176),
(4,181),
(4,184),
(4,188),
(4,189),
(4,194),
(4,197),
(4,198),
(5,11),
(5,24),
(5,30),
(5,40),
(5,50),
(5,71),
(5,72),
(5,73),
(5,74),
(5,80),
(5,81),
(5,86),
(5,87),
(5,91),
(5,96),
(5,97),
(5,98),
(5,102),
(5,104),
(5,108),
(5,113),
(5,114),
(5,127),
(5,135),
(5,137),
(5,141),
(5,145),
(5,148),
(5,151),
(5,155),
(5,161),
(5,163),
(5,164),
(5,167),
(5,182),
(5,190),
(5,200);