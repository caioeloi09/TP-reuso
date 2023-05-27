package com.election.view;

import com.election.controller.ElectionController;
import com.election.controller.MunipalElectionController;
import com.election.entity.Voter;

public class ReadAndPrintMunicipal extends ReadAndPrint{

    public static int showMenu(){
        print("Escolha uma opção:\n");
        print("(1) Entrar (Eleitor)");
        print("(2) Entrar (TSE)");
        print("(0) Fechar aplicação");
        return readInt();
    }

    public static void showVoterMenu(){
        print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");
        print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");
        if (!ElectionController.currentElection.getStatus()) {
            print("A eleição ainda não foi inicializada, verifique com um funcionário do TSE");
            return;
        }
        Voter voter = ReadAndPrint.getVoter();
        if (voter == null)
            return;
        print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");

        print("Vamos começar!\n");
        print(
                "OBS:\n- A partir de agora caso você queira votar nulo você deve usar um numero composto de 0 (00 e 0000)\n- A partir de agora caso você queira votar branco você deve escrever br\n");
        print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");

        print("\nInsira seu voto para presidente:\n\n");
         if (MunipalElectionController.voteMayor(voter))
           print("Voto para presidente registrado com sucesso");
         print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");

    }
}
