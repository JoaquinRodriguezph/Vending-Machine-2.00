import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FactoryController {

    public FactoryController(FactoryView factoryView, FactoryModel factoryModel) {
        this.factoryModel = factoryModel;
        this.factoryView = factoryView;
        this.errorFrame = new JFrame();
        this.payment = new ArrayList<Money>();

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
                    if (vendingMachineChosed <= 0 || vendingMachineChosed > factoryModel.getVendingMachineSize())
                    {
                        factoryModel.invalidNumberError(errorFrame);
                        return;
                    }
                    factoryView.getCardLayout().show(factoryView.getCardPanel(), "Main Program");
                    int vendingMachineChosed2 = vendingMachineChosed - 1;
                    if (factoryModel.getVendingMachines().get(vendingMachineChosed2) instanceof SpecialVendingMachine){
                        factoryView.showDisplayInventoriesBtn();
                    }
                }
            }
        });

        this.factoryView.setBuyFromVmBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Buy from Vending Machine");
                factoryModel.displayVendingMachineInfo(vendingMachineChosed, factoryView.getJcomp4(), errorFrame);
                ArrayList<String> comboBox = factoryModel.comboboxChoices(vendingMachineChosed);
                for (String string: comboBox){
                    factoryView.getJcomp11().addItem(string);
                }
            }
        });

        this.factoryView.setJcomp1BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem){
                    if (total >= price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)){
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            payment.clear();
                        }
                        else{
                            for (Money money : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            factoryView.getJcomp4().append("You have bought " + factoryModel.getVendingMachines().get(vendingMachineChosed - 1).getSlotItemName(slotChosed) + ".\n");
                            factoryModel.dispenseItem(vendingMachineChosed, slotChosed);
                            selectedItem = false;
                        }
                    }
                    else{
                        Money money = new Money(1);
                        payment.add(money);
                        int tempTotal = 0;
                        for (Money money2 : payment){
                            tempTotal += money2.getValue();
                        }
                        total = tempTotal;
                        factoryView.getJcomp4().append("You have payed " + total + " pesos.\n");
                        if (total > price || total == price) {
                            ArrayList<Money> before = payment;
                            payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                            if (before.equals(payment)) {
                                factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                                payment.clear();
                            }

                        }
                        else{
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            factoryView.getJcomp4().append("You have bought " + factoryModel.getVendingMachines().get(vendingMachineChosed - 1).getSlotItemName(slotChosed) + ".\n");
                            factoryModel.dispenseItem(vendingMachineChosed, slotChosed);
                            selectedItem = false;
                        }
                    }
                }
                else{
                    factoryModel.noItemSelectedError(errorFrame);
                }
            }
        });

        this.factoryView.setJcomp2BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem){
                    if (total > price || total == price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)){
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            payment.clear();
                        }
                        else{
                            for (Money money : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            factoryView.getJcomp4().append("You have bought " + factoryModel.getVendingMachines().get(vendingMachineChosed - 1).getSlotItemName(slotChosed) + ".\n");
                            factoryModel.dispenseItem(vendingMachineChosed, slotChosed);
                            selectedItem = false;
                        }
                    }
                    else{
                        Money money = new Money(5);
                        payment.add(money);
                        int tempTotal = 0;
                        for (Money money2 : payment){
                            tempTotal += money2.getValue();
                        }
                        total = tempTotal;
                        factoryView.getJcomp4().append("You have payed " + total + " pesos.\n");
                        if (total > price || total == price) {
                            ArrayList<Money> before = payment;
                            payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                            if (before.equals(payment)) {
                                factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                                payment.clear();
                            }
                        }
                    }
                }
                else{
                    factoryModel.noItemSelectedError(errorFrame);
                }
            }
        });
        this.factoryView.setJcomp13BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slotChosed = factoryView.getJcomp11().getSelectedIndex() + 1;
                if (factoryModel.getVendingMachines().get(vendingMachineChosed - 1).isSlotAvailable(slotChosed)){
                    factoryModel.success(errorFrame);
                    selectedItem = true;
                    price = factoryModel.getVendingMachines().get(vendingMachineChosed - 1).getSlotPrice(slotChosed);
                }
                else {
                    factoryModel.slotNotAvailableError(errorFrame);
                }
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
                factoryModel.displayVendingMachineInfo(vendingMachineChosed, factoryView.getRestockTa(), errorFrame);
                factoryModel.displayItems(factoryView.getRestockTa2());
            }
        });

        this.factoryView.setStockBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isParsable(factoryView.getSelectSlotTf()) && isParsable(factoryView.getSelectItemTf()) && isParsable(factoryView.getQuantityItemTf())){
                    int selectSlot = Integer.parseInt(factoryView.getSelectSlotTf());
                    int selectItem = Integer.parseInt(factoryView.getSelectItemTf());
                    int quantityItem = Integer.parseInt(factoryView.getQuantityItemTf());
                    if (selectSlot <= 0 || selectItem <= 0 || quantityItem <= 0 || selectSlot > factoryModel.getVendingMachines().get(vendingMachineChosed - 1).getNumSlots())
                    {
                        factoryModel.invalidNumberError(errorFrame);
                        return;
                    }
                    else{
                        factoryModel.setStock(vendingMachineChosed, selectSlot, selectItem, quantityItem, errorFrame);
                        factoryView.clearAllTextAreas();
                        factoryModel.displayVendingMachineInfo(vendingMachineChosed, factoryView.getRestockTa(), errorFrame);
                        factoryModel.displayItems(factoryView.getRestockTa2());
                    }
                }
                else{
                    factoryModel.invalidNumberError(errorFrame);
                }
            }
        });

        this.factoryView.setChangePriceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Change Item Slot Price");
                factoryModel.displayVendingMachineInfo(vendingMachineChosed, factoryView.getChangePriceTa(), errorFrame);
            }
        });

        this.factoryView.setSetPriceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isParsable(factoryView.getSelectItemTf2()) && isParsable(factoryView.getPriceItemTf())){
                    int selectItem = Integer.parseInt(factoryView.getSelectItemTf2());
                    int priceItem = Integer.parseInt(factoryView.getPriceItemTf());
                    if (selectItem <= 0 || priceItem <= 0 || selectItem > factoryModel.getVendingMachines().get(vendingMachineChosed - 1).getNumSlots())
                    {
                        factoryModel.invalidNumberError(errorFrame);
                        return;
                    }

                    else{
                        factoryModel.changeItemSlotPrice(vendingMachineChosed, selectItem, priceItem, errorFrame);
                        factoryView.clearAllTextAreas();
                        factoryModel.displayVendingMachineInfo(vendingMachineChosed, factoryView.getChangePriceTa(), errorFrame);
                    }
                }
                else{
                    factoryModel.invalidNumberError(errorFrame);
                }
            }
        });
        //Do Maintenance Buttons
        this.factoryView.setCollectMoneyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryModel.collectMoney(vendingMachineChosed, errorFrame);
            }
        });
        this.factoryView.setReplenishChangeBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Replenish Change");
                factoryModel.displayVendingMachineMoney(vendingMachineChosed, factoryView.getReplenishChangeTa());
            }
        });

        this.factoryView.setReplenishBillsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isParsable(factoryView.getReplenishBillsTf()) && isParsable(factoryView.getQuantityBillsTf())){
                    int denomination = Integer.parseInt(factoryView.getReplenishBillsTf());
                    int quantity = Integer.parseInt(factoryView.getQuantityBillsTf());
                    if (denomination <= 0 || quantity <= 0 || denomination > 9)
                    {
                        factoryModel.invalidNumberError(errorFrame);
                        return;
                    }
                    else{
                        factoryModel.replenishBills(vendingMachineChosed, denomination, quantity, errorFrame);
                        factoryView.clearAllTextAreas();
                        factoryModel.displayVendingMachineMoney(vendingMachineChosed, factoryView.getReplenishChangeTa());
                    }
                }
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
                factoryModel.displayItems(factoryView.getItemStocksTa());
            }
        });

        this.factoryView.setDisplayInventoriesBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Display Inventories");
                factoryModel.displayInventories(vendingMachineChosed, factoryView.getInventoriesTa());
            }
        });

        this.factoryView.setDisplayTransactionsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Display Transactions");
                factoryModel.displayTransactions(vendingMachineChosed, factoryView.getTransactionsTa());
            }
        });

        this.factoryView.setDisplayMoneyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Display Money");
                factoryModel.displayVendingMachineMoney(vendingMachineChosed, factoryView.getMoneyTa());
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
                    choice = Integer.parseInt(factoryView.getPickVmTf2());
                    if(choice > 0 && choice <= factoryModel.getVendingMachineSize()){
                        factoryView.clearAllTextAreas();
                        factoryModel.displayVendingMachineInfo(choice, factoryView.getDetailsTa(), errorFrame);
                    }
                    else {
                        factoryModel.invalidNumberError(errorFrame);
                    }
                }
                else {
                    factoryModel.invalidNumberError(errorFrame);
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
    private int price, moneyPayed, total;
    private ArrayList<Money> payment;
    private boolean selectedItem = false;
    private int vendingMachineChosed;
    private int choice, slotChosed;
    private JFrame errorFrame;
    private FactoryView factoryView;
    private FactoryModel factoryModel;
}
