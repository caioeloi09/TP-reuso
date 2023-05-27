package com.election.controller;

import com.election.entity.*;

import java.util.Collections;
import java.util.List;

import static com.election.view.ReadAndPrint.*;


public class ElectionController {
    public static List<Vote> voteList;
    // TODO : computar candidateRanking
    public static List<Candidate> candidateRanking; 
    static boolean exit = false;
    public static Election currentElection;
    public static void initializeElection(String electionPassword){
        try{

            while(!exit){
                print("Selecione o tipo de eleicao desejada:\n");
                print("(1) Presidencial");
                print("(2) Estadual");
                print("(3) Municipal");
                print("(4) Universitaria");
                print("(0) Fechar Aplicacao");
                int command = readInt();
                switch (command) {
                    case 1 -> {
                        createElection(electionPassword, "Presidencial");
                        exit = true;
                    }
                    case 2 -> {
                        createElection(electionPassword, "Estadual");
                        exit = true;
                    }
                    case 3 -> {
                        createElection(electionPassword, "Municipal");
                        exit = true;
                    }
                    case 4 -> {
                        createElection(electionPassword, "Universitaria");
                        exit = true;
                    }
                    case 0 -> exit = true;
                }
            }
        }catch(Exception e){
            print("Erro inesperado");
        }

    }

    private static void createElection(String electionPassword, String electionType) {
        if (electionType.equalsIgnoreCase("presidencial")) {
            currentElection =  new PresidentialElection("PRESIDENTIAL");
        } else if (electionType.equalsIgnoreCase("municipal")) {
            currentElection = new MunicipalElection("MUNICIPAL");
        } else if (electionType.equalsIgnoreCase("estadual")) {
            currentElection = new StateElection("STATE");
        }else if (electionType.equalsIgnoreCase("universitaria")) {
            currentElection = new UDepartamentElection("UNIVERSITY");
        }
        else {
            throw new IllegalArgumentException("Tipo de eleição inválido.");
        }
    }

    public static void computeRanking(){
        for(Vote vote : voteList){
            boolean found = false;
            for(Candidate candidate : candidateRanking){
                if(candidate.equals(vote.getCandidate())){
                    candidate.addVote(); 
                    found = true;
                    break; 
                }
            }
            if(!found){
                candidateRanking.add(vote.getCandidate()); 
            }
        }
        Collections.sort(candidateRanking, (c1, c2) -> Integer.compare(c2.getVoteCount(), c1.getVoteCount())); 
    }

    public static int getValidVotes(){return currentElection.getValidVotes();}
    public static int getNullVotes(){return currentElection.getNullVotes();}
    public static int getWhiteVotes(){return currentElection.getWhiteVotes();}
}
