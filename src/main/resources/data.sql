insert into user_details(id, birth_date, name) values(1001, current_date(), 'Ivan Santos');
insert into user_details(id, birth_date, name) values(1003, current_date(), 'Carmen Gomes');
insert into user_details(id, birth_date, name) values(1002, current_date(), 'Ivan Júnior');
insert into user_details(id, birth_date, name) values(1004, current_date(), 'João Victor');
insert into user_details(id, birth_date, name) values(1005, current_date(), 'João Paulo');
insert into user_details(id, birth_date, name) values(1006, current_date(), 'Teka Gomes');

insert into post(id, description, user_id) values (1001, 'Postagem do Ivan Santos sobre o Ivan Júnior', 1001);
insert into post(id, description, user_id) values (1002, 'Postagem do Ivan Júnior sobre o Ivan Santos', 1002);
insert into post(id, description, user_id) values (1003, 'Postagem do Ivan Santos sobre a Carmen Gomes', 1001);
insert into post(id, description, user_id) values (1004, 'Postagem do Ivan Santos sobre o João Victor', 1001);
insert into post(id, description, user_id) values (1005, 'Postagem do João Victor sobre o Ivan Júnior', 1004);
insert into post(id, description, user_id) values (1006, 'Postagem do João Paulo sobre o Ivan Júnior', 1005);
insert into post(id, description, user_id) values (1007, 'Postagem do Carmen Gomes sobre o Ivan Júnior', 1003);
insert into post(id, description, user_id) values (1008, 'Postagem do Carmen Gomes sobre o Ivan Júnior', 1003);
insert into post(id, description, user_id) values (1009, 'Postagem do Ivan Júnior sobre o Ivan Júnior', 1002);
insert into post(id, description, user_id) values (1010, 'Postagem do João victor sobre o Ivan Santos', 1004);