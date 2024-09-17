# TheMovieDB_Project

### General Requirements
1. Store information about movies, actors, genres, and directors.
2. Implement Entities and DTO. DTOs should be used as the return types and arguments for the DAO methods
3. Write crud methods for entities
4. Write tests with JUnit and test containers

### Functionality of the backend
Retrieve information about movies, genres, actors, and directors.
1. All danish movies released in the last 5 years. (Around 1146 movies in total)
2. See a list of all movies pulled fro the DB.
3. See a list of all actors and directors that were part of a movie.
4. See a list of all genres for a movie.
5. Able to update and delete movies from DB. Not necessarily all fields, but at least the title and the release date.
6. Search movie by title. Search should be case insensitive and return all movies that contain the search string in the title.
7. Total average rating of all movies in the DB. Top 10 lowest and highest rated movies, and top 10 most popular movies.

## Todo
### Day 1
1. Sketch class diagram. Entities and their fields. Relationships
2. Make DTOs to convert JSON data.
3. Fetch all data from the API and print to the console
4. Convert DTOs to entities and save in DB

### Day 2
1. Implement DAO layer. Write the last CRUD methods for the entities.
2. Implement the service layer. The service layer should use the DAO methods and fetch data from the DB.

### Day 3
1. Write test for DAO and service layer. Make sure you use JUnit and test containers.

### Day 4
1. Make sure that the code is well documented and that the code is clean and readable.
2. Share on github
3. Hand in assignment on Moodle.
