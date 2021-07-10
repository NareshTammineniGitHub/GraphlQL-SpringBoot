# GraphlQL-SpringBoot

Oracle XE Database Schema 

DROP SEQUENCE student_id_seq;
DROP SEQUENCE address_id_seq;
DROP SEQUENCE subject_id_seq;

CREATE SEQUENCE student_id_seq;
CREATE SEQUENCE address_id_seq;
CREATE SEQUENCE subject_id_seq;

DROP TABLE  address;

CREATE TABLE address (
  id number(11) NOT NULL ,
  street varchar2(100) NOT NULL,
  city varchar2(45) NOT NULL,
  PRIMARY KEY (id)
) ;

INSERT INTO address VALUES (1,'Happy Street','Delhi');
INSERT INTO address VALUES (2,'2nd Street','Mumbai');
INSERT INTO address VALUES (3,'3rd Street','Delhi');
INSERT INTO address VALUES (4,'any street','Mumbai');

commit;

DROP TABLE student;
CREATE TABLE student (
  id Number(11) NOT NULL ,
  first_name varchar2(50) NOT NULL,
  last_name varchar2(50) ,
  email varchar2(30) ,
  address_id Number(11) ,
  PRIMARY KEY (id)
);

INSERT INTO student VALUES (1,'John','Smith','john@gmail.com',1);
INSERT INTO student VALUES (2,'Virat','Dave','virat@gmail.com',2);
INSERT INTO student VALUES (3,'Steve','Martin','steve@gmail.com',3);
INSERT INTO student VALUES (4,'Sachin','Kumar','sachin@gmail.com',4);
commit;

DROP TABLE subject;
CREATE TABLE subject (
  id Number(11) NOT NULL ,
  subject_name varchar2(45),
  marks_obtained Number  ,
  student_id Number(11) ,
  PRIMARY KEY (id),
  CONSTRAINT subject_ibfk_1 FOREIGN KEY (student_id) REFERENCES student (id)
);
INSERT INTO subject VALUES (1,'Java',80,1);
INSERT INTO subject VALUES (2,'MySQL',70,1);
INSERT INTO subject VALUES (3,'Java',80,2);
INSERT INTO subject VALUES (4,'MySQL',70,2);
INSERT INTO subject VALUES (5,'MongoDB',70,2);
INSERT INTO subject VALUES (6,'MySQL',70,3);
INSERT INTO subject VALUES (7,'MongoDB',70,3);
INSERT INTO subject VALUES (8,'Java',60,4);
INSERT INTO subject VALUES (9,'MongoDB',50,4);

commit;

select * from address;
select * from student;
select * from subject;

select student_id_seq.nextval from dual;
select address_id_seq.nextval from dual;
select subject_id_seq.nextval from dual;
