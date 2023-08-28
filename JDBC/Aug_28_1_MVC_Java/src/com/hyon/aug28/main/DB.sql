CREATE TABLE TORIKIZOKU(
     t_location VARCHAR2(20 CHAR) PRIMARY KEY,
     t_name VARCHAR2(10 CHAR) NOT NULL,
     t_seat NUMBER(3) NOT NULL
); 

CREATE TABLE RESERVATION(
	r_no NUMBER(3) PRIMARY KEY,
    r_name VARCHAR2(10 CHAR) NOT NULL,
	r_time DATE NOT NULL,
    r_phonenum VARCHAR2(20 CHAR) NOT NULL,
    r_location VARCHAR2(20 CHAR) NOT NULL,
    CONSTRAINT fk_r_location FOREIGN KEY(r_location)
    REFERENCES TORIKIZOKU(t_location)
    ON DELETE CASCADE
);

CREATE SEQUENCE RESERVATION_SEQ;
