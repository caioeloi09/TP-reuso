import com.election.controller.ElectionController;
import com.election.controller.PresidentialElectionController;
import com.election.view.ReadAndPrint;

public class Main {
    public static void main(String [] args){
        String electionPassword = "password";

        ElectionController.initializeElection(electionPassword);

        // Startar todos os eleitores e profissionais
        ReadAndPrint.loadVoters();
        ReadAndPrint.loadProfessionals();

        switch (ElectionController.currentElection.getElectionType()){
            case "PRESIDENTIAL":
                PresidentialElectionController.startMenu();

            case "MUNICIPAL":


        }


    }

}