import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The FactoryView class is the View of the MVC pattern. It is responsible for the GUI of the program.
 * It is also responsible for the creation of the buttons and the panels.
 */
public class FactoryView {
    private JFrame mainFrame;
    private JLabel menuLabel;
    private JPanel btnPanel;

    public JPanel getCardPanel() {
        return cardPanel;
    }

    private JPanel cardPanel;

    //Main Menu Panels
    private JPanel startProgramPanel, showInventoryPanel, customizeVMPanel, customizeStocksPanel;

    //Main Program Panels
    private JPanel buyFromVmPanel, doMaintenancePanel, selectWalletPanel, showCurrentWalletPanel;

    private JButton backBtn12, backBtn13, backBtn14, backBtn15;

    //Customize Vending Machine Components
    private JPanel createVMPanel, showDetailsPanel, showVMPanel;

    private JLabel nameVmLbl, numSlotsLbl, maxItemsLbl;

    private JTextField nameVmTf, numSlotsTf, maxItemsTf;

    private JLabel pickVmLbl; private JTextField pickVmTf;
    private JButton createVmBtn, pickBtn, backBtn9, backBtn10, backBtn11;

    //Customize Item Stock Components
    private JPanel createItemPanel, addItemPanel, showItemsPanel;

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
    private JButton backBtn1, backBtn2, backBtn3, backBtn4, backBtn5, backBtn6, backBtn7, backBtn8;

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
    private ArrayList<JButton> btnList, backBtnList, mainProgramBtnList, stocksBtnList, vendingMachineBtnList;

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
        setCreateItemsPanel();
        setAddItemsPanel();
        setShowItemsPanel();
        setShowInventoryPanel();
        //Customize Vending Machine Panel
        setCreateVMPanel();
        setShowDetailsPanel();
        setShowVMPanel();

        setButtons();
        this.mainFrame.setVisible(true);
    }

    public void setButtonsList() {
        this.btnList = new ArrayList<JButton>();
        this.backBtnList = new ArrayList<JButton>();
        this.stocksBtnList = new ArrayList<JButton>();
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
        this.backBtn8 = new JButton("Back");
        this.backBtn9 = new JButton("Back");
        this.backBtn10 = new JButton("Back");
        this.backBtn11 = new JButton("Back");
        this.backBtn12 = new JButton("Back");
        this.backBtn13 = new JButton("Back");
        this.backBtn14 = new JButton("Back");
        this.backBtn15 = new JButton("Back");

        backBtnList.add(this.backBtn1);backBtnList.add(this.backBtn2);backBtnList.add(this.backBtn3);
        backBtnList.add(this.backBtn4);backBtnList.add(this.backBtn5);backBtnList.add(this.backBtn6);
        backBtnList.add(this.backBtn7);backBtnList.add(this.backBtn8);backBtnList.add(this.backBtn9);
        backBtnList.add(this.backBtn10);backBtnList.add(this.backBtn11);backBtnList.add(this.backBtn12);
        backBtnList.add(this.backBtn13);backBtnList.add(this.backBtn14);backBtnList.add(this.backBtn15);
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

        backBtn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Stocks");
            }
        });

        backBtn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Vending Machine");
            }
        });

        backBtn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Vending Machine");
            }
        });

        backBtn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Vending Machine");
            }
        });
    }

    public void setButtons(){

        //Main Menu Buttons
        this.startProgramBtn = new JButton("Start Main Program");
        btnList.add(this.startProgramBtn);
        this.customizeVmBtn = new JButton("Customize Vending Machines");
        btnList.add(this.customizeVmBtn);
        this.customizeStocksBtn = new JButton("Customize Item");
        btnList.add(this.customizeStocksBtn);
        this.showInventoryBtn = new JButton("Show Inventory");
        btnList.add(this.showInventoryBtn);


        for (JButton button : btnList){
            button.setBackground(Color.pink);
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            btnPanel.add(button);
        }

        //Main Menu Panels
        cardPanel.add(btnPanel, "Main Menu");
        cardPanel.add(startProgramPanel, "Main Program");
        cardPanel.add(showInventoryPanel, "Show Inventory");
        cardPanel.add(customizeVMPanel, "Customize Vending Machine");
        cardPanel.add(customizeStocksPanel, "Customize Stocks");

        //Customize Item Panels
        cardPanel.add(createItemPanel, "Create Item");
        cardPanel.add(addItemPanel, "Add Item");
        cardPanel.add(showItemsPanel, "Show Items");

        //Customize Vending Machine Panels
        cardPanel.add(createVMPanel, "Create Vending Machine");
        cardPanel.add(showDetailsPanel, "Show Details");
        cardPanel.add(showVMPanel, "Show Vending Machines");

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

        //Customize Stocks Buttons
        this.createItemBtn = new JButton("Create Item");
        stocksBtnList.add(createItemBtn);
        this.addItemBtn = new JButton("Add Item");
        stocksBtnList.add(addItemBtn);
        this.showItemBtn = new JButton("Show Items");
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

    //Customize Vending Machine Panels

    public void setCreateVMPanel(){
        this.createVMPanel = new JPanel(cardLayout);
        createVMPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.nameVmLbl = new JLabel("Vending Machine Name: ");
        gbc.gridx = 0; gbc.gridy = 0; createVMPanel.add(nameVmLbl, gbc);
        this.numSlotsLbl = new JLabel("Number of Slots: ");
        gbc.gridx = 0; gbc.gridy = 1; createVMPanel.add(numSlotsLbl, gbc);
        this.maxItemsLbl = new JLabel("Max Items per Slot: ");
        gbc.gridx = 0; gbc.gridy = 2; createVMPanel.add(maxItemsLbl, gbc);
        this.nameVmTf = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 0; createVMPanel.add(nameVmTf, gbc);
        this.numSlotsTf = new JTextField(5);
        gbc.gridx = 1; gbc.gridy = 1; createVMPanel.add(numSlotsTf, gbc);
        this.maxItemsTf = new JTextField(5);
        gbc.gridx = 1; gbc.gridy = 2; createVMPanel.add(maxItemsTf, gbc);
        this.createVMBtn = new JButton("Create Vending Machine");
        gbc.gridx = 0; gbc.gridy = 3; createVMPanel.add(createVMBtn, gbc);
        createVMPanel.setBackground(Color.pink);
        gbc.gridx = 1; gbc.gridy = 3; createVMPanel.add(backBtn9, gbc);
    }

    public void setShowDetailsPanel(){
        this.showDetailsPanel = new JPanel(cardLayout);
        showDetailsPanel.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(itemsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.showDetailsPanel.add(scrollPane);
        this.pickBtn = new JButton("Pick");
        this.pickVmLbl = new JLabel("Pick Vending Machine:");
        this.pickVmLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.pickVmTf = new JTextField();
        this.pickVmTf.setHorizontalAlignment(SwingConstants.CENTER);
        this.pickVmTf.setColumns(10);
        this.showDetailsPanel.add(pickVmLbl);
        this.showDetailsPanel.add(pickVmTf);
        this.showDetailsPanel.add(pickBtn);
        this.showDetailsPanel.add(backBtn10, BorderLayout.SOUTH);
        showDetailsPanel.setBackground(Color.pink);
    }

    public void setShowVMPanel(){
        this.showVMPanel = new JPanel(cardLayout);
        showVMPanel.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(itemsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.showVMPanel.add(scrollPane);
        this.showVMPanel.add(backBtn11);
        showVMPanel.setBackground(Color.orange);
    }

    public void setCustomizeStocksPanel(){
        this.customizeStocksPanel = new JPanel(cardLayout);
        customizeStocksPanel.setLayout(new GridLayout(4,1));
        customizeStocksPanel.setBackground(Color.orange);
        customizeStocksPanel.add(backBtn5);
    }

    //Customize Item Panels
    public void setCreateItemsPanel(){
        this.createItemPanel = new JPanel(cardLayout);
        createItemPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        this.itemNamelbl = new JLabel("Item Name: ");
        gbc.gridx = 0; gbc.gridy = 0; createItemPanel.add(itemNamelbl, gbc);
        this.calorieslbl = new JLabel("Calories: ");
        gbc.gridx = 0; gbc.gridy = 1; createItemPanel.add(calorieslbl, gbc);
        this.stockslbl = new JLabel("Stocks: ");
        gbc.gridx = 0; gbc.gridy = 2; createItemPanel.add(stockslbl, gbc);
        this.itemNameTf = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 0; createItemPanel.add(itemNameTf, gbc);
        this.caloriesTf = new JTextField(5);
        gbc.gridx = 1; gbc.gridy = 1; createItemPanel.add(caloriesTf, gbc);
        this.stocksTf = new JTextField(5);
        gbc.gridx = 1; gbc.gridy = 2; createItemPanel.add(stocksTf, gbc);
        this.createStockBtn = new JButton("Create Item");
        gbc.gridx = 0; gbc.gridy = 3; createItemPanel.add(createStockBtn);
        gbc.gridx = 1; gbc.gridy = 3; createItemPanel.add(backBtn6);
        createItemPanel.setBackground(Color.getHSBColor(21, 79, 94));
    }

    public void setAddItemsPanel(){
        this.addItemPanel = new JPanel(cardLayout);
        addItemPanel.setLayout(new FlowLayout());
        //GridBagConstraints gbc = new GridBagConstraints();
        this.addItemTf = new JTextField(10);
        this.addItemBtn = new JButton("Add Item");
        this.itemsTa = new JTextArea();
        itemsTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.addItemPanel.add(scrollPane);
        this.addItemPanel.add(addItemTf);
        this.addItemPanel.add(addItemBtn);
        this.addItemPanel.add(backBtn7);
        addItemPanel.setBackground(Color.getHSBColor(10,9, 94));
    }

    public void setShowItemsPanel(){
        this.showItemsPanel = new JPanel(cardLayout);
        showItemsPanel.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(itemsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.showItemsPanel.add(scrollPane);
        this.showItemsPanel.add(backBtn8);
        showItemsPanel.setBackground(Color.getHSBColor(100,9, 94));
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
    public void setCustomizeStocksBtnListener(ActionListener actionListener){this.customizeStocksBtn.addActionListener(actionListener);}

    public void setShowInventoryBtnListener(ActionListener actionListener){this.showInventoryBtn.addActionListener(actionListener);}

    //Setter for Vending Machine Buttons
    public void setCreateVMBtnListener(ActionListener actionListener){this.createVMBtn.addActionListener(actionListener);}

    public void setShowDetailsBtnListener(ActionListener actionListener){this.showDetailsBtn.addActionListener(actionListener);}
    public void setShowVMBtnListener(ActionListener actionListener){this.showVMBtn.addActionListener(actionListener);}

    //Setter for Item Stock Buttons

    public void setCreateItemBtnListener(ActionListener actionListener){this.createItemBtn.addActionListener(actionListener);}
    public void setCreateStockBtnListener(ActionListener actionListener){this.createStockBtn.addActionListener(actionListener);}
    public void setAddItemBtnListener(ActionListener actionListener){this.addItemBtn.addActionListener(actionListener);}

    public void setShowItemsBtnListener(ActionListener actionListener){this.showItemBtn.addActionListener(actionListener);}
}
