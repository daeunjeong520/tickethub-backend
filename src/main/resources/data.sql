insert into performance(name, viewing_hours, date, cast, location, poster_path) values ('콘서트A', 100, now(), '출연진A', '서울시 00구', '/img/imgA.png');
insert into performance(name, viewing_hours, date, cast, location, poster_path) values ('콘서트B', 180, now(), '출연진B', '서울시 00구', '/img/imgB.png');
insert into performance(name, viewing_hours, date, cast, location, poster_path) values ('콘서트C', 120, now(), '출연진C', '서울시 00구', '/img/imgC.png');
insert into performance(name, viewing_hours, date, cast, location, poster_path) values ('콘서트D', 60, now(), '출연진D', '서울시 00구', '/img/imgD.png');

insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'A', '0', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'A', '1', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'A', '2', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'A', '3', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'A', '4', 50000, false);

insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'B', '0', 50000, true);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'B', '1', 50000, true);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'B', '2', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'B', '3', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'B', '4', 50000, false);

insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'C', '0', 70000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'C', '1', 70000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'C', '2', 70000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'C', '3', 70000, true);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'C', '4', 70000, true);

insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'D', '0', 70000, true);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'D', '1', 70000, true);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'D', '2', 70000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'D', '3', 70000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'D', '4', 70000, false);

insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'E', '0', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'E', '1', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'E', '2', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'E', '3', 50000, false);
insert into seat(performance_id, seat_row, seat_col, price, is_book) values (1, 'E', '4', 50000, false);