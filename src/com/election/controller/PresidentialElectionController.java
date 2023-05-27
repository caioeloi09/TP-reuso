package com.election.controller;

import com.election.entity.Vote;
import com.election.entity.Voter;
import com.election.view.ReadAndPrint;
import com.election.view.ReadAndPrintPresidential;

import static com.election.view.ReadAndPrint.print;

public class PresidentialElectionController extends ElectionController{
    public static void startMenu() {
        try {
            boolean menuOn = true;
            while (menuOn) {
                int command = ReadAndPrintPresidential.showMenu();
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
        ReadAndPrintPresidential.showVoterMenu();
    }
    public static boolean votePresident(Voter voter){
        Vote presidentialVote = ReadAndPrint.readVote();
        return false;
    }

    public static boolean voteFederalDeputy(Voter voter, int i) {

        return false;
    }
}
