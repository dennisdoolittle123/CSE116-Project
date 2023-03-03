package ratings;
import ratings.datastructures.LinkedListNode;
import java.util.LinkedList;

public class Song {
    private String title;
    private String artist;
    private String songID;
    private LinkedList<Rating> ratings;

    public Song(String title, String artist, String songID) {
        this.title = title;
        this.artist = artist;
        this.songID = songID;
        ratings = new LinkedList<Rating>();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongID() {
        return songID;
    }

    public void setSongID(String songID) {
        this.songID = songID;
    }


    //task3
    public void addRating(Rating rating) {
        if (!didReviewerRateSong(rating.getReviewerID())) {
            ratings.add(rating);
        }
    }

    public LinkedList<Rating> getRatings() {
        return ratings;
    }

    public double averageRating() {
        int count = 0;
        double sum = 0;
        for (Rating rating : ratings) {
            int value = rating.getRating();
            if (value != -1) {
                sum += value;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        } else {
            return sum / count;
        }
    }

    public boolean didReviewerRateSong(String reviewerID) {
        for (Rating rating : ratings) {
            if (rating.getReviewerID().equals(reviewerID)) {
                return true;
            }
        }
        return false;
    }

    public void removeRatingByReviewer(Reviewer reviewer) {
        ratings.removeIf(rating -> rating.getReviewerID().equals(reviewer.getReviewerID()));
    }
}
