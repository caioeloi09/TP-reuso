package com.election.entity;

public class Candidate {
    int electoralNumber;
    String name;

    public Candidate(String name, int electoralNumber) {
        this.name = name;
        this.electoralNumber = electoralNumber;
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
}
