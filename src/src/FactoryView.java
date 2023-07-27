import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FactoryView {
    private JFrame mainFrame;
    private JLabel menuLabel;
    private JPanel btnPanel, ctrlPanel;
    private JPanel startProgramPanel, showInventoryPanel, customizeVMPanel, customizeMoneyPanel, customizeStocksPanel;

    private Icon backIcon;

    private CardLayout cardLayout;
    private JButton backBtn;
    private JButton startProgramBtn, showInventoryBtn;
    private JButton customizeVmBtn, customizeMoneyBtn, customizeStocksBtn;
    private ArrayList<JButton> buttonList;

    public FactoryView() {
        this.btnPanel = new JPanel();
        this.btnPanel.setLayout(cardLayout);
        btnPanel.setLayout(new GridLayout(10,1));
        this.buttonList = new ArrayList<JButton>();
        this.ctrlPanel = new JPanel();
        this.cardLayout = new CardLayout();
        this.ctrlPanel.setLayout(cardLayout);
        backIcon = new ImageIcon("resources/backButton.png");
        this.backBtn = new JButton(backIcon);
        backBtn.setSize(1, 1);

        this.mainFrame = new JFrame("Vending Machine Factory");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(350, 400);

        setStartProgramPanel();
        this.mainFrame.add(ctrlPanel);


        //setProgramMenuGrid();
        setButtons();
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

    public void setButtons(){

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

        ctrlPanel.add(btnPanel, "Main Menu");
        ctrlPanel.add(startProgramPanel, "Main Program");
        startProgramBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cardLayout.next(startProgramPanel);
                //ctrlPanel.setBackground(Color.pink);
                //ctrlPanel.setVisible(true);
                cardLayout.show(ctrlPanel, "Main Program");
            }
        });
    }

    public void setStartProgramPanel(){
        this.startProgramPanel = new JPanel(cardLayout);
        startProgramPanel.add(backBtn);
        startProgramPanel.setLayout(new GridLayout(10, 1));
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(ctrlPanel);
            }
        });
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
        customizeMoneyPanel.setBackground(Color.orange);
    }

    public void setShowInventoryPanel(){
        this.showInventoryPanel = new JPanel(cardLayout);
        showInventoryPanel.setBackground(Color.darkGray);
    }
    public void invisible(){
        for (JButton button : buttonList){
            button.setVisible(false);
        }
    }

    private JPanel createPanel(String content) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(content);
        panel.add(label);
        return panel;
    }
    public void setStartProgramBtn(ActionListener actionListener){this.startProgramBtn.addActionListener(actionListener);}
    public void setSelectVMBtnListener(ActionListener actionListener){this.customizeVmBtn.addActionListener(actionListener);}
    public void setCustomizeVmBtnListener(ActionListener actionListener){this.customizeMoneyBtn.addActionListener(actionListener);}
    public void setCustomizeStocksBtnListener(ActionListener actionListener){this.customizeStocksBtn.addActionListener(actionListener);}

    public void setShowInventoryBtnListener(ActionListener actionListener){this.showInventoryBtn.addActionListener(actionListener);}


}
