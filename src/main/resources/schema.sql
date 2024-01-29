-- create schema sandbox if  not exists;
use
sandbox;

DROP TABLE IF EXISTS t_film;
create table t_film
(
    id            int NOT NULL AUTO_INCREMENT,
    c_title       varchar(100),
    c_description text,
    id_director   int references t_director,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS t_director;
create table t_director
(
    id     int NOT NULL AUTO_INCREMENT,
    c_name varchar(100),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS t_actor;
create table t_actor
(
    id     int NOT NULL AUTO_INCREMENT,
    c_name varchar(100),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS t_film_actor;
create table t_film_actor
(
    id_film  int references t_film,
    id_actor int references t_actor,
    PRIMARY KEY (id_film, id_actor)
);
