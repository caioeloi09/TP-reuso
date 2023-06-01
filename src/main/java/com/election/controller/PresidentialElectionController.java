package com.election.controller;

import com.election.entity.Candidate;
import com.election.entity.Vote;
import com.election.entity.Voter;
import com.election.enums.ElectionRoundEnum;
import com.election.enums.RoleEnum;
import com.election.view.ReadAndPrint;
import com.election.view.ReadAndPrintPresidential;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.election.view.ReadAndPrint.*;

public class PresidentialElectionController extends ElectionController{
    private static List<Candidate> candidateRankingPresidential = new ArrayList<>();
    private static List<Candidate> candidateRankingFederal = new ArrayList<>();
    public static void startMenu() {
        try {
            boolean menuOn = true;
            while (menuOn) {
                int command = ReadAndPrintPresidential.showMenu();
                switch (command) {
                    case 1 -> voterMenu();
                    case 2 -> ReadAndPrint.certifiedProfessionalMenu();
                    case 0 -> menuOn = false;
                    default -> print("Comando inválido\n");
                }
            }
        } catch (Exception e) {
            print("Erro inesperado\n");
        }
    }

    private static void voterMenu() {
        ReadAndPrintPresidential.showVoterMenu();
    }
    
    public static boolean votePresident(Voter voter){
        Vote presidentialVote = ReadAndPrint.readVote();
        ElectionController.voteList.add(presidentialVote);
        voter.alreadyVoted = true;
        return true;
    }

    public static boolean voteFederalDeputy(Voter voter, int i) {
        Vote federalVote = readVote();
        ElectionController.voteList.add(federalVote);
        voter.alreadyVoted = true;
        return true;
    }

    private void computeVotes(){
            candidateRankingPresidential = ElectionController.candidatesList.stream()
                    .filter(candidate -> candidate.getRole().equals(RoleEnum.PRESIDENT.name()))
                    .toList();
            if (currentElection.getRound().equals(ElectionRoundEnum.FIRST_ROUND.name())){
                candidateRankingFederal = ElectionController.candidatesList.stream()
                        .filter(candidate -> candidate.getRole().equals(RoleEnum.FEDERAL_DEPUTY.name()))
                        .toList();
            }
            candidateRankingPresidential.sort((c1, c2) -> Integer.compare(c2.getVoteCount(), c1.getVoteCount()));
            candidateRankingFederal.sort((c1, c2) -> Integer.compare(c2.getVoteCount(), c1.getVoteCount()));


    }
}
