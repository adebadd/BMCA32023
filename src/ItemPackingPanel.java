import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ItemPackingPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextField tfWeight;
    private ArrayList<Item> itemsList;
    private JTextField tfDimensions;
    private JTextField tfNumberOfItems;

    public ItemPackingPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

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
            
            tfWeight = new JTextField("(KG)");
            tfWeight.setForeground(new Color(0, 128, 255));
            tfWeight.setFont(new Font("Arial", Font.BOLD, 20));
            tfWeight.setColumns(10);
            tfWeight.setBorder(new LineBorder(new Color(0, 128, 255), 2));
            tfWeight.setBackground(new Color(255, 255, 255));
            tfWeight.setBounds(118, 167, 564, 51);
            add(tfWeight);
            
            JLabel lblItemname = new JLabel("Enter Weight:");
            lblItemname.setForeground(new Color(0, 128, 255));
            lblItemname.setFont(new Font("Arial", Font.BOLD, 20));
            lblItemname.setBounds(118, 137, 468, 31);
            add(lblItemname);
            
            JLabel lblItemType = new JLabel("Enter Dimensions:");
            lblItemType.setForeground(new Color(0, 128, 255));
            lblItemType.setFont(new Font("Arial", Font.BOLD, 20));
            lblItemType.setBounds(118, 234, 468, 31);
            add(lblItemType);
            
            JLabel lblExpirationDate = new JLabel("Enter number of items:");
            lblExpirationDate.setForeground(new Color(0, 128, 255));
            lblExpirationDate.setFont(new Font("Arial", Font.BOLD, 20));
            lblExpirationDate.setBounds(118, 338, 468, 31);
            add(lblExpirationDate);
            JButton btnCalculatePackage = new JButton("CALCULATE PACKAGE AMOUNT");
            btnCalculatePackage.setForeground(new Color(255, 255, 255));
            btnCalculatePackage.setFont(new Font("Arial", Font.BOLD, 20));
            btnCalculatePackage.setBorder(null);
            btnCalculatePackage.setBackground(new Color(0, 128, 255));
            btnCalculatePackage.setActionCommand("AddNewStock");
            btnCalculatePackage.setBounds(201, 465, 398, 62);
            add(btnCalculatePackage);
            
            btnCalculatePackage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String weight = tfWeight.getText();
                    String dimensions = tfDimensions.getText();
                    String numberOfItems = tfNumberOfItems.getText();

                    if (!isNumeric(weight)) {
                        JOptionPane.showMessageDialog(ItemPackingPanel.this, "Weight must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!dimensions.matches("\\d{2}x\\d{2}")) {
                        JOptionPane.showMessageDialog(ItemPackingPanel.this, "Dimensions must be in the format 00x00.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!isNumeric(numberOfItems)) {
                        JOptionPane.showMessageDialog(ItemPackingPanel.this, "Number of items must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String itemSize = determineItemSize(dimensions);
                    int totalPackages = calculatePackageAmount(Double.parseDouble(weight), Integer.parseInt(numberOfItems));

                    mainFrame.setPackingDetails(weight, dimensions, numberOfItems, itemSize, totalPackages);
                    mainFrame.switchToItemPackedPanel();
                }
            });
            
            
            tfDimensions = new JTextField("00x00");
            tfDimensions.setForeground(new Color(0, 128, 255));
            tfDimensions.setFont(new Font("Arial", Font.BOLD, 20));
            tfDimensions.setColumns(10);
            tfDimensions.setBorder(new LineBorder(new Color(0, 128, 255), 2));
            tfDimensions.setBackground(Color.WHITE);
            tfDimensions.setBounds(118, 264, 564, 51);
            add(tfDimensions);
            
            tfNumberOfItems = new JTextField("#");
            tfNumberOfItems.setForeground(new Color(0, 128, 255));
            tfNumberOfItems.setFont(new Font("Arial", Font.BOLD, 20));
            tfNumberOfItems.setColumns(10);
            tfNumberOfItems.setBorder(new LineBorder(new Color(0, 128, 255), 2));
            tfNumberOfItems.setBackground(Color.WHITE);
            tfNumberOfItems.setBounds(118, 370, 564, 51);
            add(tfNumberOfItems);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.switchToPanel("HomePanel");
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
        
        FocusListener clearTextListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                source.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
              
            }
        };

        tfWeight.addFocusListener(clearTextListener);
        tfDimensions.addFocusListener(clearTextListener);
        tfNumberOfItems.addFocusListener(clearTextListener);
      
        
    
        
   
    }
    
    private String determineItemSize(String dimensions) {
        String[] parts = dimensions.split("x");
        int width = Integer.parseInt(parts[0]);
        int height = Integer.parseInt(parts[1]);

        if (width < 10 && height < 10) {
            return "Small";
        } else if (width < 20 && height < 20) {
            return "Medium";
        } else {
            return "Large";
        }
    }

    private int calculatePackageAmount(double totalWeight, int totalItems) {
        final int MAX_ITEMS_PER_BOX = 10;
        final double MAX_WEIGHT_PER_BOX = 20;

        int totalPackages = 0;

        while (totalItems > 0 || totalWeight > 0) {
            totalPackages++;

            if (totalItems > MAX_ITEMS_PER_BOX) {
                totalItems -= MAX_ITEMS_PER_BOX;
            } else {
                totalItems = 0;
            }

            if (totalWeight > MAX_WEIGHT_PER_BOX) {
                totalWeight -= MAX_WEIGHT_PER_BOX;
            } else {
                totalWeight = 0;
            }
        }

        return totalPackages;
    }



    
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    
}