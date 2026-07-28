SELECT e1.employee_name, e2.employee_name AS mentor_name
FROM Employees e1
JOIN Employees e2 ON e1.mentor_id = e2.employee_id
WHERE e1.hire_date BETWEEN e2.hire_date AND DATE_ADD(e2.hire_date, INTERVAL 30 DAY)
ORDER BY mentor_name ASC;
