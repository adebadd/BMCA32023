import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.net.URL;
import java.util.ArrayList;

public class LoginPanel extends JPanel {
    private JTextField tFEmail;
    private JPasswordField pFPassword;
    private JButton btnLogin;

    
    private MainFrame mainFrame; 
    private JLabel lblProfile;
    
    public LoginPanel(MainFrame mainFrame, ArrayList<User> userList) {
    	this.mainFrame = mainFrame;
    	  setBackground(new Color(0, 128, 255));
          setBounds(0, 0, 802, 600);  // Set bounds for the panel

          // Initialize the ArrayList
   
          setLayout(null);

          JLabel lblPassword = new JLabel("Password:");
          lblPassword.setBounds(166, 304, 468, 31);
          lblPassword.setForeground(Color.WHITE);
          lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
          add(lblPassword);

          JLabel lblEmail = new JLabel("Email:");
          lblEmail.setBounds(166, 225, 468, 31);
          lblEmail.setForeground(Color.WHITE);
          lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
          add(lblEmail);

     

          tFEmail = new JTextField();
          tFEmail.setFont(new Font("Arial", Font.BOLD, 20));
          tFEmail.setBounds(166, 252, 468, 42);
          tFEmail.setColumns(10);
          tFEmail.setBorder(new LineBorder(new Color(255, 255, 255), 2));
          tFEmail.setBackground(new Color(0, 128, 255));
          add(tFEmail);

          pFPassword = new JPasswordField();
          pFPassword.setFont(new Font("Arial", Font.BOLD, 20));
          pFPassword.setBounds(166, 331, 468, 42);
          pFPassword.setBackground(new Color(0, 128, 255));
          pFPassword.setBorder(new LineBorder(new Color(255, 255, 255), 2));
          add(pFPassword);

          try {
              URL imageUrl = new URL("https://images2.imgbox.com/a9/97/viQNvJOJ_o.png");
              Image image = ImageIO.read(imageUrl).getScaledInstance(93, 104, Image.SCALE_SMOOTH);
              ImageIcon scaledIcon = new ImageIcon(image);

              JLabel lblProfile = new JLabel(scaledIcon);
              lblProfile.setBounds(341, 31, 120, 104);
              add(lblProfile);
          } catch (Exception e) {
              e.printStackTrace();
          }

          JLabel lblStockControl = new JLabel("STOCK CONTROL");
          lblStockControl.setBounds(313, 145, 176, 24);
          lblStockControl.setForeground(Color.WHITE);
          lblStockControl.setFont(new Font("Arial", Font.BOLD, 20));
          add(lblStockControl);

          JButton btnLogin = new JButton("LOGIN");
          btnLogin.setBounds(314, 402, 172, 43);
          btnLogin.setBackground(new Color(255, 255, 255));
          btnLogin.setForeground(new Color(5, 164, 165));
          btnLogin.setFont(new Font("Arial", Font.BOLD, 20));


          btnLogin.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  handleLogin(userList);
              }
          });
          btnLogin.setActionCommand("Login");
          btnLogin.setBorder(null);
          add(btnLogin);
          
          JLabel lblLogin = new JLabel("LOGIN");
          lblLogin.setForeground(Color.WHITE);
          lblLogin.setFont(new Font("Arial", Font.BOLD, 20));
          lblLogin.setBounds(367, 168, 68, 24);
          add(lblLogin);
          
          JLabel lblDontHaveAn = new JLabel("Dont have an account?");
          lblDontHaveAn.setForeground(Color.WHITE);
          lblDontHaveAn.setFont(new Font("Arial", Font.BOLD, 12));
          lblDontHaveAn.setBounds(313, 462, 130, 14);
          add(lblDontHaveAn);
          
          JLabel lblRegister = new JLabel("<html><u>Register</u></html>");
          lblRegister.setForeground(new Color(255, 255, 255));
          lblRegister.setFont(new Font("Arial", Font.BOLD, 12));
          lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          lblRegister.setBounds(445, 462, 52, 14);
          add(lblRegister);
          
          lblRegister.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(java.awt.event.MouseEvent e) {
                  mainFrame.switchToPanel("RegisterPanel");
              }
          });
      
      }
      
    
    

    
    private void handleLogin(ArrayList<User> userList) {
    	
        String email = tFEmail.getText().trim();
        String password = new String(pFPassword.getPassword()).trim();
        tFEmail.setText("");
        pFPassword.setText("");

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both email and password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean isValidUser = false;
        for (User user : userList) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                isValidUser = true;
                break;
            }
        }

        if (isValidUser) {
        
            mainFrame.switchToPanel("HomePanel");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
      
      
}