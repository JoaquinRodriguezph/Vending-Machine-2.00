import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FactoryView {
    private JFrame mainFrame;
    private JLabel menuLabel;
    private JPanel btnPanel;
    private ArrayList<JButton> buttonList;

    public FactoryView() {
        this.btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(10,1));

        this.mainFrame = new JFrame("Vending Machine Factory");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(350, 400);

        this.menuLabel = new JLabel("Main Menu");
        menuLabel.setHorizontalAlignment(JLabel.CENTER);

        this.mainFrame.add(this.menuLabel);

        setProgramMenuGrid();

        this.mainFrame.add(btnPanel);

        this.mainFrame.setVisible(true);
    }

    public void setProgramMenuGrid() {

        JButton btn = new JButton();
        btn.setPreferredSize(new Dimension(300, 10));
        btn.setLabel("12");

        btnPanel.add(new Button("Start Main Program"));
        btnPanel.add(btn);
        btnPanel.add(new Button("1"));

    }
}
