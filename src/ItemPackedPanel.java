import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ItemPackedPanel extends JPanel {
    private MainFrame mainFrame;

    public ItemPackedPanel(MainFrame mainFrame, String weight, String dimensions, String numberOfItems, String itemSize, int totalPackages) {
        this.mainFrame = mainFrame;

    	  
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(0, 128, 255));
        
        try {
          
            
        
              JLabel lblBox = new JLabel("");
              lblBox.setBounds(398, 174, 373, 274);
              add(lblBox);
              
              URL lblBoxURL = new URL("https://images2.imgbox.com/7e/2f/Tl5jWj1I_o.png");
              Image boxImage = ImageIO.read(lblBoxURL);
              ImageIcon boxIcon = new ImageIcon(boxImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH));
              lblBox.setIcon(boxIcon);
              
              JLabel lblWeight = new JLabel();
              lblWeight.setText("Item weight: " + weight + " KG");
              lblWeight.setForeground(new Color(255, 255, 255));
              lblWeight.setFont(new Font("Arial", Font.PLAIN, 25));
              lblWeight.setBounds(43, 210, 499, 31);
              add(lblWeight);
              
              JLabel lblDimensions = new JLabel();
              lblDimensions.setText("Dimensions: " + dimensions);
              lblDimensions.setForeground(Color.WHITE);
              lblDimensions.setFont(new Font("Arial", Font.PLAIN, 25));
              lblDimensions.setBounds(43, 270, 499, 31);
              add(lblDimensions);
              
              JLabel lblNumberOfItems = new JLabel("Number of items: " + numberOfItems);
              lblNumberOfItems.setForeground(Color.WHITE);
              lblNumberOfItems.setFont(new Font("Arial", Font.PLAIN, 25));
              lblNumberOfItems.setBounds(43, 330, 499, 31);
              add(lblNumberOfItems);
              

              JLabel lblRequirment = new JLabel();
              String packageText = totalPackages == 1 ? " box" : " boxes";
              lblRequirment.setText("You require " + totalPackages + packageText);
              lblRequirment.setForeground(Color.WHITE);
              lblRequirment.setFont(new Font("Arial", Font.BOLD, 30));
              lblRequirment.setBounds(43, 370, 499, 36);
              add(lblRequirment);

              
              JLabel lblWeightCat = new JLabel();
              lblWeightCat.setText("Weight Category: " + itemSize);
              lblWeightCat.setForeground(Color.WHITE);
              lblWeightCat.setFont(new Font("Arial", Font.PLAIN, 25));
              lblWeightCat.setBounds(43, 240, 499, 31);
              add(lblWeightCat);
              
              JPanel panel = new JPanel();
              panel.setLayout(null);
              panel.setBackground(new Color(0, 128, 255));
              panel.setBounds(0, 0, 800, 85);
              add(panel);
              
              JLabel lblBack = new JLabel("");
              lblBack.setBounds(30, 19, 32, 56);
              panel.add(lblBack);
              URL profileImageUrl = new URL("https://images2.imgbox.com/40/5d/mYEhCmUo_o.png");
              Image profileImage = ImageIO.read(profileImageUrl);
              ImageIcon profileIcon = new ImageIcon(profileImage.getScaledInstance(25, 35, Image.SCALE_SMOOTH));
              lblBack.setIcon(profileIcon);
              lblBack.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseClicked(MouseEvent e) {
                      mainFrame.switchToPanel("ItemPackingPanel");
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
       
      
        
    
        
   
    }
}