import java.util.ArrayList;

public class TicketManager {
    
    private ArrayList<TrainTicket> tickets;

    public TicketManager() {
        this.tickets = new ArrayList<>();
    }

    
    public String addTicket(String name, String dest, String tClass, String priceStr) {
       
        if (name.isEmpty() || dest.isEmpty() || tClass.isEmpty()) {
            return "Error: All fields are required.";
        }

        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            return "Error: Price must be a valid number.";
        }

        double finalPrice = price;
        if (tClass.equalsIgnoreCase("Business")) {
            finalPrice = price * 1.5;
        } else if (!tClass.equalsIgnoreCase("Economy")) {
            return "Error: Class must be 'Economy' or 'Business'.";
        }

        tickets.add(new TrainTicket(name, dest, tClass, finalPrice));
        return "Success: Ticket added for " + name;
    }

    
    public String getAllTicketsFormatted() {
        if (tickets.isEmpty()) return "No reservations found.";
        
        StringBuilder sb = new StringBuilder();
        for (TrainTicket t : tickets) {
            sb.append(String.format("Name: %-15s | Dest: %-15s | Class: %-10s | Total: R%.2f%n", 
                t.getPassengerName(), t.getDestination(), t.getTicketClass(), t.getBasePrice()));
        }
        return sb.toString();
    }
}