package com.movie;

public class StandaloneMovieClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MovieType movie = new MovieType();
		
		MovieServiceImplService mss = new MovieServiceImplService();
		MovieService service = mss.getMovieServiceImplPort();
		
		movie.setTitle("The Big Lebowski");
		movie.setRating("PG-13");
		movie.setDescription("Let's Go Bowling");
		movie.getActor().add("Jeff Bridges");
		movie.getActor().add("John Goodman");
		
		System.out.println(service.addMovie(movie));


	}

}
