drop table if exists subscriptions;
create table subscriptions(id bigint auto_increment, email varchar(50) NOT NULL, firstName varchar(50), 
gender varchar(20), dateOfBirth date NOT NULL, consent boolean NOT NULL, newsletterId varchar(20) NOT NULL, 
PRIMARY KEY (email));