import controller.Controller;
import model.Model;
import view.View;

class Main{
	
	public static void main(String[] args){

       
		Model model = new Model();
	    View view = new View(model);
		Controller controller = new Controller(model, view);

	    view.setVisible(true);

	}
}