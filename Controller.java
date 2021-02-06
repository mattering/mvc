import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Controller{
	Model model;
	View view;
	Tab1Controller tab1Controller;
	Tab2Controller tab2Controller;

	Controller(Model model, View view){
		this.model = model;
		this.view = view;
		tab1Controller = new Tab1Controller(model.tab1Model,this.view);
		tab2Controller = new Tab2Controller(model.tab2Model,this.view);


	}





}