SELECT 
    e.employee_id, 
    e.first_name, 
    e.last_name, 
    e.salary, 
    d.department_name, 
    e.hire_date, 
    l.city
FROM 
    employees e
JOIN 
    departments d ON e.department_id = d.department_id
JOIN 
    locations l ON d.location_id = l.location_id
WHERE 
    e.hire_date BETWEEN '1998-01-01' AND DATE_ADD('1998-01-01', INTERVAL 90 DAY)
ORDER BY 
    e.employee_id ASC;
