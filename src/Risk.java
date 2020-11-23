/*
Author: Nicolas Duciaume
 */

import Controller.RiskController;
import Model.*;
import View.*;

public class Risk {
	/**
	 * The main method for the game
	 * 
	 * @param args the arguments for the main method
	 */
	public static void main(String[] args) {
		RiskModel model = new RiskModel();
		RiskView view = new RiskView();
		RiskController controller = new RiskController(model, view);

	}

}
