package com.company;

/**
 * This class contains all methods and constructors necessary to create a Song object
 *
 * @author ryper
 * @version 1.0
 */

public class Song {
    private String artist;
    private String title;

    /**
     * non-default constructor for Song class
     *
     * @param artist String that represents the name of the artist
     * @param title String that represents the title of the song
     */
    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    /**
     * A setter method for the name of the artist
     * @param a String that represents the name of the artist
     */
    public void setArtist(String a) {
        this.artist = a;
    }

    /**
     * A setter method for the title of the song
     * @param t String that represents the title of the song
     */
    public void setTitle(String t) {
        this.title = t;
    }

    /**
     * A getter method for the name of the artist
     * @return The name of the artist as a String datatype
     */
    public String getArtist() {
        return artist;
    }

    /**
     * A getter method for the title of the song
     * @return The title of the song as a String datatype
     */
    public String getTitle() {
        return title;
    }

    /**
     * This is an overridden toString() method that provides the format of a song written to the txt file
     * @return Returns a string of the artist of a song and the song title separated by a hyphen.
     */
    @Override
    public String toString() {
        return artist + " - " + title;
    }
}
