import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Register_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register_page frame = new Register_page();
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
    public Register_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 808, 679);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblStudentRegister = new JLabel("Student: Register Details");
        lblStudentRegister.setIcon(new ImageIcon("C:\\Users\\santh\\Desktop\\VetriHtml\\Customer Registration & Check IN.png"));
        lblStudentRegister.setForeground(Color.RED);
        lblStudentRegister.setFont(new Font("Times New Roman", Font.BOLD, 31));
        lblStudentRegister.setBounds(193, 47, 417, 46);
        contentPane.add(lblStudentRegister);

        JLabel lblNewLabel_1 = new JLabel("Register No");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1.setBounds(158, 141, 149, 36);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(380, 141, 190, 36);
        contentPane.add(textField);

        JLabel lblNewLabel_1_1 = new JLabel("Student Name");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1_1.setBounds(158, 210, 149, 36);
        contentPane.add(lblNewLabel_1_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(380, 210, 190, 36);
        contentPane.add(textField_1);

        JLabel lblNewLabel_1_2 = new JLabel("Department");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_2.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1_2.setBounds(158, 287, 149, 36);
        contentPane.add(lblNewLabel_1_2);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(380, 287, 190, 36);
        contentPane.add(textField_2);

        JLabel lblNewLabel_1_3 = new JLabel("Date of Birth");
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_3.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1_3.setBounds(158, 362, 149, 36);
        contentPane.add(lblNewLabel_1_3);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(380, 362, 190, 36);
        contentPane.add(textField_3);

        JLabel lblNewLabel_1_4 = new JLabel("Email");
        lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_4.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1_4.setBounds(158, 437, 149, 36);
        contentPane.add(lblNewLabel_1_4);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(380, 437, 190, 36);
        contentPane.add(textField_4);

        JLabel lblNewLabel_1_1_1 = new JLabel("Contact No.");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1_1.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1_1_1.setBounds(158, 509, 149, 36);
        contentPane.add(lblNewLabel_1_1_1);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(380, 509, 190, 36);
        contentPane.add(textField_5);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerStudent();
            }
        });
        btnRegister.setForeground(new Color(0, 0, 0));
        btnRegister.setBackground(new Color(173, 216, 230));
        btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnRegister.setBounds(418, 578, 112, 36);
        contentPane.add(btnRegister);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Home_Page().setVisible(true);
                dispose();
            }
        });
        btnBack.setBackground(new Color(175, 238, 238));
        btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnBack.setBounds(591, 578, 112, 36);
        contentPane.add(btnBack);
    }

    private void registerStudent() {
        try {
            int reg_no = Integer.parseInt(textField.getText());
            String name = textField_1.getText();
            String dept = textField_2.getText();
            String dob = textField_3.getText();
            String email = textField_4.getText();
            String contact = textField_5.getText(); // Changed to String

            String sql = "INSERT INTO student (reg_no, name, department, dob, email, contact) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/san", "sa", "");
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, reg_no);
                pstmt.setString(2, name);
                pstmt.setString(3, dept);
                pstmt.setString(4, dob);
                pstmt.setString(5, email);
                pstmt.setString(6, contact); // Changed to setString

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Student registered successfully!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid register number format: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    }
}
