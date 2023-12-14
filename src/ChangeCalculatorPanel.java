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

public class ChangeCalculatorPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextField tfItemCost;
    private JTextField tfCashPaid;
    private JTextArea taChange;



    public ChangeCalculatorPanel(MainFrame mainFrame) {
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
            
            tfItemCost = new JTextField();
            tfItemCost.setForeground(new Color(0, 128, 255));
            tfItemCost.setFont(new Font("Arial", Font.BOLD, 20));
            tfItemCost.setColumns(10);
            tfItemCost.setBorder(new LineBorder(new Color(0, 128, 255), 2));
            tfItemCost.setBackground(new Color(255, 255, 255));
            tfItemCost.setBounds(118, 146, 564, 51);
            add(tfItemCost);
            
            JLabel lblItemCost = new JLabel("Item Cost:");
            lblItemCost.setForeground(new Color(0, 128, 255));
            lblItemCost.setFont(new Font("Arial", Font.BOLD, 20));
            lblItemCost.setBounds(118, 116, 468, 31);
            add(lblItemCost);
            
            JLabel lblPaid = new JLabel("Cash Paid:");
            lblPaid.setForeground(new Color(0, 128, 255));
            lblPaid.setFont(new Font("Arial", Font.BOLD, 20));
            lblPaid.setBounds(118, 213, 468, 31);
            add(lblPaid);
            JButton btnCalculateChange = new JButton("CALCULATE CHANGE");
            
            btnCalculateChange.setForeground(new Color(255, 255, 255));
            btnCalculateChange.setFont(new Font("Arial", Font.BOLD, 20));
            btnCalculateChange.setBorder(null);
            btnCalculateChange.setBackground(new Color(0, 128, 255));
            btnCalculateChange.setActionCommand("AddNewStock");
            btnCalculateChange.setBounds(278, 477, 243, 62);
            add(btnCalculateChange);
            
            
            
            tfCashPaid = new JTextField();
            tfCashPaid.setForeground(new Color(0, 128, 255));
            tfCashPaid.setFont(new Font("Arial", Font.BOLD, 20));
            tfCashPaid.setColumns(10);
            tfCashPaid.setBorder(new LineBorder(new Color(0, 128, 255), 2));
            tfCashPaid.setBackground(Color.WHITE);
            tfCashPaid.setBounds(118, 247, 564, 51);
            add(tfCashPaid);
            

            JTextArea taChange = new JTextArea();
            taChange.setEditable(false);
            taChange.setBorder(new LineBorder(new Color(0, 128, 255), 2));
            taChange.setFont(new Font("Arial", Font.BOLD, 18));
            taChange.setBounds(118, 335, 564, 115);
            add(taChange);
            
            JLabel lblChangeToBeGiven = new JLabel("Change to be given:");
            lblChangeToBeGiven.setForeground(new Color(0, 128, 255));
            lblChangeToBeGiven.setFont(new Font("Arial", Font.BOLD, 20));
            lblChangeToBeGiven.setBounds(118, 308, 468, 31);
            add(lblChangeToBeGiven);
            
            btnCalculateChange.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        double itemCost = Double.parseDouble(tfItemCost.getText());
                        double cashPaid = Double.parseDouble(tfCashPaid.getText());

                        if (cashPaid < itemCost) {
                            JOptionPane.showMessageDialog(mainFrame, "Cash paid is less than the item cost.", "Error", JOptionPane.ERROR_MESSAGE);
                            taChange.setText(""); 
                        } else if (cashPaid % 1 != 0) {
                            // Check if cash paid is not a whole number
                            JOptionPane.showMessageDialog(mainFrame, "Please enter a whole number for cash paid.", "Input Error", JOptionPane.ERROR_MESSAGE);
                            taChange.setText("");
                        } else {
                            double change = cashPaid - itemCost;
                            String changeText = calculateChange(change);
                            taChange.setText(changeText);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(mainFrame, "Please enter valid numbers for item cost and cash paid.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        taChange.setText(""); 
                    }
                }
            });
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.switchToPanel("HomePanel");
                resetFields();
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
    
    private void resetFields() {
        tfItemCost.setText("");
        tfCashPaid.setText("");
        taChange.setText("");
    }
    
    private String calculateChange(double change) {
        StringBuilder sb = new StringBuilder();
        int[] notesAndCoins = {50, 20, 10, 5, 1};
        for (int value : notesAndCoins) {
            int count = (int) (change / value);
            change -= count * value;
            sb.append(count).append(" x €").append(value).append("\n");
        }
        return sb.toString();
    }
    
    public void updateItemCost() {
        if (mainFrame != null) {
            double cost = mainFrame.getTotalCost();
            tfItemCost.setText(cost > 0 ? String.format("%.2f", cost) : "");
        }
    }

}