package com.example.Task.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double avgVotes;

    private boolean ableToVoteForAll;

    @OneToMany
    private List<Vote> votes;

    @OneToMany
    private List<Comment> comments;

    private String description;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAvgVotes() {
        return avgVotes;
    }

    public void setAvgVotes(double avgVotes) {
        this.avgVotes = avgVotes;
    }

    public boolean isAbleToVoteForAll() {
        return ableToVoteForAll;
    }

    public void setAbleToVoteForAll(boolean ableToVoteForAll) {
        this.ableToVoteForAll = ableToVoteForAll;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}