package TrainTicketSystem;

import java.sql.*;

public class DatabaseHandler {
    
    private final String URL = "";
    private final String USER = "root"; 
    private final String PASS = "my_password";

    public void insertTicket(TrainTicket ticket) {
        String sql = "INSERT INTO tickets (passenger_name, destination, ticket_class, total_price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            
            pstmt.setString(1, ticket.getPassengerName());
            pstmt.setString(2, ticket.getDestination());
            pstmt.setString(3, ticket.getTicketClass());
            pstmt.setDouble(4, ticket.getBasePrice());

            pstmt.executeUpdate();
            System.out.println("Ticket successfully saved to database!");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
