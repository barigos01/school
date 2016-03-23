CREATE SEQUENCE score_seq 
INCREMENT BY 1
START WITH 1
;

DROP TABLE Grade CASCADE CONSTRAINT;
DROP SEQUENCE hak;

CREATE TABLE Grade(
	score_seq NUMBER PRIMARY KEY,
	id VARCHAR2(30) NOT NULL,
	java NUMBER,
	sql NUMBER,
	jsp NUMBER,
	spring NUMBER
);

ALTER TALBE Grade RENAME hak TO examSeq;

INSERT INTO Grade(score_seq, id, java, sql, jsp, spring) VALUES(score_seq.NEXTVAL,'hong', 100, 90, 100, 90);
INSERT INTO Grade VALUES(score_seq.NEXTVAL,'kim', 90, 80, 90, 80);
INSERT INTO Grade VALUES(score_seq.NEXTVAL,'lee', 80, 70, 80, 70);
INSERT INTO Grade VALUES(score_seq.NEXTVAL,'song', 30, 40, 50, 20);
INSERT INTO Grade VALUES(score_seq.NEXTVAL,'yoon', 60, 50, 90, 70);
INSERT INTO Grade VALUES(score_seq.NEXTVAL,'kim2', 10, 25, 40, 30);

SELECT * FROM Grade;
SELECT * FROM Grade WHERE id = 'kim';
