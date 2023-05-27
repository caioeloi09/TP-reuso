package com.election.controller;

import com.election.view.ReadAndPrint;
import com.election.view.ReadAndPrintMunicipal;
import com.election.entity.Vote;
import com.election.entity.Voter;

import static com.election.view.ReadAndPrint.print; 

public class MunipalElectionController {

    public static void startMenu() {
        try {
            boolean menuOn = true;
            while (menuOn) {
                int command = ReadAndPrintMunicipal.showMenu();
                switch (command) {
                    case 1 -> voterMenu();

                    //case 2 -> tseMenu();
                    case 0 -> menuOn = false;
                    default -> print("Comando inválido\n");
                }
            }
        } catch (Exception e) {
            print("Erro inesperado\n");
        }
    }

    private static void voterMenu() {
        ReadAndPrintMunicipal.showVoterMenu();
    }
    
    public static boolean voteMayor(Voter voter){
        Vote mayorVote = ReadAndPrint.readVote();
        ElectionController.voteList.add(mayorVote); 
        voter.alreadyVoted = true; 
        return true;
    }

}
