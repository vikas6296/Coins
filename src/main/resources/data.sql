CREATE TABLE coins (
   id int NOT NULL,
   user_balance int DEFAULT NULL,
   name varchar(25) DEFAULT NULL,
   PRIMARY KEY (id)
 ) ;

insert into coins(id,user_balance,name) values(1,4000,'viks');
insert into coins (id,user_balance,name)values(2,5000,'vikass');
insert into coins (id,user_balance,name)values(3,2000,'viksy');
insert into coins (id,user_balance,name)values(4,6000,'viksyyyy');
