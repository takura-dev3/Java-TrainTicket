package TrainTicketSystem;

public class TrainTicket {
    private final String passengerName;
    private final String destination;
    private final String ticketClass;
    private final double basePrice;

   
    public TrainTicket(String passengerName, String destination, String ticketClass, double basePrice) {
        this.passengerName = passengerName;
        this.destination = destination;
        this.ticketClass = ticketClass;
        this.basePrice = basePrice;
    }

    public String getPassengerName() { return passengerName; }
    public String getDestination() { return destination; }
    public String getTicketClass() { return ticketClass; }
    public double getBasePrice() { return basePrice; }
}