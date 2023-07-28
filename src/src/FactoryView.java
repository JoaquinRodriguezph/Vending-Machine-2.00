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
    private JPanel startProgramPanel, showInventoryPanel, customizeVMPanel, customizeMoneyPanel, customizeStocksPanel;

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    private CardLayout cardLayout;
    private JButton backBtn1, backBtn2, backBtn3, backBtn4, backBtn5, backBtn6;

    //Buttons for the Main Menu
    private JButton startProgramBtn, showInventoryBtn, customizeVmBtn, customizeMoneyBtn, customizeStocksBtn;

    //Buttons for the Customize Money Menu
    private JButton createMoneyBtn, showMoneyBtn;

    //Buttons for the Customize Item Stock Menu

    private JButton createItemBtn, addItemBtn, showItemBtn;

    public JTextArea getShowInventoryText() {
        return showInventoryText;
    }

    private JScrollPane scrollPane;
    private JTextArea showInventoryText;
    private ArrayList<JButton> buttonList, backButtonList, stocksButtonList;

    public FactoryView() {
        this.btnPanel = new JPanel();
        this.btnPanel.setLayout(cardLayout);
        btnPanel.setLayout(new GridLayout(10,1));
        this.buttonList = new ArrayList<JButton>();
        this.backButtonList = new ArrayList<JButton>();
        this.stocksButtonList = new ArrayList<JButton>();
        this.cardPanel = new JPanel();
        this.cardLayout = new CardLayout();
        this.cardPanel.setLayout(cardLayout);
        this.mainFrame = new JFrame("Vending Machine Factory");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(350, 400);
        this.mainFrame.add(cardPanel);

        setBackButtons();

        setStartProgramPanel();
        setShowInventoryPanel();
        setCustomizeStocksPanel();

        setButtons();
        //setProgramMenuGrid();
        //this.mainFrame.add(startProgramPanel);
        this.mainFrame.setVisible(true);
    }

    public void setProgramMenuGrid() {

        //JButton btn = new JButton();
        //btn.setPreferredSize(new Dimension(300, 10));
        //btn.setLabel("12");

        this.menuLabel = new JLabel("Main Menu");
        menuLabel.setVerticalAlignment(JLabel.TOP);
        menuLabel.setHorizontalAlignment(JLabel.CENTER);
        this.mainFrame.add(this.menuLabel);

        /*
        buttonList.add(new JButton("Start Main Program"));
        buttonList.add(new JButton("Customize Vending Machines"));
        buttonList.add(new JButton("Customize Money"));
        buttonList.add(new JButton("Customize Item Stocks"));
        buttonList.add(new JButton("Show Inventory"));

        for (JButton button : buttonList){
            button.setBackground(Color.pink);
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            btnPanel.add(button);
        }*/
    }

    public void setBackButtons(){
        this.backBtn1 = new JButton("Back");
        this.backBtn2 = new JButton("Back");
        this.backBtn3 = new JButton("Back");
        this.backBtn4 = new JButton("Back");
        this.backBtn5 = new JButton("Back");
        this.backBtn6 = new JButton("Back");
        backButtonList.add(this.backBtn1);
        backButtonList.add(this.backBtn2);
        backButtonList.add(this.backBtn3);
        backButtonList.add(this.backBtn4);
        backButtonList.add(this.backBtn5);
        backButtonList.add(this.backBtn6);

        backBtn1.addActionListener(new ActionListener() { //Back button for Main Program to Main Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel);
            }
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

    }

    public void setButtons(){

        //Main Menu Buttons
        this.startProgramBtn = new JButton("Start Main Program");
        buttonList.add(this.startProgramBtn);
        this.customizeVmBtn = new JButton("Customize Vending Machines");
        buttonList.add(this.customizeVmBtn);
        this.customizeMoneyBtn = new JButton("Customize Money");
        buttonList.add(this.customizeMoneyBtn);
        this.customizeStocksBtn = new JButton("Customize Item Stocks");
        buttonList.add(this.customizeStocksBtn);
        this.showInventoryBtn = new JButton("Show Inventory");
        buttonList.add(this.showInventoryBtn);


        for (JButton button : buttonList){
            button.setBackground(Color.pink);
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            btnPanel.add(button);
        }

        cardPanel.add(btnPanel, "Main Menu");
        cardPanel.add(startProgramPanel, "Main Program");
        cardPanel.add(showInventoryPanel, "Show Inventory");
        cardPanel.add(customizeStocksPanel, "Customize Stocks");

        //Customize Money Buttons

        //Customize Stocks Buttons
        this.createItemBtn = new JButton("Create Item Stock");
        stocksButtonList.add(createItemBtn);
        this.addItemBtn = new JButton("Add Item Stock");
        stocksButtonList.add(addItemBtn);
        this.showItemBtn = new JButton("Show Item Stocks");
        stocksButtonList.add(showItemBtn);

        for (JButton button : stocksButtonList){
            button.setBackground(Color.getHSBColor(173, 216, 230));//Light Blue
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            customizeStocksPanel.add(button);
        }
    }

    public void setStartProgramPanel(){
        this.startProgramPanel = new JPanel(cardLayout);
        startProgramPanel.setLayout(new GridLayout(10, 1));
        startProgramPanel.add(backBtn1);
        startProgramPanel.setBackground(Color.pink);
    }

    public void setCustomizeVMPanel(){
        this.customizeVMPanel = new JPanel(cardLayout);
        customizeVMPanel.setBackground(Color.red);
    }

    public void setCustomizeMoneyPanel(){
        this.customizeMoneyPanel = new JPanel(cardLayout);
        customizeMoneyPanel.setBackground(Color.CYAN);
    }

    public void setCustomizeStocksPanel(){
        this.customizeStocksPanel = new JPanel(cardLayout);
        customizeStocksPanel.setLayout(new GridLayout(4,1));
        customizeStocksPanel.setBackground(Color.orange);
        customizeStocksPanel.add(backBtn5);
    }

    public void setShowInventoryPanel(){
        this.showInventoryPanel = new JPanel(cardLayout);
        showInventoryPanel.setLayout(new GridLayout(2,1));
        showInventoryPanel.setBackground(Color.darkGray);
        this.showInventoryText = new JTextArea();
        this.showInventoryText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(showInventoryText);
        showInventoryPanel.add(backBtn4);
        showInventoryPanel.add(scrollPane);
    }
    /*public void invisible(){
        for (JButton button : buttonList){
            button.setVisible(false);
        }
    }*/
    public void setStartProgramBtn(ActionListener actionListener){this.startProgramBtn.addActionListener(actionListener);}
    public void setSelectVMBtnListener(ActionListener actionListener){this.customizeVmBtn.addActionListener(actionListener);}
    public void setCustomizeVmBtnListener(ActionListener actionListener){this.customizeMoneyBtn.addActionListener(actionListener);}
    public void setCustomizeStocksBtnListener(ActionListener actionListener){this.customizeStocksBtn.addActionListener(actionListener);}

    public void setShowInventoryBtnListener(ActionListener actionListener){this.showInventoryBtn.addActionListener(actionListener);}


}
