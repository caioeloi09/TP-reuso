package com.election.entity;

public class MunicipalElection extends Election {

    protected int totalMayorValidVotes = 0;
    protected int totalMayorWhiteVotes = 0;
    protected  int totalMayorNullVotes = 0;

    public MunicipalElection(String electionType) {
        super(electionType);
    }
}
