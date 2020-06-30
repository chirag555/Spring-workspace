package swapnil;

import java.util.Scanner;

public class Solution {

	public static int findAvgBudgetByDirector(Movie[] movies, String director) {

		int avgBudget;
		int tempBudget = 0;
		int i;
		for (i = 0; i < movies.length; i++) {

			if (movies[i].getDirector().equals(director)) {
				tempBudget = tempBudget + movies[i].getBudget();
			}
		}
		avgBudget = tempBudget / i;
		return tempBudget == 0 ? 0 : avgBudget;

	}

	public static Movie getMovieByRatingBudget(Movie[] movies, int rating, int budget) {
		int i;
		for (i = 0; i < movies.length; i++) {

			if (movies[i].getRating() == rating && movies[i].getBudget() == budget) {
				return movies[i];

			}
		}
		return null;

	}

	public static void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);
		Movie[] movieArray = new Movie[10];
		for (int i = 0; i < 10; i++) {
			movieArray[i].setMovieId(scanner.nextInt());
			movieArray[i].setDirector(scanner.nextLine());
			movieArray[i].setRating(scanner.nextInt());
			movieArray[i].setBudget(scanner.nextInt());
		}
		String director = null;
		int rating = 0, budget = 0;
		director = scanner.nextLine();
		rating = scanner.nextInt();
		budget = scanner.nextInt();
		System.out.println();
		findAvgBudgetByDirector(movieArray, director);
		System.out.println();
		getMovieByRatingBudget(movieArray, rating, budget);

		scanner.close();
	}

}

class Movie {
	private int movieId;
	private String director;
	private int rating;
	private int budget;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public Movie(int movieId, String director, int rating, int budget) {

		this.movieId = movieId;
		this.director = director;
		this.rating = rating;
		this.budget = budget;
	}
}