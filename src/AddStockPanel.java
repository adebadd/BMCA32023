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

public class AddStockPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextField tfItemName;
    private JTextField tfExpirationDate;
    private ArrayList<Item> itemsList;

    public AddStockPanel(MainFrame mainFrame, ArrayList<Item> itemsList) {
        this.mainFrame = mainFrame;
        this.itemsList = itemsList; 
    	  
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
            
            tfItemName = new JTextField();
            tfItemName.setForeground(new Color(0, 128, 255));
            tfItemName.setFont(new Font("Arial", Font.BOLD, 20));
            tfItemName.setColumns(10);
            tfItemName.setBorder(new LineBorder(new Color(0, 128, 255), 2));
            tfItemName.setBackground(new Color(255, 255, 255));
            tfItemName.setBounds(118, 167, 564, 51);
            add(tfItemName);
            
            JLabel lblItemname = new JLabel("Item Name:");
            lblItemname.setForeground(new Color(0, 128, 255));
            lblItemname.setFont(new Font("Arial", Font.BOLD, 20));
            lblItemname.setBounds(118, 137, 468, 31);
            add(lblItemname);
            
            JLabel lblItemType = new JLabel("Item Type:");
            lblItemType.setForeground(new Color(0, 128, 255));
            lblItemType.setFont(new Font("Arial", Font.BOLD, 20));
            lblItemType.setBounds(118, 234, 468, 31);
            add(lblItemType);
            
            JComboBox<String> cbItemType = new JComboBox<>();
            cbItemType.addItem("Luxury");
            cbItemType.addItem("Essential");
            cbItemType.addItem("Gift");
            cbItemType.setBorder(new LineBorder(new Color(0, 128, 255), 2));
            cbItemType.setForeground(new Color(0, 128, 255));
            cbItemType.setFont(new Font("Arial", Font.BOLD, 20));
            cbItemType.setBounds(118, 264, 564, 51);
            add(cbItemType);
            
            JLabel lblExpirationDate = new JLabel("Expiration Date:");
            lblExpirationDate.setForeground(new Color(0, 128, 255));
            lblExpirationDate.setFont(new Font("Arial", Font.BOLD, 20));
            lblExpirationDate.setBounds(118, 338, 468, 31);
            add(lblExpirationDate);
            
            
            
            tfExpirationDate = new JTextField("--/--/----");
            tfExpirationDate.setForeground(new Color(0, 128, 255));
            tfExpirationDate.setFont(new Font("Arial", Font.BOLD, 20));
            tfExpirationDate.setColumns(10);
            tfExpirationDate.setBorder(new LineBorder(new Color(0, 128, 255), 2));
            tfExpirationDate.setBackground(Color.WHITE);
            tfExpirationDate.setBounds(118, 369, 564, 51);
            add(tfExpirationDate);

        
            tfExpirationDate.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    formatAndSetDate();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    formatAndSetDate();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    formatAndSetDate();
                }

                private void formatAndSetDate() {
                    SwingUtilities.invokeLater(() -> {
                        String text = tfExpirationDate.getText();
                        String formattedText = formatAsDate(text);
                        if (!formattedText.equals(text)) {
                            tfExpirationDate.setText(formattedText);
                        }
                    });
                }

                private String formatAsDate(String text) {
                    StringBuilder formatted = new StringBuilder();
                    int length = Math.min(text.length(), 10); // Limit the length to 10 characters

                    for (int i = 0, j = 0; i < length; i++) {
                        char c = text.charAt(i);
                        if (Character.isDigit(c)) {
                            formatted.append(c);
                            j++; // Increment counter for digit characters
                            if ((j == 2 || j == 4) && i < length - 1) {
                                formatted.append("/");
                            }
                        }
                    }
                    return formatted.toString();
                }
            });
            JButton btnAddNewStock = new JButton("ADD NEW STOCK");
            btnAddNewStock.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String itemName = tfItemName.getText().trim();
                    String expirationDate = tfExpirationDate.getText().trim();
                    String itemType = (String) cbItemType.getSelectedItem();

                    if (itemName.isEmpty() || expirationDate.isEmpty() || itemType == null) {
                        JOptionPane.showMessageDialog(AddStockPanel.this, "All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                     
                        Item newItem = new Item(itemName, itemType, expirationDate);
                        itemsList.add(newItem);

                      
                        tfItemName.setText("");
                        tfExpirationDate.setText("--/--/----");
                        cbItemType.setSelectedIndex(0);

                  
                        JOptionPane.showMessageDialog(AddStockPanel.this, "Item added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            btnAddNewStock.setForeground(new Color(255, 255, 255));
            btnAddNewStock.setFont(new Font("Arial", Font.BOLD, 20));
            btnAddNewStock.setBorder(null);
            btnAddNewStock.setBackground(new Color(0, 128, 255));
            btnAddNewStock.setActionCommand("AddNewStock");
            btnAddNewStock.setBounds(284, 465, 231, 62);
            add(btnAddNewStock);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.switchToPanel("StockControlPanel");
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
        
       
      
        
    
        
   
    }
}