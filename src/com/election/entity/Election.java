package com.election.entity;

import com.election.enums.ElectionTypeEnum;

public class Election {
    protected int totalValidVotes = 0;
    protected int totalNullVotes = 0;
    protected int totalWhiteVotes = 0;

    protected ElectionTypeEnum electionType;
    protected boolean status;
    protected Election(String electionType) {
        this.status = false;
        this.electionType = ElectionTypeEnum.valueOf(electionType);
    }
    public boolean getStatus() {
        return this.status;
    }
    public String getElectionType(){
        return this.electionType.name();
    }
    public void setStatus(boolean status){
        this.status = status;
    }
}
