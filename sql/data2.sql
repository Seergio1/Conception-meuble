CREATE TABLE poste(
    id serial primary key,
    nom VARCHAR(50),
    salaireBase DECIMAL(10,2)
);
insert into poste values(default,'polisseur',3500);
insert into poste values(default,'vernisseur',5000);

CREATE TABLE employe(
    id serial primary key,
    nom VARCHAR(100),
    annee_exp DECIMAL(10,2) NOT NULL
);


CREATE TABLE profil(
    id serial primary key,
    nom VARCHAR(50)
);
insert into profil values(default,'ouvrier');
insert into profil values(default,'senior');
insert into profil values(default,'expert');

drop table profil_duree;
CREATE TABLE profil_duree(
    id serial primary key,
    id_profil integer NOT NULL,
    experience DECIMAL(10,2) NOT NULL,
    coeff DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_profil) REFERENCES profil(id)
);
insert into profil_duree values(default,1,2,1);
insert into profil_duree values(default,2,3,2);
insert into profil_duree values(default,3,5,3);


CREATE TABLE employe_embauche(
    id serial primary key,
    id_profil integer NOT NULL,
    id_employe integer NOT NULL,
    id_poste integer NOT NULL,
    date_embauche timestamp,
    FOREIGN KEY (id_profil) REFERENCES profil(id),
    FOREIGN KEY (id_employe) REFERENCES employe(id),
    FOREIGN KEY (id_poste) REFERENCES poste(id)
);


insert into employe values (default,'Sergio',0);
insert into employe_embauche VALUES(default,1,2,1,2022-01-28);
insert into employe values (default,'Carolia',4);
insert into employe_embauche VALUES(default,3,3,1,CURRENT_TIMESTAMP);
insert into employe values (default,'deathGio',6);
insert into employe_embauche VALUES(default,3,4,2,'2022-01-28');




-- question 5
CREATE TABLE genre(
    id serial primary key,
    nom VARCHAR(50)
);

CREATE TABLE client(
    id serial primary key,
    nom VARCHAR(100),
    id_genre integer NOT NULL,
    FOREIGN KEY(id_genre) REFERENCES genre(id)
);

CREATE TABLE vente(
    id serial primary key,
    id_client integer NOT NULL,
    nombre integer not NULL,
    id_meuble integer not NULL,
    FOREIGN KEY(id_client) REFERENCES client(id),
    FOREIGN KEY(id_meuble) REFERENCES meuble(id)
);


-- Insertion des genres
INSERT INTO genre (nom) VALUES ('homme'), ('femme');

-- Insertion des clients
INSERT INTO client (nom, id_genre) VALUES ('Client1', 1), ('Client2', 2);

-- Insertion des ventes
INSERT INTO vente (id_client, nombre, id_meuble) VALUES (1, 2, 1), (2, 3, 2);


-- stat par un meuble
SELECT
    c.nom AS nom_categorie,
    s.nom AS nom_style,
    t.nom AS nom_taille,
    g.nom AS genre,
    SUM(CASE WHEN g.nom = 'homme' THEN v.nombre ELSE 0 END) AS ventes_homme,
    SUM(CASE WHEN g.nom = 'femme' THEN v.nombre ELSE 0 END) AS ventes_femme
FROM
    vente v
JOIN
    client cl ON v.id_client = cl.id
JOIN
    genre g ON cl.id_genre = g.id
JOIN
    meuble m ON v.id_meuble = m.id
JOIN
    categorie c ON m.id_categorie = c.id
JOIN
    style s ON m.id_style = s.id
JOIN
    taille t ON m.id_taille = t.id
WHERE
    m.id = 1 
GROUP BY
 c.nom, s.nom, t.nom, g.nom;



-- select pour tous les meubles
CREATE or REPLACE VIEW stat_all_meuble as(
    SELECT
    c.nom AS nom_categorie,
    s.nom AS nom_style,
    t.nom AS nom_taille,
    g.nom AS genre,
    SUM(CASE WHEN g.nom = 'homme' THEN v.nombre ELSE 0 END) AS ventes_homme,
    SUM(CASE WHEN g.nom = 'femme' THEN v.nombre ELSE 0 END) AS ventes_femme
FROM
    vente v
JOIN
    client cl ON v.id_client = cl.id
JOIN
    genre g ON cl.id_genre = g.id
JOIN
    meuble m ON v.id_meuble = m.id
JOIN
    categorie c ON m.id_categorie = c.id
JOIN
    style s ON m.id_style = s.id
JOIN
    taille t ON m.id_taille = t.id
GROUP BY
    c.nom, s.nom, t.nom, g.nom
);



CREATE or REPLACE VIEW v_profil_duree as(
    select * from profil_duree where id in (select max(id) from profil_duree group by id_profil)
);







-- pour voir l'etat de l'employé
CREATE or REPLACE VIEW v_info_employe as
(
    SELECT
    e.nom AS employe_nom,
    p.nom AS profil_nom,
    poste.nom AS nom_poste,
    ee.date_embauche AS date_embauche,
    poste.salaireBase * pd.coeff AS salaire_employe,
    e.annee_exp as annee_exp
FROM
    employe e
JOIN
    employe_embauche ee ON e.id = ee.id_employe
JOIN
    profil p ON ee.id_profil = p.id
JOIN
    v_profil_duree pd ON p.id = pd.id_profil
JOIN
    poste ON ee.id_poste = poste.id
WHERE
    e.annee_exp >= 0 -- Tous les employés, peu importe l'expérience
ORDER BY
    e.nom
);

CREATE or REPLACE VIEW v_info_employe_with_idemp as
(
    SELECT
    e.nom AS employe_nom,
    p.nom AS profil_nom,
    poste.nom AS nom_poste,
    ee.date_embauche AS date_embauche,
    poste.salaireBase * pd.coeff AS salaire_employe,
    e.annee_exp as annee_exp,
    e.id as id_employe
FROM
    employe e
JOIN
    employe_embauche ee ON e.id = ee.id_employe
JOIN
    profil p ON ee.id_profil = p.id
JOIN
    v_profil_duree pd ON p.id = pd.id_profil
JOIN
    poste ON ee.id_poste = poste.id
WHERE
    e.annee_exp >= 0 -- Tous les employés, peu importe l'expérience
ORDER BY
    e.nom
);

-- requete pour avoir le profil par rapport à lexperience
SELECT
  CASE
    WHEN :experience_input >= 0 AND :experience_input < (SELECT experience FROM profil_duree WHERE id_profil = 1) THEN 1 -- Id du profil "ouvrier"
    WHEN :experience_input >= (SELECT experience FROM profil_duree WHERE id_profil = 1) AND :experience_input < (SELECT experience FROM profil_duree WHERE id_profil = 2) THEN 2 -- Id du profil "senior"
    WHEN :experience_input >= (SELECT experience FROM profil_duree WHERE id_profil = 2) THEN 3 -- Id du profil "expert"
  END AS idProfil;

  SELECT
  CASE
    WHEN 2 >= 0 AND 2 < (SELECT experience FROM profil_duree WHERE id_profil = 1) THEN 1 -- Id du profil "ouvrier"
    WHEN 2 >= (SELECT experience FROM profil_duree WHERE id_profil = 1) AND 2 < (SELECT experience FROM profil_duree WHERE id_profil = 2) THEN 2 -- Id du profil "senior"
    WHEN 2 >= (SELECT experience FROM profil_duree WHERE id_profil = 2) THEN 3 -- Id du profil "expert"
  END AS idProfil;





    

>=0 || <2 ouvrier
>=2 || <3 senior 
>=3 expert




