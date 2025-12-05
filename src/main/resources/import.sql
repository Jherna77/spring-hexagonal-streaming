INSERT INTO role (id, name, tag) VALUES (1, 'ADMIN', 'user.role.admin');
INSERT INTO role (id, name, tag) VALUES (2, 'EMPLOYEE', 'user.role.employee');
INSERT INTO role (id, name, tag) VALUES (3, 'MEMBER', 'user.role.member');

INSERT INTO users (id, email, password, first_name, last_name, phone, address, city, province, country, postal_code, role_id) VALUES (1, 'admin@lsimax.es','$2a$10$IsazYoCM1gRI1WctOcPjYeK6zwL8qe0ECwr2UcE4oor72XMv8A9fS','Administrador','Master','611102030','Main Street, SN','N/A','N/A', 'Spain', 21000, 1);
INSERT INTO users (id, email, password, first_name, last_name, phone, address, city, province, country, postal_code, role_id) VALUES (2, 'employee@lsimax.es','$2a$10$IsazYoCM1gRI1WctOcPjYeK6zwL8qe0ECwr2UcE4oor72XMv8A9fS','Empleado','Default','622203040','Main Street, SN','N/A','N/A', 'Spain', 21000, 2);
INSERT INTO users (id, email, password, first_name, last_name, phone, address, city, province, country, postal_code, role_id) VALUES (3, 'member@lsimax.es','$2a$10$IsazYoCM1gRI1WctOcPjYeK6zwL8qe0ECwr2UcE4oor72XMv8A9fS','Socio','Default','633405060','Main Street, SN','N/A','N/A', 'Spain', 21000, 3);

INSERT INTO directors (id, name) VALUES (1, 'Quentin Tarantino'); -- id=1
INSERT INTO directors (id, name) VALUES (2, 'Martin Scorsese'); -- id=2
INSERT INTO directors (id, name) VALUES (3, 'Peter Jackson'); -- id=3
INSERT INTO directors (id, name) VALUES (4, 'Guy Ritchie'); -- id=4
INSERT INTO directors (id, name) VALUES (5, 'Robert Rodriguez'); -- id=5
INSERT INTO directors (id, name) VALUES (6, 'Joel Coen'); -- id=6
INSERT INTO directors (id, name) VALUES (7, 'Alex Pina'); -- id=7
INSERT INTO directors (id, name) VALUES (8, 'Vince Gilligan'); -- id=8
INSERT INTO directors (id, name) VALUES (9, 'Pierre Coffin'); -- id=9
INSERT INTO directors (id, name) VALUES (10, 'David Benioff'); -- id=10
INSERT INTO directors (id, name) VALUES (11, 'J.J. Abrams'); -- id=11
INSERT INTO directors (id, name) VALUES (12, 'Matt Groening'); -- id=12
INSERT INTO directors (id, name) VALUES (13, 'David Crane'); -- id=13
INSERT INTO directors (id, name) VALUES (14, 'Marta Kauffman'); -- id=14
INSERT INTO directors (id, name) VALUES (15, 'The Duffer Brothers'); -- id=15
INSERT INTO directors (id, name) VALUES (16, 'Charlie Brooker'); -- id=16
INSERT INTO directors (id, name) VALUES (17, 'Michael Moore'); -- id=17
INSERT INTO directors (id, name) VALUES (18, 'Morgan Spurlock'); -- id=18
INSERT INTO directors (id, name) VALUES (19, 'Davis Guggenheim'); -- id=19
INSERT INTO directors (id, name) VALUES (20, 'Asif Kapadia'); -- id=20
INSERT INTO directors (id, name) VALUES (21, 'Wim Wenders'); -- id=21
INSERT INTO directors (id, name) VALUES (22, 'Jeremy Isaacs'); -- id=22
INSERT INTO directors (id, name) VALUES (23, 'Tara Pirnia'); -- id=23

INSERT INTO actors (id, name) VALUES (1, 'John Travolta'); -- id=1
INSERT INTO actors (id, name) VALUES (2, 'Uma Thurman'); -- id=2
INSERT INTO actors (id, name) VALUES (3, 'Bruce Willis'); -- id=3
INSERT INTO actors (id, name) VALUES (4, 'Leonardo DiCaprio'); -- id=4
INSERT INTO actors (id, name) VALUES (5, 'Margot Robbie'); -- id=5
INSERT INTO actors (id, name) VALUES (6, 'Elijah Wood'); -- id=6
INSERT INTO actors (id, name) VALUES (7, 'Viggo Mortensen'); -- id=7
INSERT INTO actors (id, name) VALUES (8, 'Jason Statham'); -- id=8
INSERT INTO actors (id, name) VALUES (9, 'Brad Pitt'); -- id=9
INSERT INTO actors (id, name) VALUES (10, 'George Clooney'); -- id=10
INSERT INTO actors (id, name) VALUES (11, 'Salma Hayek'); -- id=11
INSERT INTO actors (id, name) VALUES (12, 'Jeff Bridges'); -- id=12
INSERT INTO actors (id, name) VALUES (13, 'John Goodman'); -- id=13
INSERT INTO actors (id, name) VALUES (14, 'Harvey Keitel'); -- id=14
INSERT INTO actors (id, name) VALUES (15, 'Alvaro Morte'); -- id=15
INSERT INTO actors (id, name) VALUES (16, 'Úrsula Corberó'); -- id=16
INSERT INTO actors (id, name) VALUES (17, 'Alba Flores'); -- id=17
INSERT INTO actors (id, name) VALUES (18, 'Bryan Cranston'); -- id=18
INSERT INTO actors (id, name) VALUES (19, 'Aaron Paul'); -- id=19
INSERT INTO actors (id, name) VALUES (20, 'Emilia Clarke'); -- id=20
INSERT INTO actors (id, name) VALUES (21, 'Kit Harington'); -- id=21
INSERT INTO actors (id, name) VALUES (22, 'Matthew Fox'); -- id=22
INSERT INTO actors (id, name) VALUES (23, 'Evangeline Lilly'); -- id=23
INSERT INTO actors (id, name) VALUES (24, 'Jennifer Aniston'); -- id=24
INSERT INTO actors (id, name) VALUES (25, 'Matthew Perry'); -- id=25
INSERT INTO actors (id, name) VALUES (26, 'Wynona Ryder'); -- id=26
INSERT INTO actors (id, name) VALUES (27, 'Millie Bobby Brown'); -- id=27
INSERT INTO actors (id, name) VALUES (28, 'Rory Kinnear'); -- id=28
INSERT INTO actors (id, name) VALUES (29, 'Lindsay Duncan'); -- id=29

INSERT INTO genres (id, name) VALUES (1, 'Acción'); -- id=1
INSERT INTO genres (id, name) VALUES (2, 'Thriller'); -- id=2
INSERT INTO genres (id, name) VALUES (3, 'Misterio'); -- id=3
INSERT INTO genres (id, name) VALUES (4, 'Terror'); -- id=4
INSERT INTO genres (id, name) VALUES (5, 'Comedia'); -- id=5
INSERT INTO genres (id, name) VALUES (6, 'Aventuras'); -- id=6
INSERT INTO genres (id, name) VALUES (7, 'Drama'); -- id=7
INSERT INTO genres (id, name) VALUES (8, 'Biográfico'); -- id=8
INSERT INTO genres (id, name) VALUES (9, 'Fantástico'); -- id=9
INSERT INTO genres (id, name) VALUES (10, 'Crimen'); -- id=10
INSERT INTO genres (id, name) VALUES (11, 'Animación'); -- id=11
INSERT INTO genres (id, name) VALUES (12, 'Futuro'); -- id=12
INSERT INTO genres (id, name) VALUES (13, 'Tecnología'); -- id=13
INSERT INTO genres (id, name) VALUES (14, 'Historia'); -- id=14
INSERT INTO genres (id, name) VALUES (15, 'Conspiración'); -- id=15
INSERT INTO genres (id, name) VALUES (16, 'Sátira'); -- id=16
INSERT INTO genres (id, name) VALUES (17, 'Cambio climático'); -- id=17
INSERT INTO genres (id, name) VALUES (18, 'Musical'); -- id=18
INSERT INTO genres (id, name) VALUES (19, 'Bélico'); -- id=19

INSERT INTO users_directors (user_id, director_id) VALUES (3, 1);
INSERT INTO users_directors (user_id, director_id) VALUES (3, 4);
INSERT INTO users_directors (user_id, director_id) VALUES (3, 5);

INSERT INTO users_actors (user_id, actor_id) VALUES (3, 3);
INSERT INTO users_actors (user_id, actor_id) VALUES (3, 5);
INSERT INTO users_actors (user_id, actor_id) VALUES (3, 14);

INSERT INTO users_genres (user_id, genre_id) VALUES (3, 1);
INSERT INTO users_genres (user_id, genre_id) VALUES (3, 2);
INSERT INTO users_genres (user_id, genre_id) VALUES (3, 10);

INSERT INTO content_type (id, name, tag) VALUES (1, 'Películas','content.type.movies');
INSERT INTO content_type (id, name, tag) VALUES (2, 'Series','content.type.series');
INSERT INTO content_type (id, name, tag) VALUES (3, 'Documentales','content.type.docs');

INSERT INTO features(id, name, tag) VALUES (1, 'Películas anteriores a 2000', 'content.feature.film.before');
INSERT INTO features(id, name, tag) VALUES (2, 'Películas posteriores a 2000', 'content.feature.film.after');
INSERT INTO features(id, name, tag) VALUES (3, 'Series', 'content.feature.series');
INSERT INTO features(id, name, tag) VALUES (4, 'Documentales', 'content.feature.docs');

INSERT INTO plans (id, name, description, price, duration) VALUES (1, 'Freemium', 'No pagues nada y disfruta de los grándes clásicos totalmente gratis y sin compromiso', 0, 0);
INSERT INTO plans (id, name, description, price, duration) VALUES (2, 'Basic', 'Cualquier película a tu disposición sin límite. Podrás cancelar cuando quieras.', 5.99, 12);
INSERT INTO plans (id, name, description, price, duration) VALUES (3, 'Gold', 'Todas las películas, series y documentales sin límite y sin compromiso de permanencia al mejor precio', 9.99, 12);

INSERT INTO plans_features (plan_id, feature_id) VALUES (1, 1);
INSERT INTO plans_features (plan_id, feature_id) VALUES (2, 1);
INSERT INTO plans_features (plan_id, feature_id) VALUES (2, 2);
INSERT INTO plans_features (plan_id, feature_id) VALUES (3, 1);
INSERT INTO plans_features (plan_id, feature_id) VALUES (3, 2);
INSERT INTO plans_features (plan_id, feature_id) VALUES (3, 3);
INSERT INTO plans_features (plan_id, feature_id) VALUES (3, 4);

INSERT INTO subscriptions (id, user_id, plan_id, start, finish) VALUES (1, 3, 3, '2023-10-26 00:00:00', '2024-10-26 00:00:00'); -- id=1

INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (1, 1, 1, 'Pulp Fiction', 1994, 'Productora 1', 'https://pics.filmaffinity.com/pulp_fiction-210382116-large.jpg', 'https://www.youtube.com/embed/bokzC0iRXoQ?si=FhFtpKqb0c7-7Xle', '2023-09-15 00:00:00'); -- id=1
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (2, 1, 2, 'El lobo de Wall Street', 2013, 'Productora 2', 'https://pics.filmaffinity.com/the_wolf_of_wall_street-675195906-large.jpg', 'https://www.youtube.com/embed/9XYwNiNh0sY?si=X3MuUO4gogjlulu-', '2023-09-30 00:00:00'); -- id=2
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (3, 1, 2, 'El señor de los anillos: La comunidad del anillo', 2001, 'Productora 3', 'https://pics.filmaffinity.com/the_lord_of_the_rings_the_fellowship_of_the_ring-952398002-large.jpg', 'https://www.youtube.com/embed/UXgbHdnoJrg?si=OqtxPe8VqTqrwoqo', '2023-10-15 00:00:00'); -- id=3
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (4, 1, 2, 'Snatch. Cerdos y diamantes', 2000, 'Productora 4', 'https://pics.filmaffinity.com/snatch-921179475-large.jpg', 'https://www.youtube.com/embed/fjcIu1bsCdE?si=09Juk5v07HGfkKIg', '2023-10-30 00:00:00'); -- id=4
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (5, 1, 2, 'Érase una vez en... Hollywood', 2019, 'Productora 3', 'https://pics.filmaffinity.com/once_upon_a_time_in_hollywood-735160977-large.jpg', 'https://www.youtube.com/embed/a0bXU8g75Io?si=J3Deazm2w2jeuIND', '2023-11-15 00:00:00'); -- id=5
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (6, 1, 1, 'Abierto hasta el amanecer', 1996, 'Productora 2', 'https://pics.filmaffinity.com/from_dusk_till_dawn-128126387-large.jpg', 'https://www.youtube.com/embed/HqdPnj-qLcY?si=ufM55JIvUUClydP-', '2023-11-30 00:00:00'); -- id=6
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (7, 1, 1, 'El gran Lebowsky', 1998, 'Productora 1', 'https://pics.filmaffinity.com/the_big_lebowski-877217211-large.jpg', 'https://www.youtube.com/embed/hjwCTOD3zvY?si=zLJlpuRiCd1fE6m6', '2023-12-15 00:00:00'); -- id=7
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (8, 2, 3, 'La casa de papel', 2017, 'Productora 2', 'https://pics.filmaffinity.com/la_casa_de_papel-169273913-large.jpg', 'https://www.youtube.com/embed/2st4vR0ciV8?si=T-_H79O_KDSVj2B4', '2023-12-30 00:00:00'); -- id=8
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (9, 2, 3, 'Breaking bad', 2008, 'Productora 3', 'https://pics.filmaffinity.com/breaking_bad-504442815-large.jpg', 'https://www.youtube.com/embed/NWEHZh8Z0Lg?si=-cLNnXkYjRr3jWnF', '2024-01-15 00:00:00'); -- id=9
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (10, 1, 2, 'Gru, mi villano favorito', 2010, 'Productora 4', 'https://pics.filmaffinity.com/despicable_me-886797392-large.jpg', 'https://www.youtube.com/embed/b1EI6DB-9LQ?si=k7Ouf3cR2wIR3o3E', '2024-01-30 00:00:00'); -- id=10
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (11, 2, 3, 'Juego de tronos', 2011, 'Productora 3', 'https://pics.filmaffinity.com/game_of_thrones-293142110-large.jpg', 'https://www.youtube.com/embed/beG07Q917rU?si=lozK4uusCIPyAaWB', '2024-02-15 00:00:00'); -- id=11
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (12, 2, 3, 'Perdidos', 2004, 'Productora 2', 'https://pics.filmaffinity.com/lost-924104956-large.jpg', 'https://www.youtube.com/embed/cR2RdsmqD_g?si=LLb2noKrjDPE4wqU', '2024-03-15 00:00:00'); -- id=12
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (13, 2, 3, 'Los Simpson', 1989, 'Productora 1', 'https://pics.filmaffinity.com/the_simpsons-397676780-large.jpg', 'https://www.youtube.com/embed/uWWEXcasU1U?si=n6voh8GEzxsATSiZ', '2024-03-31 00:00:00'); -- id=13
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (14, 2, 3, 'Friends', 2004, 'Productora 2', 'https://pics.filmaffinity.com/friends-344732706-large.jpg', 'https://www.youtube.com/embed/a8mgLuqUae4?si=bNb_M0mWLZp5qdB', '2024-04-15 00:00:00'); -- id=14
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (15, 2, 3, 'Stranger Things', 2016, 'Productora 3', 'https://pics.filmaffinity.com/stranger_things-875025085-large.jpg', 'https://www.youtube.com/embed/yjmDBKyemUw?si=qbTALUxijQrsv0Zr', '2024-04-20 00:00:00'); -- id=15
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (16, 2, 3, 'Black Mirror', 2011, 'Productora 4', 'https://pics.filmaffinity.com/black_mirror-872421892-large.jpg', 'https://www.youtube.com/embed/-2zyoHC8OpY?si=k8V-lDpNtTZNIm_q', '2024-01-20 00:00:00'); -- id=16
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (17, 3, 4, 'Fahrenheit 9/11', 2004, 'Productora 3', 'https://pics.filmaffinity.com/fahrenheit_9_11_fahrenheit_911-834498050-large.jpg', 'https://www.youtube.com/embed/WWHjKzQUWNQ?si=JyPOEsDVxsQImS97', '2024-04-15 03:33:33'); -- id=17
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (18, 3, 4, 'Super Size Me', 2004, 'Productora 2', 'https://pics.filmaffinity.com/super_size_me-712955185-large.jpg', 'https://www.youtube.com/embed/gOS-Uo0jEKQ?si=H2nSZnEZAZKQhGIO', '2024-01-23 00:00:00'); -- id=18
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (19, 3, 4, 'Una verdad incómoda', 2006, 'Productora 1', 'https://pics.filmaffinity.com/an_inconvenient_truth-663901536-large.jpg', 'https://www.youtube.com/embed/Bu6SE5TYrCM?si=L3T5x83GbWb5bZmd', '2024-02-17 00:00:00'); -- id=19
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (20, 3, 4, 'Senna', 2010, 'Productora 2', 'https://pics.filmaffinity.com/senna-725854936-large.jpg', 'https://www.youtube.com/embed/7AksXrB5s1A?si=M1XnQlyJJjexcJgQ', '2024-02-23 00:00:00'); -- id=20
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (21, 3, 4, 'Buena Vista Social Club', 1999, 'Productora 3', 'https://pics.filmaffinity.com/buena_vista_social_club-214606687-large.jpg', 'https://www.youtube.com/embed/qgaja-e__2w?si=gDsBATlz4WAlG4SJ', '2024-03-17 00:00:00'); -- id=21
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (22, 3, 4, 'El mundo en guerra', 1974, 'Productora 4', 'https://pics.filmaffinity.com/the_world_at_war-600960292-large.jpg', 'https://www.youtube.com/embed/0b4g4ZZNC1E?si=QLbN-dgAUbSReSrR', '2024-04-12 00:00:00'); -- id=22
INSERT INTO contents (id, type_id, feature_id, title, premier, production, cover, resource_path, added) VALUES (23, 3, 4, 'Steve Jobs: Visionary Genius', 2012, 'Productora 3', 'https://pics.filmaffinity.com/steve_jobs_visionary_genius-205460209-large.jpg', 'https://www.youtube.com/embed/mGGS32kfGKk?si=oOYuu9CTQaSBb_J6', '2024-04-23 00:00:00'); -- id=23

UPDATE contents set synopsis = 'Jules y Vincent son dos asesinos a sueldo que trabajan para el gángster Marsellus Wallace. Cuando llega la hora de trabajar, ambos deben ponerse "manos a la obra". Su misión: recuperar un misterioso maletín.' where id = 1;
UPDATE contents set synopsis = 'Película basada en hechos reales del corredor de bolsa neoyorquino Jordan Belfort. Dinero. Poder. Mujeres. Drogas. Las tentaciones abundaban y el temor a la ley era irrelevante. Jordan nunca se conformaba con lo que tenía.' where id = 2;
UPDATE contents set synopsis = 'Con la ayuda de sus amigos y de valientes aliados, el joven hobbit Frodo emprende un peligroso viaje con la misión de destruir el Anillo Único. Pero el malvado Sauron ordena la persecución del grupo.' where id = 3;
UPDATE contents set synopsis = 'Franky es un ladrón de diamantes que tiene que entregar un valioso ejemplar a su jefe, pero, antes de hacerlo, se deja convencer para apostar en un combate ilegal de boxeo. En realidad, se trata de una trampa para arrebatarle el diamante.' where id = 4;
UPDATE contents set synopsis = 'Hollywood, años 60. La estrella de un western televisivo, Rick Dalton, intenta amoldarse a los cambios del medio al mismo tiempo que su doble. La vida de Dalton está ligada completamente a Hollywood.' where id = 5;
UPDATE contents set synopsis = 'Los hermanos Seth y Richard, dos de los criminales más peligrosos de América, huyen en dirección a Mexico. Después de tomar rehenes y pasar la frontera, todos pasan la noche en un local de carretera.' where id = 6;
UPDATE contents set synopsis = 'El Nota, un vago que vive en Los Angeles, es confundido por unos matones con el millonario Jeff Lebowski, con quien comparte apellido. De su encuentro surgirá un trato: el Nota recibirá una recompensa si encuentra a la mujer del magnate.' where id = 7;
UPDATE contents set synopsis = 'Un misterioso personaje, "El Profesor", planea el mayor de los atracos jamás ideado. Para llevar a cabo el ambicioso plan, recluta a una banda formada por personas con ciertas cualidades y algo en común: no tienen nada que perder.' where id = 8;
UPDATE contents set synopsis = 'Walter White, un profesor de química de Albuquerque se entera de que tiene cáncer de pulmón. La brutal noticia lo impulsa a dar un drástico cambio a su vida: fabricar y vender anfetaminas.' where id = 9;
UPDATE contents set synopsis = 'Gru es un hombre deplorable que planea el acto criminal más increíble de la Historia: robar la Luna. Incitado por una madre malvada, sólo encontrará un obstáculo en su camino: tres niñas huérfanas a las que tendá que cuidar temporalmente.' where id = 10;
UPDATE contents set synopsis = 'La historis se desarrolla en un mundo ficticio de carácter medieval donde hay Siete Reinos. Diversas facciones conspiran con un solo objetivo: apoderarse del Trono de Hierro.' where id = 11;
UPDATE contents set synopsis = 'Un grupo de supervivientes de un accidente de aviación en una remota isla del Pacífico mostrarán lo mejor y lo peor de sí mismos. En la isla, aparentemente desierta, suceden cosas muy extrañas.' where id = 12;
UPDATE contents set synopsis = 'Serie que narra la historia de una peculiar familia (id, Homer, Marge, Bart, Maggie y Lisa Simpson) y otros divertidos personajes de la localidad norteamericana de Springfield.' where id = 13;
UPDATE contents set synopsis = 'Serie que narra las aventuras de una pandilla de amigos que viven en Manhattan y que suelen reunirse en sus apartamentos o en su bar habitual, el Central Perk.' where id = 14;
UPDATE contents set synopsis = 'Homenaje a los clásicos misterios sobrenaturales de los años 80. Narra la historia de un niño que desaparece en un pequeño pueblo sin dejar rastro. En su búsqueda desesperada, amigos y familiares se ven envueltos en un asombroso enigma.' where id = 15;
UPDATE contents set synopsis = 'Serie antológica que muestra el lado oscuro de la tecnología y cómo ésta afecta y puede alterar nuestra vida, a veces con consecuencias tan impredecibles como aterradoras.' where id = 16;
UPDATE contents set synopsis = '"Fahrenheit 9/11" toma como punto de partida la controvertida elección de George W. Bush en el año 2000 como presidente de los Estados Unidos y describir las oscuras relaciones económicas entre su padre y la familia de Osama Bin Laden' where id = 17;
UPDATE contents set synopsis = 'Documental en el que Morgan Spurlock investiga en su propio cuerpo los efectos de la comida basura, comiendo únicamente en McDonalds 3 veces al día durante un mes y acudiendo posteriormente al médico: los resultados fueron sorprendentes.' where id = 18;
UPDATE contents set synopsis = 'Documental sobre los efectos devastadores del cambio climático.' where id = 19;
UPDATE contents set synopsis = 'Documental que recorre la vida del legendario piloto brasileño Ayrton Senna (id, 1960-1994), desde la temporada de su debut en 1984 hasta su prematura muerte una década después en el Gran Premio de San Marino.' where id = 20;
UPDATE contents set synopsis = 'Cuando Ry Cooder viajó a Cuba para grabar un álbum con Ibrahim Ferrer y los músicos que habían colaborado en el disco Buena Vista Social Club, Wenders lo siguió: observó a los músicos en el estudio y rastreó sus vidas en La Habana.' where id = 21;
UPDATE contents set synopsis = 'Considerada como la mejor serie documental de la II Guerra Mundial. Contiene entrevistas a multitud de testigos y protagonistas importantes de los hechos.' where id = 22;
UPDATE contents set synopsis = 'Documental que repasa la carrera y el legado del mítico empresario californiano Steve Jobs. Presenta a un hombre muy curioso y determinado.' where id = 23;

INSERT INTO contents_actors (content_id, actor_id) VALUES (1, 1);
INSERT INTO contents_actors (content_id, actor_id) VALUES (1, 2);
INSERT INTO contents_actors (content_id, actor_id) VALUES (1, 3);
INSERT INTO contents_actors (content_id, actor_id) VALUES (1, 14);
INSERT INTO contents_actors (content_id, actor_id) VALUES (2, 4);
INSERT INTO contents_actors (content_id, actor_id) VALUES (2, 5);
INSERT INTO contents_actors (content_id, actor_id) VALUES (3, 6);
INSERT INTO contents_actors (content_id, actor_id) VALUES (3, 7);
INSERT INTO contents_actors (content_id, actor_id) VALUES (4, 8);
INSERT INTO contents_actors (content_id, actor_id) VALUES (4, 9);
INSERT INTO contents_actors (content_id, actor_id) VALUES (5, 4);
INSERT INTO contents_actors (content_id, actor_id) VALUES (5, 5);
INSERT INTO contents_actors (content_id, actor_id) VALUES (5, 9);
INSERT INTO contents_actors (content_id, actor_id) VALUES (6, 10);
INSERT INTO contents_actors (content_id, actor_id) VALUES (6, 11);
INSERT INTO contents_actors (content_id, actor_id) VALUES (6, 14);
INSERT INTO contents_actors (content_id, actor_id) VALUES (7, 12);
INSERT INTO contents_actors (content_id, actor_id) VALUES (7, 13);
INSERT INTO contents_actors (content_id, actor_id) VALUES (8, 15);
INSERT INTO contents_actors (content_id, actor_id) VALUES (8, 16);
INSERT INTO contents_actors (content_id, actor_id) VALUES (8, 17);
INSERT INTO contents_actors (content_id, actor_id) VALUES (9, 18);
INSERT INTO contents_actors (content_id, actor_id) VALUES (9, 19);
INSERT INTO contents_actors (content_id, actor_id) VALUES (11, 20);
INSERT INTO contents_actors (content_id, actor_id) VALUES (11, 21);
INSERT INTO contents_actors (content_id, actor_id) VALUES (12, 22);
INSERT INTO contents_actors (content_id, actor_id) VALUES (12, 23);
INSERT INTO contents_actors (content_id, actor_id) VALUES (14, 24);
INSERT INTO contents_actors (content_id, actor_id) VALUES (14, 25);
INSERT INTO contents_actors (content_id, actor_id) VALUES (15, 26);
INSERT INTO contents_actors (content_id, actor_id) VALUES (15, 27);
INSERT INTO contents_actors (content_id, actor_id) VALUES (16, 28);
INSERT INTO contents_actors (content_id, actor_id) VALUES (16, 29);

INSERT INTO contents_directors (content_id, director_id) VALUES (1, 1);
INSERT INTO contents_directors (content_id, director_id) VALUES (2, 2);
INSERT INTO contents_directors (content_id, director_id) VALUES (3, 3);
INSERT INTO contents_directors (content_id, director_id) VALUES (4, 4);
INSERT INTO contents_directors (content_id, director_id) VALUES (5, 1);
INSERT INTO contents_directors (content_id, director_id) VALUES (6, 1);
INSERT INTO contents_directors (content_id, director_id) VALUES (6, 5);
INSERT INTO contents_directors (content_id, director_id) VALUES (7, 6);
INSERT INTO contents_directors (content_id, director_id) VALUES (8, 7);
INSERT INTO contents_directors (content_id, director_id) VALUES (9, 8);
INSERT INTO contents_directors (content_id, director_id) VALUES (10, 9);
INSERT INTO contents_directors (content_id, director_id) VALUES (11, 10);
INSERT INTO contents_directors (content_id, director_id) VALUES (12, 11);
INSERT INTO contents_directors (content_id, director_id) VALUES (13, 12);
INSERT INTO contents_directors (content_id, director_id) VALUES (14, 13);
INSERT INTO contents_directors (content_id, director_id) VALUES (14, 14);
INSERT INTO contents_directors (content_id, director_id) VALUES (15, 15);
INSERT INTO contents_directors (content_id, director_id) VALUES (16, 16);
INSERT INTO contents_directors (content_id, director_id) VALUES (17, 17);
INSERT INTO contents_directors (content_id, director_id) VALUES (18, 18);
INSERT INTO contents_directors (content_id, director_id) VALUES (19, 19);
INSERT INTO contents_directors (content_id, director_id) VALUES (20, 20);
INSERT INTO contents_directors (content_id, director_id) VALUES (21, 21);
INSERT INTO contents_directors (content_id, director_id) VALUES (22, 22);
INSERT INTO contents_directors (content_id, director_id) VALUES (23, 23);

INSERT INTO contents_genres (content_id, genre_id) VALUES (1, 2);
INSERT INTO contents_genres (content_id, genre_id) VALUES (1, 10);
INSERT INTO contents_genres (content_id, genre_id) VALUES (2, 5);
INSERT INTO contents_genres (content_id, genre_id) VALUES (2, 7);
INSERT INTO contents_genres (content_id, genre_id) VALUES (2, 8);
INSERT INTO contents_genres (content_id, genre_id) VALUES (3, 1);
INSERT INTO contents_genres (content_id, genre_id) VALUES (3, 6);
INSERT INTO contents_genres (content_id, genre_id) VALUES (3, 9);
INSERT INTO contents_genres (content_id, genre_id) VALUES (4, 5);
INSERT INTO contents_genres (content_id, genre_id) VALUES (4, 10);
INSERT INTO contents_genres (content_id, genre_id) VALUES (5, 2);
INSERT INTO contents_genres (content_id, genre_id) VALUES (5, 5);
INSERT INTO contents_genres (content_id, genre_id) VALUES (5, 7);
INSERT INTO contents_genres (content_id, genre_id) VALUES (6, 1);
INSERT INTO contents_genres (content_id, genre_id) VALUES (6, 2);
INSERT INTO contents_genres (content_id, genre_id) VALUES (6, 4);
INSERT INTO contents_genres (content_id, genre_id) VALUES (6, 9);
INSERT INTO contents_genres (content_id, genre_id) VALUES (7, 5);
INSERT INTO contents_genres (content_id, genre_id) VALUES (8, 1);
INSERT INTO contents_genres (content_id, genre_id) VALUES (8, 2);
INSERT INTO contents_genres (content_id, genre_id) VALUES (8, 10);
INSERT INTO contents_genres (content_id, genre_id) VALUES (9, 2);
INSERT INTO contents_genres (content_id, genre_id) VALUES (9, 7);
INSERT INTO contents_genres (content_id, genre_id) VALUES (9, 10);
INSERT INTO contents_genres (content_id, genre_id) VALUES (10, 5);
INSERT INTO contents_genres (content_id, genre_id) VALUES (10, 6);
INSERT INTO contents_genres (content_id, genre_id) VALUES (10, 11);
INSERT INTO contents_genres (content_id, genre_id) VALUES (11, 1);
INSERT INTO contents_genres (content_id, genre_id) VALUES (11, 6);
INSERT INTO contents_genres (content_id, genre_id) VALUES (11, 7);
INSERT INTO contents_genres (content_id, genre_id) VALUES (11, 9);
INSERT INTO contents_genres (content_id, genre_id) VALUES (12, 3);
INSERT INTO contents_genres (content_id, genre_id) VALUES (12, 6);
INSERT INTO contents_genres (content_id, genre_id) VALUES (12, 7);
INSERT INTO contents_genres (content_id, genre_id) VALUES (12, 9);
INSERT INTO contents_genres (content_id, genre_id) VALUES (13, 5);
INSERT INTO contents_genres (content_id, genre_id) VALUES (13, 11);
INSERT INTO contents_genres (content_id, genre_id) VALUES (14, 5);
INSERT INTO contents_genres (content_id, genre_id) VALUES (15, 2);
INSERT INTO contents_genres (content_id, genre_id) VALUES (15, 3);
INSERT INTO contents_genres (content_id, genre_id) VALUES (15, 7);
INSERT INTO contents_genres (content_id, genre_id) VALUES (15, 9);
INSERT INTO contents_genres (content_id, genre_id) VALUES (16, 2);
INSERT INTO contents_genres (content_id, genre_id) VALUES (16, 7);
INSERT INTO contents_genres (content_id, genre_id) VALUES (16, 9);
INSERT INTO contents_genres (content_id, genre_id) VALUES (17, 15);
INSERT INTO contents_genres (content_id, genre_id) VALUES (18, 16);
INSERT INTO contents_genres (content_id, genre_id) VALUES (19, 17);
INSERT INTO contents_genres (content_id, genre_id) VALUES (20, 8);
INSERT INTO contents_genres (content_id, genre_id) VALUES (21, 18);
INSERT INTO contents_genres (content_id, genre_id) VALUES (22, 14);
INSERT INTO contents_genres (content_id, genre_id) VALUES (22, 19);
INSERT INTO contents_genres (content_id, genre_id) VALUES (23, 8);
INSERT INTO contents_genres (content_id, genre_id) VALUES (23, 13);

INSERT INTO ratings (content_id, user_id, rating, rating_date) VALUES (1, 3, 2, '2023-10-27 03:33:33');
INSERT INTO ratings (content_id, user_id, rating, rating_date) VALUES (5, 3, 1, '2023-10-28 05:55:55');
INSERT INTO ratings (content_id, user_id, rating, rating_date) VALUES (6, 3, 3, '2023-10-29 01:23:45');
INSERT INTO ratings (content_id, user_id, rating, rating_date) VALUES (10, 3, 3, '2023-10-30 05:43:21');
INSERT INTO ratings (content_id, user_id, rating, rating_date) VALUES (12, 3, 2, '2023-10-31 22:22:22');

INSERT INTO play_lists (content_id, user_id, added_date) VALUES (1, 3, '2023-10-27 04:33:33');
INSERT INTO play_lists (content_id, user_id, added_date) VALUES (5, 3, '2023-10-28 06:55:55');
INSERT INTO play_lists (content_id, user_id, added_date) VALUES (6, 3, '2023-10-29 02:23:45');
INSERT INTO play_lists (content_id, user_id, added_date) VALUES (12, 3, '2023-10-31 23:22:22');

INSERT INTO history (id, content_id, user_id, view_date) VALUES (1, 1, 3, '2023-10-27 04:33:33');
INSERT INTO history (id, content_id, user_id, view_date) VALUES (2, 5, 3, '2023-10-28 06:55:55');
INSERT INTO history (id, content_id, user_id, view_date) VALUES (3, 6, 3, '2023-10-29 02:23:45');
INSERT INTO history (id, content_id, user_id, view_date) VALUES (4, 10, 3, '2023-10-30 06:43:21');
INSERT INTO history (id, content_id, user_id, view_date) VALUES (5, 12, 3, '2023-10-31 23:22:22');
INSERT INTO history (id, content_id, user_id, view_date) VALUES (6, 2, 3, '2024-04-15 12:00:00');
INSERT INTO history (id, content_id, user_id, view_date) VALUES (7, 2, 3, '2024-04-15 13:00:00');
INSERT INTO history (id, content_id, user_id, view_date) VALUES (8, 2, 3, '2024-04-15 14:00:00');
INSERT INTO history (id, content_id, user_id, view_date) VALUES (9, 2, 3, '2024-04-15 15:00:00');