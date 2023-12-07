import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private RegisterPanel registerPanel;
    private LoginPanel loginPanel;
    private HomePanel homePanel;
    private ArrayList<User> userList;
    
    public MainFrame() {
    	setResizable(false);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        
        userList = new ArrayList<>();
        registerPanel = new RegisterPanel(this, userList);
        loginPanel = new LoginPanel(this, userList);
        homePanel = new HomePanel(this);
        

        mainPanel.add(registerPanel, "RegisterPanel");
        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(homePanel, "HomePanel");

        getContentPane().add(mainPanel);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void switchToPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}