import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.net.URL;

public class ProfilePanel extends JPanel {
    private MainFrame mainFrame;

    public ProfilePanel(MainFrame mainFrame) {
    	
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(255, 255, 255));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 255));
        panel.setBounds(0, 0, 800, 85);
        add(panel);
      
        
        panel.setLayout(null);
        
        JLabel lblBack = new JLabel("");
        lblBack.setBounds(30, 19, 32, 56);
        panel.add(lblBack);
        try {
            URL profileImageUrl = new URL("https://images2.imgbox.com/40/5d/mYEhCmUo_o.png");
            Image profileImage = ImageIO.read(profileImageUrl);
            ImageIcon profileIcon = new ImageIcon(profileImage.getScaledInstance(25, 35, Image.SCALE_SMOOTH));
            lblBack.setIcon(profileIcon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.switchToPanel("HomePanel"); // Switch to Home Panel
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblBack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        
        
        
       
        
        JButton btnLogout = new JButton("LOG OUT");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchToPanel("LoginPanel"); // Switch to Login Panel
            }
        });
        btnLogout.setBorder(null);
        btnLogout.setForeground(new Color(255, 255, 255));
        btnLogout.setFont(new Font("Arial", Font.BOLD, 26));
        btnLogout.setBackground(new Color(0, 128, 255));
        btnLogout.setBounds(205, 252, 389, 95);
        add(btnLogout);
     
        
      
        
    
        
   
    }
}