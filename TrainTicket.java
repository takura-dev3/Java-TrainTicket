public class TrainTicket {
    private String passengerName;
    private String destination;
    private String ticketClass;
    private double basePrice;
    Object[] get;

    // Constructor
    public TrainTicket(String passengerName, String destination, String ticketClass, double basePrice) {
        this.passengerName = passengerName;
        this.destination = destination;
        this.ticketClass = ticketClass;
        this.basePrice = basePrice;
    }

    // Getters
    public String getPassengerName() { return passengerName; }
    public String getDestination() { return destination; }
    public String getTicketClass() { return ticketClass; }
    public double getBasePrice() { return basePrice; }
}