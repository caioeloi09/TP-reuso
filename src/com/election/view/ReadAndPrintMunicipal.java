package com.election.view;

import com.election.controller.ElectionController;
import com.election.controller.MunipalElectionController;
import com.election.entity.Candidate;
import com.election.entity.Vote;
import com.election.entity.Voter;
import com.election.view.ReadAndPrint;
import java.util.List;

import static com.election.view.ReadAndPrint.print; 

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

        print("\nInsira seu voto para prefeito:\n\n");
         if (MunipalElectionController.voteMayor(voter))
           print("Voto para prefeito registrado com sucesso");
         print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");

    }

    public static void showResults(){
        print("Resultado da Eleicao:");
        print("Votos validos: " + ElectionController.getValidVotes());
        print("Votos nulos: " + ElectionController.getNullVotes());
        print("Votos brancos: " +  ElectionController.getWhiteVotes()); 
        print("\n"); 

        List<Candidate> candidateRanking = ElectionController.candidateRanking; 

        candidateRanking.stream().forEach(candidate -> print(candidate.toString()));
    }

}
