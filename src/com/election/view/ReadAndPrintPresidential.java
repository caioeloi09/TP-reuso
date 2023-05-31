package com.election.view;

import com.election.controller.ElectionController;
import com.election.controller.PresidentialElectionController;
import com.election.entity.Candidate;
import com.election.entity.Voter;
import com.election.enums.ElectionStatusEnum;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static java.lang.System.exit;

public class ReadAndPrintPresidential extends ReadAndPrint{

    public static void loadCandidates() {
        try{
            Path filePath = Paths.get(Objects.requireNonNull(ReadAndPrint.class.getClassLoader()
                            .getResource("presidentialCandidates.txt")).toURI());
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                var candidateData = line.split(",");
                ReadAndPrint.CandidateMap.put(Integer.valueOf(candidateData[0]),
                        new Candidate.Builder()
                                .electoralNumber(Integer.parseInt(candidateData[0]))
                                .name(candidateData[1])
                                .build());
            }

        } catch (Exception e){
            print("Erro na inicialização dos dados");
            exit(1);
        }
    }

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
        if (!ElectionController.currentElection.getStatus().equals(ElectionStatusEnum.RUNNING.name())) {
            print("A eleição ainda não foi inicializada, verifique com um funcionário do TSE");
            return;
        }
        Voter voter = ReadAndPrint.getVoter();
        if (voter == null)
            return;
        if (voter.alreadyVoted){
            print("Eleitor já realizou voto!\n");
            print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");
            return;
        }
        print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");

        print("Vamos começar!\n");
        print(
                "OBS:\n- A partir de agora caso você queira votar nulo você deve usar um numero composto de 0 (00 e 0000)\n- A partir de agora caso você queira votar branco você deve escrever br\n");
        print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");

        print("\nInsira seu voto para presidente:\n\n");
         if (PresidentialElectionController.votePresident(voter))
           print("Voto para presidente registrado com sucesso");
         print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");

        print("\nInsira seu voto para deputado federal (opção 1):\n\n");
         if (PresidentialElectionController.voteFederalDeputy(voter, 1))
           print("Primeiro voto para deputado federal registrado com sucesso");
         print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");

        print("\nInsira seu voto para deputado federal (opção 2):\n\n");
         if (PresidentialElectionController.voteFederalDeputy(voter, 2))
           print("Segundo voto para deputado federal registrado com sucesso");
         print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");
    }
}
