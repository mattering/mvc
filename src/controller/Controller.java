package controller;

import controller.Tab1Controller;
import controller.Tab2Controller;
import model.Model;
import view.View;

public class Controller{
	Model model;
	View view;
	Tab1Controller tab1Controller;
	Tab2Controller tab2Controller;

	public Controller(Model model, View view){
		this.model = model;
		this.view = view;
		tab1Controller = new Tab1Controller(model.tab1Model,this.view);
		tab2Controller = new Tab2Controller(model.tab2Model,this.view);


	}





}