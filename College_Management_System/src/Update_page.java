import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Update_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Update_page frame = new Update_page();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Update_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 802, 625);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblStudentUpdate = new JLabel("Student : Update Details");
        lblStudentUpdate.setForeground(Color.RED);
        lblStudentUpdate.setFont(new Font("Times New Roman", Font.BOLD, 31));
        lblStudentUpdate.setBounds(214, 51, 378, 46);
        contentPane.add(lblStudentUpdate);

        JLabel lblNewLabel_1 = new JLabel("Register No");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1.setBounds(164, 170, 149, 36);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(342, 170, 190, 36);
        contentPane.add(textField);

        JLabel lblNewLabel_1_1 = new JLabel("Contact No.");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1_1.setBounds(164, 263, 149, 36);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Email");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_2.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1_2.setBounds(164, 351, 149, 36);
        contentPane.add(lblNewLabel_1_2);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(342, 263, 190, 36);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(342, 351, 190, 36);
        contentPane.add(textField_2);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudentDetails();
            }
        });
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnUpdate.setBackground(new Color(173, 216, 230));
        btnUpdate.setBounds(391, 436, 112, 36);
        contentPane.add(btnUpdate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Home_Page().setVisible(true);
                dispose();
            }
        });
        btnCancel.setForeground(Color.BLACK);
        btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnCancel.setBackground(new Color(173, 216, 230));
        btnCancel.setBounds(556, 436, 112, 36);
        contentPane.add(btnCancel);
    }

    private void updateStudentDetails() {
        try {
            int reg_no = Integer.parseInt(textField.getText());
            String contact = textField_1.getText();
            String email = textField_2.getText();

            String sql = "UPDATE student SET contact = ?, email = ? WHERE reg_no = ?";

            try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/san", "sa", "");
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, contact);
                pstmt.setString(2, email);
                pstmt.setInt(3, reg_no);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Student details updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No student found with the given register number.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid register number format.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    }
}
