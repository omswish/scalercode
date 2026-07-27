SELECT movie_title
FROM Movies
WHERE genre NOT IN ('Romance', 'Drama')
ORDER BY movie_id ASC;
