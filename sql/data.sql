CREATE DATABASE datameuble;

CREATE TABLE categorie(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL
);

insert into categorie values(default,'canape');
insert into categorie values(default,'lit');
insert into categorie values(default,'chaise');

CREATE TABLE matiere(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL
);

insert into matiere values(default,'tissu');
insert into matiere values(default,'perle');
insert into matiere values(default,'chaines');

CREATE TABLE style(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL
);

insert into style values(default,'moderne');
insert into style values(default,'contemporain');
insert into style values(default,'ancien');

CREATE TABLE taille(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    unite INTEGER NOT NULL
);

insert into taille values(default,'small',0);
insert into taille values(default,'medium',0);
insert into taille values(default,'large',0);

CREATE TABLE meuble(
    id SERIAL PRIMARY KEY,
    id_style INTEGER NOT NULL,
    id_categorie INTEGER NOT NULL,
    id_taille INTEGER NOT NULL,
    prix_vente DECIMAL(10,2) NOT NULL, -- pourcentage ito fa tsy tode lay prix [PV = PR+ ((PR*pourcentage)/100)]
    FOREIGN KEY(id_categorie) REFERENCES categorie(id),
    FOREIGN KEY(id_style) REFERENCES style(id),
    FOREIGN KEY(id_taille) REFERENCES taille(id)
); 


CREATE TABLE matiere_style(
    id SERIAL PRIMARY KEY,
    id_matiere INTEGER NOT NULL,
    id_style INTEGER NOT NULL,
    FOREIGN KEY(id_matiere) REFERENCES matiere(id),
    FOREIGN KEY(id_style) REFERENCES style(id)
);

CREATE TABLE ville(
    id_ville serial primary key,
    nom VARCHAR(20)
);

INSERT INTO ville VALUES(default,'Antananarivo');

CREATE TABLE region(
    id_region serial primary key,
    nom VARCHAR(20)
);
INSERT INTO region VALUES(default,'Analamanga');
INSERT INTO region VALUES(default,'Bongolava');

CREATE TABLE fournisseur(
    id serial primary key,
    nom VARCHAR(50),
    id_region integer,
    id_ville integer,

    FOREIGN KEY (id_ville) REFERENCES ville(id_ville),
    FOREIGN KEY (id_region) REFERENCES region(id_region)
);

INSERT INTO fournisseur VALUES(default,'Fournisseur 1',1,1);
INSERT INTO fournisseur VALUES(default,'Fournisseur 2',2,1);

CREATE TABLE prix_matiere(
    id SERIAL PRIMARY KEY,
    id_matiere INTEGER NOT NULL,
    id_fournisseur INTEGER NOT NULL,
    prix DECIMAL(10,2) NOT NULL,
    date_prix timestamp,
    FOREIGN KEY(id_matiere) REFERENCES matiere(id),
    FOREIGN KEY (id_fournisseur) REFERENCES fournisseur(id)
);

INSERT INTO prix_matiere VALUES(default,1,1,1500,CURRENT_TIMESTAMP);
INSERT INTO prix_matiere VALUES(default,2,1,1700,CURRENT_TIMESTAMP);
INSERT INTO prix_matiere VALUES(default,3,1,1900,CURRENT_TIMESTAMP);





-- formule, ito lay table fabrication taloha iny
CREATE TABLE meuble_matiere(
    id SERIAL PRIMARY KEY,
    id_meuble INTEGER NOT NULL,
    id_matiere INTEGER NOT NULL,
    quantite DECIMAL(10,2) NOT NULL,
    FOREIGN KEY(id_matiere) REFERENCES taille(id),
    FOREIGN KEY(id_meuble) REFERENCES meuble(id)
);


CREATE TABLE meuble_ouvriers(
    id serial primary key,
    id_meuble INTEGER NOT NULL,
    id_employe INTEGER NOT NULL,

    FOREIGN KEY (id_meuble) REFERENCES meuble(id),
    FOREIGN KEY (id_employe) REFERENCES employe(id)
);

CREATE TABLE taille_nombre(
    id serial primary key,
    id_taille INTEGER NOT NULL,
    nombre DECIMAL(10,2) NOT NULL
);

insert into taille_nombre VALUES(default,1,2);
insert into taille_nombre VALUES(default,2,4);
insert into taille_nombre VALUES(default,3,8);

CREATE TABLE duree_style(
    id serial primary key,
    id_style INTEGER NOT NULL,
    duree DECIMAL(10,2) NOT NULL
);

insert into duree_style VALUES(default,1,2);
insert into duree_style VALUES(default,2,4);
insert into duree_style VALUES(default,3,8);
insert into duree_style VALUES(default,4,3);


--manomboka eto ny resaka stock
CREATE TABLE stock_materiel(
    id serial primary key,
    id_matiere INTEGER NOT NULL,
    entree DECIMAL(10,2) NOT NULL,
    sortie DECIMAL(10,2) NOT NULL,
    date_stock timestamp,

    FOREIGN KEY (id_matiere) REFERENCES matiere(id)

);

CREATE TABLE stock_meuble(
    id serial primary key,
    id_meuble INTEGER NOT NULL,
    entree DECIMAL(10,2) NOT NULL,
    sortie DECIMAL(10,2) NOT NULL,
    date_stock timestamp,

    FOREIGN KEY (id_meuble) REFERENCES meuble(id)
);


CREATE or REPLACE VIEW v_matiere_style as
SELECT s.nom as nom_style, m.nom as nom_matiere,s.id as id_style
FROM matiere_style ms
JOIN style s ON ms.id_style = s.id
JOIN matiere m ON ms.id_matiere = m.id;

CREATE or REPLACE VIEW v_meuble as
SELECT s.nom as nom_style, c.nom as nom_categorie,t.nom as nom_taille,m.id as id_meuble,m.prix_vente
FROM meuble m
JOIN style s ON m.id_style = s.id
JOIN categorie c ON m.id_categorie = c.id
JOIN taille t ON m.id_taille = t.id;

CREATE or REPLACE VIEW v_meuble_matiere as
SELECT vm.nom_style ,vm.nom_categorie,m.nom as nom_matiere,vm.nom_taille,mm.id_matiere,mm.quantite,vm.id_meuble
FROM meuble_matiere mm
JOIN v_meuble vm ON mm.id_meuble = vm.id_meuble
JOIN matiere m ON mm.id_matiere = m.id;

CREATE or REPLACE VIEW v_ouvrier as
SELECT o.nom as nom_ouvrier,t.nom as nom_type,t.salaire,o.id_ouvrier
FROM ouvrier o
JOIN type_ouvrier t ON o.id_type = t.id;

CREATE or REPLACE VIEW v_prix_matiere as
SELECT pm.prix as prix_matiere,pm.date_prix,pm.id_fournisseur,pm.id_matiere,m.nom as nom_matiere,f.nom as nom_fournisseur
FROM prix_matiere pm
JOIN fournisseur f ON pm.id_fournisseur = f.id
JOIN matiere m ON pm.id_matiere = m.id;

CREATE or REPLACE VIEW v_prix_meuble as
select sum((quantite*pm.prix_unitaire)) as prix_total,id_meuble from meuble_matiere mm 
join (select min(prix) as prix_unitaire,id_matiere from prix_matiere where id_fournisseur = 1 group by id_matiere) as pm
on mm.id_matiere = pm.id_matiere 
group by id_meuble;

CREATE or REPLACE VIEW v_info_meuble as
SELECT vm.id_meuble,vm.nom_categorie,vm.nom_style,vm.nom_taille,vpm.prix_total
FROM v_prix_meuble vpm
JOIN v_meuble vm ON vpm.id_meuble = vm.id_meuble;



-- requete
-- prix total d'un meuble
select sum((quantite*pm.prix_unitaire)) as prix_total,id_meuble from meuble_matiere mm 
join (select min(prix) as prix_unitaire,id_matiere from prix_matiere where id_fournisseur = 1 group by id_matiere) as pm
on mm.id_matiere = pm.id_matiere 
where id_meuble = 2
group by id_meuble;

-- prix de tous les meubles
select sum((quantite*pm.prix_unitaire)) as prix_total,id_meuble from meuble_matiere mm 
join (select min(prix) as prix_unitaire,id_matiere from prix_matiere where id_fournisseur = 1 group by id_matiere) as pm
on mm.id_matiere = pm.id_matiere 
group by id_meuble;

--etat stock quantite matiere
SELECT SUM(entree) - SUM(sortie) AS quantite_actuelle 
FROM stock_materiel
WHERE id_matiere = 1;

--etat stock quantite meuble
SELECT SUM(entree) - SUM(sortie) AS quantite_actuelle 
FROM stock_meuble
WHERE id_meuble = 1;


--etat stock actuel matiere
CREATE or REPLACE VIEW  v_stock_matiere as(
SELECT mat.nom,quantite_actuelle FROM (
        SELECT SUM(entree) - SUM(sortie) AS quantite_actuelle ,m.id
        FROM stock_materiel sm
        JOIN matiere m ON sm.id_matiere = m.id
        group by m.id
        ) as stock_mat 
    JOIN matiere mat
    ON stock_mat.id = mat.id
);

--etat stock actuel meuble
CREATE or REPLACE VIEW v_stock_meuble as(
        SELECT nom_categorie,nom_style,nom_taille,quantite_actuelle FROM(
        SELECT SUM(entree) - SUM(sortie) AS quantite_actuelle,m.id
        FROM stock_meuble sm
        JOIN meuble m ON sm.id_meuble = m.id
        group by m.id
        ) as stock_meub
    JOIN v_meuble vm
    ON stock_meub.id = vm.id_meuble
);










