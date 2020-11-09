import Controller.GameController;
import Controller.RiskController;
import Model.*;
import View.*;

public class Risk {

    public static void main(String[] args) {
        RiskModel model = new RiskModel();
        RiskView view = new RiskView();
        RiskController controller = new RiskController(model,view);

    }


}
