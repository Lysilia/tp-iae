ALTER TABLE B DROP CONSTRAINT FK_B_C_ID
ALTER TABLE COMMANDE DROP CONSTRAINT COMMANDEADRESSESID
DROP TABLE COMMAND_ITEM
DROP TABLE B
DROP TABLE ADRESSE
DROP TABLE C
DROP TABLE A
DROP TABLE ITEM
DROP TABLE CLIENT
DROP TABLE COMMANDE
DROP TABLE CLIENT_ADRESSE
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
