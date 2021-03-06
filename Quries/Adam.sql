-- 1. write a SQL query to find the first name, last name, department number, and department name for each employee.
SELECT E.FIRST_NAME,E.LAST_NAME,D.DEPARTMENT_ID,D.DEPARTMENT_NAME
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

-- 2. write a SQL query to find the first name, last name, department, city, and state province for each employee.
SELECT E.FIRST_NAME,E.LAST_NAME,D.DEPARTMENT_NAME,L.CITY,L.STATE_PROVINCE
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID INNER JOIN  LOCATIONS L
ON D.LOCATION_ID = L.LOCATION_ID;

-- 3. write a SQL query to find the first name, last name, salary, and job grade for all employees.

SELECT E.FIRST_NAME, E.LAST_NAME, E.SALARY, J.GRADE
FROM EMPLOYEES E INNER JOIN JOB_GRADES J
    ON E.SALARY BETWEEN J.LOWEST_SAL AND J.HIGHEST_SAL ;

-- 4. write a SQL query to find all those employees who work in department ID 80 or 40.
-- Return first name, last name, department number and department name.
SELECT FIRST_NAME,LAST_NAME,D.DEPARTMENT_ID,D.DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE E.DEPARTMENT_ID IN (80,40);

-- 5. write a SQL query to find those employees whose first name contains a letter āzā.
-- Return first name, last name, department, city, and state province.
SELECT FIRST_NAME,LAST_NAME,DEPARTMENT_NAME,CITY,STATE_PROVINCE
FROM EMPLOYEES INNER JOIN DEPARTMENTS
   ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID
   INNER JOIN LOCATIONS
ON DEPARTMENTS.LOCATION_ID = LOCATIONS.LOCATION_ID
WHERE EMPLOYEES.FIRST_NAME LIKE '%z%';



-- 6. write a SQL query to find all departments including those without any employee.
-- Return first name, last name, department ID, department name

SELECT EMPLOYEES.FIRST_NAME,EMPLOYEES.LAST_NAME,DEPARTMENTS.DEPARTMENT_ID,DEPARTMENTS.DEPARTMENT_NAME
FROM EMPLOYEES RIGHT OUTER JOIN DEPARTMENTS
ON EMPLOYEES.EMPLOYEE_ID = DEPARTMENTS.MANAGER_ID;

-- 7. write a SQL query to find those employees who earn less than the employee of ID 182. Return first name, last name and salary.

SELECT FIRST_NAME,LAST_NAME,SALARY
FROM EMPLOYEES
WHERE SALARY <  (SELECT SALARY FROM EMPLOYEES
WHERE EMPLOYEE_ID=182);


-- 8. write a SQL query to display the department name, city, and state province for each department.

SELECT D.DEPARTMENT_NAME,L.CITY,L.STATE_PROVINCE
FROM DEPARTMENTS D INNER JOIN LOCATIONS L
    on D.LOCATION_ID = L.LOCATION_ID;


-- 9. write a SQL query to find the employees and their managers. Return the first name of the employee and manager.

SELECT E.FIRST_NAME,D.MANAGER_ID
FROM EMPLOYEES E INNER JOIN DEPARTMENTS d
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;


-- 10 write a SQL query to find those employees who have or not any department. Return first name, last name, department ID, department name.


-- 11. write a SQL query to find the employees and their managers. These managers do not work under any manager. Return the first name of the employee and manager.


-- 12.write a SQL query to find those employees who work in a department where the employee of last name 'Taylor' works. Return first name, last name and department ID



-- 13.write a SQL query to find those employees who get higher salary than the employee whose ID is 163. Return first name, last name.

SELECT FIRST_NAME,LAST_NAME,SALARY
FROM EMPLOYEES
    WHERE SALARY > (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE EMPLOYEE_ID =163);

SELECT SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID =163;

-- 14.write a SQL query to find those employees whose designation is the same as the employee whose ID is 169.
-- Return first name, last name, department ID and job ID.

SELECT FIRST_NAME,LAST_NAME,DEPARTMENT_ID,JOB_ID
FROM EMPLOYEES
WHERE JOB_ID = (
SELECT JOB_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID=169);

-- 15.write a SQL query to find those employees whose salary matches the smallest salary of any of the departments.
-- Return first name, last name and department ID.
SELECT FIRST_NAME,LAST_NAME,DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY IN (SELECT MIN(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID);

-- 16. write a SQL query to find those employees who earn more than the average salary. Return employee ID, first name, last name.

SELECT FIRST_NAME,LAST_NAME,EMPLOYEE_ID
FROM EMPLOYEES
    WHERE SALARY > (
SELECT ROUND ( AVG(SALARY), 2)
FROM EMPLOYEES);


-- 17. write a SQL query to find those employees who report that manager whose first name is āPayamā.
-- Return first name, last name, employee ID and salary.

select FIRST_NAME, LAST_NAME, EMPLOYEE_ID, SALARY
FROM EMPLOYEES
where MANAGER_ID=(select MANAGER_ID
                  from EMPLOYEES
                  where FIRST_NAME='Payam');

-- 18. write a SQL query to find all those employees who work in the Finance department.
-- Return department ID, name (first), job ID and department name.



-- 19. write a SQL query to find those employees whose ID matches any of the number 134, 159 and 183.
-- Return all the fields.

SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN (134,159,183);


-- 20. write a SQL query to find those employees whose salary is in the range of smallest salary,
-- and 2500. Return all the fields.

SELECT *
FROM EMPLOYEES
    WHERE SALARY BETWEEN   ( SELECT MIN(SALARY)
FROM EMPLOYEES) AND 2500 ;


-- 21. write a SQL query to find those employees
-- who do not work in those departments where manager ids are in the range 100, 200
-- (Begin and end values are included.) Return all the fields of the employees.

SELECT *
FROM EMPLOYEES
    WHERE DEPARTMENT_ID NOT IN (
SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE EMPLOYEES.MANAGER_ID BETWEEN 100 AND 200);

-- 22. write a SQL query to find those employees who get second-highest salary.
-- Return all the fields of the employees.

SELECT MAX((SALARY))
FROM EMPLOYEES
    WHERE SALARY!= (
SELECT MAX(SALARY)
FROM EMPLOYEES);

-- 23. write a SQL query to find those employees who get fifth-highest salary. Return all the fields of the employees.

SELECT  MIN(SALARY)
FROM (SELECT  DISTINCT SALARY
      FROM EMPLOYEES
      ORDER BY SALARY DESC
     )
WHERE ROWNUM <=5;





