import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FactoryView {
    private JFrame mainFrame;
    private JLabel menuLabel;
    private JPanel btnPanel;

    private JButton startProgramBtn, showInventoryBtn;
    private JButton customizeVmBtn, customizeMoneyBtn, customizeStocksBtn;
    private ArrayList<JButton> buttonList;

    public FactoryView() {
        this.btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(10,1));
        this.buttonList = new ArrayList<JButton>();

        this.mainFrame = new JFrame("Vending Machine Factory");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(350, 400);


        setProgramMenuGrid();

        this.mainFrame.add(btnPanel);

        this.mainFrame.setVisible(true);
    }

    public void setProgramMenuGrid() {

        //JButton btn = new JButton();
        //btn.setPreferredSize(new Dimension(300, 10));
        //btn.setLabel("12");

        this.menuLabel = new JLabel("Main Menu");
        menuLabel.setVerticalAlignment(JLabel.TOP);
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
    }

    public void setStartProgramBtn(ActionListener actionListener){this.startProgramBtn.addActionListener(actionListener);}
    public void setSelectVMBtnListener(ActionListener actionListener){this.customizeVmBtn.addActionListener(actionListener);}
    public void setCustomizeVmBtnListener(ActionListener actionListener){this.customizeMoneyBtn.addActionListener(actionListener);}
    public void setCustomizeStocksBtnListener(ActionListener actionListener){this.customizeStocksBtn.addActionListener(actionListener);}

    public void setShowInventoryBtnListener(ActionListener actionListener){this.showInventoryBtn.addActionListener(actionListener);}


}
