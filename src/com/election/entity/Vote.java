package com.election.entity;

public class Vote {
    private String type;
    private String candidatePosition; 
    private Candidate candidate;

    public Vote(String type){ this.type = type;}
    public Vote(String type, Candidate candidate){
        this.type = type;
        this.candidate = candidate;
    }

    public Candidate getCandidate(){
        return this.candidate; 
    }

    public String getCandidatePosition(){
        return this.candidatePosition; 
    }
}
