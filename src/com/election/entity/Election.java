package com.election.entity;

import com.election.enums.ElectionStatusEnum;
import com.election.enums.ElectionTypeEnum;

public class Election {
    protected int totalValidVotes = 0;
    protected int totalNullVotes = 0;
    protected int totalWhiteVotes = 0;

    protected ElectionTypeEnum electionType;
    protected ElectionStatusEnum status;
    protected Election(String electionType) {
        this.status = ElectionStatusEnum.NOT_INITIALIZED;
        this.electionType = ElectionTypeEnum.valueOf(electionType);
    }
    public String getStatus() {
        return this.status.name();
    }
    public String getElectionType(){
        return this.electionType.name();
    }
    public void setStatus(String status){
        this.status = ElectionStatusEnum.valueOf(status);
    }
}
