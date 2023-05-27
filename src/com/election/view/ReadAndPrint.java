package com.election.view;

import com.election.entity.Candidate;
import com.election.entity.CertifiedProfessional;
import com.election.entity.Vote;
import com.election.entity.Voter;

import java.io.BufferedReader;
import java.nio.file.Paths;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;

import static java.lang.System.exit;

public class ReadAndPrint {
    private static final Map<String, Voter> VoterMap = new HashMap<>();
    private static final Map<Integer, Candidate> CandidateMap = new HashMap<>();
    private static final Map<String, CertifiedProfessional> CertifiedMap = new HashMap<>();
    private static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    public static void print(String output) {
        System.out.println(output);
    }
    public static String readString() {
        try {
            return scanner.readLine();
        } catch (Exception e) {
            print("\nErro na leitura de entrada, digite novamente");
            return readString();
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (Exception e) {
            print("\nErro na leitura de entrada, digite novamente");
            return readInt();
        }
    }


    public static void loadVoters() {
        try {
            Path filePath = Paths.get(ReadAndPrint.class.getClassLoader().getResource("voterLoad.txt").toURI());
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                var voterData = line.split(",");
                VoterMap.put(voterData[0],
                        new Voter.Builder()
                                .electoralCard(voterData[0])
                                .name(voterData[1])
                                .state(voterData[2])
                                .build());
            }
        } catch (Exception e) {
            print("Erro na inicialização dos dados");
            exit(1);
        }
    }

    public static void loadProfessionals() {
        try{
            Path filePath = Paths.get(ReadAndPrint.class.getClassLoader().getResource("TSEEmployees.txt").toURI());
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                var professionalData = line.split(",");
                CertifiedMap.put(professionalData[0],
                        new CertifiedProfessional.Builder()
                                .user(professionalData[0])
                                .password(professionalData[1])
                                .build());
            }

        } catch (Exception e){
            print("Erro na inicialização dos dados");
            exit(1);
        }
    }

    public static Voter getVoter() {
        print("Insira seu título de eleitor:");
        String electoralCard = readString();
        Voter voter = VoterMap.get(electoralCard);
        if (voter == null) {
            print("Eleitor não encontrado, por favor confirme se a entrada está correta e tente novamente");
        } else {
            print("Olá, você é " + voter.name + " de " + voter.state + "?\n");
            print("(1) Sim\n(2) Não");
            int command = readInt();
            if (command == 1)
                return voter;
            else if (command == 2)
                print("Ok, você será redirecionado para o menu inicial");
            else {
                print("Entrada inválida, tente novamente");
                return getVoter();
            }
        }
        return null;
    }

    public Vote readVote(){
        print("\nInsira o número do candidato:\n\n");
        int candidateNumber = readInt();
        Candidate candidate = CandidateMap.get(candidateNumber);
        if (candidate == null){
            print("Candidato não encontrado, por favor confirme se a entrada está correta e tente novamente");
            readVote();
        }else {

        }

    }
}
