// Import necessary packages
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.UIManager;

public class RegisterPanel extends JPanel {
    private JTextField tFName;
    private JTextField tFEmail;
    private JPasswordField pFPassword;
    private ArrayList<User> userList; 
    

    private MainFrame mainFrame; 
    
    public RegisterPanel(MainFrame mainFrame, ArrayList<User> userList) {
    	
    	   this.mainFrame = mainFrame;
    	    this.userList = userList; 

    	 
    	 
    	

        setBackground(new Color(0, 128, 255));
        setBounds(0, 0, 802, 600);  // Set bounds for the panel

        // Initialize the ArrayList
        userList = new ArrayList<>();
        setLayout(null);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(166, 289, 468, 31);
        lblEmail.setForeground(new Color(255, 255, 255));
        lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblEmail);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(166, 368, 468, 31);
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblPassword);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(166, 208, 468, 31);
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblName);

        tFName = new JTextField();
        tFName.setFont(new Font("Arial", Font.BOLD, 20));
        tFName.setBounds(166, 237, 468, 42);
        tFName.setBorder(new LineBorder(new Color(255, 255, 255), 2));
        tFName.setBackground(new Color(0, 128, 255));
        add(tFName);
        tFName.setColumns(10);

        tFEmail = new JTextField();
        tFEmail.setFont(new Font("Arial", Font.BOLD, 20));
        tFEmail.setBounds(166, 316, 468, 42);
        tFEmail.setColumns(10);
        tFEmail.setBorder(new LineBorder(new Color(255, 255, 255), 2));
        tFEmail.setBackground(new Color(0, 128, 255));
        add(tFEmail);

        pFPassword = new JPasswordField();
        pFPassword.setFont(new Font("Arial", Font.BOLD, 20));
        pFPassword.setBounds(166, 398, 468, 42);
        pFPassword.setBackground(new Color(0, 128, 255));
        pFPassword.setBorder(new LineBorder(new Color(255, 255, 255), 2));
        add(pFPassword);

        try {
            URL imageUrl = new URL("https://images2.imgbox.com/a9/97/viQNvJOJ_o.png");
            Image image = ImageIO.read(imageUrl).getScaledInstance(93, 104, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);

            JLabel lblProfile = new JLabel(scaledIcon);
            lblProfile.setBounds(346, 31, 110, 104);
            add(lblProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblRegister = new JLabel("STOCK CONTROL");
        lblRegister.setBounds(312, 145, 178, 24);
        lblRegister.setForeground(Color.WHITE);
        lblRegister.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblRegister);

        JButton btnRegister = new JButton("REGISTER");
        btnRegister.setBounds(315, 461, 172, 43);
        btnRegister.setBackground(new Color(255, 255, 255));
        btnRegister.setForeground(new Color(0, 128, 255));
        btnRegister.setFont(new Font("Arial", Font.BOLD, 20));
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call method to handle user registration
                handleRegistration();
            }
        });
        btnRegister.setActionCommand("Register");
        btnRegister.setBorder(null);
        add(btnRegister);

        JLabel lblNewLabel = new JLabel("Already have an account?");
        lblNewLabel.setBounds(315, 513, 145, 14);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
        add(lblNewLabel);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(464, 513, 32, 14);
        lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblLogin.setForeground(new Color(0, 0, 0));
        lblLogin.setFont(new Font("Arial", Font.BOLD, 12));
        lblLogin.addMouseListener(new MouseAdapter() {
          
           
        });
        add(lblLogin);
        
        JLabel lblRegistration = new JLabel("REGISTRATION");
        lblRegistration.setForeground(Color.WHITE);
        lblRegistration.setFont(new Font("Arial", Font.BOLD, 20));
        lblRegistration.setBounds(326, 167, 150, 24);
        add(lblRegistration);
        
        lblLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                mainFrame.switchToPanel("LoginPanel");
            }
        });
    
    }
    
    
    private void handleRegistration() {
        String name = tFName.getText().trim(); // Trim to remove leading/trailing spaces
        String email = tFEmail.getText().trim();
        String password = new String(pFPassword.getPassword()).trim();

        // Check if any field is empty
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop further processing
        }

        // Check for duplicate email
        if (isDuplicateEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email already registered. Please use a different email.", "Registration Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Proceed with registration
            User user = new User(name, email, password);
            userList.add(user);
            clearInputFields();

            // Switch to login panel
            mainFrame.switchToPanel("LoginPanel");
        }
    }
    

    // Method to check if an email already exists in the userList
    private boolean isDuplicateEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true; // Email already exists
            }
        }
        return false; // Email does not exist
    }

    // Method to handle login (add your login logic here)

    private void clearInputFields() {
        tFName.setText("");
        tFEmail.setText("");
        pFPassword.setText("");
    }
}