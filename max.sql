SELECT ROUND(MAX(lat_n), 4) AS max
FROM station
WHERE lat_n < 138.2523;
