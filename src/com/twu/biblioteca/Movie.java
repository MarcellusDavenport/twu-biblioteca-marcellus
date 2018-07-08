package com.twu.biblioteca;

public class Movie {

    // Movies have a name, year, director and movie rating (from 1-10 or unrated).
    private String name;
    private int year;
    private String director;
    private String movieRating;
    private String userCheckedOutByLibraryNumber;

    public Movie(String name, int year, String director, String movieRating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        userCheckedOutByLibraryNumber = "none";
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setUserCheckedOutByLibraryNumber(String user) {
        userCheckedOutByLibraryNumber = user;
    }

    public boolean isAvailable() {
        return userCheckedOutByLibraryNumber.equals("none");
    }

    public String getUserCheckedOutByLibraryNumber() {
        return userCheckedOutByLibraryNumber;
    }
}
