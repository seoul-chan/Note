--===========================================================================================================================================================
--===========================================================================함       수======================================================================

-- 오라클이 제공하는 함수에 대해 알아보자
-- 문자열 처리 함수
-- 1. LENGTH : 문자열의 길이를 나타내는 함수
-- 사용 형식 : LENGTH(문자열||컬럼명) 숫자를 반환
SELECT LENGTH('벌써3월') FROM DUAL;

SELECT LENGTH(EMAIL) FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE LENGTH(EMAIL)>=16;

-- LENGTHB(문자열 또는 컬럼명) : 문자열 BYTE크기
-- 한글은 3BYTE로 처리함(EXPRESS 버전) , ENTERPRISE 버전은 2BYTE로 처리
SELECT LENGTHB('가나다'), LENGTH('가나다'), LENGTHB('ABC')
FROM DUAL;
SELECT LENGTH(EMP_NAME), LENGTH(EMAIL)
FROM EMPLOYEE;

-- INSTR : 찾는 문자열||컬럼에서 지정한 위치 ~부터 ~까지의 문자열 인덱스 반환.
-- 사용형식 : INSTR(대상 문자열||컬럼, 찾을문자[, 시작위치, 횟수]) 
-- 시작위치, 횟수 : 시작위치 글자에서 검색을 시작하여 횟수 번째인 문자열을 검색
-- 시작위치, 횟수 생략 시 DEFAULT=1로 처음 위치에 하나 찾으면 종료 함
-- 횟수는 중복 값이 나왔을 때 유효함
SELECT INSTR('KH정보교육원','KH') FROM DUAL;
SELECT INSTR('KH정보교육원 KH CLASS 화이팅','KH',4) FROM DUAL;
SELECT INSTR('KH정보교육원 KH CLASS 화이팅','KH',1,2) FROM DUAL;
--시작위치가 음수(-)인 경우 뒤에서 부터 찾음 == LASTINDEXOF
SELECT INSTR('KH정보교육원 KH RCLASS 화이팅 KH는 강남','KH',-7,1) FROM DUAL; --결과 9

-- EMAIL에서 @의 위치를 찾아보자
-- EMAIL에서 두번째 .의 위치를 찾아보자
SELECT INSTR(EMAIL,'@'), INSTR(EMAIL,'.',1,2)
FROM EMPLOYEE;


-- LPAD/RPAD
-- 특정 길이의 여백이 생기면 그 공간을 특정문자로 채우는 함수
-- LPAD/RPAD(대상문자열, 지정길이[,특정문자])
-- 한글은 글자당 2글자로 인식
-- 특정문자 미 지정시 공백으로 채워진다.
SELECT '안녕',LPAD('안녕',10) FROM DUAL; 
SELECT '안녕',LPAD('안녕',10,'#') FROM DUAL; 
SELECT '안녕',RPAD('안녕',10,'#') FROM DUAL; 
SELECT EMAIL, RPAD(EMAIL,16,'*') FROM EMPLOYEE;

-- LTRIM/RTRIM
-- 왼쪽, 오른쪽의 공백, 특정 기호를 제거하는 것
-- LTRIM/RTRIM(대상문자||컬럼[,문자)
-- 한 글자 찾은 후 다음 글자가 일치하는 글자가 나오지 않는 경우 제거를 중지한다.
SELECT LTRIM('     SQL') FROM DUAL;
SELECT LTRIM('SSSSSSSQL','S') FROM DUAL;

-- 한 글자씩 가나다 중 일치하는 항목이 있는지 비교 ('가''나''다')
-- 라만 남고 가,나,다는 모두 제거되어 출력된다.
SELECT LTRIM('가나다가나다가나다가나다라라라','가나다') FROM DUAL;
-- 양쪽의 가나다 제거
SELECT RTRIM(LTRIM('가나다가나다가나다가나다라라라가나다가나다','가나다'),'가나다') FROM DUAL;

-- TRIM : 양쪽에 있는 띄워쓰기, 특정문자 제거
-- 옵션에 따라 왼쪽, 오른쪽에 특정문자, 공백을 제거할 수도 있음
-- LTRIM/RTRIM과 달리 한개 문자만 제거가 가능하다.
-- TRIM(문자||컬럼)
-- TRIM('특정문자' FROM 문자열||컬럼명)
-- TRIM(LEADING '특정문자' FROM 문자열||컬럼명) --왼쪽
-- TRIM(TRAILING '특정문자' FROM 문자열||컬럼명) --오른쪽
-- TRIM(BOTH '특정문자' FROM 문자열||컬럼명) -- 양쪽
SELECT TRIM(' CHAN  ') FROM DUAL;
SELECT TRIM('K' FROM 'KKK CHAN KKK') FROM DUAL; --양쪽 K제거
SELECT TRIM(BOTH 'K' FROM 'KKK CHAN KKK') FROM DUAL; --왼쪽 K제거
SELECT TRIM(LEADING 'K' FROM 'KKK CHAN KKK') FROM DUAL; --왼쪽 K제거
SELECT TRIM(TRAILING 'K' FROM 'KKK CHAN KKK') FROM DUAL; --왼쪽 K제거


-- SUBSTR : 원하는 위치의 문자를 잘라내는 기능
-- SUBSTR('문자열'||컬럼명,'시작인덱스[,길이])
-- 길이는 시작인덱스 문자를 포함한 길이다.
SELECT SUBSTR('HELLO FUNCTION',6) FROM DUAL;
SELECT SUBSTR('HELLO FUNCTION',7,2) FROM DUAL;
SELECT SUBSTR('HELLO FUNCTION',-8,3) FROM DUAL; --뒤에서 시작
SELECT SUBSTR('HELLO FUNCTION',INSTR('HELLO FUNCTION','F'),3) FROM DUAL;

--EMPLOYEE테이블에서 사원의 성만 출력하기
SELECT SUBSTR(EMP_NAME,1,1) FROM EMPLOYEE;

-- EMPLOYEE테이블에서 남자사원만 출력하기
SELECT * FROM EMPLOYEE WHERE SUBSTR(EMP_NO,8,1)='1';

-- LOWER/UPPER/INITCAP
-- DB저장 할 때 대소문자 통일 시 사용
SELECT LOWER('Welcome to world') FROM DUAL;
SELECT LOWER('Welcome to world') FROM DUAL;
SELECT INITCAP('Welcome to world') FROM DUAL;

-- CONCAT (==||): 문자열 연결, 합치기
SELECT CONCAT('문자열을',' 합쳐준다.') FROM DUAL;
SELECT CONCAT(EMP_NAME, SALARY) FROM EMPLOYEE;

-- REPLACE : 컬럼||문자열의 일정부분을 변경하는 함수
-- REPLACE(문자||컬럼, 대상문자, 변경할 문자)
-- 출력시에만 변경되어 출력될 뿐 원본 데이터가 변경되는 것은 아니다.
SELECT REPLACE('I LOVE YOU','LOVE','HATE') FROM DUAL;
SELECT REPLACE(EMAIL,'kh.or.kr','rclass.com') FROM EMPLOYEE;

--REVERSE : 출력 순서변경
SELECT REVERSE('I LOVE YOU') FROM DUAL;

--TRANSLATE : 특정문자를 지정한 문자로 자동으로 변경해서 출력해주는 기능
SELECT TRANSLATE('010-1234-5678', '01012345678', '영일영일이삼사오육칠팔') FROM EMPLOYEE;

--EMPLOYEE테이블에서 사원번호, 사원명, 주민번호, 연봉을 조회
-- 주민번호는 생년월일만 출력하고 나머지는 *로 표시
SELECT EMP_ID, EMP_NAME, SUBSTR(EMP_NO,1,6)||'******', SALARY FROM EMPLOYEE;


-- 다음문자열에서 앞뒤 모든 숫자를 제거하세요
-- '982341678934529HELLO89798739273402'


-- 숫자처리함수
-- ABS : 절대값 출력
SELECT ABS(10),ABS(-10) FROM DUAL;

-- MOD : 나머지연산 == %
-- MOD(숫자, 나눌수) : 나머지가 반환
SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10,4) FROM DUAL;



-- 실수처리함수
-- ROUND : 반올림하는 함수
-- ROUND(실수, 소수점자리수) : 실수의 소수점 자리수에서 반올림한다.
SELECT ROUND(126.456,2) FROM DUAL;

--FLOOR : 소수점 자리 버림
SELECT FLOOR(126.456) FROM DUAL;
SELECT FLOOR(SYSDATE-HIRE_DATE) FROM EMPLOYEE;

--TRUNC : 원하는 위치의 소수점 자리 버럼
SELECT TRUNC(126.456,2) FROM DUAL;

--CEIL : 무조건 올림.
SELECT CEIL(126.456) FROM DUAL;



-- 날짜처리 함수
-- 날짜끼리 산술연산 -> 숫자(일자)
-- 날짜하고 숫자를 산술연산 -> 날짜(숫자만큼 일자를 계산)

-- SYSDATE : 현재날짜 출력
-- SYSTIMESTAMP : 현재날짜 시 분 초 밀리세컨초 출력
SELECT SYSDATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE,'YYYY-MM-DD HH:MI:SS') FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE,'HH:MI:SS') FROM DUAL;

-- 어제 오늘 내일 출력하기
SELECT SYSDATE-1 AS 어제,SYSDATE AS 오늘,SYSDATE+1 AS 내일 FROM DUAL;
-- 개월수 계산
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 2) FROM DUAL;
-- 사원의 입사한 후 한달뒤를 조회하기
SELECT EMP_NAME, ADD_MONTHS(HIRE_DATE,1) FROM EMPLOYEE;

-- 날짜의 개월차이를 구하려면
-- MONTHS_BETWEEN : 두개의 날짜를 받아서 두날짜의 개월수차이를 계산해주는 함수
SELECT MONTHS_BETWEEN(SYSDATE,ADD_MONTHS(SYSDATE,10)) FROM DUAL;

-- EMPLOYEE테이블에서 사원의 사원명, 부서코드, 근무개월수를 출력하시오
SELECT EMP_NAME, DEPT_CODE, FLOOR(MONTHS_BETWEEN(SYSDATE,HIRE_DATE)) FROM EMPLOYEE;

--NEXT_DAY : 가장 가까운 다음 요일의 날짜를 구해주는 함수
SELECT NEXT_DAY(SYSDATE,'월') FROM DUAL; -- LOCALE이 KOREA이기에 한글 인식을 한다.
SELECT * FROM V$NLS_PARAMETERS; -- LOCALE 확인 명령어 (NLS_ISO_CURRENCY -> KOREA로 되어있다)

--LAST_DAY : 그달의 마지막 날 출력
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- EXTRACT : 년, 월, 일, 시, 분, 초를 따로 숫자형으로 받을 수 있는 함수
-- EXTRACT(YEAR FROM DATE) : 년이 숫자로 반환
-- EXTRACT(MONTH FROM DATE) : 월이 숫자로 반환
-- EXTRACT(DAY FROM DATE) : 일이 숫자로 반환
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(DAY FROM SYSDATE) FROM DUAL;


-- 시분초
-- SYSDATE로는 시분초를 볼수 없기에 TIMESTAMP로 캐스팅을 해야 시분초를 볼 수 있다.
SELECT EXTRACT(HOUR FROM CAST(SYSDATE AS TIMESTAMP)) FROM DUAL;
SELECT EXTRACT(MINUTE FROM CAST(SYSDATE AS TIMESTAMP)) FROM DUAL;
SELECT EXTRACT(SECOND FROM CAST(SYSDATE AS TIMESTAMP)) FROM DUAL;


-- 형변환 함수
-- 오라클에서 형변환 자동으로 해주는 경우가 있음
-- '00/01/01'
-- TO_CHAR : 숫자||날짜를 문자로 변경해주는 함수
-- TO_CHAR(날짜[,FORMAT]) : 날짜를 문자로 변경
-- TO_CHAR(숫자[, FORMAT]) : 숫자를 문자로 변경

FORMAT
YYYY : 년도 4자리
YY : 년도 2자리
MONTH : 월, LOCALE 맞춰서 출력
MM : 월을 숫자로
DD : 날짜 표현
D : 요일을 숫자로 표현
DAY : 요일 표현
HH : 시간
MI : 분
SS : 초

SELECT SYSDATE,TO_CHAR(SYSDATE,'YY-MM-DD HH:MI:SS') FROM DUAL;
--사원테이블에서 사원명, 고용일 (1990/2/20(화)) 출력하기
SELECT EMP_NAME,TO_CHAR(HIRE_DATE,'YYYY/MM/DD(DY)') FROM EMPLOYEE;


-- 숫자를 문자로 변경하기
-- 9 : 해당 자리수에 숫자가 있으면 표시, 없으면 표시 하지 않음
-- 0 : 해당 자리수에 숫자가 있으면 표시, 없으면 0으로 표시
SELECT TO_CHAR(1000000, '999,999,999') FROM DUAL;
SELECT TO_CHAR(1000000, '000,000,000') FROM DUAL;
SELECT TO_CHAR(1000000, '999,999,999.00') FROM DUAL;


-- 돈 화폐기호를 표시
-- L : LOCALE에 맞춰 나라에 맞는 원화 표시를 출력해준다.
SELECT TO_CHAR(1000000, 'L999,999,999') FROM DUAL;


-- TO_DATE : 숫자, 문자열 날짜형식으로 변경하는 함수
-- TO_DATE('문자열','YYYMMDD') FROM DUAL;
-- 숫자형태에서 날짜로 형변환시 숫자 맨앞에 0을 사용하면 안 된다.
SELECT TO_DATE('19921030','YYYYMMDD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('19921030 10:52:22','YYYYMMDD HH:MI:SS'),'YYYY-MM-DD HH:MI:SS') FROM DUAL;


-- TO_NUMBER : 문자열을 숫자형태로 변경하는 함수, 자동 형변환이 없기에 계산을 위해 사용
 SELECT TO_NUMBER('1,000,000','999,999,999') FROM DUAL;
 
SELECT SYSDATE AS "안녕", ADD_MONTHS(SYSDATE,18) AS "잘가" FROM DUAL;
 
-- NULL 처리함수
-- NVL() : DATA값이 NULL일때 대체하는 값을 지정
-- NVL2() : NVL2(DATA,NULL값이 아닌 경우,NULL값인 경우)
SELECT BONUS, NVL(BONUS,0) FROM EMPLOYEE;
SELECT (SALARY+SALARY*NVL(BONUS,0))*12 연봉 FROM EMPLOYEE;
SELECT EMP_NAME,NVL(DEPT_CODE,'인턴')FROM EMPLOYEE;
SELECT BONUS, NVL2(BONUS,'있다','없다') FROM EMPLOYEE;


-- SELECT문에 조건에 따라 분기해보기
-- DECODE함수 이용하기
-- 자바의 SWITCH 비슷함
-- DECODE(기준값, 조건1,결과1,조건2,결과2,...,결과(DEFAULT - 해당 조건 없는 경우))
-- 성별 컴럼을 생성할 수 있음
SELECT EMP_NAME, EMP_NO,
DECODE(SUBSTR(EMP_NO,8,1),'1','남자','2','여자')
FROM EMPLOYEE;

--===========================================================================================================================================================
--===========================================================================================================================================================


-- CASE문 : 조건에 의해 분기 처리되는 함수
-- CASE
--  WHEN 조건 THEN 실행구문
--  WHEN 조건 THEN 실행구문
--  ELSE
-- END;
SELECT EMP_NAME, EMP_NO,
    CASE 
     WHEN SUBSTR(EMP_NO,8,1)='1' THEN '남자'
     WHEN SUBSTR(EMP_NO,8,1)='2' THEN '여자'
     END AS 성별
FROM EMPLOYEE;

SELECT EMP_NAME, EMP_NO,
    CASE
    WHEN SUBSTR(EMP_NO,8,1)='1' THEN '남자'
    ELSE '여자'
    END AS 성별
FROM EMPLOYEE;

SELECT TO_NUMBER(EXTRACT(YEAR FROM SYSDATE))-TO_NUMBER(SUBSTR(EMP_NO,1,2))
FROM EMPLOYEE;


SELECT EMP_ID 사원번호, EMP_NAME 사원명, 
CONCAT(SUBSTR(EMP_NO,1,8),'*******')AS 주민번호,
    CASE WHEN SUBSTR(EMP_NO,8,1)='1' THEN '남' ELSE '여' END AS 성별,
    EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'YY'))+1 AS "현재나이(YY)",
    EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR'))+1 AS "현재나이(RR)",
    TO_NUMBER(EXTRACT(YEAR FROM SYSDATE)) 
    - (TO_NUMBER(SUBSTR(EMP_NO,1,2))
         + CASE WHEN SUBSTR(EMP_NO,8,1) IN ('1','2') THEN 1900 ELSE 2000 END)+1 AS 현재나이
FROM EMPLOYEE;

-- 년도를 두자리로 가져올 때 YY, RR방식
-- 년도를 네 자리로 가져올 때 YYYY, RRRR은 동일하다
-- YY포맷 : 무조건 현재세기를 기준으로 가져온다
-- 20 -> 2020년, 98 -> 2098년, 88 -> 2088년
-- RR포맷 : 현재 년도를 기준으로 현재 년도 보다 숫자가 크면 전 세기로 간주한다.


insert into KH.EMPLOYEE (EMP_ID,EMP_NAME,EMP_NO,EMAIL,PHONE,DEPT_CODE,JOB_CODE,SAL_LEVEL,SALARY,BONUS,MANAGER_ID,HIRE_DATE,ENT_DATE,ENT_YN) 
values ('250','고두밋','470808-2123341','go_dm@kh.or.kr',null,'D2','J2','S5',4480000,null,null,to_date('94/01/20','RR/MM/DD'),null,'N');



-- 그룹함수
-- 결과가 한개 ROW로 출력되기에 컬럼을 추가할 수 없다. 
-- (오직 하나의 컬럼만 사용 가능)

-- SUM
SELECT SUM(SALARY) FROM EMPLOYEE;

-- 여자사원의 급여의 총합을 조회하기
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='2';
--전체 사원 연봉의 총합을 구하세요. 보너스포함 없으면 0으로 계산
SELECT SUM(SALARY+SALARY*NVL(BONUS,0))*12
FROM EMPLOYEE;

-- AVG : 그룹의 평균을 구하는 함수
SELECT TO_CHAR(FLOOR(AVG(SALARY)), 'L999,999,999') AS 평균급여 -- 별칭 부여시 자동 오른쪽 정렬
FROM EMPLOYEE;

-- COUNT : 그룹의 ROW수를 구하는 함수
-- 전체 사원수를 구하세요
SELECT COUNT(*)
FROM EMPLOYEE;

--급여를 300만원 이상받는 사원의 수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- COUNT(*||컬럼명)
-- 컬럼에 데이터에 NULL이 있으면 제외하고 카운트한다.
SELECT COUNT(*), COUNT(BONUS)
FROM EMPLOYEE;

SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 그룹함수는 한번에 출력이 가능
SELECT COUNT(*), SUM(SALARY), AVG(SALARY)
--SELECT DEPT_CODE, COUNT(*), SUM(SALARY), AVG(SALARY) --에러, DEPT_CODE의 결과는 여러개 이기 때문에
FROM EMPLOYEE;

-- MAX/MIN
-- 문자 비교는 불가능하며 숫자||날짜만 가능하다.
-- 사원중 급여가 제일 높은 사람의 급여, 제일 낮은 사람의 급여
SELECT MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE;

SELECT MAX(HIRE_DATE), MIN(HIRE_DATE)
FROM EMPLOYEE;

-- GROUP BY
-- 하나의 특정 값으로 그룹을 맺어 사용한다.
-- FROM절 바로 뒤에서 사용
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--부서별 사원수를 조회하세요
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--직급별 급여합계, 평균, 인원수를 조회하세요
SELECT JOB_CODE, SUM(SALARY), AVG(SALARY), COUNT(*) AS 인원수
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY AVG(SALARY) DESC;

-- 문제 : 선생님 자료 참고
SELECT JOB_CODE, COUNT(*), AVG(SALARY)
FROM EMPLOYEE
WHERE JOB_CODE != 'J1'
GROUP BY JOB_CODE;

SELECT EXTRACT(YEAR FROM HIRE_DATE) AS 입사년도, COUNT(*) AS 인원
FROM EMPLOYEE
WHERE JOB_CODE != 'J1'
GROUP BY EXTRACT(YEAR FROM HIRE_DATE)
ORDER BY EXTRACT(YEAR FROM HIRE_DATE);

SELECT DECODE(SUBSTR(EMP_NO,8,1),'1','남','2','여') AS 성별, COUNT(*)
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO,8,1),'1','남','2','여');


-- GROUP BY 절에는 다수의 컬럼을 넣을 수 있음
SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE; -- 두 컬럼이 일치하는게 하나의 그룹으로 구성됨


--HAVING절 : 그룹함수로 필터링 할 수 있게 하는것
-- 그룹함수를 가지고 ROW를 필터링할때 WHERE절 사용하지 못하고, HAVING절을 사용해야 한다.

-- 부서별 급여 평균이 300백만원 이상인 부서들의 부서코드, 급여평균을 조회
SELECT DEPT_CODE, FLOOR(AVG(SALARY))
FROM EMPLOYEE
-- WHERE AVG(SALARY)>=3000000 그룹함수는 WHERE절에 들어갈 수 없다. -> HAVING절 필요
GROUP BY DEPT_CODE
HAVING AVG(SALARY)>=3000000;

-- 부서별 인원이 3명보다 많은 부서와 인원수를 출력하세요
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(*)>=3
ORDER BY 2 DESC;

SELECT DEPT_CODE, FLOOR(AVG(SALARY)) 평균
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE
ORDER BY 1;