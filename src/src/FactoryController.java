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
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Pick Vending Machine");
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

        //Sets up Main Program Buttons
        this.factoryView.setPickVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Main Program");
            }
        });

        this.factoryView.setDoMaintenanceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Do Maintenance");
            }
        });
        this.factoryView.setSelectWalletBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Select Wallet");
            }
        });
        this.factoryView.setShowCurrentWalletBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Current Wallet");}
        });

        //Sets up Do Maintenance Buttons

        this.factoryView.setShowItemSlotsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Item Slots");
            }
        });
        this.factoryView.setShowItemStocksBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Item Stocks");
            }
        });

        this.factoryView.setDisplayInventoriesBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Display Inventories");
            }
        });

        this.factoryView.setDisplayTransactionsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Display Transactions");
            }
        });

        this.factoryView.setDisplayMoneyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Display Money");
            }
        });

        //Sets up Customize Item Stock Buttons

        this.factoryView.setCreateItemBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Create Item");
            }
        });

        /*
        this.factoryView.setCreateStockBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = factoryView.getItemNameTf();
                int srp = Integer.parseInt(factoryView.getSRPtf());
                int calories = Integer.parseInt(factoryView.getCaloriesTf());
                int stocks = Integer.parseInt(factoryView.getStocksTf());
                factoryModel.createItemStock(name, srp, calories, stocks, errorFrame);
            }
        });*/

        this.factoryView.setAddItemBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Add Item");
            }
        });

        this.factoryView.setShowItemsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Items");
            }
        });


        //Sets up Customize Vending Machine Buttons
        this.factoryView.setCreateVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Create Vending Machine");
            }
        });
        this.factoryView.setShowVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Vending Machines");
            }
        });

        this.factoryView.setShowDetailsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Details");
            }
        });
    }
    private JFrame errorFrame;
    private FactoryView factoryView;
    private FactoryModel factoryModel;
}
