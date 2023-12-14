import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.net.URL;

public class StockControlPanel extends JPanel {
    private MainFrame mainFrame;

    public StockControlPanel(MainFrame mainFrame) {
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(255, 255, 255));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 255));
        panel.setBounds(0, 0, 800, 85);
        add(panel);
        try {
            URL basketImageUrl = new URL("https://images2.imgbox.com/58/1d/8LrTkjGi_o.png");
            Image basketImage = ImageIO.read(basketImageUrl);
            ImageIcon basketIcon = new ImageIcon(basketImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        panel.setLayout(null);
        try {
            URL profileImageUrl = new URL("https://images2.imgbox.com/9c/a8/eQat6Vsb_o.png");
            Image profileImage = ImageIO.read(profileImageUrl);
            ImageIcon profileIcon = new ImageIcon(profileImage.getScaledInstance(45, 50, Image.SCALE_SMOOTH));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
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
        
        JLabel lblStockControl = new JLabel("VIEW STOCk");
        lblStockControl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblStockControl.setDoubleBuffered(true);
        lblStockControl.setFocusable(false);
        lblStockControl.setFont(new Font("Arial", Font.BOLD, 18));
        lblStockControl.setForeground(new Color(255, 255, 255));
        lblStockControl.setBackground(new Color(255, 255, 255));
        lblStockControl.setBounds(43, 419, 163, 16);
        add(lblStockControl);

        JLabel lblItemPacking = new JLabel(" - DELETE STOCK");
        lblItemPacking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblItemPacking.setDoubleBuffered(true);
        lblItemPacking.setFocusable(false);
        lblItemPacking.setForeground(Color.WHITE);
        lblItemPacking.setFont(new Font("Arial", Font.BOLD, 18));
        lblItemPacking.setBackground(Color.WHITE);
        lblItemPacking.setBounds(545, 415, 163, 24);
        add(lblItemPacking);

        JLabel lblAddStock = new JLabel(" + ADD STOCK");
        lblAddStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblAddStock.setDoubleBuffered(true);
        lblAddStock.setFocusable(false);
        lblAddStock.setForeground(Color.WHITE);
        lblAddStock.setFont(new Font("Arial", Font.BOLD, 18));
        lblAddStock.setBackground(Color.WHITE);
        lblAddStock.setBounds(294, 415, 216, 24);
        add(lblAddStock);
        
        

        JButton btnViewStock = new JButton("");
        btnViewStock.setDefaultCapable(false);
        btnViewStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnViewStock.setFocusPainted(false);
        btnViewStock.setRolloverEnabled(false);
        btnViewStock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchToPanel("ViewStockPanel"); 
            }
        });
        try {
            URL imageUrl = new URL("https://images2.imgbox.com/02/f5/rZSzbZBk_o.png");
            Image image = ImageIO.read(imageUrl);
            ImageIcon icon = new ImageIcon(image.getScaledInstance(65, 74, Image.SCALE_SMOOTH));
            btnViewStock.setIcon(icon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        btnViewStock.setBorder(null);
        btnViewStock.setBackground(new Color(0, 128, 255));
        btnViewStock.setBounds(43, 233, 211, 205);
        add(btnViewStock);
        

        JButton btnChangeCalculator = new JButton("");
        btnChangeCalculator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchToPanel("AddStockPanel"); 
            }
        });
        
        btnChangeCalculator.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnChangeCalculator.setFocusPainted(false);
        btnChangeCalculator.setRolloverEnabled(false);
        try {
            URL imageUrlCalculator = new URL("https://images2.imgbox.com/11/ec/77cTVSDV_o.png");
            Image imageCalculator = ImageIO.read(imageUrlCalculator);
            ImageIcon iconCalculator = new ImageIcon(imageCalculator.getScaledInstance(74, 74, Image.SCALE_SMOOTH));
            btnChangeCalculator.setIcon(iconCalculator);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        btnChangeCalculator.setBorder(null);
        btnChangeCalculator.setBackground(new Color(0, 128, 255));
        btnChangeCalculator.setBounds(294, 233, 211, 205);
        add(btnChangeCalculator);

        JButton btnDeleteStock = new JButton("");
        btnDeleteStock.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnDeleteStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteStock.setFocusPainted(false);
        btnDeleteStock.setRolloverEnabled(false);
        try {
            URL imageUrlPacking = new URL("https://images2.imgbox.com/8e/c0/2QCRjHc6_o.png");
            Image imagePacking = ImageIO.read(imageUrlPacking);
            ImageIcon iconPacking = new ImageIcon(imagePacking.getScaledInstance(86, 86, Image.SCALE_SMOOTH));
            btnDeleteStock.setIcon(iconPacking);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        btnDeleteStock.setBorder(null);
        btnDeleteStock.setBackground(new Color(0, 128, 255));
        btnDeleteStock.setBounds(545, 233, 211, 205);
        add(btnDeleteStock);
        
        btnDeleteStock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchToPanel("DeleteStockPanel"); 
            }
        });
        
    
        
   
    }
}