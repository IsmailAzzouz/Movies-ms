package org.com.ex.model;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class MovieDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="imdbID")
    private String imdbID;

    @Column(name="title")
    private String title;

    @Column(name="release_year")
    private String year;

    @Column(name="type")
    private String type;

    @Column(name="imageUrl")
    private String imageUrl;

    public MovieDetails(){}

    public MovieDetails(String imdbID, String title, String year, String type, String imageUrl) {
        this.imdbID = imdbID;
        this.title = title;
        this.year = year;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "MovieDetails{" +
                "id=" + id +
                ", imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", type='" + type + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
