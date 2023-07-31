import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FactoryView {
    private JFrame mainFrame;
    private JLabel menuLabel;
    private JPanel btnPanel;

    public JPanel getCardPanel() {
        return cardPanel;
    }

    private JPanel cardPanel;

    //Main Menu Panels
    private JPanel startProgramPanel, showInventoryPanel, customizeVMPanel, customizeMoneyPanel, customizeStocksPanel;

    //Customize Item Stock Components
    private JPanel createItemStockPanel, addItemStockPanel, showItemStockPanel;

    private JLabel itemNamelbl, calorieslbl, stockslbl, SRPlbl, itemNumberlbl, addItemlbl;

    private JButton createStockBtn;
    private JTextField itemNameTf, caloriesTf, stocksTf, SRPtf, addItemTf, numItemTf, showItemTf;
    private JTextArea itemsTa; //TextArea for showing the items

    public String getItemNameTf() {
        return this.itemNameTf.getText();
    }

    public String getCaloriesTf() {
        return this.caloriesTf.getText();
    }

    public String getStocksTf() {
        return this.stocksTf.getText();
    }

    public String getSRPtf() {
        return this.SRPtf.getText();
    }

    //
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    private CardLayout cardLayout;
    private JButton backBtn1, backBtn2, backBtn3, backBtn4, backBtn5, backBtn6, backBtn7;

    //Buttons for the Main Menu
    private JButton startProgramBtn, showInventoryBtn, customizeVmBtn, customizeMoneyBtn, customizeStocksBtn;

    //Buttons for the Main Program

    private JButton buyFromVmBtn, doMaintenanceBtn, selectWalletBtn, showCurrentWalletBtn;

    //Buttons for the Vending Machine
    private JButton createVMBtn, showDetailsBtn, showVMBtn;

    //Buttons for the Customize Money Menu
    private JButton createMoneyBtn, showMoneyBtn;

    //Buttons for the Customize Item Stock Menu

    private JButton createItemBtn, addItemBtn, showItemBtn;

    public JTextArea getShowInventoryText() {
        return showInventoryText;
    }
    private JScrollPane scrollPane;
    private JTextArea showInventoryText;
    private ArrayList<JButton> btnList, backBtnList, mainProgramBtnList, stocksBtnList, moneyBtnList, vendingMachineBtnList;

    public FactoryView() {
        this.btnPanel = new JPanel();
        this.btnPanel.setLayout(cardLayout);
        btnPanel.setLayout(new GridLayout(10,1));
        this.cardPanel = new JPanel();
        this.cardLayout = new CardLayout();
        this.cardPanel.setLayout(cardLayout);
        this.mainFrame = new JFrame("Vending Machine Factory");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(350, 400);
        this.mainFrame.add(cardPanel);

        setButtonsList();
        setBackButtons();

        setStartProgramPanel();
        setCustomizeVMPanel();
        //Stocks Panel
        setCustomizeStocksPanel();
        setCreateItemStockPanel();
        setAddItemStockPanel();
        //Money Panel
        setCustomizeMoneyPanel();
        setShowInventoryPanel();

        setButtons();
        this.mainFrame.setVisible(true);
    }

    public void setButtonsList() {
        this.btnList = new ArrayList<JButton>();
        this.backBtnList = new ArrayList<JButton>();
        this.stocksBtnList = new ArrayList<JButton>();
        this.moneyBtnList = new ArrayList<JButton>();
        this.vendingMachineBtnList = new ArrayList<JButton>();
        this.mainProgramBtnList = new ArrayList<JButton>();
    }

    public void setBackButtons(){
        this.backBtn1 = new JButton("Back");
        this.backBtn2 = new JButton("Back");
        this.backBtn3 = new JButton("Back");
        this.backBtn4 = new JButton("Back");
        this.backBtn5 = new JButton("Back");
        this.backBtn6 = new JButton("Back");
        this.backBtn7 = new JButton("Back");
        backBtnList.add(this.backBtn1);
        backBtnList.add(this.backBtn2);
        backBtnList.add(this.backBtn3);
        backBtnList.add(this.backBtn4);
        backBtnList.add(this.backBtn5);
        backBtnList.add(this.backBtn6);
        backBtnList.add(this.backBtn7);
        backBtn1.addActionListener(new ActionListener() { //Back button for Main Program to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel);
            }
        });

        backBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {cardLayout.show(cardPanel,"Main Menu");}
        });

        backBtn3.addActionListener(new ActionListener() {//Back button for Customize Money to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {cardLayout.show(cardPanel,"Main Menu");}
        });
        backBtn4.addActionListener(new ActionListener() { //Back button for Main Program to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu");
            }
        });

        backBtn5.addActionListener(new ActionListener() {//Back button for Item Stocks to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu");
            }
        });

        backBtn6.addActionListener(new ActionListener() {//Back button for Create Item Stock to Customize Item Stocks
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Stocks");
            }
        });

        backBtn7.addActionListener(new ActionListener() {//Back button for Create Item Stock to Customize Item Stocks
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Stocks");
            }
        });
    }

    public void setButtons(){

        //Main Menu Buttons
        this.startProgramBtn = new JButton("Start Main Program");
        btnList.add(this.startProgramBtn);
        this.customizeVmBtn = new JButton("Customize Vending Machines");
        btnList.add(this.customizeVmBtn);
        this.customizeMoneyBtn = new JButton("Customize Money");
        btnList.add(this.customizeMoneyBtn);
        this.customizeStocksBtn = new JButton("Customize Item Stocks");
        btnList.add(this.customizeStocksBtn);
        this.showInventoryBtn = new JButton("Show Inventory");
        btnList.add(this.showInventoryBtn);


        for (JButton button : btnList){
            button.setBackground(Color.pink);
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            btnPanel.add(button);
        }

        //Main Menu buttons
        cardPanel.add(btnPanel, "Main Menu");
        cardPanel.add(startProgramPanel, "Main Program");
        cardPanel.add(showInventoryPanel, "Show Inventory");
        cardPanel.add(customizeVMPanel, "Customize Vending Machine");
        cardPanel.add(customizeMoneyPanel, "Customize Money");
        cardPanel.add(customizeStocksPanel, "Customize Stocks");
        cardPanel.add(createItemStockPanel, "Create Item");
        cardPanel.add(addItemStockPanel, "Add Item");

        //Main Program Buttons
        this.buyFromVmBtn = new JButton("Buy from Vending Machine");
        mainProgramBtnList.add(buyFromVmBtn);
        this.doMaintenanceBtn = new JButton("Do Maintenance");
        mainProgramBtnList.add(doMaintenanceBtn);
        this.selectWalletBtn = new JButton("Select Wallet");
        mainProgramBtnList.add(selectWalletBtn);
        this.showCurrentWalletBtn = new JButton("Show Current Wallet");
        mainProgramBtnList.add(showCurrentWalletBtn);
        for (JButton button: mainProgramBtnList){
            button.setBackground(Color.getHSBColor(173, 216, 230));//Light Blue
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            startProgramPanel.add(button);
        }

        //Customize Vending Machine Buttons
        this.createVMBtn = new JButton("Create Vending Machine");
        vendingMachineBtnList.add(createVMBtn);
        this.showDetailsBtn = new JButton("Show Details");
        vendingMachineBtnList.add(showDetailsBtn);
        this.showVMBtn = new JButton("Show Vending Machines");
        vendingMachineBtnList.add(showVMBtn);
        for (JButton button: vendingMachineBtnList){
            button.setBackground(Color.getHSBColor(173, 216, 230));//Light Blue
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            customizeVMPanel.add(button);
        }

        //Customize Money Buttons
        this.createMoneyBtn = new JButton("Create New Money");
        moneyBtnList.add(createMoneyBtn);
        this.showMoneyBtn = new JButton("Show All Money");
        moneyBtnList.add(showMoneyBtn);
        for (JButton button: moneyBtnList){
            button.setBackground(Color.getHSBColor(173, 216, 230));//Light Blue
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            customizeMoneyPanel.add(button);
        }

        //Customize Stocks Buttons
        this.createItemBtn = new JButton("Create Item Stock");
        stocksBtnList.add(createItemBtn);
        this.addItemBtn = new JButton("Add Item Stock");
        stocksBtnList.add(addItemBtn);
        this.showItemBtn = new JButton("Show Item Stocks");
        stocksBtnList.add(showItemBtn);

        for (JButton button : stocksBtnList){
            button.setBackground(Color.getHSBColor(173, 216, 230));//Light Blue
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            customizeStocksPanel.add(button);
        }
    }

    public void setStartProgramPanel(){
        this.startProgramPanel = new JPanel(cardLayout);
        startProgramPanel.setLayout(new GridLayout(5, 1));
        startProgramPanel.add(backBtn1);
        startProgramPanel.setBackground(Color.pink);
    }

    public void setCustomizeVMPanel(){
        this.customizeVMPanel = new JPanel(cardLayout);
        customizeVMPanel.setLayout(new GridLayout(4,1));
        customizeVMPanel.setBackground(Color.red);
        customizeVMPanel.add(backBtn2);
    }

    public void setCustomizeMoneyPanel(){
        this.customizeMoneyPanel = new JPanel(cardLayout);
        customizeMoneyPanel.setLayout(new GridLayout(3,1));
        customizeMoneyPanel.setBackground(Color.CYAN);
        customizeMoneyPanel.add(backBtn3);
    }

    public void setCustomizeStocksPanel(){
        this.customizeStocksPanel = new JPanel(cardLayout);
        customizeStocksPanel.setLayout(new GridLayout(4,1));
        customizeStocksPanel.setBackground(Color.orange);
        customizeStocksPanel.add(backBtn5);
    }

    public void setCreateItemStockPanel(){
        this.createItemStockPanel = new JPanel(cardLayout);
        createItemStockPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        this.itemNamelbl = new JLabel("Item Name: ");
        gbc.gridx = 0; gbc.gridy = 0; createItemStockPanel.add(itemNamelbl, gbc);
        this.calorieslbl = new JLabel("Calories: ");
        gbc.gridx = 0; gbc.gridy = 1; createItemStockPanel.add(calorieslbl, gbc);
        this.stockslbl = new JLabel("Stocks: ");
        gbc.gridx = 0; gbc.gridy = 2; createItemStockPanel.add(stockslbl, gbc);
        this.SRPlbl = new JLabel("SRP: ");
        gbc.gridx = 0; gbc.gridy = 3; createItemStockPanel.add(SRPlbl, gbc);
        this.itemNameTf = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 0; createItemStockPanel.add(itemNameTf, gbc);
        this.caloriesTf = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 1; createItemStockPanel.add(caloriesTf, gbc);
        this.stocksTf = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 2; createItemStockPanel.add(stocksTf, gbc);
        this.SRPtf = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 3; createItemStockPanel.add(SRPtf, gbc);
        this.createStockBtn = new JButton("Create Item");
        gbc.gridx = 0; gbc.gridy = 4; createItemStockPanel.add(createStockBtn);
        gbc.gridx = 1; gbc.gridy = 4; createItemStockPanel.add(backBtn6);
        createItemStockPanel.setBackground(Color.getHSBColor(21, 79, 94));
    }

    public void setAddItemStockPanel(){
        this.addItemStockPanel = new JPanel(cardLayout);
        addItemStockPanel.setLayout(new FlowLayout());
        //GridBagConstraints gbc = new GridBagConstraints();
        this.addItemTf = new JTextField(10);
        this.addItemBtn = new JButton("Add Item");
        this.itemsTa = new JTextArea();
        itemsTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.addItemStockPanel.add(scrollPane);
        this.addItemStockPanel.add(addItemTf);
        this.addItemStockPanel.add(addItemBtn);
        this.addItemStockPanel.add(backBtn7);
        addItemStockPanel.setBackground(Color.getHSBColor(10,9, 94));
    }
    public void hideButtons(ArrayList<JButton> buttons){
        for (JButton button : buttons){
            button.setVisible(false);
        }
    }

    public void showButtons(ArrayList<JButton> buttons){
        for (JButton button : buttons){
            button.setVisible(true);
        }
    }
    public void setShowInventoryPanel(){
        this.showInventoryPanel = new JPanel(cardLayout);
        showInventoryPanel.setLayout(new GridLayout(2,1));
        showInventoryPanel.setBackground(Color.darkGray);
        this.showInventoryText = new JTextArea();
        this.showInventoryText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(showInventoryText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        showInventoryPanel.add(backBtn4);
        showInventoryPanel.add(scrollPane);
    }

    //Setters for Main Menu Buttons
    public void setStartProgramBtn(ActionListener actionListener){this.startProgramBtn.addActionListener(actionListener);}
    public void setCustomizeVMBtnListener(ActionListener actionListener){this.customizeVmBtn.addActionListener(actionListener);}
    public void setCustomizeMoneyBtnListener(ActionListener actionListener){this.customizeMoneyBtn.addActionListener(actionListener);}
    public void setCustomizeStocksBtnListener(ActionListener actionListener){this.customizeStocksBtn.addActionListener(actionListener);}

    public void setShowInventoryBtnListener(ActionListener actionListener){this.showInventoryBtn.addActionListener(actionListener);}

    //Setter for Item Stock Buttons

    public void setCreateItemBtnListener(ActionListener actionListener){this.createItemBtn.addActionListener(actionListener);}
    public void setCreateStockBtnListener(ActionListener actionListener){this.createStockBtn.addActionListener(actionListener);}
    public void setAddItemBtnListener(ActionListener actionListener){this.addItemBtn.addActionListener(actionListener);}
}
