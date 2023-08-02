import java.util.ArrayList;
import java.util.Iterator;

public class FactoryMain {
    public static void main(String args[]) {

        FactoryView factoryView = new FactoryView();
        FactoryModel factoryModel = new FactoryModel();

        FactoryController factoryController = new FactoryController(factoryView, factoryModel);
    }

}
