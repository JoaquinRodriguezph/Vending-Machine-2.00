import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FactoryView {
    private JFrame mainFrame;
    private JLabel menuLabel;
    private JPanel btnPanel;
    private JButton selectBtn, createBtn, showBtn;
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
        }
    }

    public void setSelectBtnListener(ActionListener actionListener){this.selectBtn.addActionListener(actionListener);}
    public void setCreateBtnListener(ActionListener actionListener){this.createBtn.addActionListener(actionListener);}
    public void setShowBtnListener(ActionListener actionListener){this.showBtn.addActionListener(actionListener);}
}
