DROP TABLE IF EXISTS user_details;

CREATE TABLE user_details (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstName VARCHAR(250) NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  password VARCHAR(250) DEFAULT NULL,
  role VARCHAR(50) DEFAULT NULL
);

insert into user_details ( firstName, lastName, email, password, role)
VALUES
    ('Admin','Admin','admin@admin.admin','$2a$10$iWlExBh7PVV8kle/xuyub.VeZgZkzsNXWZKb8QURrHuI7srH5Wp1O','ADMIN'),
    ('Agent','Agent','agent@agent.agent','$2a$10$iWlExBh7PVV8kle/xuyub.VeZgZkzsNXWZKb8QURrHuI7srH5Wp1O','AGENT'),
    ('Hobey','Paulig','hpaulig2@barnesandnoble.com','74BGZV2','AGENT'),
    ('Rossie','Orviss','rorviss3@homestead.com','LzkrC6','AGENT'),
    ('Farrand','Benoix','fbenoix4@dion.ne.jp','7lzOrkbgZvC','AGENT'),
    ('Gordon','Lingwood','glingwood5@unblog.fr','h2sADL4c','AGENT'),
    ('Genia','Varfolomeev','gvarfolomeev6@blogs.com','MaaY1tG1vAL9','AGENT');

DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstname VARCHAR(250) NOT NULL,
  lastname VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

insert into employees ( firstName, lastName, email)
VALUES
    ('Caren','Foden','cfoden0@sphinn.com'),
    ('Darryl','Veronique','dveronique1@jugem.jp'),
    ('Ulises','Prendiville','uprendiville2@360.cn'),
    ('Julius','Gozzett','jgozzett3@admin.ch'),
    ('Reggis','Lintill','rlintill4@wikia.com'),
    ('Frederich','Lortzing','flortzing5@mapy.cz'),
    ('Verna','Humphrys','vhumphrys6@mashable.com'),
    ('Nickola','Lacroux','nlacroux7@msu.edu'),
    ('Farr','Lissandre','flissandre8@examiner.com'),
    ('Amble','Mohamed','amohamed9@blogspot.com'),
    ('Greggory','Keming','gkeminga@unicef.org'),
    ('Shirlene','Luesley','sluesleyb@census.gov'),
    ('Marthena','Tatershall','mtatershallc@technorati.com'),
    ('Brewer','McKeveney','bmckeveneyd@wsj.com'),
    ('Sherie','Bools','sboolse@ow.ly'),
    ('Derrick','Roz','drozf@tuttocitta.it'),
    ('Dorothea','Toovey','dtooveyg@i2i.jp'),
    ('Teddy','Fesby','tfesbyh@archive.org'),
    ('Ethelin','Stanaway','estanawayi@blogspot.com'),
    ('Aurelia','Allwell','aallwellj@domainmarket.com'),
    ('Inglebert','Parkins','iparkinsk@domainmarket.com'),
    ('Faunie','Ray','frayl@narod.ru'),
    ('Nan','Livzey','nlivzeym@netvibes.com'),
    ('Evonne','Pardi','epardin@studiopress.com'),
    ('Urbano','Ogborne','uogborneo@hugedomains.com'),
    ('Kimble','Ostrich','kostrichp@ezinearticles.com'),
    ('Clyde','Orwin','corwinq@ezinearticles.com'),
    ('Tish','McKerley','tmckerleyr@npr.org'),
    ('Isidore','Daish','idaishs@studiopress.com'),
    ('Reg','Hounsom','rhounsomt@unicef.org'),
    ('Tim','Wogan','twoganu@washingtonpost.com'),
    ('Thalia','Hayth','thaythv@skyrock.com'),
    ('Muffin','Jermin','mjerminw@jugem.jp'),
    ('Samson','Henryson','shenrysonx@photobucket.com'),
    ('Tobe','Quarry','tquarryy@networkadvertising.org'),
    ('Ethelred','Vowden','evowdenz@prweb.com'),
    ('Enrichetta','Rutgers','erutgers10@businessweek.com'),
    ('Astrix','Batrop','abatrop11@nifty.com'),
    ('Shoshanna','Cottrell','scottrell12@360.cn');