package ratings;

import java.util.LinkedList;
import java.util.List;

public class Song {
    private String title;
    private String artist;
    private String songID;
    private LinkedList<Rating> ratings;

    public Song(String title, String artist, String songID){
        this.title = title;
        this.artist = artist;
        this.songID = songID;
        ratings = new LinkedList<>();

    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getArtist(){
        return artist;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public String getSongID(){
        return songID;
    }
    public void setSongID(String songID){
        this.songID=songID;
    }


    //task3
    public void addRating(Rating rating){
        if(didReviewerRateSong(rating.getReviewerID())){
            System.out.println("Error:" + rating.getReviewerID()+ "already rated song.");
            return;


        }
        ratings.add(rating);

    }
    public LinkedList<Rating> getRatings(){
        return ratings;
    }
    public double averageRating(){
        int sum = 0;
        int count = 0;

        for (Rating rating : ratings) {
            if (rating.getRating() != -1){
                sum += rating.getRating();
                count++;
            }
        }
        if (count == 0){
            return 0.0;
        }
        return (double) sum / count;


    }
    public boolean didReviewerRateSong(String reviewerID){
        for (Rating rating: ratings){
            if (rating.getReviewerID().equals(reviewerID)){
                return true;
            }
        }
        return false;

    }
    public void removeRatingsByReviewer(Reviewer reviewer){
        ratings.removeIf(rating -> rating.getReviewerID().equals(reviewer.getReviewerID()));
    }



}
