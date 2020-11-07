import Controller.RiskController;
import View.RiskView;

public class RiskGame {

    public static void main(String[] args) {
        RiskView view = new RiskView();
        RiskController controller = new RiskController(view);
    }


}
