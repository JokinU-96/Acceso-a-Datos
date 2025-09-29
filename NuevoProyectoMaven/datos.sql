-- ------------------------------------------------
-- SCRIPT DE INSERCIÓN DE DATOS
-- ------------------------------------------------

-- 1. INSERCIÓN DE DEPARTAMENTOS
-- Los dept_no (10, 20, 30, 40) son TINYINT, PRIMARY KEY.
INSERT INTO departamentos (dept_no, dnombre, loc) VALUES
                                                      (10, 'CONTABILIDAD', 'SEVILLA'),
                                                      (20, 'INVESTIGACIÓN', 'MADRID'),
                                                      (30, 'VENTAS', 'BARCELONA'),
                                                      (40, 'PRODUCCIÓN', 'BILBAO');

---

-- 2. INSERCIÓN DE EMPLEADOS
-- dept_no debe coincidir con un departamento existente (10, 20, 30, o 40).
-- dir (director) apunta a otro emp_no (jefe).
INSERT INTO empleados (emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no) VALUES
-- DEPARTAMENTO 20 (INVESTIGACIÓN - MADRID)
(7369, 'SÁNCHEZ', 'EMPLEADO', 7902, '1980-12-17', 1040.00, NULL, 20),
(7902, 'FERNÁNDEZ', 'ANALISTA', 7566, '1981-12-03', 3000.00, NULL, 20),
(7566, 'JIMÉNEZ', 'DIRECTOR', 7839, '1981-04-02', 2975.00, NULL, 20),

-- DEPARTAMENTO 30 (VENTAS - BARCELONA)
(7499, 'ARROYO', 'VENDEDOR', 7698, '1981-02-20', 1600.00, 300.00, 30),
(7698, 'DOMÍNGUEZ', 'DIRECTOR', 7839, '1981-05-01', 2850.00, NULL, 30),
(7844, 'GARCÍA', 'VENDEDOR', 7698, '1981-09-08', 1500.00, 0.00, 30),

-- DEPARTAMENTO 10 (CONTABILIDAD - SEVILLA)
(7839, 'REY', 'PRESIDENTE', NULL, '1981-11-17', 5000.00, NULL, 10), -- Es el jefe de todos (dir = NULL)
(7934, 'MUÑOZ', 'EMPLEADO', 7782, '1982-01-23', 1300.00, NULL, 10),

-- DEPARTAMENTO 40 (PRODUCCIÓN - BILBAO)
(8001, 'VELASCO', 'TÉCNICO', 7782, '1982-02-15', 2100.00, NULL, 40),
(8002, 'CASTRO', 'OPERARIO', 7782, '1982-02-15', 1800.00, NULL, 40);

-- NOTA: El campo 'dir' para el empleado 7839 (PRESIDENTE) es NULL porque no tiene jefe.
-- Los empleados 7782 (si existiera) y 7566 serían directores intermedios.