package com.election.controller;

import com.election.view.ReadAndPrint; 
import com.election.view.ReadAndPrintUDepartment;
import com.election.entity.Vote;
import com.election.entity.Voter;

import static com.election.view.ReadAndPrint.print; 

public class UDepartmentElectionController {

    public static void startMenu() {
        try {
            boolean menuOn = true;
            while (menuOn) {
                int command = ReadAndPrintUDepartment.showMenu();
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
        ReadAndPrintUDepartment.showVoterMenu();
    }

    public static boolean voteChief(Voter voter){
        Vote chiefVote = ReadAndPrint.readVote();
        ElectionController.voteList.add(chiefVote); 
        voter.alreadyVoted = true; 
        return true;
    }

}
