package TrainTicketSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketSystemGUI extends JFrame {
    private JTextField txtName, txtDest, txtClass, txtPrice;
    private JTextArea displayArea;
    private TicketManager manager;

    public TicketSystemGUI() {
        manager = new TicketManager();
        
        
        setTitle("Train Ticket System 2026");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.add(new JLabel("Passenger Name:"));
        txtName = new JTextField(); inputPanel.add(txtName);
        
        inputPanel.add(new JLabel("Destination:"));
        txtDest = new JTextField(); inputPanel.add(txtDest);
        
        inputPanel.add(new JLabel("Class (Economy/Business):"));
        txtClass = new JTextField(); inputPanel.add(txtClass);
        
        inputPanel.add(new JLabel("Base Price:"));
        txtPrice = new JTextField(); inputPanel.add(txtPrice);

        JButton btnAdd = new JButton("Add Ticket");
        inputPanel.add(btnAdd);
        
        add(inputPanel, BorderLayout.NORTH);

        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

     
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = manager.addTicket(
                    txtName.getText(), 
                    txtDest.getText(), 
                    txtClass.getText(), 
                    txtPrice.getText()
                );
                
               
                if (result.startsWith("Error")) {
                    JOptionPane.showMessageDialog(null, result, "Input Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    displayArea.setText(manager.getAllTicketsFormatted());
                    clearFields();
                }
            }
        });
    }

    private void clearFields() {
        txtName.setText("");
        txtDest.setText("");
        txtClass.setText("");
        txtPrice.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketSystemGUI().setVisible(true));
    }
}