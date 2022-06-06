/*CREATE OR REPLACE TABLE direccion (direccion VARCHAR(50));*/

/*CREATE DATABASE wikipedia*/
USE wikipedia;
DROP TABLE imagen;
DROP TABLE subtitulo;
DROP TABLE referencia;
DROP TABLE pagina;


CREATE OR REPLACE TABLE Pagina (ID INT PRIMARY KEY NOT NULL, 
										  TITULO VARCHAR(200), 
										  LINK VARCHAR(200), 
										  CantSubtitulos INT, 
										  CantPalabras INT, 
										  CantReferencias INT, 
										  CantPalabrasTitulo INT);
										  
CREATE OR REPLACE TABLE Subtitulo (ID INT PRIMARY KEY AUTO_INCREMENT, 
											  Subtitulo VARCHAR(200),
											  ID_Pagina INT,
											  CantPalabras INT,
											  
											  CONSTRAINT `fk_pagina_subtitulo`
    										  FOREIGN KEY (ID_Pagina) REFERENCES pagina (ID)
    										  ON DELETE CASCADE);
    										  
CREATE OR REPLACE TABLE Referencia (ID INT PRIMARY KEY AUTO_INCREMENT,
											   Referencia VARCHAR(200), 
											   Link VARCHAR(200),
											   Activo BOOL,
											   ID_Pagina INT,
											   
											   CONSTRAINT `fk_pagina_referencia`
    										   FOREIGN KEY (ID_Pagina) REFERENCES pagina (ID)
    										   ON DELETE CASCADE);
											   
CREATE OR REPLACE TABLE Imagen (ID INT PRIMARY KEY AUTO_INCREMENT,
										  URL VARCHAR(200),
										  Alt VARCHAR(500),
										  CantPalabras INT,
										  ID_Pagina INT,
										  
										  CONSTRAINT `fk_pagina_imagen`
    									  FOREIGN KEY (ID_Pagina) REFERENCES pagina (ID)
    									  ON DELETE CASCADE);
    									  
    									  
CREATE OR REPLACE TABLE Populares (ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
											  NumTop INT,
											  Palabra VARCHAR(100),
											  Apariciones INT,
											  ID_Pagina INT,
											  
											  CONSTRAINT `fk_pagina_populares`
    										  FOREIGN KEY (ID_Pagina) REFERENCES pagina (ID)
    										  ON DELETE CASCADE);							  