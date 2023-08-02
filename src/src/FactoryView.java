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

    /**
     * This method is used to return the cardPanel.
     * @return the cardPanel.
     */
    public JPanel getCardPanel() {
        return cardPanel;
    }


    /**
     * This method is used to return the string from text field getPickVMTf.
     * @return the string from text field getPickVMTf.
     */
    public String getPickVMTf() {
        return pickVMTf.getText();
    }


    /**
     * This method is used to return the JTextArea jcomp4.
     * @return the JTextArea jcomp4.
     */
    public JTextArea getJcomp4() {
        return jcomp4;
    }



    public JComboBox getJcomp11() {
        return jcomp11;
    }


    //Change Price

    /**
     * This method is used to return the JTextArea changePriceTa.
     * @return
     */
    public JTextArea getChangePriceTa() {
        return changePriceTa;
    }



    public String getSelectItemTf() {
        return selectItemTf.getText();
    }


    public String getPriceItemTf() {
        return priceItemTf.getText();
    }



    public JTextArea getRestockTa() {
        return restockTa;
    }

    public JTextArea getRestockTa2() {
        return restockTa2;
    }


    public String getSelectItemTf2() {
        return selectItemTf2.getText();
    }



    public String getQuantityItemTf() {
        return quantityItemTf.getText();
    }


    public String getSelectSlotTf() {
        return selectSlotTf.getText();
    }

    public String getReplenishBillsTf() {
        return replenishBillsTf.getText();
    }


    public String getQuantityBillsTf() {
        return quantityBillsTf.getText();
    }


    /**
     * This method is used to return the JTextArea getInventoriesTa.
     * @return the JTextArea getInventoriesTa.
     */
    public JTextArea getInventoriesTa() {
        return inventoriesTa;
    }


    /**
     * This method is used to return the JTextArea getTransactionsTa.
     * @return the JTextArea getTransactionsTa.
     */
    public JTextArea getTransactionsTa() {
        return transactionsTa;
    }


    /**
     * This method is used to return the JTextArea moneyTa.
     * @return the JTextArea moneyTa.
     */
    public JTextArea getMoneyTa() {
        return moneyTa;
    }


    /**
     * This method is used to return the JTextArea itemStocksTa.
     * @return the JTextArea itemStocksTa.
     */
    public JTextArea getItemStocksTa() {
        return itemStocksTa;
    }

    /**
     * This method is used to return the JTextArea getItemSlotsTa.
     * @return the JTextArea getItemSlotsTa.
     */
    public JTextArea getItemSlotsTa() {
        return itemSlotsTa;
    }


    /**
     * This method is used to return the JTextArea getReplenishChangeTa.
     * @return the JTextArea getReplenishChangeTa.
     */

    public JTextArea getReplenishChangeTa() {
        return replenishChangeTa;
    }

    public String getNameVmTf2() {
        return nameVmTf2.getText();
    }

    public String getNumSlotsTf2() {
        return numSlotsTf2.getText();
    }

    public String getMaxItemsTf2() {
        return maxItemsTf2.getText();
    }

    public String getInventoryLimitTf2() {
        return inventoryLimitTf2.getText();
    }

    /**
     * This method is used to return the string from text field getNameVmTf.
     * @return the string from text field getNameVmTf.
     */
    public String getNameVmTf() {
        return nameVmTf.getText();
    }

    /**
     * This method is used to return the string from text field getNumSlotsTf.
     * @return the string from text field getNumSlotsTf.
     */
    public String getNumSlotsTf() {
        return numSlotsTf.getText();
    }

    /**
     * This method is used to return the string from text field getMaxItemsTf.
     * @return the string from text field getMaxItemsTf.
     */
    public String getMaxItemsTf() {
        return maxItemsTf.getText();
    }

    /**
     * This method is used to return the string from text field getPickVmTf.
     * @return the string from text field getPickVmTf.
     */
    public String getPickVmTf2() {
        return pickVmTf2.getText();
    }

    /**
     * This method is used to return the string from text field getItemNameTf.
     * @return the string from text field getItemNameTf.
     */
    public String getAddItemTf() {
        return this.addItemTf.getText();
    }

    /**
     * This method is used to return the JTextArea itemsTa.
     * @return the JTextArea itemsTa.
     */
    public JTextArea getItemsTa() {
        return itemsTa;
    }

    public JTextArea getShowItemsTa() {
        return showItemsTa;
    }


    public JTextArea getDetailsTa() {
        return detailsTa;
    }

    public JTextArea getShowVMTa() {
        return showVMTa;
    }


    public JTextArea getVmTa() {
        return vmTa;
    }



    /**
     * This method is used to get the String value in the text field.
     * @return String value of itemNameTf.
     */
    public String getItemNameTf() {
        return this.itemNameTf.getText();
    }

    /**
     * This method is used to get the String value in the text field.
     * @return String value of caloriesTf.
     */
    public String getCaloriesTf() {
        return this.caloriesTf.getText();
    }

    /**
     * This method is used to get the String value in the text field.
     * @return String value of stocksTf.
     */
    public String getStocksTf() {
        return this.stocksTf.getText();
    }

    /**
     * This method is used to get the String value in the text field.
     * @return String value of SRPtf.
     */
    public String getSRPtf() {
        return this.SRPtf.getText();
    }

    /**
     * This method is used to get the card layout.
     * @return the card layout.
     */
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    /**
     * This method is used to return the string from text field getSelectItemtoAddTf.
     * @return the string from text field getSelectItemtoAddTf.
     */
    public String getSelectItemtoAddTf() {
        return selectItemtoAddTf.getText();
    }

    /**
     * This method is the constructor for the Factory View Class. It is used to initialize the components of the GUI.
     */
    public FactoryView() {
        this.btnPanel = new JPanel();
        this.btnPanel.setLayout(cardLayout);
        btnPanel.setLayout(new GridLayout(3,1));
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
        setSVMPanel();
        setDoMaintenancePanel();
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
        //Special Vending Machine Panels
        setAddItemtoInventoryPanel();
        setChangePriceofItemPanel();

        //Stocks Panel
        setCustomizeStocksPanel();
        setCreateItemsPanel();
        setAddItemsPanel();
        setShowItemsPanel();
        //Customize Vending Machine Panel
        setCreateVMPanel();
        setCreateSpecialVMPanel();
        setShowDetailsPanel();
        setShowVMPanel();

        setButtons();
        this.mainFrame.setVisible(true);
    }

    /**
     * This method is used to set the list of buttonslists for the Factory View Class.
     */
    public void setButtonsList() {
        this.btnList = new ArrayList<JButton>();
        this.backBtnList = new ArrayList<JButton>();
        this.stocksBtnList = new ArrayList<JButton>();
        this.vendingMachineBtnList = new ArrayList<JButton>();
        this.mainProgramBtnList = new ArrayList<JButton>();
    }

    /**
     * This method is used to set the back Buttons for the Factory View Class.
     */
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
        this.backBtn29 = new JButton("Back"); this.backBtn30 = new JButton("Back"); this.jcomp14 = new JButton("Back");
        this.backBtn31 = new JButton("Back"); this.addItemtoInventoryBackBtn = new JButton("Back");
        this.changePriceofItemBackBtn = new JButton("Back"); this.Back = new JButton("Back");

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
        backBtnList.add(this.jcomp14); backBtnList.add(this.backBtn31); backBtnList.add(this.addItemtoInventoryBackBtn);
        backBtnList.add(this.changePriceofItemBackBtn); backBtnList.add(this.Back);
        backBtn1.addActionListener(new ActionListener() { //Back button for Main Program to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Pick Vending Machine"); clearAllTextAreas();
            }
        });

        backBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu"); clearAllTextAreas();}
        });

        backBtn3.addActionListener(new ActionListener() {//Back button for Customize Money to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu"); clearAllTextAreas();}
        });
        backBtn4.addActionListener(new ActionListener() { //Back button for Main Program to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu"); clearAllTextAreas();
            }
        });

        backBtn5.addActionListener(new ActionListener() {//Back button for Item Stocks to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu"); clearAllTextAreas();
            }
        });

        backBtn6.addActionListener(new ActionListener() {//Back button for Create Item Stock to Customize Item Stocks
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Stocks"); clearAllTextAreas();
            }
        });

        backBtn7.addActionListener(new ActionListener() {//Back button for Create Item Stock to Customize Item Stocks
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Stocks"); clearAllTextAreas();
            }
        });

        backBtn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Stocks"); clearAllTextAreas();
            }
        });

        backBtn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Vending Machine"); clearAllTextAreas();
            }
        });

        backBtn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Vending Machine"); clearAllTextAreas();
            }
        });

        backBtn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Vending Machine"); clearAllTextAreas();
            }
        });

        backBtn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program"); clearAllTextAreas();
            }
        });

        backBtn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu"); clearAllTextAreas();
            }
        });

        backBtn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program"); clearAllTextAreas();
            }
        });

        backBtn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program"); clearAllTextAreas();
            }
        });

        backBtn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Menu"); clearAllTextAreas();
            }
        });

        backBtn17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });

        backBtn18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });

        backBtn19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });

        backBtn20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });

        backBtn21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });
        backBtn22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });

        backBtn23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });

        backBtn24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();}
        });

        backBtn25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });

        backBtn26.addActionListener(new ActionListener() { //Back button for Do Maintenance to Main Program
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program"); clearAllTextAreas();
            }
        });

        backBtn27.addActionListener(new ActionListener() { //Back Button for Buying from  to Main Program
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program"); clearAllTextAreas();
            }
        });

        jcomp14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Main Program"); clearAllTextAreas();
            }
        });
        backBtn31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Customize Vending Machine"); clearAllTextAreas();
            }
        });
        addItemtoInventoryBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });

        changePriceofItemBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Do Maintenance"); clearAllTextAreas();
            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"Buy from Vending Machine");
            }
        });
    }

    /**
     * This method sets the buttons for the GUI and adds panels to the main panel, card layout.
     */
    public void setButtons(){

        //Main Menu Buttons
        this.startProgramBtn = new JButton("Start Main Program");
        btnList.add(this.startProgramBtn);
        this.customizeVmBtn = new JButton("Customize Vending Machines");
        btnList.add(this.customizeVmBtn);
        this.customizeStocksBtn = new JButton("Customize Item");
        btnList.add(this.customizeStocksBtn);


        for (JButton button : btnList){
            button.setBackground(Color.pink);
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            btnPanel.add(button);
        }

        //Main Menu Panels
        cardPanel.add(btnPanel, "Main Menu");
        cardPanel.add(startProgramPanel, "Main Program");
        cardPanel.add(customizeVMPanel, "Customize Vending Machine");
        cardPanel.add(customizeStocksPanel, "Customize Stocks");

        //Main Program Panels
        cardPanel.add(pickVMPanel, "Pick Vending Machine");
        cardPanel.add(buyFromVmPanel, "Buy from Vending Machine");
        cardPanel.add(svmPanel, "Special Vending Machine");
        cardPanel.add(doMaintenancePanel, "Do Maintenance");

        //Do Maintenance Panels

        cardPanel.add(restockPanel, "Restock");
        cardPanel.add(changePricePanel, "Change Item Slot Price");
        cardPanel.add(collectMoneyPanel, "Collect Money");
        cardPanel.add(replenishChangePanel, "Replenish Change");
        cardPanel.add(showItemSlotsPanel, "Show Item Slots");
        cardPanel.add(showItemStocksPanel, "Show Item Stocks");
        cardPanel.add(displayInventoriesPanel, "Display Inventories");
        cardPanel.add(displayTransactionsPanel, "Display Transactions");
        cardPanel.add(displayMoneyPanel, "Display Money");

        //Special Vending Machine Panels
        cardPanel.add(addItemtoInventoryPanel, "Add Item to Inventory");
        cardPanel.add(changePriceofItemPanel, "Change Price of Item");

        //Customize Item Panels
        cardPanel.add(createItemPanel, "Create Item");
        cardPanel.add(addItemPanel, "Add Item");
        cardPanel.add(showItemsPanel, "Show Items");

        //Customize Vending Machine Panels
        cardPanel.add(createVMPanel, "Create Regular Vending Machine");
        cardPanel.add(createSpecialVMPanel, "Create Special Vending Machine");
        cardPanel.add(showDetailsPanel, "Show Details");
        cardPanel.add(showVMPanel, "Show Vending Machines");

        //Main Program Buttons
        this.buyFromVmBtn = new JButton("Buy from Vending Machine");
        mainProgramBtnList.add(buyFromVmBtn);
        this.doMaintenanceBtn = new JButton("Do Maintenance");
        mainProgramBtnList.add(doMaintenanceBtn);
        for (JButton button: mainProgramBtnList){
            button.setBackground(Color.getHSBColor(173, 216, 230));//Light Blue
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            startProgramPanel.add(button);
        }

        //Customize Vending Machine Buttons
        this.createVMBtn = new JButton("Create Regular Vending Machine");
        vendingMachineBtnList.add(createVMBtn);
        this.createSpecialVMBtn = new JButton("Create Special Vending Machine");
        vendingMachineBtnList.add(createSpecialVMBtn);
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

    /**
     * This method sets the Start Program Panel.
     */
    public void setStartProgramPanel(){
        this.startProgramPanel = new JPanel(cardLayout);
        startProgramPanel.setLayout(new GridLayout(3, 1));
        startProgramPanel.add(backBtn1);
        startProgramPanel.setBackground(Color.pink);
    }

    /**
     * This method sets the Customize Vending Machine Panel.
     */
    public void setCustomizeVMPanel(){
        this.customizeVMPanel = new JPanel(cardLayout);
        customizeVMPanel.setLayout(new GridLayout(5,1));
        customizeVMPanel.setBackground(Color.red);
        customizeVMPanel.add(backBtn2);
    }

    //Main Program Panels

    /**
     * This method sets the Buy from Vending Machine Panel.
     */
    public void setBuyFromVmPanel(){
        this.buyFromVmPanel = new JPanel(cardLayout);
        buyFromVmPanel.setLayout(null);
        String[] jcomp16Items = {"Item 1", "Item 2", "Item 3"};

        //construct components
        jcomp1 = new JButton ("1 Peso");
        jcomp2 = new JButton ("5 Peso");
        jcomp3 = new JButton ("10 Peso");
        jcomp4 = new JTextArea (5, 5);
        JScrollPane jcomp4Scroller = new JScrollPane(jcomp4, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jcomp5 = new JButton ("20 Peso");
        jcomp6 = new JButton ("50 Peso");
        jcomp7 = new JButton ("100 Peso");
        jcomp8 = new JButton ("200 Peso");
        jcomp9 = new JButton ("500 Peso");
        jcomp10 = new JButton ("1000 Peso");
        jcomp11 = new JComboBox ();
        jcomp12 = new JLabel ("Enter item slot:");
        jcomp13 = new JButton ("Enter");
        jcomp15 = new JButton ("Buysilog");
        jcomp16 = new JComboBox (jcomp16Items);

        buyFromVmPanel.add (jcomp1); buyFromVmPanel.add(jcomp2); buyFromVmPanel.add(jcomp3); buyFromVmPanel.add(jcomp4Scroller);
        buyFromVmPanel.add (jcomp5); buyFromVmPanel.add(jcomp6); buyFromVmPanel.add(jcomp7); buyFromVmPanel.add(jcomp8);
        buyFromVmPanel.add (jcomp9); buyFromVmPanel.add(jcomp10); buyFromVmPanel.add(jcomp11); buyFromVmPanel.add(jcomp12);
        buyFromVmPanel.add (jcomp13); buyFromVmPanel.add(jcomp14); buyFromVmPanel.add(jcomp15); buyFromVmPanel.add(jcomp16);

        jcomp1.setBounds (30, 285, 80, 20);
        jcomp2.setBounds (115, 285, 80, 20);
        jcomp3.setBounds (205, 285, 80, 20);
        jcomp4Scroller.setBounds (15, 5, 560, 225);
        jcomp5.setBounds (295, 285, 90, 20);
        jcomp6.setBounds (395, 285, 100, 25);
        jcomp7.setBounds (25, 320, 100, 25);
        jcomp8.setBounds (135, 320, 100, 25);
        jcomp9.setBounds (245, 320, 100, 25);
        jcomp10.setBounds (360, 320, 100, 25);
        jcomp11.setBounds (145, 245, 100, 25);
        jcomp12.setBounds (40, 245, 100, 25);
        jcomp13.setBounds (255, 245, 100, 25);
        jcomp14.setBounds (465, 245, 100, 25);
        jcomp15.setBounds (470, 320, 100, 25);
        jcomp16.setBounds (360, 245, 100, 25);
    }

    /**
     * This method sets the Pick Vending Machine Panel.
     */
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

    /**
     * This method sets the Do Maintenance Panel.
     */
    public void setDoMaintenancePanel(){
        this.doMaintenancePanel = new JPanel(cardLayout);
        doMaintenancePanel.setLayout(new GridLayout(12,1));
        doMaintenancePanel.add(backBtn26);
        this.restockBtn = new JButton("Restock");
        doMaintenancePanel.add(restockBtn);
        this.changePriceBtn = new JButton("Change Item Slot Price");
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
        this.addItemtoInventoryMenuBtn = new JButton("Add Item to Inventory");
        addItemtoInventoryMenuBtn.setVisible(false);
        doMaintenancePanel.add(addItemtoInventoryMenuBtn);
        this.changePriceofItemMenuBtn = new JButton("Change Price of Item");
        changePriceofItemMenuBtn.setVisible(false);
        doMaintenancePanel.add(changePriceofItemMenuBtn);
        doMaintenancePanel.add(displayMoneyBtn);
        doMaintenancePanel.setBackground(Color.green);
    }

    //Do Maintenance Panels

    /**
     * This method sets the Restock Panel.
     */
    public void setRestockPanel(){
        this.restockPanel = new JPanel(cardLayout);
        restockPanel.setLayout(new FlowLayout());
        this.restockTa = new JTextArea();
        restockTa.setEditable(false);
        this.restockTa2 = new JTextArea();
        restockTa2.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(restockTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(150, 150));
        this.restockPanel.add(scrollPane);
        JScrollPane scrollPane2 = new JScrollPane(restockTa2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane2.setPreferredSize(new Dimension(150, 150));
        this.restockPanel.add(scrollPane2);
        this.selectSlotLbl = new JLabel("Select Slot: ");
        this.selectSlotLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.selectSlotTf = new JTextField(20);
        this.selectSlotTf.setHorizontalAlignment(SwingConstants.CENTER);
        this.selectItemLbl = new JLabel("Select Item: ");
        this.selectItemLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.selectItemTf = new JTextField(20);
        this.selectItemTf.setHorizontalAlignment(SwingConstants.CENTER);
        this.quantityItemLbl = new JLabel("Quantity: ");
        this.quantityItemLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.quantityItemTf = new JTextField(20);
        this.quantityItemTf.setHorizontalAlignment(SwingConstants.CENTER);
        this.stockBtn = new JButton("Stock");
        restockPanel.add(selectSlotLbl);
        restockPanel.add(selectSlotTf);
        restockPanel.add(selectItemLbl);
        restockPanel.add(selectItemTf);
        restockPanel.add(quantityItemLbl);
        restockPanel.add(quantityItemTf);
        restockPanel.add(stockBtn);
        restockPanel.add(backBtn17);
    }

    /**
     * This method sets the Change Price Panel.
     */
    public void setChangePricePanel(){
        this.changePricePanel = new JPanel(cardLayout);
        changePricePanel.setLayout(new FlowLayout());
        this.changePriceTa = new JTextArea();
        changePriceTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(changePriceTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.changePricePanel.add(scrollPane);
        this.selectItemLbl2 = new JLabel("Select Slot: ");
        this.selectItemLbl2.setHorizontalAlignment(SwingConstants.CENTER);
        this.selectItemTf2 = new JTextField(20);
        this.selectItemTf2.setHorizontalAlignment(SwingConstants.CENTER);
        this.priceItemLbl = new JLabel("Set Price: ");
        this.priceItemLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.priceItemTf = new JTextField(20);
        this.priceItemTf.setHorizontalAlignment(SwingConstants.CENTER);
        this.setPriceBtn = new JButton("Change Price");
        changePricePanel.add(selectItemLbl2);
        changePricePanel.add(selectItemTf2);
        changePricePanel.add(priceItemLbl);
        changePricePanel.add(priceItemTf);
        changePricePanel.add(setPriceBtn);
        changePricePanel.add(backBtn18);
        changePricePanel.setBackground(Color.pink);
    }

    //Do maintenance panels

    /**
     * This method sets the Collect Money Panel.
     */
    public void setCollectMoneyPanel(){
        this.collectMoneyPanel = new JPanel(cardLayout);
        collectMoneyPanel.add(backBtn19);
    }

    /**
     * This method sets the Replenish Change Panel.
     */
    public void setReplenishChangePanel(){
        this.replenishChangePanel = new JPanel(cardLayout);
        replenishChangePanel.setLayout(new FlowLayout());
        this.replenishChangeTa = new JTextArea();
        replenishChangeTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(replenishChangeTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.replenishChangePanel.add(scrollPane);
        this.replenishBillslbl = new JLabel("Enter No. : ");
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

    /**
     * This method sets the Show Item Slots Panel.
     */
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

    /**
     * This method sets the Show Item Stocks Panel.
     */
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

    /**
     * This method sets the Display Inventories Panel.
     */
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

    /**
     * This method sets the Display Transactions Panel.
     */
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

    /**
     * This method sets the Display Money Panel.
     */
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

    //Customize Vending Machine Panels

    /**
     * This method sets the Create Regular Vending Machine Panel.
     */
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
        this.createVMBtn2 = new JButton("Create Regular Vending Machine");
        gbc.gridx = 0; gbc.gridy = 3; createVMPanel.add(createVMBtn2, gbc);
        createVMPanel.setBackground(Color.pink);
        gbc.gridx = 1; gbc.gridy = 3; createVMPanel.add(backBtn9, gbc);
    }

    public void setCreateSpecialVMPanel(){
        this.createSpecialVMPanel = new JPanel(cardLayout);
        createSpecialVMPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.nameVmLbl2 = new JLabel("Vending Machine Name: ");
        gbc.gridx = 0; gbc.gridy = 0; createSpecialVMPanel.add(nameVmLbl2, gbc);
        this.numSlotsLbl2 = new JLabel("Number of Slots: ");
        gbc.gridx = 0; gbc.gridy = 1; createSpecialVMPanel.add(numSlotsLbl2, gbc);
        this.maxItemsLbl2 = new JLabel("Max Items per Slot: ");
        gbc.gridx = 0; gbc.gridy = 2; createSpecialVMPanel.add(maxItemsLbl2, gbc);
        this.inventoryLimitLbl2 = new JLabel("Inventory Limit: ");
        gbc.gridx = 0; gbc.gridy = 3; createSpecialVMPanel.add(inventoryLimitLbl2, gbc);
        this.nameVmTf2 = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 0; createSpecialVMPanel.add(nameVmTf2, gbc);
        this.numSlotsTf2 = new JTextField(5);
        gbc.gridx = 1; gbc.gridy = 1; createSpecialVMPanel.add(numSlotsTf2, gbc);
        this.maxItemsTf2 = new JTextField(5);
        gbc.gridx = 1; gbc.gridy = 2; createSpecialVMPanel.add(maxItemsTf2, gbc);
        this.inventoryLimitTf2 = new JTextField(5);
        gbc.gridx = 1; gbc.gridy = 3; createSpecialVMPanel.add(inventoryLimitTf2, gbc);
        this.createVMBtn3 = new JButton("Create Special Vending Machine");
        gbc.gridx = 0; gbc.gridy = 4; createSpecialVMPanel.add(createVMBtn3, gbc);
        createSpecialVMPanel.setBackground(Color.pink);
        gbc.gridx = 1; gbc.gridy = 4; createSpecialVMPanel.add(backBtn31, gbc);
    }

    /**
     * This method sets the Show Details Panel.
     */
    public void setShowDetailsPanel(){
        this.showDetailsPanel = new JPanel(cardLayout);
        this.detailsTa = new JTextArea();
        detailsTa.setEditable(false);
        showDetailsPanel.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(detailsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.showDetailsPanel.add(scrollPane);
        this.pickBtn = new JButton("Pick");
        this.pickVendingMachineLbl = new JLabel("Pick Vending Machine:");
        this.pickVendingMachineLbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.pickVmTf2 = new JTextField();
        this.pickVmTf2.setHorizontalAlignment(SwingConstants.CENTER);
        this.pickVmTf2.setColumns(10);
        this.showDetailsPanel.add(pickVendingMachineLbl);
        this.showDetailsPanel.add(pickVmTf2);
        this.showDetailsPanel.add(pickBtn);
        this.showDetailsPanel.add(backBtn10, BorderLayout.SOUTH);
        showDetailsPanel.setBackground(Color.pink);
    }

    /**
     * This method sets the Show Vending Machine Panel.
     */
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

    /**
     * This method sets the Customize Stocks Panel.
     */
    public void setCustomizeStocksPanel(){
        this.customizeStocksPanel = new JPanel(cardLayout);
        customizeStocksPanel.setLayout(new GridLayout(4,1));
        customizeStocksPanel.setBackground(Color.orange);
        customizeStocksPanel.add(backBtn5);
    }

    //Customize Item Panels

    /**
     * This method sets the Create Item Panel.
     */
    public void setCreateItemsPanel(){
        this.createItemPanel = new JPanel(cardLayout);
        createItemPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        this.itemNamelbl = new JLabel("Item Name: ");
        gbc.gridx = 0; gbc.gridy = 0; createItemPanel.add(itemNamelbl, gbc);
        this.calorieslbl = new JLabel("Calories: ");
        gbc.gridx = 0; gbc.gridy = 1; createItemPanel.add(calorieslbl, gbc);
        this.itemNameTf = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 0; createItemPanel.add(itemNameTf, gbc);
        this.caloriesTf = new JTextField(5);
        gbc.gridx = 1; gbc.gridy = 1; createItemPanel.add(caloriesTf, gbc);
        this.createStockBtn = new JButton("Create Item");
        gbc.gridx = 0; gbc.gridy = 2; createItemPanel.add(createStockBtn);
        gbc.gridx = 1; gbc.gridy = 2; createItemPanel.add(backBtn6);
        createItemPanel.setBackground(Color.getHSBColor(21, 79, 94));
    }

    /**
     * This method sets the Add Items Panel.
     */
    public void setAddItemsPanel(){
        this.addItemPanel = new JPanel(cardLayout);
        addItemPanel.setLayout(new FlowLayout());
        //GridBagConstraints gbc = new GridBagConstraints();
        this.selectItemtoAddLbl = new JLabel("Select Item to Add: ");
        this.selectItemtoAddTf = new JTextField(10);
        this.selectItemtoAddBtn = new JButton("Select Item");
        this.addItemLbl = new JLabel("Num_of_Items:");
        this.addItemTf = new JTextField(5);
        this.addItemBtn2 = new JButton("Add Item");
        this.itemsTa = new JTextArea();
        itemsTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemsTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        this.addItemPanel.add(scrollPane);
        this.addItemPanel.add(selectItemtoAddLbl);
        this.addItemPanel.add(selectItemtoAddTf);
        this.addItemPanel.add(selectItemtoAddBtn);
        this.addItemPanel.add(addItemLbl);
        this.addItemPanel.add(addItemTf);
        this.addItemPanel.add(addItemBtn2);
        this.addItemPanel.add(backBtn7);
        addItemPanel.setBackground(Color.getHSBColor(10,9, 94));
    }

    /**
     * This method sets the Show Items Panel.
     */
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

    /**
     * This method clears all text areas.
     */
    public void clearAllTextAreas(){
        this.jcomp4.setText(""); this.restockTa.setText(""); this.itemStocksTa.setText(""); this.inventoriesTa.setText(""); this.transactionsTa.setText("");
        this.moneyTa.setText(""); this.itemSlotsTa.setText(""); this.replenishChangeTa.setText(""); this.showItemsTa.setText("");
        this.detailsTa.setText(""); this.showVMTa.setText(""); this.vmTa.setText(""); this.itemsTa.setText(""); this.changePriceTa.setText("");
        this.restockTa2.setText(""); this.addItemTa.setText(""); this.changePriceofItemTa.setText("");
    }

    public void showDisplayInventoriesBtn(){
        this.displayInventoriesBtn.setVisible(true);
    }

    //Setters for Main Menu Buttons

    /**
     * This method sets the Start Program Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setStartProgramBtn(ActionListener actionListener){this.startProgramBtn.addActionListener(actionListener);}

    /**
     * This method sets the Customize Vending Machine Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setCustomizeVMBtnListener(ActionListener actionListener){this.customizeVmBtn.addActionListener(actionListener);}

    /**
     * This method sets the Customize Stocks Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setCustomizeStocksBtnListener(ActionListener actionListener){this.customizeStocksBtn.addActionListener(actionListener);}

    //Setters for Main Program Buttons

    /**
     * This method sets the Pick Vending Machine Button on what to do when pressed .
     * @param actionListener, is to be overdriven.
     */
    public void setPickVMBtnListener(ActionListener actionListener){this.pickVMBtn.addActionListener(actionListener);}

    /**
     * This method sets the Buy From Vending Machine Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setBuyFromVmBtnListener(ActionListener actionListener){this.buyFromVmBtn.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp13 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */

    /**
     * This method sets the Jcomp1 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp1BtnListener(ActionListener actionListener){this.jcomp1.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp2 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp2BtnListener(ActionListener actionListener){this.jcomp2.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp3 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp3BtnListener(ActionListener actionListener){this.jcomp3.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp5 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp5BtnListener(ActionListener actionListener){this.jcomp5.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp6 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp6BtnListener(ActionListener actionListener){this.jcomp6.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp7 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp7BtnListener(ActionListener actionListener){this.jcomp7.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp8 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp8BtnListener(ActionListener actionListener){this.jcomp8.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp9 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp9BtnListener(ActionListener actionListener){this.jcomp9.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp10 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp10BtnListener(ActionListener actionListener){this.jcomp10.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp13 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp13BtnListener(ActionListener actionListener){this.jcomp13.addActionListener(actionListener);}

    /**
     * This method sets the Jcomp15 Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setJcomp15BtnListener(ActionListener actionListener){this.jcomp15.addActionListener(actionListener);}
    /**
     * This method sets the Do Maintenance Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */


    public void setDoMaintenanceBtnListener(ActionListener actionListener){this.doMaintenanceBtn.addActionListener(actionListener);}

    //Setters for Do Maintenance Buttons

    /**
     * This method sets the Set Restock Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setRestockBtnListener(ActionListener actionListener){this.restockBtn.addActionListener(actionListener);}

    /**
     * This method sets the SetS Stock Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setStockBtnListener(ActionListener actionListener){this.stockBtn.addActionListener(actionListener);}
    /**
     * This method sets the Set to Change Price Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setChangePriceBtnListener(ActionListener actionListener){this.changePriceBtn.addActionListener(actionListener);}

    /**
     * This method sets the Collect Money Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */

    public void setSetPriceBtnListener(ActionListener actionListener){this.setPriceBtn.addActionListener(actionListener);}
    public void setCollectMoneyBtnListener(ActionListener actionListener){this.collectMoneyBtn.addActionListener(actionListener);}

    /**
     * This method sets the Replenish Change Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setReplenishChangeBtnListener(ActionListener actionListener){this.replenishChangeBtn.addActionListener(actionListener);}

    /**
     * This method sets the Show Item Slots Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */

    public void setReplenishBillsBtnListener(ActionListener actionListener){this.replenishBillsBtn.addActionListener(actionListener);}
    public void setShowItemSlotsBtnListener(ActionListener actionListener){this.showItemSlotsBtn.addActionListener(actionListener);}

    /**
     * This method sets the Show Item Stocks Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setShowItemStocksBtnListener(ActionListener actionListener){this.showItemStocksBtn.addActionListener(actionListener);}

    /**
     * This method sets the Display Inventories Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setDisplayInventoriesBtnListener(ActionListener actionListener){this.displayInventoriesBtn.addActionListener(actionListener);}

    /**
     * This method sets the Display Transactions Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setDisplayTransactionsBtnListener(ActionListener actionListener){this.displayTransactionsBtn.addActionListener(actionListener);}

    /**
     * This method sets the Display Money Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setDisplayMoneyBtnListener(ActionListener actionListener){this.displayMoneyBtn.addActionListener(actionListener);}

    //Setter for Vending Machine Buttons

    /**
     * This method sets the Create Regular Vending Machine Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setCreateVMBtnListener(ActionListener actionListener){this.createVMBtn.addActionListener(actionListener);}

    /**
     * This method sets the Create Regular Vending Machine Button2 on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setCreateVMBtn2Listener(ActionListener actionListener){this.createVMBtn2.addActionListener(actionListener);}
    /**
     * This method sets the Show Details Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */

    public void setShowDetailsBtnListener(ActionListener actionListener){this.showDetailsBtn.addActionListener(actionListener);}

    /**
     * This method sets the Create Special Vending Machine Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */

    public void setCreateSpecialVMBtnListener(ActionListener actionListener){this.createSpecialVMBtn.addActionListener(actionListener);}

    /**
     * This method sets the Create Special Vending Machine Button3 on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setCreateVMBtn3Listener(ActionListener actionListener){this.createVMBtn3.addActionListener(actionListener);}
    /**
     * This method sets the Pick Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setPickBtnListener(ActionListener actionListener){this.pickBtn.addActionListener(actionListener);}

    /**
     * This method sets the Show Vending Machine Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setShowVMBtnListener(ActionListener actionListener){this.showVMBtn.addActionListener(actionListener);}

    //Setter for Item Stock Buttons

    /**
     * This method sets the Create Item Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setCreateItemBtnListener(ActionListener actionListener){this.createItemBtn.addActionListener(actionListener);}

    /**
     * This method sets the Create Stock Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setCreateStockBtnListener(ActionListener actionListener){this.createStockBtn.addActionListener(actionListener);}

    /**
     * This method sets the Select Item to Add Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setSelectItemtoAddBtnListener(ActionListener actionListener){this.selectItemtoAddBtn.addActionListener(actionListener);}

    /**
     * This method sets the Add Item Button2 on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setAddItemBtn2Listener(ActionListener actionListener){this.addItemBtn2.addActionListener(actionListener);}

    /**
     * This method sets the Add Item Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setAddItemBtnListener(ActionListener actionListener){this.addItemBtn.addActionListener(actionListener);}

    /**
     * This method sets the Show Items Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setShowItemsBtnListener(ActionListener actionListener){this.showItemBtn.addActionListener(actionListener);}

    /**
     * This method sets the Add Item To Inventory Menu Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setAddItemtoInventoryMenuBtnListener(ActionListener actionListener){this.addItemtoInventoryMenuBtn.addActionListener(actionListener);}

    /**
     * This method sets the Add Item to Inventory button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setAddItemtoInventoryBtnListener(ActionListener actionListener){this.addItemtoInventoryBtn.addActionListener(actionListener);}

    /**
     * This method sets the Change Price of Item Menu Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setChangePriceofItemMenuBtnListener(ActionListener actionListener){this.changePriceofItemMenuBtn.addActionListener(actionListener);}

    /**
     * This method sets the Change Price of Item Button on what to do when pressed.
     * @param actionListener, is to be overdriven.
     */
    public void setChangePriceofItemBtnListener(ActionListener actionListener){this.changePriceofItemBtn.addActionListener(actionListener);}

    /**
     * This method shows the Special Vending Machine Buttons.
     */
    public void showSpecialVMButtons(){
        this.addItemtoInventoryMenuBtn.setVisible(true);
        this.changePriceofItemMenuBtn.setVisible(true);
    }

    /**
     * This method hides the Special Vending Machine Buttons.
     */
    public void hideSpecialVMButtons(){
        this.addItemtoInventoryMenuBtn.setVisible(false);
        this.changePriceofItemMenuBtn.setVisible(false);
    }

    /**
     * This method sets the Add Item to Inventory Panel.
     */
    public void setAddItemtoInventoryPanel(){
        this.addItemtoInventoryPanel = new JPanel();
        this.addItemtoInventoryPanel.setLayout(new FlowLayout());
        this.addItemTa = new JTextArea();
        this.addItemTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.addItemTa, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.selectSpecialItemLbl = new JLabel("Select Special Item: ");
        this.selectSpecialItemTf = new JTextField(18);
        this.setSpecialPriceLbl = new JLabel("Set Price: ");
        this.setSpecialPriceTf = new JTextField(10);
        this.addItemtoInventoryBtn = new JButton("Add Item");
        this.addItemtoInventoryPanel.add(scrollPane);
        this.addItemtoInventoryPanel.add(this.selectSpecialItemLbl);
        this.addItemtoInventoryPanel.add(this.selectSpecialItemTf);
        this.addItemtoInventoryPanel.add(this.setSpecialPriceLbl);
        this.addItemtoInventoryPanel.add(this.setSpecialPriceTf);
        this.addItemtoInventoryPanel.add(this.addItemtoInventoryBtn);
        this.addItemtoInventoryPanel.add(this.addItemtoInventoryBackBtn);
    }

    /**
     * This method sets the change to Price of Item Panel.
     */
    public void setChangePriceofItemPanel(){
        this.changePriceofItemPanel = new JPanel();
        this.changePriceofItemPanel.setLayout(new FlowLayout());
        this.changePriceofItemTa = new JTextArea();
        this.changePriceofItemTa.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.changePriceofItemTa, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.selectIndexLbl = new JLabel("Select Index: ");
        this.selectIndexTf = new JTextField(18);
        this.setItemPriceLbl = new JLabel("Set Price: ");
        this.setItemPriceTf = new JTextField(10);
        this.changePriceofItemBtn = new JButton("Change Price");
        this.changePriceofItemPanel.add(scrollPane);
        this.changePriceofItemPanel.add(this.selectIndexLbl);
        this.changePriceofItemPanel.add(this.selectIndexTf);
        this.changePriceofItemPanel.add(this.setItemPriceLbl);
        this.changePriceofItemPanel.add(this.setItemPriceTf);
        this.changePriceofItemPanel.add(this.changePriceofItemBtn);
        this.changePriceofItemPanel.add(this.changePriceofItemBackBtn);
        changePriceofItemPanel.setBackground(Color.WHITE);
    }

    /**
     * This method shows the Set Price Components.
     */
    public void showSpecialPrice(){
        this.setSpecialPriceLbl.setVisible(true);
        this.setSpecialPriceTf.setVisible(true);
    }

    /**
     * This method hides the Set Price Components.
     */
    public void hideSpecialPrice(){
        this.setSpecialPriceLbl.setVisible(false);
        this.setSpecialPriceTf.setVisible(false);
    }

    public void setSVMPanel(){
        this.svmPanel = new JPanel();
        String[] itemSlotItems = {};

        //construct components
        onePeso = new JButton ("1 Peso");
        fivePeso = new JButton ("5 Peso");
        tenPeso = new JButton ("10 Peso");
        SelledItems = new JTextArea (5, 5);
        twentyPeso = new JButton ("20 Peso");
        fiftyPeso = new JButton ("50 Peso");
        hundredPeso = new JButton ("100 Peso");
        twoHundredPeso = new JButton ("200 Peso");
        fiveHundredPeso = new JButton ("500 Peso");
        thousandPeso = new JButton ("1000 Peso");
        enterSpecialItemSlot = new JLabel ("Enter item slot:");
        Confirm = new JButton ("Confirm");
        itemSlot = new JComboBox (itemSlotItems);
        Add = new JButton ("Add");
        Selected_Items = new JTextArea (5, 5);

        //adjust size and set layout
        svmPanel.setPreferredSize (new Dimension (582, 359));
        svmPanel.setLayout (null);

        //add components
        svmPanel.add (onePeso);
        svmPanel.add (fivePeso);
        svmPanel.add (tenPeso);
        svmPanel.add (SelledItems);
        svmPanel.add (twentyPeso);
        svmPanel.add (fiftyPeso);
        svmPanel.add (hundredPeso);
        svmPanel.add (twoHundredPeso);
        svmPanel.add (fiveHundredPeso);
        svmPanel.add (thousandPeso);
        svmPanel.add (enterSpecialItemSlot);
        svmPanel.add (Back);
        svmPanel.add (Confirm);
        svmPanel.add (itemSlot);
        svmPanel.add (Add);
        svmPanel.add (Selected_Items);

        //set component bounds (only needed by Absolute Positioning)
        onePeso.setBounds (25, 285, 80, 20);
        fivePeso.setBounds (115, 285, 80, 20);
        tenPeso.setBounds (205, 285, 80, 20);
        SelledItems.setBounds (20, 5, 320, 225);
        twentyPeso.setBounds (295, 285, 90, 20);
        fiftyPeso.setBounds (395, 285, 100, 25);
        hundredPeso.setBounds (25, 320, 100, 25);
        twoHundredPeso.setBounds (135, 320, 100, 25);
        fiveHundredPeso.setBounds (245, 320, 100, 25);
        thousandPeso.setBounds (360, 320, 100, 25);
        enterSpecialItemSlot.setBounds (20, 240, 100, 25);
        Back.setBounds (470, 245, 100, 25);
        Confirm.setBounds (470, 320, 100, 25);
        itemSlot.setBounds (110, 240, 100, 25);
        Add.setBounds (220, 240, 100, 25);
        Selected_Items.setBounds (345, 5, 230, 225);
    }
    private JFrame mainFrame;
    private JLabel menuLabel;
    private JPanel btnPanel;

    private JPanel cardPanel;

    //Main Menu Panels
    private JPanel startProgramPanel, customizeVMPanel, customizeStocksPanel, pickVMPanel;

    //Main Program Components
    private JPanel buyFromVmPanel, doMaintenancePanel;
    private JButton backBtn26;//doMaintenanceBackBtn
    private JButton backBtn27;//buyFromVmBackBtn

    private JLabel pickVMLbl;


    private JTextField pickVMTf; private JButton pickVMBtn, backBtn16;
    private JButton  backBtn12, backBtn13, backBtn14, backBtn15;

    //Special Buying Components
    private JPanel svmPanel;
    private JButton onePeso;
    private JButton fivePeso;
    private JButton tenPeso;

    /**
     * This method returns the Selled Items Text Area.
     * @return SelledItems text area.
     */
    public JTextArea getSelledItems() {
        return SelledItems;
    }

    private JTextArea SelledItems;
    private JButton twentyPeso;
    private JButton fiftyPeso;
    private JButton hundredPeso;
    private JButton twoHundredPeso;
    private JButton fiveHundredPeso;
    private JButton thousandPeso;
    private JLabel enterSpecialItemSlot;
    private JButton Back;
    private JButton Confirm;
    private JComboBox itemSlot;
    private JButton Add;
    private JTextArea Selected_Items;

    //Buying Components
    private JButton jcomp1; private JButton jcomp2; private JButton jcomp3;


    private JTextArea jcomp4; private JButton jcomp5;
    private JButton jcomp6; private JButton jcomp7; private JButton jcomp8; private JButton jcomp9; private JButton jcomp10;

    private JComboBox jcomp11; private JLabel jcomp12; private JButton jcomp13;
    private JButton jcomp14; private JButton jcomp15; private JComboBox jcomp16;

    //Do Maintenance Components

    private JPanel restockPanel, changePricePanel, collectMoneyPanel, replenishChangePanel, showItemSlotsPanel;
    private JButton restockBtn, changePriceBtn, collectMoneyBtn, replenishChangeBtn, showItemSlotsBtn;
    private JButton backBtn17, backBtn18, backBtn19, backBtn20, backBtn21;
    private JLabel enterItemLbl; private JTextField enterItemTf; private JButton SRPbtn, editBtn;
    private JButton setPriceBtn;

    //Special Vending Machine Components
    private JButton addItemtoInventoryMenuBtn, changePriceofItemMenuBtn;
    private JPanel addItemtoInventoryPanel, changePriceofItemPanel;

    private JTextArea changePriceTa; private JLabel selectItemLbl2;

    private JTextField selectItemTf;

    private JLabel priceItemLbl;

    private JTextField priceItemTf; private JButton priceItemBtn;

    /**
     * This method returns the Add Item Text Area
     * @return the Add Item Text Area
     */
    public JTextArea getAddItemTa() {
        return addItemTa;
    }

    private JTextArea addItemTa; private JLabel selectSpecialItemLbl, setSpecialPriceLbl;
    private JTextField selectSpecialItemTf;

    public String getSelectSpecialItemTf() {
        return selectSpecialItemTf.getText();
    }

    public String getSetSpecialPriceTf() {
        return setSpecialPriceTf.getText();
    }

    private JTextField setSpecialPriceTf; private JButton addItemtoInventoryBtn, addItemtoInventoryBackBtn;

    public JTextArea getChangePriceofItemTa() {
        return changePriceofItemTa;
    }

    private JTextArea changePriceofItemTa; private JLabel selectIndexLbl, setItemPriceLbl;

    public String getSelectIndexTf() {
        return selectIndexTf.getText();
    }

    private JTextField selectIndexTf;

    public String getSetItemPriceTf() {
        return setItemPriceTf.getText();
    }

    private JTextField setItemPriceTf; private JButton changePriceofItemBtn, changePriceofItemBackBtn;
    //Restock Components
    private JTextArea restockTa;

    private JTextArea restockTa2; private JLabel selectItemLbl, quantityItemLbl; private JButton stockBtn;

    private JTextField selectItemTf2;


    private JLabel selectSlotLbl;


    private JTextField selectSlotTf;
    private JTextField quantityItemTf;
    private JPanel editPricePanel, setToSRPPanel, setAllToSRPPanel, displaySlotsPanel;

    private JButton backBtn28, backBtn29, backBtn30;

    //Replenish Components
    private JLabel replenishBillslbl;


    private JTextField replenishBillsTf; private JButton replenishBillsBtn;
    private JLabel quantityBillsLbl;


    private JTextField quantityBillsTf; private JButton quantityBillsBtn;
    private JPanel showItemStocksPanel, displayInventoriesPanel, displayTransactionsPanel, displayMoneyPanel;
    private JButton showItemStocksBtn, displayInventoriesBtn, displayTransactionsBtn, displayMoneyBtn;

    private JTextArea itemStocksTa;

    private JTextArea inventoriesTa;

    private JTextArea transactionsTa;

    private JTextArea moneyTa;


    private JTextArea itemSlotsTa;

    private JTextArea replenishChangeTa;
    private JButton backBtn22, backBtn23, backBtn24, backBtn25;


    //Customize Vending Machine Components
    private JPanel createVMPanel, showDetailsPanel, showVMPanel;

    private JPanel createSpecialVMPanel;

    private JLabel nameVmLbl2, numSlotsLbl2, maxItemsLbl2; private JTextField nameVmTf2;
    private JTextField numSlotsTf2;

    private JTextField maxItemsTf2;
    private JLabel inventoryLimitLbl2;



    private JTextField inventoryLimitTf2;
    private JButton createVMBtn3; private JButton backBtn31;
    private JLabel nameVmLbl, numSlotsLbl, maxItemsLbl;


    private JTextField nameVmTf, numSlotsTf, maxItemsTf;

    private JLabel pickVendingMachineLbl;


    private JTextField pickVmTf2;
    private JButton createVmBtn, createVMBtn2, pickBtn, backBtn9, backBtn10, backBtn11;

    //Customize Item Stock Components
    private JPanel createItemPanel, addItemPanel, showItemsPanel;

    private JLabel itemNamelbl, calorieslbl, SRPlbl, itemNumberlbl, addItemlbl;

    private JButton createStockBtn, addItemBtn2;
    private JTextField itemNameTf;
    private JTextField caloriesTf;
    private JTextField stocksTf;
    private JTextField SRPtf;


    private JTextField addItemTf;
    private JTextField numItemTf;
    private JTextField showItemTf;


    private JTextArea itemsTa;
    private JTextArea showItemsTa;
    private JTextArea walletTa;


    private JTextArea detailsTa;

    private JTextArea showVMTa;
    private JTextArea vmTa; //TextArea for showing the items

    private CardLayout cardLayout;
    private JButton backBtn1, backBtn2, backBtn3, backBtn4, backBtn5, backBtn6, backBtn7, backBtn8;

    //Buttons for the Main Menu
    private JButton startProgramBtn, customizeVmBtn, customizeMoneyBtn, customizeStocksBtn;

    //Buttons for the Main Program

    private JButton buyFromVmBtn, doMaintenanceBtn;

    //Buttons for the Vending Machine
    private JButton createVMBtn, createSpecialVMBtn, showDetailsBtn, showVMBtn;

    //Buttons for the Customize Money Menu
    private JButton createMoneyBtn, showMoneyBtn;

    //Buttons for the Customize Item Stock Menu

    private JButton createItemBtn, addItemBtn, showItemBtn, selectItemtoAddBtn;
    private JLabel selectItemtoAddLbl, addItemLbl;
    private JTextField selectItemtoAddTf;
    private JScrollPane scrollPane;
    private ArrayList<JButton> btnList, backBtnList, mainProgramBtnList, stocksBtnList, vendingMachineBtnList;



}
