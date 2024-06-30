package com.androidpprog2.baseprojectsallemovies;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {

    private String title;
    private int year;
    private List<String> cast;
    private List<String> genres;
    private int length;
    private int score;
    private String language;
    private String extract;
    private String imageUrl;

    // Constructor
    public Movie(String title, int year, List<String> cast, List<String> genres, int length, int score, String language, String extract, String imageUrl) {
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.genres = genres;
        this.length = length;
        this.score = score;
        this.language = language;
        this.extract = extract;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getCast() {
        return cast;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getLength() {
        return length;
    }

    public int getScore() {
        return score;
    }

    public String getLanguage() {
        return language;
    }

    public String getExtract() {
        return extract;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
