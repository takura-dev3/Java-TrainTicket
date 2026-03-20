package TrainTicketSystem;

import java.util.ArrayList;

public class TicketScanner {

  
     
    public ArrayList<TrainTicket> searchByDestination(ArrayList<TrainTicket> ticketList, String searchDest) {
        ArrayList<TrainTicket> results = new ArrayList<>();

        for (TrainTicket t : ticketList) {
          
            if (t.getDestination().equalsIgnoreCase(searchDest)) {
                results.add(t);
            }
        }

        return results;
    }
}