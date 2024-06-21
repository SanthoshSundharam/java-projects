import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Home_Page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home_Page frame = new Home_Page();
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
    public Home_Page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 811, 583);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("COLLEGE MANAGEMENT SYSTEM");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\santh\\Desktop\\VetriHtml\\manage.png"));
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblNewLabel.setBackground(Color.LIGHT_GRAY);
        lblNewLabel.setBounds(159, 41, 505, 37);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("A SIMPLE MANAGEMENT SYSTEM");
        lblNewLabel_1.setForeground(Color.BLUE);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNewLabel_1.setBounds(220, 107, 408, 37);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Add Student");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Register_page().setVisible(true);
            }
        });
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(0, 0, 255));
        btnNewButton.setFont(new Font("Serif", Font.PLAIN, 26));
        btnNewButton.setBounds(129, 260, 231, 43);
        contentPane.add(btnNewButton);

        JButton btnUpdateStudent = new JButton("Update Student");
        btnUpdateStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Update_page().setVisible(true);
            }
        });
        btnUpdateStudent.setForeground(Color.WHITE);
        btnUpdateStudent.setBackground(Color.BLUE);
        btnUpdateStudent.setFont(new Font("Serif", Font.PLAIN, 26));
        btnUpdateStudent.setBounds(478, 260, 231, 43);
        contentPane.add(btnUpdateStudent);

        JButton btnDeleteStudent = new JButton("Delete Student");
        btnDeleteStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Delete_page().setVisible(true);
            }
        });
        btnDeleteStudent.setForeground(Color.WHITE);
        btnDeleteStudent.setBackground(Color.BLUE);
        btnDeleteStudent.setFont(new Font("Serif", Font.PLAIN, 26));
        btnDeleteStudent.setBounds(129, 391, 231, 43);
        contentPane.add(btnDeleteStudent);

        JButton btnSearchStudent = new JButton("Search Student");
        btnSearchStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Search_page().setVisible(true);
            }
        });
        btnSearchStudent.setForeground(Color.WHITE);
        btnSearchStudent.setBackground(Color.BLUE);
        btnSearchStudent.setFont(new Font("Serif", Font.PLAIN, 26));
        btnSearchStudent.setBounds(478, 391, 231, 43);
        contentPane.add(btnSearchStudent);
    }
}
