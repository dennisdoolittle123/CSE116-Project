package ratings;
import ratings.Rating;
import ratings.Reviewer;
import ratings.datastructures.LinkedListNode;
import java.util.LinkedList;

package ratings;

import java.util.LinkedList;

public class Song {
    private String title;
    private String artist;
    private String songID;
    private LinkedListNode<Rating> ratings;

    public Song(String title, String artist, String songID) {
        this.title = title;
        this.artist = artist;
        this.songID = songID;
        this.ratings = null;
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

    public void addRating(Rating rating) {
        if (didReviewerRateSong(rating.getReviewerID())) {
            // Reviewer has already rated this song, don't add the new rating
            return;
        }
        if (this.ratings == null) {
            this.ratings = new LinkedListNode<Rating>(rating);
        } else {
            this.ratings.appendToTail(rating);
        }
    }

    public LinkedListNode<Rating> getRatings() {
        return this.ratings;
    }

    public double averageRating() {
        int count = 0;
        int sum = 0;
        LinkedListNode<Rating> curr = this.ratings;
        while (curr != null) {
            int rating = curr.getData().getRating();
            if (rating != -1) {
                count++;
                sum += rating;
            }
            curr = curr.getNext();
        }
        return (count == 0) ? 0 : ((double) sum / count);
    }

    public boolean didReviewerRateSong(String reviewerID) {
        LinkedListNode<Rating> curr = this.ratings;
        while (curr != null) {
            if (curr.getData().getReviewerID().equals(reviewerID)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public void removeRatingByReviewer(Reviewer reviewer) {
        LinkedListNode<Rating> prev = null;
        LinkedListNode<Rating> curr = this.ratings;
        while (curr != null) {
            if (curr.getData().getReviewerID().equals(reviewer.getReviewerID())) {
                if (prev == null) {
                    // removing the first node in the list
                    this.ratings = curr.getNext();
                } else {
                    prev.setNext(curr.getNext());
                }
                break;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }
}