import javax.swing.JOptionPane;

public class ReservationSystem {

    public static void main(String[] args) {
        
        // 1. Input Passenger Name
        String name = JOptionPane.showInputDialog(null, "Enter Passenger Name:", 
                "Train Ticket System", JOptionPane.QUESTION_MESSAGE);
        if (name == null) return; // Exit gracefully if 'Cancel' is pressed

        // 2. Input Destination
        String dest = JOptionPane.showInputDialog(null, "Enter Destination:", 
                "Train Ticket System", JOptionPane.QUESTION_MESSAGE);
        if (dest == null) return;

        // 3. Input & Validate Base Price (Numeric Error Handling)
        double basePrice = 0;
        boolean validPrice = false;
        while (!validPrice) {
            try {
                String priceInput = JOptionPane.showInputDialog("Enter Base Price:");
                if (priceInput == null) return;
                
                basePrice = Double.parseDouble(priceInput);
                validPrice = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a numeric value.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // 4. Input & Validate Ticket Class
        String tClass = "";
        double finalPrice = 0;
        boolean validClass = false;

        while (!validClass) {
            tClass = JOptionPane.showInputDialog("Enter Ticket Class (Economy/Business):");
            if (tClass == null) return;

            if (tClass.equalsIgnoreCase("Economy")) {
                finalPrice = basePrice;
                validClass = true;
            } else if (tClass.equalsIgnoreCase("Business")) {
                finalPrice = basePrice * 1.5;
                validClass = true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid class! Please enter 'Economy' or 'Business'.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // 5. Create object and display
        TrainTicket ticket = new TrainTicket(name, dest, tClass, finalPrice);
        printTicket(ticket);
    }

    public static void printTicket(TrainTicket ticket) {
        String output = String.format(
                "OFFICIAL TICKET%n" +
                "================================%n" +
                "Passenger:   %s%n" +
                "Destination: %s%n" +
                "Class:       %s%n" +
                "Total Fare:  R%.2f%n" +
                "================================",
                ticket.getPassengerName(), 
                ticket.getDestination(), 
                ticket.getTicketClass(), 
                ticket.getBasePrice()
        );

        JOptionPane.showMessageDialog(null, output, "Ticket Details", JOptionPane.INFORMATION_MESSAGE);
    }
}