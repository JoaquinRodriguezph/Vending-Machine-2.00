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
    private JPanel startProgramPanel, showInventoryPanel, customizeVMPanel, customizeStocksPanel, pickVMPanel;

    //Main Program Components
    private JPanel buyFromVmPanel, doMaintenancePanel, selectWalletPanel, showCurrentWalletPanel;
    private JButton backBtn26;//doMaintenanceBackBtn
    private JButton backBtn27;//buyFromVmBackBtn

    private JLabel pickWalletLbl; private JTextField pickWalletTf;
    private JLabel pickVMLbl; private JTextField pickVMTf; private JButton pickVMBtn, backBtn16;
    private JButton pickWalletBtn, backBtn12, backBtn13, backBtn14, backBtn15;

    //Do Maintenance Components

    private JPanel restockPanel, changePricePanel, collectMoneyPanel, replenishChangePanel, showItemSlotsPanel;
    private JButton restockBtn, changePriceBtn, collectMoneyBtn, replenishChangeBtn, showItemSlotsBtn;
    private JButton backBtn17, backBtn18, backBtn19, backBtn20, backBtn21;

    //Change Price Components
    private JButton editPricebtn, setToSRPbtn, setAllToSRPbtn, displaySlotsbtn;

    private JTextArea editPriceTa; private JLabel enterSlotLbl, enterPriceLbl; private JTextField enterSlotTf, enterPriceTf;
    private JTextArea displaySlotsTa, setToSRPTa;
    private JLabel enterItemLbl; private JTextField enterItemTf; private JButton SRPbtn, editBtn;

    //Restock Components
    private JTextArea restockTa; private JLabel selectItemLbl, quantityItemLbl; private JButton stockBtn;
    private JTextField selectItemTf, quantityItemTf;
    private JPanel editPricePanel, setToSRPPanel, setAllToSRPPanel, displaySlotsPanel;

    private JButton backBtn28, backBtn29, backBtn30;

    //Replenish Components
    private JLabel replenishBillslbl; private JTextField replenishBillsTf; private JButton replenishBillsBtn;
    private JLabel quantityBillsLbl; private JTextField quantityBillsTf; private JButton quantityBillsBtn;
    private JPanel showItemStocksPanel, displayInventoriesPanel, displayTransactionsPanel, displayMoneyPanel;
    private JButton showItemStocksBtn, displayInventoriesBtn, displayTransactionsBtn, displayMoneyBtn;

    private JTextArea itemStocksTa, inventoriesTa, transactionsTa, moneyTa, itemSlotsTa, replenishChangeTa;
    private JButton backBtn22, backBtn23, backBtn24, backBtn25;


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
    private JTextArea itemsTa, currentWalletTa, showItemsTa, walletTa, detailsTa, showVMTa, vmTa; //TextArea for showing the items

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

    /**
     * This method is used to get the card layout
     * @return the card layout
     */
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
        //Main Program Panels
        setPickVMPanel();
        setBuyFromVmPanel();
        setDoMaintenancePanel();
        setSelectWalletPanel();
        setShowCurrentWalletPanel();
        //Do Maintenance Panels
        setRestockPanel();
        setChangePricePanel();
        setCollectMoneyPanel();
        setReplenishChangePanel();
        setShowItemSlotsPanel();
        setShowItemStocksPanel();
        setDisplayInventoriesPanel();
        setDisplayTransactionsPanel();
        setDisplayMoneyPanel();
        //Change Price Panels
        setEditPricePanel();
        setSetToSRPPanel();
        setSetAllToSRPPanel();
        setDisplaySlotsPanel();

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
        this.backBtn1 = new JButton("Back"); this.backBtn2 = new JButton("Back"); this.backBtn3 = new JButton("Back");
        this.backBtn4 = new JButton("Back"); this.backBtn5 = new JButton("Back"); this.backBtn6 = new JButton("Back");
        this.backBtn7 = new JButton("Back"); this.backBtn8 = new JButton("Back"); this.backBtn9 = new JButton("Back");
        this.backBtn10 = new JButton("Back"); this.backBtn11 = new JButton("Back"); this.backBtn12 = new JButton("Back");
        this.backBtn13 = new JButton("Back"); this.backBtn14 = new JButton("Back"); this.backBtn15 = new JButton("Back");
        this.backBtn16 = new JButton("Back"); this.backBtn17 = new JButton("Back"); this.backBtn18 = new JButton("Back");
        this.backBtn19 = new JButton("Back"); this.backBtn20 = new JButton("Back"); this.backBtn21 = new JButton("Back"); this.backBtn22 = new JButton("Back");
        this.backBtn23 = new JButton("Back"); this.backBtn24 = new JButton("Back"); this.backBtn25 = new JButton("Back");
        this.backBtn26 = new JButton("Back"); this.backBtn27 = new JButton("Back"); this.backBtn28 = new JButton("Back");
        this.backBtn29 = new JButton("Back"); this.backBtn30 = new JButton("Back");


        backBtnList.add(this.backBtn1);backBtnList.add(this.backBtn2);backBtnList.add(this.backBtn3);
        backBtnList.add(this.backBtn4);backBtnList.add(this.backBtn5);backBtnList.add(this.backBtn6);
        backBtnList.add(this.backBtn7);backBtnList.add(this.backBtn8);backBtnList.add(this.backBtn9);
        backBtnList.add(this.backBtn10);backBtnList.add(this.backBtn11);backBtnList.add(this.backBtn12);
        backBtnList.add(this.backBtn13);backBtnList.add(this.backBtn14);backBtnList.add(this.backBtn15);
        backBtnList.add(this.backBtn16); backBtnList.add(this.backBtn17); backBtnList.add(this.backBtn18);
        backBtnList.add(this.backBtn19); backBtnList.add(this.backBtn20); backBtnList.add(this.backBtn21);
        backBtnList.add(this.backBtn22); backBtnList.add(this.backBtn23); backBtnList.add(this.backBtn24);
        backBtnList.add(this.backBtn25); backBtnList.add(this.backBtn26); backBtnList.add(this.backBtn27);
        backBtnList.add(this.backBtn28); backBtnList.add(this.backBtn29); backBtnList.add(this.backBtn30);
        backBtn1.addActionListener(new ActionListener() { //Back button for Main Program to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Pick Vending Machine");
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

        backBtn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program");
            }
        });

        backBtn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu");
            }
        });

        backBtn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program");
            }
        });

        backBtn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program");
            }
        });

        backBtn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu");
            }
        });

        backBtn17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance");
            }
        });

        backBtn18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance");
            }
        });

        backBtn19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance");
            }
        });

        backBtn20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance");
            }
        });

        backBtn21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance");
            }
        });
        backBtn22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance");
            }
        });

        backBtn23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance");
            }
        });

        backBtn24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {cardLayout.show(cardPanel,"Do Maintenance");}
        });

        backBtn25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance");
            }
        });

        backBtn26.addActionListener(new ActionListener() { //Back button for Do Maintenance to Main Program
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program");
            }
        });

        backBtn27.addActionListener(new ActionListener() { //Back Button for Buying from  to Main Program
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program");
            }
        });

        backBtn28.addActionListener(new ActionListener() { //Back Button for Buying from  to Main Program
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Change Price");
            }
        });

        backBtn29.addActionListener(new ActionListener() { //Back Button for Buying from  to Main Program
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Change Price");
            }
        });

        backBtn30.addActionListener(new ActionListener() { //Back Button for Buying from  to Main Program
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Change Price");
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

        //Main Program Panels
        cardPanel.add(pickVMPanel, "Pick Vending Machine");
        cardPanel.add(buyFromVmPanel, "Buy from Vending Machine");
        cardPanel.add(doMaintenancePanel, "Do Maintenance");
        cardPanel.add(selectWalletPanel, "Select Wallet");
        cardPanel.add(showCurrentWalletPanel, "Show Current Wallet");

        //Do Maintenance Panels

        cardPanel.add(restockPanel, "Restock");
        cardPanel.add(changePricePanel, "Change Price");
        cardPanel.add(collectMoneyPanel, "Collect Money");
        cardPanel.add(replenishChangePanel, "Replenish Change");
        cardPanel.add(showItemSlotsPanel, "Show Item Slots");
        cardPanel.add(showItemStocksPanel, "Show Item Stocks");
        cardPanel.add(displayInventoriesPanel, "Display Inventories");
        cardPanel.add(displayTransactionsPanel, "Display Transactions");
        cardPanel.add(displayMoneyPanel, "Display Money");

        //Change Price Panels

        cardPanel.add(editPricePanel, "Edit Price");
        cardPanel.add(setToSRPPanel, "Set to SRP");
        cardPanel.add(setAllToSRPPanel, "Set All to SRP");
        cardPanel.add(displaySlotsPanel, "Display Slots");
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
    //Main Program Panels
    public void setBuyFromVmPanel(){
        this.buyFromVmPanel = new JPanel(cardLayout);
    }

    public void setPickVMPanel(){
        this.pickVMPanel = new JPanel(cardLayout);
        pickVMPanel.setLayout(new FlowLayout());
        this.vmTa = new JTextArea();
        vmTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(vmTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.pickVMBtn = new JButton("Pick Vending Machine");
        this.pickVMLbl = new JLabel("Pick Vending Machine: ");
        this.pickVMLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.pickVMTf = new JTextField(10);
        this.pickVMTf.setHorizontalAlignment(SwingConstants.CENTER);
        pickVMPanel.add(scrollPane);
        pickVMPanel.add(pickVMLbl);
        pickVMPanel.add(pickVMTf);
        pickVMPanel.add(pickVMBtn);
        pickVMPanel.add(backBtn13);
    }
    public void setDoMaintenancePanel(){
        this.doMaintenancePanel = new JPanel(cardLayout);
        doMaintenancePanel.setLayout(new GridLayout(10,1));
        doMaintenancePanel.add(backBtn26);
        this.restockBtn = new JButton("Restock");
        doMaintenancePanel.add(restockBtn);
        this.changePriceBtn = new JButton("Change Price");
        doMaintenancePanel.add(changePriceBtn);
        this.collectMoneyBtn = new JButton("Collect Money");
        doMaintenancePanel.add(collectMoneyBtn);
        this.replenishChangeBtn = new JButton("Replenish Change");
        doMaintenancePanel.add(replenishChangeBtn);
        this.showItemSlotsBtn = new JButton("Show Item Slots");
        doMaintenancePanel.add(showItemSlotsBtn);
        this.showItemStocksBtn = new JButton("Show Item Stocks");
        doMaintenancePanel.add(showItemStocksBtn);
        this.displayInventoriesBtn = new JButton("Display Inventories");
        doMaintenancePanel.add(displayInventoriesBtn);
        this.displayTransactionsBtn = new JButton("Display Transactions");
        doMaintenancePanel.add(displayTransactionsBtn);
        this.displayMoneyBtn = new JButton("Display Money");
        doMaintenancePanel.add(displayMoneyBtn);
        doMaintenancePanel.setBackground(Color.green);
    }

    //Do Maintenance Panels
    public void setRestockPanel(){
        this.restockPanel = new JPanel(cardLayout);
        restockPanel.setLayout(new FlowLayout());
        this.restockTa = new JTextArea();
        restockTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(restockTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.restockPanel.add(scrollPane);
        this.selectItemLbl = new JLabel("Select Item: ");
        this.selectItemLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.selectItemTf = new JTextField(20);
        this.selectItemTf.setHorizontalAlignment(SwingConstants.CENTER);
        this.quantityItemLbl = new JLabel("Quantity: ");
        this.quantityItemLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.quantityItemTf = new JTextField(20);
        this.quantityItemTf.setHorizontalAlignment(SwingConstants.CENTER);
        this.stockBtn = new JButton("Stock");
        restockPanel.add(selectItemLbl);
        restockPanel.add(selectItemTf);
        restockPanel.add(quantityItemLbl);
        restockPanel.add(quantityItemTf);
        restockPanel.add(stockBtn);
        restockPanel.add(backBtn17);
    }

    public void setChangePricePanel(){
        this.changePricePanel = new JPanel(cardLayout);
        changePricePanel.setLayout(new GridLayout(5,1));
        changePricePanel.add(backBtn18);
        this.editPricebtn = new JButton("Edit Price");
        this.setToSRPbtn = new JButton("Set to SRP");
        this.setAllToSRPbtn = new JButton("Set All to SRP");
        this.displaySlotsbtn = new JButton("Display Slots");
        changePricePanel.add(editPricebtn);
        changePricePanel.add(setToSRPbtn);
        changePricePanel.add(setAllToSRPbtn);
        changePricePanel.add(displaySlotsbtn);
        changePricePanel.setBackground(Color.blue);
    }

    //Change Price Panels
    public void setEditPricePanel(){
        this.editPricePanel = new JPanel(cardLayout);
        editPricePanel.setLayout(new FlowLayout());
        this.editPriceTa = new JTextArea();
        editPriceTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editPriceTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        editPricePanel.add(scrollPane);
        this.enterSlotLbl = new JLabel("Enter Slot: ");
        this.enterSlotTf = new JTextField(20);
        this.enterPriceLbl = new JLabel("Enter Price: ");
        this.enterPriceTf = new JTextField(10);
        this.editBtn = new JButton("Edit");
        editPricePanel.add(enterSlotLbl);
        editPricePanel.add(enterSlotTf);
        editPricePanel.add(enterPriceLbl);
        editPricePanel.add(enterPriceTf);
        editPricePanel.add(editBtn);
        editPricePanel.add(backBtn28);
    }

    public void setSetToSRPPanel(){
        this.setToSRPPanel = new JPanel(cardLayout);
        setToSRPPanel.setLayout(new FlowLayout());
        this.setToSRPTa = new JTextArea();
        setToSRPTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(setToSRPTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.setToSRPPanel.add(scrollPane);
        this.enterItemLbl = new JLabel("Enter Slot: ");
        this.enterItemTf = new JTextField(10);
        this.SRPbtn = new JButton("Set to SRP");
        setToSRPPanel.add(backBtn29);
    }

    public void setSetAllToSRPPanel(){
        this.setAllToSRPPanel = new JPanel(cardLayout);
    }

    public void setDisplaySlotsPanel(){
        this.displaySlotsPanel = new JPanel(cardLayout);
        displaySlotsPanel.setLayout(new FlowLayout());
        this.displaySlotsTa = new JTextArea();
        displaySlotsTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displaySlotsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.displaySlotsPanel.add(scrollPane);
        displaySlotsPanel.add(backBtn30);
    }
    //Do maintenance panels
    public void setCollectMoneyPanel(){
        this.collectMoneyPanel = new JPanel(cardLayout);
        collectMoneyPanel.add(backBtn19);
    }

    public void setReplenishChangePanel(){
        this.replenishChangePanel = new JPanel(cardLayout);
        replenishChangePanel.setLayout(new FlowLayout());
        this.replenishChangeTa = new JTextArea();
        replenishChangeTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(replenishChangeTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.replenishChangePanel.add(scrollPane);
        this.replenishBillslbl = new JLabel("Replenish Bills: ");
        this.replenishBillsTf = new JTextField(20);
        this.quantityBillsLbl = new JLabel("Quantity: ");
        this.quantityBillsTf = new JTextField(20);
        replenishChangePanel.add(replenishBillslbl);
        replenishChangePanel.add(replenishBillsTf);
        replenishChangePanel.add(quantityBillsLbl);
        replenishChangePanel.add(quantityBillsTf);
        this.replenishBillsBtn = new JButton("Replenish");
        replenishChangePanel.add(replenishBillsBtn);
        replenishChangePanel.setBackground(Color.yellow);
        replenishChangePanel.add(backBtn20);
    }

    public void setShowItemSlotsPanel(){
        this.showItemSlotsPanel = new JPanel(cardLayout);
        showItemSlotsPanel.setLayout(new FlowLayout());
        this.itemSlotsTa = new JTextArea();
        itemSlotsTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemSlotsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.showItemSlotsPanel.add(scrollPane);
        this.showItemSlotsPanel.add(backBtn21);
    }
    public void setShowItemStocksPanel(){
        this.showItemStocksPanel = new JPanel(cardLayout);
        showItemStocksPanel.setLayout(new FlowLayout());
        this.itemStocksTa = new JTextArea();
        itemStocksTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemStocksTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.showItemStocksPanel.add(scrollPane);
        this.showItemStocksPanel.add(backBtn22);
    }

    public void setDisplayInventoriesPanel(){
        this.displayInventoriesPanel = new JPanel(cardLayout);
        displayInventoriesPanel.setLayout(new FlowLayout());
        this.inventoriesTa = new JTextArea();
        inventoriesTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(inventoriesTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.displayInventoriesPanel.add(scrollPane);
        this.displayInventoriesPanel.add(backBtn23);
    }

    public void setDisplayTransactionsPanel(){
        this.displayTransactionsPanel = new JPanel(cardLayout);
        displayTransactionsPanel.setLayout(new FlowLayout());
        this.transactionsTa = new JTextArea();
        transactionsTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transactionsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.displayTransactionsPanel.add(scrollPane);
        this.displayTransactionsPanel.add(backBtn24);
    }

    public void setDisplayMoneyPanel(){
        this.displayMoneyPanel = new JPanel(cardLayout);
        displayMoneyPanel.setLayout(new FlowLayout());
        this.moneyTa = new JTextArea();
        moneyTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(moneyTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.displayMoneyPanel.add(scrollPane);
        this.displayMoneyPanel.add(backBtn25);
    }

    //Main program panels again
    public void setSelectWalletPanel(){
        this.selectWalletPanel = new JPanel(cardLayout);
        selectWalletPanel.setLayout(new FlowLayout());
        this.walletTa = new JTextArea();
        walletTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(walletTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.selectWalletPanel.add(scrollPane);
        this.pickWalletBtn = new JButton("Pick Wallet");
        this.pickWalletLbl = new JLabel("Pick Wallet: ");
        this.pickWalletLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.pickWalletTf = new JTextField(10);
        this.pickWalletTf.setHorizontalAlignment(SwingConstants.CENTER);
        selectWalletPanel.add(pickWalletLbl);
        selectWalletPanel.add(pickWalletTf);
        selectWalletPanel.add(pickWalletBtn);
        selectWalletPanel.add(backBtn14, BorderLayout.SOUTH);
        selectWalletPanel.setBackground(Color.orange);
    }

    public void setShowCurrentWalletPanel(){
        this.showCurrentWalletPanel = new JPanel(cardLayout);
        showCurrentWalletPanel.setLayout(new FlowLayout());
        this.currentWalletTa = new JTextArea();
        currentWalletTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.showCurrentWalletPanel.add(scrollPane);
        this.showCurrentWalletPanel.add(backBtn12);
        showCurrentWalletPanel.setBackground(Color.pink);
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
        this.detailsTa = new JTextArea();
        detailsTa.setEditable(false);
        showDetailsPanel.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(detailsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
        this.showVMTa = new JTextArea();
        showVMTa.setEditable(false);
        showVMPanel.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(showVMTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
        this.showItemsTa = new JTextArea();
        showItemsTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(showItemsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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

    //Setters for Main Program Buttons
    public void setPickVMBtnListener(ActionListener actionListener){this.pickVMBtn.addActionListener(actionListener);}
    public void setBuyFromVmBtnListener(ActionListener actionListener){this.buyFromVmBtn.addActionListener(actionListener);}
    public void setDoMaintenanceBtnListener(ActionListener actionListener){this.doMaintenanceBtn.addActionListener(actionListener);}

    public void setSelectWalletBtnListener(ActionListener actionListener){this.selectWalletBtn.addActionListener(actionListener);}
    public void setShowCurrentWalletBtnListener(ActionListener actionListener){this.showCurrentWalletBtn.addActionListener(actionListener);}

    //Setters for Do Maintenance Buttons
    public void setRestockBtnListener(ActionListener actionListener){this.restockBtn.addActionListener(actionListener);}
    public void setChangePriceBtnListener(ActionListener actionListener){this.changePriceBtn.addActionListener(actionListener);}
    public void setCollectMoneyBtnListener(ActionListener actionListener){this.collectMoneyBtn.addActionListener(actionListener);}
    public void setReplenishChangeBtnListener(ActionListener actionListener){this.replenishChangeBtn.addActionListener(actionListener);}
    public void setShowItemSlotsBtnListener(ActionListener actionListener){this.showItemSlotsBtn.addActionListener(actionListener);}
    public void setShowItemStocksBtnListener(ActionListener actionListener){this.showItemStocksBtn.addActionListener(actionListener);}
    public void setDisplayInventoriesBtnListener(ActionListener actionListener){this.displayInventoriesBtn.addActionListener(actionListener);}
    public void setDisplayTransactionsBtnListener(ActionListener actionListener){this.displayTransactionsBtn.addActionListener(actionListener);}
    public void setDisplayMoneyBtnListener(ActionListener actionListener){this.displayMoneyBtn.addActionListener(actionListener);}

    //Setter for Change Price Buttons

    public void setEditPriceBtnListener(ActionListener actionListener){this.editPricebtn.addActionListener(actionListener);}
    public void setSetToSRPBtnListener(ActionListener actionListener){this.setToSRPbtn.addActionListener(actionListener);}
    public void setSetAllToSRPBtnListener(ActionListener actionListener){this.setAllToSRPbtn.addActionListener(actionListener);}
    public void setDisplaySlotsBtnListener(ActionListener actionListener){this.displaySlotsbtn.addActionListener(actionListener);}
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
