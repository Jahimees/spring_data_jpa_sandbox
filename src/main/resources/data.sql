insert into t_director(c_name)
values ('J.jonson'),
       ('K.Kameron'),
       ('P.Piterson');

insert into t_actor(c_name)
values ('j.Johohich'),
       ('J.Depp'),
       ('B.Pitt'),
       ('L.DiKaprio');

insert into t_film(c_title, c_description, id_director)
values ('Побег из шоушенка', 'Побежали', 1),
       ('Неудержимые', 'Попробуй удержать', 2),
       ('Удержимые', 'Отпусти', 2),
       ('Эйс вентура', 'Ура', 3),
       ('Брюс всемогущий', 'Может всё', 1),
       ('Титаник', 'Утонул :(', 1);

insert into t_film_actor(id_actor, id_film)
values (1, 1),
       (2, 2),
       (3, 2),
       (4, 2),
       (4, 3),
       (4, 6),
       (3, 5),
       (2, 4);


