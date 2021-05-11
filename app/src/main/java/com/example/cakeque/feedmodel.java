package com.example.cakeque;

public class feedmodel {


    Integer id;
    String rating;
    String feedback;

    public feedmodel(String rating, String feedback) {
        this.rating = rating;
        this.feedback = feedback;
    }

    public feedmodel(Integer id, String rating, String feedback) {
        this.id = id;
        this.rating = rating;
        this.feedback = feedback;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
