SELECT * FROM DBA_USERS; --현재 데이터베이스에 등록된 계정을 조회하는 명령어 (-- : 주석 처리)

-- 기본적인 명령어를 실행하려면 명령어 작성LINE(SELECT * FROM DBA_USERS;)에 커서를 놓고 CTRL+ENTER;을 누른다.
-- 명령어는 한줄씩만 실행 할 수 있다.

SELECT * FROM TAB; --현재 계정에 등록되어 있는 테이블을 조회하는 명령어

--위에서 이용한 DBA_USERS, TAB, ROLE_SYS_PRIVS 테이블은 오라클이 이용자에게 DB에 대한 정보를
-- 제공하기 위해 만들어 놓은 가상의 테이블 -> DATA DICTIONARY

-- 오라클의 기본적으로 DB를 관리하는 계정을 자동으로 부여를 함.
-- 1. SYSTEM 계정 : 일반관리자 계정 -> 데이터 베이스를 생성/삭제 할 권한은 없음. 사용자 계정을 등록, 권한부여 등 역할
-- 2. SYS(SYS AS SYSDBA) : 수퍼관리자 게정 -> 데이터베이스를 생성하고, 삭제할 권한이 있고, 사용자계정을 등록, 권한부여 역할도 함

-- 기본적으로 DB를 이용하는 사용자 계정을 등록하고 이용해보자
-- 사용자 계정은 SYSTEM/SYS AS SYSDBA계정이 등록을 함
-- 오라클 DB를 이용하려면 반드시 계정이 있어야 함
-- CREATE : 계정을 생성하는 명령어
-- CREATE USER 계정명 IDENTIFIED BY 비밀번호
-- 계정명은 대소문자 구분하지 않고, 비밀번호는 대소문자 구분을 함
CREATE USER KH IDENTIFIED BY KH;

SELECT * FROM DBA_USERS;

--권한부여하기
--GRANT : 권한||롤[ROLE] -> [권한||ROLE],... TO 계정명;
--CONNECT(ROLE) : 계정이 DB에 접속(연결)할 수 있는 권한 부여
GRANT CONNECT TO KH; --접속할 수 있는 권한을 부여

-- 접속한 KH계정으로 조회해보기
-- KH DB(계정)로 변경 후 아래 명령어 실행
SELECT * FROM TAB; --현재 탭의 계정이 가지고 있는 테이블 조회

CREATE TABLE TEST1(
 NAME VARCHAR2(20)  -- 데이터 저장할 수 있는 공간 확보
);                   -- SYSTEM에서 테이블 생성 권한을 부여하지 않았기에 KH계정에서 테이블 생성을 할 수 없다.
                    -- 오직 SYSTEM이 부여한 일만 할 수 있다.
-- 테이블(저장 공간 : 데이터를 저장할 수 있는)을 생성할 수 있는 권한이 부여되야함.
--RESOURCE (ROLE)를 부여 : 테이블을 생성하고 이용할 수 있는 권한이 있는 ROLE;

--DBA로 이동
GRANT RESOURCE TO KH; --KH의 테이블 생성 권한 부여

-- KH로 이동
-- KH DB에 접속 시점에는 권한이 없었기에 로그 아웃 후 다시 접속해야 부여된 권한을 적용받을 수 있다.
-- 다시 접속 후 아래 명령서 실행하면 테이블 생성이 된다.
CREATE TABLE TEST1(
 NAME VARCHAR2(20)  
);

DROP TABLE TEST1; -- 테이블 지우는 명령어

-- TEST/TEST 계정 생성 및 테이블 만들기
CREATE USER TEST IDENTIFIED BY TEST;
GRANT CONNECT,RESOURCE TO TEST;
CREATE TABLE TEST(
 NAME VARCHAR2(20)
);
SELECT * FROM TEST;

-- DATA DICTIONARY 테이블 보기
SELECT * FROM DICT; --관리자계정, 사용자계정이 이용

--외부 SQL을 통해 KH DB에 테이블 추가 작업이 선행되었음
--KH에서 활용할 디비내용 확인
SELECT * FROM EMPLOYEE;
DESC EMPLOYEE; --저장된 컬럼 확인
SELECT * FROM DEPARTMENT;
SELECT * FROM JOB;
SELECT * FROM LOCATION;
SELECT * FROM NATIONAL;
SELECT * FROM SAL_GRADE;


-- 기본 SELECT문 활용하기
-- SELECT출력을 원하는 컬럼명[, 컬럼명...]
-- FROM 테이블

SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE FROM EMPLOYEE;
-- SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, TEST <-- 없는 컬럼명 작성 시 에러 발생


----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------


--EMPLOYEE 테이블의 전체 컬럼을 조회하기
DESC EMPLOYEE;

-- 테이블에 있는 전체 컬럼을 불러올때는 와일드카드(*)
SELECT * FROM employee;

-- RESULT SET에서 ROW(DATA) 필터링(원하는 조건에 맞는 데이터만 가져오려면) WHERE사용----------------------------------WHERE-------------------------
-- 필터링을 원하는 경우에만 WHERE를 사용하면 된다.
-- SELECT 컬럼명, 컬럼명, 컬럼명 ... FROM 테이블명 [WHERE 조건식(==,!=,>,<)]
SELECT * FROM employee WHERE SALARY>=3000000; --월급 300만 이상의 데이터만 출력

--DB에서는 대부분의 것들이 SELECT문안에서 이루어짐 -> 함수실행, 산술연산
--SELECT문에서 산술 연산하기 -> +,-,*,/
SELECT 10+20,10-50,2/5,20*40 FROM DUAL; --10,20 : 리터럴, DUAL : ORACLE이 제공하는 테스트용 테이블, 간단한 실행의 결과를 볼 수 있다.

-- DB에서는 자료형 구분 없이 숫자는 모두 정수형으로 취급한다.
-- 산술연산은 리터럴만 가능한게 아니다. 컬럼명을 가지고도 처리가 가능함.
-- 산술연산시에는 자료형이 NUMBER타입이어야 한다.
-- 숫자 : NUMBER (정수,실수 구분X)
-- 문자열 : VARCHAR2, CHAR
-- 날짜 : DATE

--컬럼, 리터럴 산술연산하기
-- NULL값은 연산처리가 되지 않는다.
SELECT SALARY, SALARY+2000000 FROM EMPLOYEE;
SELECT SALARY, BONUS,SALARY*BONUS FROM EMPLOYEE; --BOUNS가 NULL인 데이터는 결과값 NULL이 출력 됨

-- EMPLOYEE테이블에서 각 사원의 연봉을 조회하자
-- EMP_NAME, EMP_NO, DEPT_CODE, SALARY, 연봉
SELECT EMP_NAME, EMP_NO, DEPT_CODE, SALARY, SALARY*12 FROM EMPLOYEE;

-- 보너스를 추가한 금액으로 계산해보자.(월급+보너스금액)*12
SELECT EMP_NAME, EMP_NO, DEPT_CODE, SALARY, (SALARY+BONUS)*12 FROM EMPLOYEE;

-- 오라클에서 ''는 문자열 리터럴 표시
SELECT '20'+30 FROM DUAL; --자동 형변환으로 연산 가능
SELECT '이십'+30 FROM DUAL; --에러, 오라클은 +연산 시 모두 숫자로 연산(<->자바는 문자열 연산)


--RESTULSET 컬럼명을 변경하기 -> 컬럼명에 별칭부여
-- 결과가 원하는 컬럼의 명칭으로 출력되도록 한다.
-- 컬럼명 AS 변경할 컬럼이름 || 컬럼명 변경할 컬럼명
SELECT EMP_NAME 사원명, PHONE 전화번호, EMAIL 이메일, SALARY*12 AS 연봉 FROM EMPLOYEE;
SELECT EMP_NAME AS 사원명, PHONE AS 전화번호, EMAIL AS 이메일, SALARY*12 AS 연봉 FROM EMPLOYEE;

--띄어쓰기는 별칭부여로 인식,괄호() 등 특수기호는 사용이 불가하기에
-- 사용 시 ""로 감싸주면 된다.
SELECT EMP_NAME AS "사 원 명", SALARY AS "월급(원)", SALARY*12 AS 연봉 FROM EMPLOYEE; 

-- 컬럼 작성 위치에 리터럴 사용 시 모든 열에 리터럴 추가
SELECT EMP_NAME, '님', '100' FROM EMPLOYEE;

-- DISTINCT : 컬럼에 있는 중복값을 제거하고 출력하는 예약어(데이터)
-- SELECT문에 한개만 사용이 가능하다.
SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;
SELECT DISTINCT DEPT_CODE,JOB_CODE FROM EMPLOYEE; --동시에 중복인 것만 제거
SELECT DISTINCT DEPT_CODE, DISTINCT JOB_CODE FROM EMPLOYEE; --에러

-- || : 연결연산자, 컬럼||컬럼, 컬럼과 컬럼 또는 컬럼과 리터럴을 연결
SELECT '김경찬'||'하하하'||'금요일' FROM DUAL; --하나의 컬럼으로 출력
SELECT EMP_NAME||'님',SALARY||'원' FROM EMPLOYEE; 

SELECT EMP_NAME || '의 월급은' ||
SALARY || '원 입니다.'
FROM EMPLOYEE;


-- 비교 연산자
-- 동등비교연산 : =
SELECT * FROM EMPLOYEE WHERE EMP_NAME='송종기';

--EMPLOYEE 테이블에서 DEPT_CODE D5인 사원의 전체 컬럼 조회
--200만원 이상 월급을 받는 사원 조회
-- JOB_CODE가 J5가 아닌 사원을 조회하기
SELECT * FROM EMPLOYEE WHERE DEPT_CODE='D5';
--비교 연산자
SELECT * FROM EMPLOYEE WHERE SALARY>2000000;

-- 부정 연산자
SELECT * FROM EMPLOYEE WHERE JOB_CODE!='J5';
SELECT * FROM EMPLOYEE WHERE JOB_CODE<>'J5';
SELECT * FROM EMPLOYEE WHERE JOB_CODE^='J5';

--RESULT SET의 값(리터럴)들은 대소문자를 구분한다. 그 외 명령어 입력 등 영문 입력은 대소문자 구분 X

--논리연산 연결하기 : AND, OR, NOT
--EMPLOYEE테이블에서 DEPT_CODE D5이면서 SALARYRHK 300백만원 이상인 사원.
SELECT * FROM EMPLOYEE WHERE DEPT_CODE='D5' AND SALARY>=3000000;

--EMPLOYEE테이블에서 DEPT_CODE가 D5이거나 D6인 사원의 이름, 급여 부서코드를 조회
SELECT * FROM EMPLOYEE;
SELECT EMP_NAME,SALARY,DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE='D5' OR DEPT_CODE='D6';

-- NOT
-- 부서코드가 D5가 아닌 사원을 조회하세요
SELECT * FROM EMPLOYEE WHERE NOT DEPT_CODE='D5';
SELECT EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE WHERE NOT (SALARY>=3000000 AND SALARY<=5000000);



-- ORACLE에서 제공하는 비교연산자
-- BETWEEN AND -> 특정범위를 조회할 때 사용하는 연산자
-- 컬럼명 BETWEEN 값 AND 값 또는 값<=컬럼명 AND 값>=컬럼명
SELECT EMP_NAME, DEPT_CODE,SALARY FROM EMPLOYEE 
-- WHERE SALARY BETWEEN 3000000 AND 5000000;
WHERE SALARY NOT BETWEEN 3000000 AND 5000000; --일정한 범위가 아닌

-- 범위를 비교하거나 대소비교를 할때 날짜 값도 가능하다.
-- 고용일이 00/01/01 이전에 입사한 사원의 이름, 부서, 고용일 구하자
DESC EMPLOYEE;
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE FROM EMPLOYEE
WHERE HIRE_DATE <'00/01/01';

-- 고용일이 90/01/01부터 01/01/01/까지 입사한 사원의 이름,부서,고용일 조회하기
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE 
FROM EMPLOYEE 
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

-- LIKE : 특정 패턴의 문자값을 조회하는 기능
-- SELECT 컬럼명 FROM 테이블명 WHERE 컬럼명 LIKE 패턴;

-- 와일드 카드를 사용해서 조회 %,_기호
-- % : 0개 이상의 임의의 문자 (0개 포함)
 -- LIKE '%안녕' -> 안녕(O), 하안녕(O) ,아아아아안녕(O), 안 녕(X) -> 안녕으로 끝나는 문자열
 -- LIKE '홍%' : 홍으로 시작하는 문자열
 -- LIKE '%병%' : 병을 포함하고 있는 문자열
 
-- _ : 1개의 임의의 문자 표시
 -- LIKE '_안녕' ; 안녕(X) 하안녕(O) 1안녕(O) -> 안녕으로 끝나는 3글자 문자열!!!
 -- LIKE '___' : 3글자 문자열
 -- LIKE '_종_' : 가운데 종을 포함하는 3글자 문자열

-- 두개를 종합할 수 있음
 -- LIKE '%안녕_' -> 안녕으로 끝나고 한글자 더 있는 문자열
 -- LIKE '_종_%' -> 3글자 이상 두번째문자가 종 인 문자열
 -- LIKE '_종%' -> 2글자 이상 두번째문자가 종 인 문자열

-- 전씨 성을 가진 사원을 조회하기 사원명, 부서코드, 급여
SELECT EMP_NAME, DEPT_CODE, SALARY 
FROM EMPLOYEE 
WHERE EMP_NAME LIKE '전_%';

-- 사원이름 전체에 이가 포함된 사원을 조회 전체컬럼
SELECT * FROM EMPLOYEE
WHERE EMP_NAME LIKE '%이%';

-- EMAIL 중 _앞이 3자리인 직원을 조회
-- ESCAPE문으로 등록을 해서 사용해야 하며 정하는데로 사용할 수 있음
SELECT * FROM EMPLOYEE
--WHERE EMAIL LIKE '___^_%' ESCAPE '^';
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

--이씨가 아닌 사원의 전체 컬럼을 조회해보자.
SELECT * 
FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '이_%';

-- NULL을 찾아보자.
-- NULL값은 아무 의미없는 공값으로 연산처리가 되지 않음
-- WHERE BONUS = NULL;  연산처리가 되지 않기에 찾을 수 없다
-- IS NULL : 컬럼에 있는 NULL값을 조회하는 연산자
-- IS NOT NULL : 컬럼에 있는 NULL이 아닌 값을 조회하는 연산자
SELECT *
FROM EMPLOYEE
WHERE BONUS IS NULL;

-- 부서가 지정이 안된 사원의 이름, 이메일 전화번호를 조회하세요
SELECT EMP_NAME, EMAIL, PHONE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL;

-- IN / NOT IN : 다중 동등비교
-- 다중행 서브쿼리를 비교할 때 사용
-- DEPT_CODE D5 또는 이거나 D6인 사원을 조회
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE IN ('D5','D6'); -- ,마다 OR로 연결
WHERE DEPT_CODE NOT IN('D5','D6');

-- 사원중 직책코드가 J7 또는 J2이고, 급여가 200백만원 이상인 사원의 이름, 급여, 부서코드를 조회
-- 연산자 우선순위에 의해 AND가 먼저 연산되기에 ()를 사용하였다.
SELECT EMP_NAME,SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE (JOB_CODE='J7' OR JOB_CODE='J2') AND SALARY>2000000;

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------

-- 데이터 순서정렬
-- ORDER BY : 오름, 내림차순 정렬 -> 컬럼을 기준으로 정렬한다.
-- 숫자 : 작은 수 -> 큰 수 ASC 오름차순 / 큰수 -> 작은 수 DESC 내림차순
-- 문자열 : 사전순 앞 -> 뒤 ASC / 사전순 뒤 -> 앞 DESC
-- 날짜 : 빠른순 -> 늦은날짜 ASC / 늦은 날짜 -> 빠른 날짜 DESC

-- ORDER BY 컬럼명 정렬기준(ASC/DESC)
-- 사용 형식 : SELECT 컬럼명, 컬럼명... FROM 테이블 명 [WHERE] [ORDER BY 컬럼명 정렬기준]
-- ORDER BY구문은 SELECT문의 맨 마지막에 작성하며 ASC/DESC를 생략하면 기본적으로 오름차순 정렬을 한다.
-- NULL은 ASC->맨 아래, DESC->맨 위에 정렬된다.

SELECT * FROM EMPLOYEE ORDER BY EMP_NAME ASC;
SELECT * FROM EMPLOYEE ORDER BY DEPT_CODE, EMP_NAME DESC; -- DEPT_CODE먼저 ASC정렬 후 동일 값 EMP_NAME DESC 정렬

--DEPT_CODE D5인 사원 중 월급을 많이 받는 사원순으로 전체 컬럼 조회하기
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE='D5'
ORDER BY SALARY DESC;

-- NULLS 옵션 : 정렬 후 NULL 값의 위치를 정할 수 있다.
SELECT DEPT_CODE, EMP_NAME
FROM EMPLOYEE
--ORDER BY DEPT_CODE NULLS FIRST;
ORDER BY DEPT_CODE DESC NULLS LAST;

-- ORDER BY 절에서 컬럼에 대한 인덱스를 기준으로 정렬할 수 있다. (인덱스는 1부터 시작)
SELECT EMP_NAME, DEPT_CODE, SALARY, EMAIL
FROM EMPLOYEE
ORDER BY 2;

-- ORDER BY 절에서는 컬럼에 부여한 별칭으로도 이용할 수 있다.
-- FROM -> WHERE -> SELECT -> ORDER BY 순으로 실행이 된다
-- 별칭이 부여되기 전에 WHERE절이 실행되기에 WHERE를 별칭 사용이 불가능하지만 ORDER BY문은 마지막에 실행되기에 별칭 사용이 가능하다.
SELECT EMP_NAME, (SALARY+(SALARY*BONUS))*12 AS 연봉
FROM EMPLOYEE
WHERE (SALARY+(SALARY*BONUS))*12>=40000000
ORDER BY 연봉 DESC;