insert into performance(name, viewing_hours, date, cast, location, poster_path) values ('콘서트A', 100, now(), '출연진A', '서울시 00구', '/img/imgA.png');
insert into performance(name, viewing_hours, date, cast, location, poster_path) values ('콘서트B', 180, now(), '출연진B', '서울시 00구', '/img/imgB.png');
insert into performance(name, viewing_hours, date, cast, location, poster_path) values ('콘서트C', 120, now(), '출연진C', '서울시 00구', '/img/imgC.png');
insert into performance(name, viewing_hours, date, cast, location, poster_path) values ('콘서트D', 60, now(), '출연진D', '서울시 00구', '/img/imgD.png');

insert into seat(performance_id, seat_type, total_seat, price, seat_limit) values (1, 'R', 100, 90000, 1);
insert into seat(performance_id, seat_type, total_seat, price, seat_limit) values (1, 'S', 100, 100000, 1);

insert into seat(performance_id, seat_type, total_seat, price, seat_limit) values (2, 'STANDING', 200, 50000, 2);
insert into seat(performance_id, seat_type, total_seat, price, seat_limit) values (2, 'SEAT', 200, 70000, 2);

insert into seat(performance_id, seat_type, total_seat, price, seat_limit) values (3, 'R', 100, 90000, 3);
insert into seat(performance_id, seat_type, total_seat, price, seat_limit) values (3, 'S', 100, 100000, 3);

insert into seat(performance_id, seat_type, total_seat, price, seat_limit) values (4, 'R', 100, 90000, 1);
insert into seat(performance_id, seat_type, total_seat, price, seat_limit) values (4, 'S', 100, 100000, 1);