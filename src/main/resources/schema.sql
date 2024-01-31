-- drop schema if exists sandbox;
-- create schema sandbox not exists;
use
sandbox;

DROP TABLE IF EXISTS t_films_actors;
DROP TABLE IF EXISTS t_film;
DROP TABLE IF EXISTS t_actor;
DROP TABLE IF EXISTS t_director;

create table t_film
(
    id            int NOT NULL AUTO_INCREMENT,
    c_title       varchar(100),
    c_description text,
    id_director   int references t_director,
    PRIMARY KEY (id)
);

create table t_director
(
    id     int NOT NULL AUTO_INCREMENT,
    c_name varchar(100),
    PRIMARY KEY (id)
);

create table t_actor
(
    id     int NOT NULL AUTO_INCREMENT,
    c_name varchar(100),
    PRIMARY KEY (id)
);

create table t_films_actors
(
    id_film  int,
    id_actor int,
    PRIMARY KEY (id_film, id_actor),
    FOREIGN KEY (id_film) REFERENCES t_film (id),
    FOREIGN KEY (id_actor) REFERENCES t_actor (id)
);
