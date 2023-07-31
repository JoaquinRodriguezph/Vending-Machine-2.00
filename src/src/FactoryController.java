import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class FactoryController {

    public FactoryController(FactoryView factoryView, FactoryModel factoryModel) {
        this.factoryModel = factoryModel;
        this.factoryView = factoryView;
        this.errorFrame = new JFrame();

        //Sets up Main Menu Buttons
        this.factoryView.setStartProgramBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Main Program");
            }
        });

        this.factoryView.setCustomizeStocksBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Customize Stocks");
            }
        });

        this.factoryView.setShowInventoryBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Inventory");
                factoryModel.displayItemInventory(factoryModel.getMyInventory(), factoryView.getShowInventoryText());
            }
        });

        this.factoryView.setCustomizeVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Customize Vending Machine");
            }
        });
        this.factoryView.setCustomizeMoneyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Customize Money");
            }
        });

        //Sets up Customize Item Stock Buttons

        this.factoryView.setCreateItemBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Create Item");
            }
        });

        this.factoryView.setCreateStockBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = factoryView.getItemNameTf();
                int srp = Integer.parseInt(factoryView.getSRPtf());
                int calories = Integer.parseInt(factoryView.getCaloriesTf());
                int stocks = Integer.parseInt(factoryView.getStocksTf());
                factoryModel.createItemStock(name, srp, calories, stocks, errorFrame);
            }
        });
    }
    private JFrame errorFrame;
    private FactoryView factoryView;
    private FactoryModel factoryModel;
}
