import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Search_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Search_page frame = new Search_page();
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
    public Search_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 731, 585);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Student : Search Details");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\santh\\Desktop\\VetriHtml\\s.png"));
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 31));
        lblNewLabel.setBounds(195, 94, 498, 46);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Register No");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1.setBounds(136, 214, 149, 36);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(343, 214, 190, 36);
        contentPane.add(textField);

        JLabel lblNewLabel_1_1 = new JLabel("Date of Birth");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1_1.setBounds(136, 301, 149, 36);
        contentPane.add(lblNewLabel_1_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(343, 301, 190, 36);
        contentPane.add(textField_1);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int reg_no = Integer.parseInt(textField.getText());
                    String dob = textField_1.getText();

                    String sql = "SELECT * FROM student WHERE reg_no = ? AND dob = ?";

                    Class.forName("org.h2.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/san", "sa", "");

                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, reg_no);
                    pstmt.setString(2, dob);

                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        String name = rs.getString("name");
                        String dept = rs.getString("department");
                        String email = rs.getString("email");
                        
                        String message = String.format("Name: %s\nDepartment: %s\nEmail: %s", name, dept, email);
                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        JOptionPane.showMessageDialog(null, "No student found with the given details.");
                    }

                    conn.close();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid register number format.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "H2 Driver not found.");
                }
            }
        });
        btnSearch.setBackground(new Color(176, 224, 230));
        btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnSearch.setBounds(304, 400, 112, 36);
        contentPane.add(btnSearch);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Home_Page().setVisible(true);
                dispose();
            }
        });
        btnCancel.setBackground(new Color(176, 224, 230));
        btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnCancel.setBounds(504, 400, 112, 36);
        contentPane.add(btnCancel);
    }
}
