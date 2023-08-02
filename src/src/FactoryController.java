import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FactoryController {

    /**
     * This method is the constructor for the Factory View Class. It is used to initialize the components of the GUI.
     */
    public FactoryController(FactoryView factoryView, FactoryModel factoryModel) {
        this.factoryModel = factoryModel;
        this.factoryView = factoryView;
        this.errorFrame = new JFrame();
        this.silog = new ArrayList<Item>();
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
                    isSVM = false;
                    if (factoryModel.getVendingMachines().get(vendingMachineChosed2) instanceof SpecialVendingMachine){
                        isSVM = true;
                        factoryView.showSpecialVMButtons();
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
                factoryView.setMainFrameSize(600,390);
                for (String string: comboBox){
                    factoryView.getJcomp11().addItem(string);
                }
                factoryView.hideBuysilog();
                if (isSVM){
                    factoryView.showBuysilog();
                }
            }
        });

        this.factoryView.setJcomp1BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem){
                    Money money = new Money(1);
                    payment.add(money);
                    int tempTotal = 0;
                    for (Money money2 : payment){
                        tempTotal += money2.getValue();
                    }
                    total = tempTotal;
                    factoryView.getJcomp4().append("You have paid " + total + " pesos.\n");
                    if (total > price || total == price) {
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)) {
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            payment.clear();
                        }
                        else{
                            if(payment.size() != 0){
                                factoryView.getJcomp4().append("Your change is being returned.\n");
                                for (Money money1: payment){
                                    factoryView.getJcomp4().append("You have received " + money1.getValue() + " pesos.\n");
                                }
                            }
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
                    Money money = new Money(5);
                    payment.add(money);
                    int tempTotal = 0;
                    for (Money money2 : payment){
                        tempTotal += money2.getValue();
                    }
                    total = tempTotal;
                    factoryView.getJcomp4().append("You have paid " + total + " pesos.\n");
                    if (total > price || total == price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)) {
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            payment.clear();
                        }
                        else{
                            if(payment.size() != 0){
                                factoryView.getJcomp4().append("Your change is being returned.\n");
                                for (Money money1: payment){
                                    factoryView.getJcomp4().append("You have received " + money1.getValue() + " pesos.\n");
                                }
                            }
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

        this.factoryView.setJcomp3BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedItem){
                    Money money = new Money(10);
                    payment.add(money);
                    int tempTotal = 0;
                    for (Money money2 : payment){
                        tempTotal += money2.getValue();
                    }
                    total = tempTotal;
                    factoryView.getJcomp4().append("You have paid " + total + " pesos.\n");
                    if (total > price || total == price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)) {
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            payment.clear();
                        }
                        else{
                            if(payment.size() != 0){
                                factoryView.getJcomp4().append("Your change is being returned.\n");
                                for (Money money1: payment){
                                    factoryView.getJcomp4().append("You have received " + money1.getValue() + " pesos.\n");
                                }
                            }
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

        this.factoryView.setJcomp5BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem){
                    Money money = new Money(20);
                    payment.add(money);
                    int tempTotal = 0;
                    for (Money money2 : payment){
                        tempTotal += money2.getValue();
                    }
                    total = tempTotal;
                    factoryView.getJcomp4().append("You have paid " + total + " pesos.\n");
                    if (total > price || total == price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)) {
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            payment.clear();
                        }
                        else{
                            if(payment.size() != 0){
                                factoryView.getJcomp4().append("Your change is being returned.\n");
                                for (Money money1: payment){
                                    factoryView.getJcomp4().append("You have received " + money1.getValue() + " pesos.\n");
                                }
                            }
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

        this.factoryView.setJcomp6BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem){
                    Money money = new Money(50);
                    payment.add(money);
                    int tempTotal = 0;
                    for (Money money2 : payment){
                        tempTotal += money2.getValue();
                    }
                    total = tempTotal;
                    factoryView.getJcomp4().append("You have paid " + total + " pesos.\n");
                    if (total > price || total == price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)) {
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            payment.clear();
                        }
                        else{
                            if(payment.size() != 0){
                                factoryView.getJcomp4().append("Your change is being returned.\n");
                                for (Money money1: payment){
                                    factoryView.getJcomp4().append("You have received " + money1.getValue() + " pesos.\n");
                                }
                            }
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

        this.factoryView.setJcomp7BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem){
                    Money money = new Money(100);
                    payment.add(money);
                    int tempTotal = 0;
                    for (Money money2 : payment){
                        tempTotal += money2.getValue();
                    }
                    total = tempTotal;
                    factoryView.getJcomp4().append("You have paid " + total + " pesos.\n");
                    if (total > price || total == price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)) {
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            payment.clear();
                        }
                        else{
                            if(payment.size() != 0){
                                factoryView.getJcomp4().append("Your change is being returned.\n");
                                for (Money money1: payment){
                                    factoryView.getJcomp4().append("You have received " + money1.getValue() + " pesos.\n");
                                }
                            }
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

        this.factoryView.setJcomp8BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem){
                    Money money = new Money(200);
                    payment.add(money);
                    int tempTotal = 0;
                    for (Money money2 : payment){
                        tempTotal += money2.getValue();
                    }
                    total = tempTotal;
                    factoryView.getJcomp4().append("You have paid " + total + " pesos.\n");
                    if (total > price || total == price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)) {
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            payment.clear();
                        }
                        else{
                            if(payment.size() != 0){
                                factoryView.getJcomp4().append("Your change is being returned.\n");
                                for (Money money1: payment){
                                    factoryView.getJcomp4().append("You have received " + money1.getValue() + " pesos.\n");
                                }
                            }
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

        this.factoryView.setJcomp9BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem){
                    Money money = new Money(500);
                    payment.add(money);
                    int tempTotal = 0;
                    for (Money money2 : payment){
                        tempTotal += money2.getValue();
                    }
                    total = tempTotal;
                    factoryView.getJcomp4().append("You have paid " + total + " pesos.\n");
                    if (total > price || total == price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)) {
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            payment.clear();
                        }
                        else{
                            if(payment.size() != 0){
                                factoryView.getJcomp4().append("Your change is being returned.\n");
                                for (Money money1: payment){
                                    factoryView.getJcomp4().append("You have received " + money1.getValue() + " pesos.\n");
                                }
                            }
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

        this.factoryView.setJcomp10BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem){
                    Money money = new Money(1000);
                    payment.add(money);
                    int tempTotal = 0;
                    for (Money money2 : payment){
                        tempTotal += money2.getValue();
                    }
                    total = tempTotal;
                    factoryView.getJcomp4().append("You have paid " + total + " pesos.\n");
                    if (total > price || total == price){
                        ArrayList<Money> before = payment;
                        payment = factoryModel.getChange(vendingMachineChosed, payment, price);
                        if (before.equals(payment)) {
                            factoryView.getJcomp4().append("Not enough change, your money is returned\n");
                            for (Money money2 : payment){
                                factoryView.getJcomp4().append("You have received " + money.getValue() + " pesos.\n");
                            };
                            payment.clear();
                        }
                        else{
                            if(payment.size() != 0){
                                factoryView.getJcomp4().append("Your change is being returned.\n");
                                for (Money money1: payment){
                                    factoryView.getJcomp4().append("You have received " + money1.getValue() + " pesos.\n");
                                }
                            }
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
        this.factoryView.setJcomp13BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slotChosed = factoryView.getJcomp11().getSelectedIndex() + 1;
                if (factoryModel.getVendingMachines().get(vendingMachineChosed - 1).isSlotAvailable(slotChosed)){
                    factoryModel.success(errorFrame);
                    selectedItem = true;
                    price = factoryModel.getVendingMachines().get(vendingMachineChosed - 1).getSlotPrice(slotChosed);
                    factoryView.getJcomp4().append("Selected Item: " + factoryModel.getVendingMachines().get(vendingMachineChosed - 1).getSlotItemName(slotChosed) + " - " + price + " PHP\n");
                }
                else {
                    factoryModel.slotNotAvailableError(errorFrame);
                }
            }
        });

        this.factoryView.setJcomp15BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSVM){
                    factoryView.getCardLayout().show(factoryView.getCardPanel(), "Special Vending Machine");
                    ArrayList<String> items = factoryModel.specialComboBox(vendingMachineChosed);
                    for (String string : items)
                    {
                        factoryView.getItemSlot().addItem(string);
                    }
                    factoryModel.displaySpecialVendingMachineInventory(vendingMachineChosed, factoryView.getSelledItems());
                    factoryView.getSelected_Items().append("Selected Items\n");
                }
                else {
                    factoryModel.notSpecialVendingMachine(errorFrame);
                }
            }
        });
        //Sets up Do Maintenance Buttons

        this.factoryView.setDoMaintenanceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Do Maintenance");
            }
        });


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
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Create Regular Vending Machine");
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
                    factoryModel.invalidNumberError(errorFrame);
                }
            }
        });

        //Special Vending Machine Listeners
        this.factoryView.setAddBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.clearAllTextAreas();
                slotChosed = factoryView.getItemSlot().getSelectedIndex() + 1;
                Item item = factoryModel.getItem(vendingMachineChosed, slotChosed);
                factoryView.getSelected_Items().append(item.getName() + "\n");
                silog.add(item);
            }
        });
        this.factoryView.setCreateSpecialVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Create Special Vending Machine");
            }
        });

        this.factoryView.setCreateVMBtn3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (isParsable(factoryView.getNumSlotsTf2()) && isParsable(factoryView.getMaxItemsTf2())
                            && isParsable(factoryView.getInventoryLimitTf2())){
                        int num = Integer.parseInt(factoryView.getNumSlotsTf2());
                        int num2 = Integer.parseInt(factoryView.getMaxItemsTf2());
                        int num3 = Integer.parseInt(factoryView.getInventoryLimitTf2());
                        String name = factoryView.getNameVmTf2();
                        factoryModel.createSpecialVendingMachine(name, num, num2, num3, errorFrame);
                    };
                }
                catch (NumberFormatException ex){
                    factoryModel.invalidNumberError(errorFrame);
                }
            }
        });

        this.factoryView.setAddItemtoInventoryMenuBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Add Item to Inventory");
                factoryModel.displayItems(factoryView.getAddItemTa());
                factoryView.hideSpecialPrice();
            }
        });

        this.factoryView.setAddItemtoInventoryBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isParsable(factoryView.getSelectSpecialItemTf())){
                      int choice = Integer.parseInt(factoryView.getSelectSpecialItemTf());
                      if (factoryModel.addToInventoryTest(vendingMachineChosed, choice)){
                            factoryModel.addToInventoryTrue(vendingMachineChosed, choice);
                            factoryView.clearAllTextAreas();
                            factoryModel.displayItems(factoryView.getAddItemTa());
                            factoryModel.success(errorFrame);
                        }
                      else{
                            factoryView.showSpecialPrice();
                            if(isParsable(factoryView.getSetSpecialPriceTf())){
                                int price = Integer.parseInt(factoryView.getSetSpecialPriceTf());
                                factoryModel.addToInventoryFalse(vendingMachineChosed, choice, price);
                                factoryView.clearAllTextAreas();
                                factoryModel.displayItems(factoryView.getAddItemTa());
                                factoryModel.success(errorFrame);
                            }
                            else{
                                factoryModel.invalidNumberError(errorFrame);
                            }
                        }
                }
                else {
                    factoryModel.invalidNumberError(errorFrame);
                }
            }
        });

        this.factoryView.setChangePriceofItemMenuBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factoryView.getCardLayout().show(factoryView.getCardPanel(), "Change Price of Item");
                factoryModel.displaySpecialVendingMachineInventory(vendingMachineChosed, factoryView.getChangePriceofItemTa());
            }
        });

        this.factoryView.setChangePriceofItemBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isParsable(factoryView.getSelectIndexTf()) && isParsable(factoryView.getSetItemPriceTf())){
                    int index = Integer.parseInt(factoryView.getSelectIndexTf());
                    int price = Integer.parseInt(factoryView.getSetItemPriceTf());
                    int listsize = factoryModel.getSVMItemListSize(vendingMachineChosed);
                    if (index <= 0 || index > listsize){
                        factoryModel.invalidNumberError(errorFrame);
                    }
                    else{
                        factoryModel.setItemPrice(vendingMachineChosed, index, price);
                        factoryView.clearAllTextAreas();
                        factoryModel.displaySpecialVendingMachineInventory(vendingMachineChosed, factoryView.getChangePriceofItemTa());
                        factoryModel.success(errorFrame);
                    }
                }
                else{
                    factoryModel.invalidNumberError(errorFrame);
                }
            }
        });

        //
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

    /**
     * This method is a helper method that checks if the input is can be used to parseInt
     *
     * @return true if the input is can be used to parseInt, false otherwise
     */
    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    private ArrayList<Item> silog;
    private boolean isSVM = false;
    private int price, moneyPayed, total;
    private ArrayList<Money> payment;
    private boolean selectedItem = false;
    private int vendingMachineChosed;
    private int choice, slotChosed;
    private JFrame errorFrame;
    private FactoryView factoryView;
    private FactoryModel factoryModel;
}
