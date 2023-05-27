package com.election.entity;

public class Candidate {
    private int electoralNumber;
    private int voteCount;  
    private String name; 

    public Candidate(String name, int electoralNumber) {
        this.name = name;
        this.electoralNumber = electoralNumber;
        this.voteCount = 0; 
    }

    public static class Builder {
        private int electoralNumber;
        private String name;

        public Candidate.Builder electoralNumber(int electoralNumber) {
            this.electoralNumber = electoralNumber;
            return this;
        }

        public Candidate.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Candidate build() {
            if (name == null)
                throw new IllegalArgumentException("name mustn't be null");

            if (name.isEmpty())
                throw new IllegalArgumentException("name mustn't be empty");

            return new Candidate(
                    this.name,
                    this.electoralNumber);
        }
    }

    public void addVote(){
        this.voteCount += 1;
    }
    
    public int getVoteCount(){
        return this.voteCount; 
    }

    @Override
    public String toString(){
        return ("Candidato: " + name + " \nVotos: " + this.voteCount); 
    }

    @Override 
    public boolean equals(Object obj){
        Candidate candidate = (Candidate) obj; 
        return this.name.equalsIgnoreCase(candidate.name); 
    }
}
