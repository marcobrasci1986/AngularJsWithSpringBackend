INSERT INTO Users(id,version,username,password,enabled)VALUES('1',0,'admin', 'admin', true);
INSERT INTO Users(id,version,username,password,enabled)VALUES('2',0,'marco', 'marco', true);
INSERT INTO Roles(id,version,username,authority)VALUES('1',0,'admin', 'ROLE_ADMIN');
INSERT INTO Roles(id,version,username,authority)VALUES('2',0,'admin', 'ROLE_USER');
INSERT INTO Roles(id,version,username,authority)VALUES('3',0,'marco', 'ROLE_USER');

INSERT INTO Employee(id,version,name,age,birthdate)VALUES('1',0,'Marco',28,'2011-11-01 12:32:01');
INSERT INTO Employee(id,version,name,age,birthdate)VALUES('2',0,'John',32,'2011-11-01 12:32:01');
INSERT INTO Employee(id,version,name,age,birthdate)VALUES('3',0,'Mark',14,'2011-11-01 12:32:01');


INSERT INTO Store(id,version,name,street1, street2, city)VALUES('1',0,'KeyMusic Brussel','Kerklaan 23', '1000', 'Brussel');
INSERT INTO Store(id,version,name,street1, street2, city)VALUES('2',0,'KeyMusic Antwerpen','Muziekstraat 15', '2500', 'Antwerpen');
INSERT INTO Store(id,version,name,street1, street2, city)VALUES('3',0,'KeyMusic Gent','Centrumlaan 14', '3650', 'Gent');

INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('1',0,'Lakland Blue', 1500.5, 'BASS', null);
INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('2',0,'Lakland Orange', 1800.2, 'BASS', null);
INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('3',0,'Fender Jass Bass 76', 1300, 'BASS', null);
INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('4',0,'Ibanez', 800, 'BASS', null);
INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('5',0,'Celinder 71', 2300, 'BASS', null);
INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('6',0,'Fender Jazz Bass', 700, 'BASS', null);
INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('7',0,'Squire 1', 250, 'BASS', null);
INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('8',0,'Musicman 1967', 4300, 'BASS', null);
INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('9',0,'Fender p. 1985', 1300, 'BASS', null);
INSERT INTO Product(id,version,name,price,category,imageUrl)VALUES('10',0,'Lakland 1993', 1300, 'BASS', null);


