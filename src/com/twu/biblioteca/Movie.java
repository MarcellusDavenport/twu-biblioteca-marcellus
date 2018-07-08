package com.twu.biblioteca;

public class Movie {

    // Movies have a name, year, director and movie rating (from 1-10 or unrated).
    private String name;
    private int year;
    private String director;
    private String movieRating;
    private String userCheckedOut;

    public Movie(String name, int year, String director, String movieRating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        userCheckedOut = "none";
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

    public void setUserCheckedOut(String user) {
        userCheckedOut = user;
    }

    public boolean isAvailable() {
        return userCheckedOut.equals("none");
    }

    public String getUserCheckedOut() {
        return userCheckedOut;
    }
}
