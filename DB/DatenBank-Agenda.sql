CREATE DATABASE DBAGENDA;

USE DBAGENDA;

CREATE TABLE EINTRAG
(
	EINTRAGID INT NOT NULL,
	TITEL VARCHAR(255) NOT NULL,
	BESCHREIBUNG VARCHAR(255) NOT NULL,
	STARTDATUM DATE,
    ENDDATUM DATE,
    ORT VARCHAR(255),
    PRIMARY KEY (EINTRAGID)
);

CREATE TABLE TAG
(
	TAGID INT NOT NULL,
	DATUM DATE,
    FK_EINTRAGID int,
    PRIMARY KEY (TAGID)
);

CREATE TABLE EINTRAG_TAG (
	EINTRAGID INT NOT NULL,
	TAGID INT NOT NULL,
    PRIMARY KEY(EINTRAGID, TAGID)
);
