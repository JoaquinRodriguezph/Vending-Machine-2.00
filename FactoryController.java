public class FactoryController {

    public FactoryController(FactoryView factoryView, FactoryModel factoryModel) {
        this.factoryModel = factoryModel;
        this.factoryView = factoryView;


    }

    private FactoryView factoryView;
    private FactoryModel factoryModel;
}
