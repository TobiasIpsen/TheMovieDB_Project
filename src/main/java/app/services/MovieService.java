package app.services;

import app.dtos.MovieAPIResponse;
import app.dtos.MovieDTO;
import app.dtos.MovieID;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class MovieService {


    public static void main(String[] args) {

        MovieService movieService = new MovieService();

//        List<MovieID> allMovies = movieService.getAPImovieDTO();
//        System.out.println(allMovies);

        MovieDTO movie = movieService.getAPImovieDTO();
        System.out.println(movie);

    }

    public MovieDTO getAPImovieDTO() {

        String apiKey = System.getenv("API_KEY");
        ObjectMapper om = new ObjectMapper();
//        List<MovieDTO> movieDTOList = null;

        try {
            // Create an HttpClient instance
            HttpClient client = HttpClient.newHttpClient();

            // Create a request

            HttpRequest request = HttpRequest.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .uri(new URI("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&page=1&primary_release_date.gte=2019-09-17&sort_by=popularity.desc&with_origin_country=DK&api_key=" + apiKey))
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            // Check the status code and print the response
            if (response.statusCode() == 200) {
                String body = response.body();
//                System.out.println(body);
                MovieAPIResponse movieAPIResponse = om.readValue(body, MovieAPIResponse.class);
                List<MovieID> movieIDs = movieAPIResponse.getMovies();
                MovieDTO movieDTO = getAllDetailMovies(movieIDs.get(0).getId());
//                MovieDTO[] movieDTO = om.readValue(body, MovieDTO[].class);
                return movieDTO;

            } else {
                System.out.println("GET request failed. Status code: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    public MovieDTO getAllDetailMovies(int id) {

        String apiKey = System.getenv("API_KEY");
        ObjectMapper om = new ObjectMapper();
//        List<MovieDTO> movieDTOList = null;
//        int idNumber ;

        try {
            // Create an HttpClient instance
            HttpClient client = HttpClient.newHttpClient();

            // Create a request

            HttpRequest request = HttpRequest.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .uri(new URI("https://api.themoviedb.org/3/movie/" + id + "?language=en-US&append_to_response=credits&api_key=" + apiKey))
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            // Check the status code and print the response
            if (response.statusCode() == 200) {
                String body = response.body();
//                System.out.println(body);
                MovieDTO movieDTO = om.readValue(body, MovieDTO.class);
                return movieDTO;

            } else {
                System.out.println("GET request failed. Status code: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}// end class






