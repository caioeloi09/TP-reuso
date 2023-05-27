package com.election.controller;

import com.election.view.ReadAndPrint;
import com.election.view.ReadAndPrintState;
import com.election.entity.Vote;
import com.election.entity.Voter;

import static com.election.view.ReadAndPrint.print; 

public class StateElectionController {

    public static void startMenu() {
        try {
            boolean menuOn = true;
            while (menuOn) {
                int command = ReadAndPrintState.showMenu();
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
        ReadAndPrintState.showVoterMenu();
    }

    public static boolean voteGovernor(Voter voter){
        Vote governorVote = ReadAndPrint.readVote();
        return false;
    }

}
