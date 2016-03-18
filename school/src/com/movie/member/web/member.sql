SELECT * FROM Test;

CREATE TABLE Member(
	id VARCHAR2(30) PRIMARY KEY,
	name VARCHAR2(30) NOT NULL,
	password VARCHAR2(30) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER
);

INSERT INTO Member(id, name, password, addr, birth) VALUES('hong', '홍길동', '1', '서울', 800101);
INSERT INTO Member(id, name, password, addr, birth) VALUES('kim', '김유신', '1', '경기', 900202);
INSERT INTO Member(id, name, password, addr, birth) VALUES('lee', '이순신', '1', '부산', 850303);
INSERT INTO Member(id, name, password, addr, birth) VALUES('song', '송중기', '1', '대전', 950404);
INSERT INTO Member VALUES('yoon', '윤', '1', '인천', 750505);

SELECT * FROM Member;
SELECT * FROM Member WHERE id = 'kim';

