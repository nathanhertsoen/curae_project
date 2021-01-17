INSERT INTO patient VALUES (1, 'Wassim','DJAMAA','H');
INSERT INTO patient VALUES (2, 'Nathan','HERTSOEN','H');
INSERT INTO patient VALUES (3, 'Cyril','PERARD','H');

INSERT INTO docteur VALUES (1, 'Serges','Mcadam','H',1);
INSERT INTO docteur VALUES (2, 'Billy','McGoyer','H',1);
INSERT INTO docteur VALUES (3, 'Johnson','McKalagan','H',2);

INSERT INTO service VALUES (1, 'Chirurgie','Discipline médicale spécialisée dans le traitement des maladies et des traumatismes, qui consiste à pratiquer, manuellement et à l''aide d''instruments, des actes opératoires sur un corps vivant.');
INSERT INTO service VALUES (2, 'Urgence','Prise en charge continue des personnes blessées, malades ou victimes de phénomènes exceptionnels et difficilement prévisibles');
INSERT INTO service VALUES (3, 'Radiologie','Spécialité médicale qui utilise des rayons X ou des ultrasons pour obtenir des images d''une partie du corps ou des organes (radiographie, échographie, scanner, IRM).');

-- FORMAT CONVERSION ACTIVE : "yyyy-MM-dd+1" TO "dd-MM-yyyy"
INSERT INTO hospitalization VALUES (1, 1, 1, 1, '1970-01-02', '2021-01-22');
