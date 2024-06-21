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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Delete_page extends JFrame {

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
                    Delete_page frame = new Delete_page();
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
    public Delete_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 752, 535);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Student : Delete Details");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\santh\\Desktop\\VetriHtml\\exit.png"));
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 31));
        lblNewLabel.setBounds(188, 62, 393, 46);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Register No");
        lblNewLabel_1.setBackground(new Color(240, 240, 240));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(153, 210, 149, 36);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(346, 210, 190, 36);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Department");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
        lblNewLabel_1_1.setBounds(153, 300, 149, 36);
        contentPane.add(lblNewLabel_1_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(346, 300, 190, 36);
        contentPane.add(textField_1);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Delete all Details");
        chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        chckbxNewCheckBox.setBounds(562, 312, 170, 21);
        contentPane.add(chckbxNewCheckBox);

        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int reg_no = Integer.parseInt(textField.getText());
                    String department = textField_1.getText();
                    boolean deleteAll = chckbxNewCheckBox.isSelected();

                    String sql;
                    if (deleteAll) {
                        sql = "DELETE FROM student WHERE reg_no = ?";
                    } else {
                        sql = "DELETE FROM student WHERE reg_no = ? AND department = ?";
                    }

                    Class.forName("org.h2.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/san", "sa", "");

                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, reg_no);
                    if (!deleteAll) {
                        pstmt.setString(2, department);
                    }

                    int rowsAffected = pstmt.executeUpdate();
                    conn.close();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Student details deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "No student found with the given details.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid register number format.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "H2 Driver not found.");
                }
            }
        });
        btnNewButton.setBackground(new Color(176, 224, 230));
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnNewButton.setBounds(363, 406, 112, 36);
        contentPane.add(btnNewButton);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Home_Page().setVisible(true);
                dispose();
            }
        });
        btnBack.setBackground(new Color(176, 224, 230));
        btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnBack.setBounds(565, 406, 112, 36);
        contentPane.add(btnBack);
    }
}
