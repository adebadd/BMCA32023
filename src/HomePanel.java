import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.net.URL;

public class HomePanel extends JPanel {
    private MainFrame mainFrame;

    public HomePanel(MainFrame mainFrame) {
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(255, 255, 255));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 255));
        panel.setBounds(0, 0, 800, 85);
        add(panel);
        
        JLabel lblBasket = new JLabel("");
        lblBasket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblBasket.setBounds(644, 16, 50, 50);
        try {
            URL basketImageUrl = new URL("https://images2.imgbox.com/58/1d/8LrTkjGi_o.png");
            Image basketImage = ImageIO.read(basketImageUrl);
            ImageIcon basketIcon = new ImageIcon(basketImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            lblBasket.setIcon(basketIcon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lblBasket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblBasket.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseClicked(MouseEvent e) {
                mainFrame.switchToPanel("BasketPanel"); // Switch to Basket Panel
            }
        });
        panel.setLayout(null);
        panel.add(lblBasket);
        
        
        JLabel lblProfile = new JLabel("");
        lblProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblProfile.setBounds(719, 16, 45, 50);
        try {
            URL profileImageUrl = new URL("https://images2.imgbox.com/9c/a8/eQat6Vsb_o.png");
            Image profileImage = ImageIO.read(profileImageUrl);
            ImageIcon profileIcon = new ImageIcon(profileImage.getScaledInstance(45, 50, Image.SCALE_SMOOTH));
            lblProfile.setIcon(profileIcon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lblProfile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.switchToPanel("ProfilePanel"); // Switch to Profile Panel
            }
        });
        
 
        
        panel.setLayout(null);
        panel.add(lblProfile);
        
        JLabel lblStockControl = new JLabel("STOCK CONTROL");
        lblStockControl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblStockControl.setDoubleBuffered(true);
        lblStockControl.setFocusable(false);
        lblStockControl.setFont(new Font("Arial", Font.BOLD, 18));
        lblStockControl.setForeground(new Color(255, 255, 255));
        lblStockControl.setBackground(new Color(255, 255, 255));
        lblStockControl.setBounds(43, 419, 163, 16);
        add(lblStockControl);

        JLabel lblItemPacking = new JLabel("ITEM PACKING");
        lblItemPacking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblItemPacking.setDoubleBuffered(true);
        lblItemPacking.setFocusable(false);
        lblItemPacking.setForeground(Color.WHITE);
        lblItemPacking.setFont(new Font("Arial", Font.BOLD, 18));
        lblItemPacking.setBackground(Color.WHITE);
        lblItemPacking.setBounds(545, 415, 133, 24);
        add(lblItemPacking);

        JLabel lblChangeCalcualtor = new JLabel("CHANGE CALCUALTOR");
        lblChangeCalcualtor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblChangeCalcualtor.setDoubleBuffered(true);
        lblChangeCalcualtor.setFocusable(false);
        lblChangeCalcualtor.setForeground(Color.WHITE);
        lblChangeCalcualtor.setFont(new Font("Arial", Font.BOLD, 18));
        lblChangeCalcualtor.setBackground(Color.WHITE);
        lblChangeCalcualtor.setBounds(294, 415, 216, 24);
        add(lblChangeCalcualtor);
        
        

        JButton btnStockControl = new JButton("");
        btnStockControl.setDefaultCapable(false);
        btnStockControl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnStockControl.setFocusPainted(false);
        btnStockControl.setRolloverEnabled(false);
        btnStockControl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
            }
        });
        btnStockControl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchToPanel("StockControlPanel"); // Switch to Stock Control Panel
            }
        });
        try {
            URL imageUrl = new URL("https://images2.imgbox.com/ba/e4/w8B7bu0Q_o.png");
            Image image = ImageIO.read(imageUrl);
            ImageIcon icon = new ImageIcon(image.getScaledInstance(60, 74, Image.SCALE_SMOOTH));
            btnStockControl.setIcon(icon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        btnStockControl.setBorder(null);
        btnStockControl.setBackground(new Color(0, 128, 255));
        btnStockControl.setBounds(43, 233, 211, 205);
        
        add(btnStockControl);

        JButton btnChangeCalculator = new JButton("");
        btnChangeCalculator.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnChangeCalculator.setFocusPainted(false);
        btnChangeCalculator.setRolloverEnabled(false);
        try {
            URL imageUrlCalculator = new URL("https://images2.imgbox.com/4c/d3/Ny9fIhFK_o.png");
            Image imageCalculator = ImageIO.read(imageUrlCalculator);
            ImageIcon iconCalculator = new ImageIcon(imageCalculator.getScaledInstance(60, 74, Image.SCALE_SMOOTH));
            btnChangeCalculator.setIcon(iconCalculator);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        btnChangeCalculator.setBorder(null);
        btnChangeCalculator.setBackground(new Color(0, 128, 255));
        btnChangeCalculator.setBounds(294, 233, 211, 205);
        btnChangeCalculator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchToPanel("ChangeCalculatorPanel"); 
            }
        });
        add(btnChangeCalculator);

        JButton btnItemPacking = new JButton("");
        btnItemPacking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnItemPacking.setFocusPainted(false);
        btnItemPacking.setRolloverEnabled(false);
        try {
            URL imageUrlPacking = new URL("https://images2.imgbox.com/dc/2b/tVDcDQpN_o.png");
            Image imagePacking = ImageIO.read(imageUrlPacking);
            ImageIcon iconPacking = new ImageIcon(imagePacking.getScaledInstance(86, 74, Image.SCALE_SMOOTH));
            btnItemPacking.setIcon(iconPacking);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        btnItemPacking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchToPanel("ItemPackingPanel"); 
            }
        });
        btnItemPacking.setBorder(null);
        btnItemPacking.setBackground(new Color(0, 128, 255));
        btnItemPacking.setBounds(545, 233, 211, 205);
        add(btnItemPacking);
        
      
        
    
        
   
    }
}