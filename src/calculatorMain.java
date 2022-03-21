import controller.CalculatorController;
import view.CalculatorView;

public class calculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CalculatorView view = new CalculatorView();
		CalculatorController controller = new CalculatorController(view);
	}

}
