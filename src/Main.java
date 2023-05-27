import com.election.controller.ElectionController;
import com.election.controller.PresidentialElectionController;
import com.election.view.ReadAndPrint;
import com.election.view.ReadAndPrintPresidential;

public class Main {
    public static void main(String [] args){
        String electionPassword = "password";

        ElectionController.initializeElection(electionPassword);

        // Startar todos os eleitores e profissionais
        ReadAndPrint.loadVoters();
        ReadAndPrint.loadProfessionals();


        switch (ElectionController.currentElection.getElectionType()){
            case "PRESIDENTIAL":
                ReadAndPrintPresidential.loadCandidates();
                PresidentialElectionController.startMenu();

            case "MUNICIPAL":

        }


    }

}