package com.example.musicrecommendation;

public class Song {
    private int id;
    private String title;
    private String genre;
    private String authorName;
    private int year;
    private int popularity;

    public Song(int id, String title, String genre, int year, int popularity, String authorName) {
    }

    public int getYear() {
        return year;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public Song() {

    }

    @Override
    public String toString() {
        return title + "-" + authorName;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}

