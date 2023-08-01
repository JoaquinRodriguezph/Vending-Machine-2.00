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
                factoryModel.displayVendingMachines(factoryView.getVmTa());
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
                if (isParsable(factoryView.getPickVMTf()))
                {
                    vendingMachineChosed = Integer.parseInt(factoryView.getPickVMTf());
                    if (vendingMachineChosed < 0 || vendingMachineChosed >= factoryModel.getVendingMachineSize())
                    {
                        factoryModel.invalidNumberError(errorFrame);
                        return;
                    }
                    factoryView.getCardLayout().show(factoryView.getCardPanel(), "Main Program");
                }
            }
        });

        this.factoryView.setBuyFromVmBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Buy from Vending Machine");
                factoryModel.displayVendingMachineInfo(vendingMachineChosed, factoryView.getJcomp4(), errorFrame);
            }
        });

        this.factoryView.setDoMaintenanceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Do Maintenance");
            }
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
                factoryModel.displayVendingMachineInfo(vendingMachineChosed, factoryView.getItemSlotsTa(), errorFrame);
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
                try{
                    if (isParsable(factoryView.getCaloriesTf()));
                    int calories = Integer.parseInt(factoryView.getCaloriesTf());
                    factoryModel.createItem(name, calories, errorFrame);
                }
                catch (NumberFormatException ex){
                    errorFrame = new JFrame("Error");
                    JOptionPane.showMessageDialog(errorFrame, "Please enter a valid number.",
                            "Error", JOptionPane.ERROR_MESSAGE);;
                }
            }
        });

        this.factoryView.setSelectItemtoAddBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (isParsable(factoryView.getSelectItemtoAddTf())){
                        choice = Integer.parseInt(factoryView.getSelectItemtoAddTf());
                        factoryModel.selectItem(choice, errorFrame);
                    };
                }
                catch (NumberFormatException ex){
                    errorFrame = new JFrame("Error");
                    JOptionPane.showMessageDialog(errorFrame, "Please enter a valid number.",
                            "Error", JOptionPane.ERROR_MESSAGE);;
                }
            }
        });

        this.factoryView.setAddItemBtn2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (isParsable(factoryView.getAddItemTf())){
                        int num = Integer.parseInt(factoryView.getAddItemTf());
                        if (num > 0){
                            factoryModel.addItem(choice, num, errorFrame);
                            factoryView.clearAllTextAreas();
                            factoryModel.displayItems(factoryView.getItemsTa());
                        }
                    };
                }
                catch (NumberFormatException ex){
                    errorFrame = new JFrame("Error");
                    JOptionPane.showMessageDialog(errorFrame, "Please enter a valid number.",
                            "Error", JOptionPane.ERROR_MESSAGE);;
                }
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
        this.factoryView.setCreateVMBtn2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (isParsable(factoryView.getNumSlotsTf()) && isParsable(factoryView.getMaxItemsTf())){
                        int num = Integer.parseInt(factoryView.getNumSlotsTf());
                        int num2 = Integer.parseInt(factoryView.getMaxItemsTf());
                        String name = factoryView.getNameVmTf();
                            factoryModel.createVendingMachine(name, num, num2, errorFrame);
                    };
                }
                catch (NumberFormatException ex){
                    errorFrame = new JFrame("Error");
                    JOptionPane.showMessageDialog(errorFrame, "Please enter a valid number.",
                            "Error", JOptionPane.ERROR_MESSAGE);;
                }
            }
        });
        this.factoryView.setShowVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Vending Machines");
                factoryModel.displayVendingMachines(factoryView.getShowVMTa());
            }
        });

        this.factoryView.setShowDetailsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Show Details");
                factoryModel.displayVendingMachines(factoryView.getDetailsTa());
            }
        });

        this.factoryView.setPickBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isParsable(factoryView.getPickVmTf2())){
                    try{
                        choice = Integer.parseInt(factoryView.getPickVmTf2());
                        if(choice >= 0 && choice < factoryModel.getVendingMachineSize()){
                            factoryView.clearAllTextAreas();
                            factoryModel.displayVendingMachineInfo(choice, factoryView.getDetailsTa(), errorFrame);
                        }
                    }
                    catch (NumberFormatException ex){
                        factoryModel.invalidNumberError(errorFrame);
                        errorFrame = new JFrame("Error");
                        JOptionPane.showMessageDialog(errorFrame, "Please enter a valid number.",
                                "Error", JOptionPane.ERROR_MESSAGE);;
                    }
                }
                else {
                    factoryModel.displayVendingMachineInfo(-1, factoryView.getDetailsTa(), errorFrame);
                }
            }
        });
    }

    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
    private int vendingMachineChosed = 0;
    private int choice;
    private JFrame errorFrame;
    private FactoryView factoryView;
    private FactoryModel factoryModel;
}
