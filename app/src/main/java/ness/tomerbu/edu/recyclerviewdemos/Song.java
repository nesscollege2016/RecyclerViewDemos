package ness.tomerbu.edu.recyclerviewdemos;

/**
 * Created by android on 02/06/2016.
 */
public class Song {
    String title;
    int imageResId;
    String artist;

    public Song(String title, int imageResId, String artist) {
        this.title = title;
        this.imageResId = imageResId;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", imageResId=" + imageResId +
                ", artist='" + artist + '\'' +
                '}';
    }
}
