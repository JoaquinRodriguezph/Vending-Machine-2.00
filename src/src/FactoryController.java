import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        this.factoryView.setBuyFromVmBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Buy from Vending Machine");
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

        this.factoryView.setRestockBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Restock");
            }
        });

        this.factoryView.setChangePriceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Change Price");
            }
        });

        //Change Price Buttons
        this.factoryView.setEditPriceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Edit Price");
            }
        });
        this.factoryView.setSetToSRPBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Set to SRP");
            }
        });

        this.factoryView.setSetAllToSRPBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.factoryView.setDisplaySlotsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Display Slots");
            }
        });

        //Do Maintenance Buttons
        this.factoryView.setCollectMoneyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.factoryView.setReplenishChangeBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Replenish Change");
            }
        });
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

        this.factoryView.setCreateStockBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = factoryView.getItemNameTf();
                int calories = Integer.parseInt(factoryView.getCaloriesTf());
                factoryModel.createItem(name, calories, errorFrame);
            }
        });

        this.factoryView.setSelectItemtoAddBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    choice = Integer.parseInt(factoryView.getSelectItemtoAddTf());
                }
                catch (NumberFormatException ex){
                    errorFrame = new JFrame("Error");
                    JOptionPane.showMessageDialog(errorFrame, "Please enter a valid number.");
                }
            }
        });

        this.factoryView.setAddItemBtn2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryModel.addItem(choice, errorFrame);
            }
        });
        this.factoryView.setAddItemBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Add Item");
                factoryModel.displayItems(factoryView.getItemsTa());
            }
        });

        this.factoryView.setShowItemsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Items");
                factoryModel.displayItems(factoryView.getShowItemsTa());
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
    private int choice;
    private JFrame errorFrame;
    private FactoryView factoryView;
    private FactoryModel factoryModel;
}
