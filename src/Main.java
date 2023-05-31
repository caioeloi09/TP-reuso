import com.election.controller.ElectionController;
import com.election.controller.PresidentialElectionController;
import com.election.enums.ElectionRoundEnum;
import com.election.view.ReadAndPrint;
import com.election.view.ReadAndPrintPresidential;

public class Main {
    public static void main(String [] args){
        String electionPassword = "password";

        ElectionController.initializeElection(electionPassword);

        // Startar todos os eleitores e profissionais
        ReadAndPrint.loadVoters();
        ReadAndPrint.loadProfessionals();
        ReadAndPrint.preElectionMenu();



        switch (ElectionController.currentElection.getElectionType()){
            case "PRESIDENTIAL":
                if (ElectionController.currentElection.getRound().equals(ElectionRoundEnum.FIRST_ROUND.name())){
                    ReadAndPrintPresidential.loadCandidates();
                    PresidentialElectionController.startMenu();
                }else{
                    ReadAndPrintPresidential.loadCandidatesSecondRound();
                    PresidentialElectionController.startMenu();
                }


            case "MUNICIPAL":

        }


    }

}