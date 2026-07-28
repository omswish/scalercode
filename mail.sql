SELECT email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1
ORDER BY email;
