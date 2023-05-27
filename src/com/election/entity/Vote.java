package com.election.entity;

public class Vote {
    String type;
    Candidate candidate;

    public Vote(String type){ this.type = type;}
    public Vote(String type, Candidate candidate){
        this.type = type;
        this.candidate = candidate;
    }
}
