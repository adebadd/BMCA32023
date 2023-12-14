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
import javax.swing.table.DefaultTableModel;

public class ViewStockPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextField tfItemName;
    private JTextField tfExpirationDate;
    private ArrayList<Item> itemsList;
    private JTable allItemsTable;

    public ViewStockPanel(MainFrame mainFrame, ArrayList<Item> itemsList) {
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
              
  
              String[] columnNames = {"Item Name", "Item Type", "Expiration Date"};
              DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
              allItemsTable = new JTable(tableModel);
              JScrollPane scrollPane = new JScrollPane(allItemsTable);
              scrollPane.setForeground(new Color(0, 128, 255));
              scrollPane.setFont(new Font("Arial", Font.BOLD, 20));
              scrollPane.setBounds(50, 100, 700, 400);
              add(scrollPane);
      
            
          
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.switchToPanel("StockControlPanel"); // Switch to Home Panel
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
    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) allItemsTable.getModel();
        model.setRowCount(0); // Clear existing data

        for (Item item : itemsList) {
            model.addRow(new Object[]{item.getItemName(), item.getItemOption(), item.getExpirationDate()});
        }
    }
}