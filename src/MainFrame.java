import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private RegisterPanel registerPanel;
    private LoginPanel loginPanel;
    private HomePanel homePanel;
    private ProfilePanel profilePanel;
    private StockControlPanel stockControlPanel;
    private AddStockPanel addStockPanel;
    private ViewStockPanel viewStockPanel;
    private DeleteStockPanel deleteStockPanel;
    private ItemPackingPanel itemPackingPanel;
    private ItemPackedPanel itemPackedPanel;
    private BasketPanel basketPanel;
    private ChangeCalculatorPanel changeCalculatorPanel;
    private ArrayList<User> userList;
    private ArrayList<Item> itemsList; 
    private String weight;
    private String dimensions;
    private String numberOfItems;
    private String itemSize;
    private int totalPackages;
    private double totalCost;
    
    public MainFrame() {
        setResizable(false);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
       
        
        userList = new ArrayList<>();
        itemsList = new ArrayList<>(); 
        registerPanel = new RegisterPanel(this, userList);
        loginPanel = new LoginPanel(this, userList);
        homePanel = new HomePanel(this);
        profilePanel = new ProfilePanel(this);
        stockControlPanel = new StockControlPanel(this);
        addStockPanel = new AddStockPanel(this, itemsList); 
        viewStockPanel = new ViewStockPanel(this, itemsList);
        deleteStockPanel = new DeleteStockPanel(this, itemsList);
        itemPackingPanel = new ItemPackingPanel(this);
        basketPanel = new BasketPanel(this);
        changeCalculatorPanel = new ChangeCalculatorPanel(this);
 
        
        mainPanel.add(registerPanel, "RegisterPanel");
        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(profilePanel, "ProfilePanel");
        mainPanel.add(homePanel, "HomePanel");
        mainPanel.add(stockControlPanel, "StockControlPanel");
        mainPanel.add(addStockPanel, "AddStockPanel");
        mainPanel.add(viewStockPanel, "ViewStockPanel");
        mainPanel.add(deleteStockPanel, "DeleteStockPanel");
        mainPanel.add(itemPackingPanel, "ItemPackingPanel");
        mainPanel.add(basketPanel, "BasketPanel");
        mainPanel.add(changeCalculatorPanel, "ChangeCalculatorPanel");


        getContentPane().add(mainPanel);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setPackingDetails(String weight, String dimensions, String numberOfItems) {
        this.weight = weight;
        this.dimensions = dimensions;
        this.numberOfItems = numberOfItems;
    }

    public void switchToPanel(String panelName) {
        if (panelName.equals("ViewStockPanel")) {
            viewStockPanel.refreshTable();
        }
        if (panelName.equals("DeleteStockPanel")) {
            deleteStockPanel.refreshTable();
        }

        cardLayout.show(mainPanel, panelName);
    }
    
    public void switchToChangeCalculatorPanel() {
        changeCalculatorPanel.updateItemCost(); // Update the total cost
        cardLayout.show(mainPanel, "ChangeCalculatorPanel"); // Switch to the ChangeCalculatorPanel
    }


    public void setPackingDetails(String weight, String dimensions, String numberOfItems, String itemSize, int totalPackages) {
        this.weight = weight;
        this.dimensions = dimensions;
        this.numberOfItems = numberOfItems;
        this.itemSize = itemSize;
        this.totalPackages = totalPackages;
    }
    
    public void switchToItemPackedPanel() {
        itemPackedPanel = new ItemPackedPanel(this, weight, dimensions, numberOfItems, itemSize, totalPackages);
        mainPanel.add(itemPackedPanel, "ItemPackedPanel"); 
        cardLayout.show(mainPanel, "ItemPackedPanel");
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalCost() {
        return this.totalCost;
    }
    
    

    public static void main(String[] args) {
        new MainFrame();
    }
    
}