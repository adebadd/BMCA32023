import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.border.LineBorder;

public class BasketPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextField tfVatRate;
    private JTextField tfPrice;
    private JTextField tfQuantity;
    private JTextArea taCostBreakdown;
    private static final int LUXURY_VAT = 20;
    private static final double LUXURY_PRICE = 50.00;
    private static final int GIFT_VAT = 5;
    private static final double GIFT_PRICE = 20.00;
    private static final int ESSENTIAL_VAT = 10;
    private static final double ESSENTIAL_PRICE = 30.00;
    private double totalCost = 0.0;
    JButton btnCheckout = new JButton("CHECKOUT");
    JComboBox<String> cbItem = new JComboBox<>();

    public BasketPanel(MainFrame mainFrame) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JLabel lblvat = new JLabel("The VAT rate (%):");
        lblvat.setForeground(new Color(0, 128, 255));
        lblvat.setFont(new Font("Arial", Font.BOLD, 20));
        lblvat.setBounds(55, 206, 264, 31);
        add(lblvat);

        JLabel lblSelectItem = new JLabel("Select an item:");
        lblSelectItem.setForeground(new Color(0, 128, 255));
        lblSelectItem.setFont(new Font("Arial", Font.BOLD, 20));
        lblSelectItem.setBounds(55, 119, 264, 31);
        add(lblSelectItem);

        
        cbItem.addItem("Luxury");
        cbItem.addItem("Essential");
        cbItem.addItem("Gift");
        cbItem.setForeground(new Color(0, 128, 255));
        cbItem.setFont(new Font("Arial", Font.BOLD, 20));
        cbItem.setBorder(new LineBorder(new Color(0, 128, 255), 2));
        cbItem.setBounds(55, 149, 264, 51);
        add(cbItem);

        cbItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFieldsBasedOnSelection((String) cbItem.getSelectedItem());
            }
        });

        tfVatRate = new JTextField();
        tfVatRate.setEditable(false); 
        tfVatRate.setForeground(new Color(0, 128, 255));
        tfVatRate.setFont(new Font("Arial", Font.BOLD, 20));
        tfVatRate.setColumns(10);
        tfVatRate.setBorder(new LineBorder(new Color(0, 128, 255), 2));
        tfVatRate.setBackground(Color.WHITE);
        tfVatRate.setBounds(55, 238, 264, 51);
        add(tfVatRate);

        tfPrice = new JTextField();
        tfPrice.setEditable(false); 
        tfPrice.setForeground(new Color(0, 128, 255));
        tfPrice.setFont(new Font("Arial", Font.BOLD, 20));
        tfPrice.setColumns(10);	
        tfPrice.setBorder(new LineBorder(new Color(0, 128, 255), 2));
        tfPrice.setBackground(Color.WHITE);
        tfPrice.setBounds(55, 331, 264, 51);
        add(tfPrice);

        JLabel lblprice = new JLabel("Price (€) per item:");
        lblprice.setForeground(new Color(0, 128, 255));
        lblprice.setFont(new Font("Arial", Font.BOLD, 20));
        lblprice.setBounds(55, 299, 240, 31);
        add(lblprice);

        tfQuantity = new JTextField();
        
        tfQuantity.setForeground(new Color(0, 128, 255));
        tfQuantity.setFont(new Font("Arial", Font.BOLD, 20));
        tfQuantity.setColumns(10);
        tfQuantity.setBorder(new LineBorder(new Color(0, 128, 255), 2));
        tfQuantity.setBackground(Color.WHITE);
        tfQuantity.setBounds(55, 424, 264, 51);
        add(tfQuantity);

        JLabel lblquantity = new JLabel("Quantity:");
        lblquantity.setForeground(new Color(0, 128, 255));
        lblquantity.setFont(new Font("Arial", Font.BOLD, 20));
        lblquantity.setBounds(55, 392, 115, 31);
        add(lblquantity);

        JButton btnAddToBasket = new JButton("ADD TO BASKET");
        btnAddToBasket.setForeground(Color.WHITE);
        btnAddToBasket.setFont(new Font("Arial", Font.BOLD, 20));
        btnAddToBasket.setBorder(null);
        btnAddToBasket.setBackground(new Color(0, 128, 255));
        btnAddToBasket.setActionCommand("AddNewStock");
        btnAddToBasket.setBounds(87, 499, 250, 43);
        add(btnAddToBasket);

       
        
        btnCheckout.setForeground(new Color(0, 128, 255));
        btnCheckout.setFont(new Font("Arial", Font.BOLD, 20));
        btnCheckout.setBorder(new LineBorder(new Color(0, 128, 255), 3));
        btnCheckout.setBackground(new Color(255, 255, 255));
        btnCheckout.setActionCommand("AddNewStock");
        btnCheckout.setBounds(433, 499, 250, 43);
        btnCheckout.setEnabled(false);
        add(btnCheckout);

        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mainFrame != null) {
                	
                    mainFrame.setTotalCost(totalCost); // Set the total cost
                    mainFrame.switchToChangeCalculatorPanel(); // Switch to ChangeCalculatorPanel
                    resetBasketPanel();
                }
            }
        });

        taCostBreakdown = new JTextArea();
        taCostBreakdown.setEditable(false); 
        taCostBreakdown.setBorder(new LineBorder(new Color(0, 128, 255), 2));
        taCostBreakdown.setFont(new Font("Arial", Font.BOLD, 20));
        JScrollPane scrollPane = new JScrollPane(taCostBreakdown);
        scrollPane.setBorder(new LineBorder(new Color(0, 128, 255)));
        scrollPane.setBounds(329, 149, 414, 326);
        add(scrollPane);
        
        JLabel lblBasket = new JLabel("Current Items in basket:");
        lblBasket.setForeground(new Color(0, 128, 255));
        lblBasket.setFont(new Font("Arial", Font.BOLD, 20));
        lblBasket.setBounds(329, 119, 264, 31);
        add(lblBasket);

        btnAddToBasket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToBasket();
            }
        });

        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.switchToPanel("HomePanel");
                resetBasketPanel();
                btnCheckout.setEnabled(false);
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

    	private void addToBasket() {
    	    try {
    	        int vatRate = Integer.parseInt(tfVatRate.getText());
    	        double price = Double.parseDouble(tfPrice.getText());
    	        int quantity = Integer.parseInt(tfQuantity.getText());
    	        double vat = vatRate / 100.0;
    	        double cost = price * quantity * (1 + vat);
    	        totalCost += cost;

    	        String itemDetails = "Item Type: " + (String) cbItem.getSelectedItem() + "\n" +
    	                "VAT Rate: " + vatRate + "%\n" +
    	                "Price per Item: €" + price + "\n" +
    	                "Quantity: " + quantity + "\n" +
    	                "-------------------------------------\n";

    	        String currentText = taCostBreakdown.getText();
    	        int totalCostIndex = currentText.lastIndexOf("Total Cost:");
    	        if (totalCostIndex != -1) {
    	          
    	            currentText = currentText.substring(0, totalCostIndex);
    	        }

    	 
    	        currentText += itemDetails;
    	        currentText += "Total Cost: €" + String.format("%.2f", totalCost) + "\n\n";

    	        taCostBreakdown.setText(currentText);

    	       
    	        cbItem.setSelectedIndex(-1);
    	        tfVatRate.setText("");
    	        tfPrice.setText("");
    	        tfQuantity.setText("");
    	        tfVatRate.setEditable(false);
    	        tfPrice.setEditable(false);
    	        tfVatRate.setEditable(false);
    	        btnCheckout.setEnabled(true);
            } catch (NumberFormatException ex) {
    	        JOptionPane.showMessageDialog(mainFrame, "VAT rate, Price, and Quantity must be integers", "Input Error", JOptionPane.ERROR_MESSAGE);
    	    }
    	    if (mainFrame != null) {
                mainFrame.setTotalCost(totalCost);
            }
        }

    	private void updateFieldsBasedOnSelection(String selectedItem) {
    	    if (selectedItem == null) {
    	        tfVatRate.setText("");
    	        tfPrice.setText("");
    	        tfVatRate.setEditable(false);
    	        tfPrice.setEditable(false);
    	        return;
    	    }
    	    switch (selectedItem) {
    	        case "Luxury":
    	        	
    	            tfVatRate.setText(String.valueOf(LUXURY_VAT));
    	            tfPrice.setText(String.format("%.2f", LUXURY_PRICE));
    	            tfVatRate.setEditable(false);
    	            tfPrice.setEditable(false);
    	            break;
    	        case "Gift":
    	            tfVatRate.setText(String.valueOf(GIFT_VAT));
    	            tfPrice.setText(String.format("%.2f", GIFT_PRICE));
    	            tfVatRate.setEditable(false);
    	            tfPrice.setEditable(false);
    	            break;
    	        case "Essential":
    	            tfVatRate.setText(String.valueOf(ESSENTIAL_VAT));
    	            tfPrice.setText(String.format("%.2f", ESSENTIAL_PRICE));
    	            tfVatRate.setEditable(false);
    	            tfPrice.setEditable(false);
    	            break;
    	    }
    	    tfVatRate.setEditable(true);
    	    tfPrice.setEditable(true);
    	}

    	private void resetBasketPanel() {
    	    tfVatRate.setText("");
    	    tfPrice.setText("");
    	    tfQuantity.setText("");
    	    taCostBreakdown.setText("");
    	    cbItem.setSelectedIndex(-1);
    	    tfVatRate.setEditable(false);
    	    tfPrice.setEditable(false);
    	    btnCheckout.setEnabled(false);
    	    totalCost = 0.0;
    	}
}