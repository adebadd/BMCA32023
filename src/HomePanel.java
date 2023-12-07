import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
	private MainFrame mainFrame;
	
	
    public HomePanel(MainFrame mainFrame) {
      
        setLayout(new BorderLayout());

        JLabel lblWelcome = new JLabel("Welcome to the Home Panel", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 24));

   

  
        add(lblWelcome, BorderLayout.NORTH);
 


        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(240, 240, 240));
    }


}