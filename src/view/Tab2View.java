package view;


import model.Tab2Model;
import view.DisplayGraphics;

import javax.swing.*;

public class Tab2View{
	Tab2Model tab2Model;
	JPanel panel = new JPanel();
	public JTextField coordinateText = new JTextField("write text file ex(text.txt)");
	public JTextField errorField = new JTextField("Please write in text at least two coordinates:) ");
	public JButton drawCoordinates = new JButton("Draw");
	public DisplayGraphics g = new DisplayGraphics();

	Tab2View(Tab2Model model){
		this.tab2Model = model;
		coordinateText.setBounds(10,10,200,30);
		drawCoordinates.setBounds(215,10,100,30);
		JLabel label = new JLabel("ERRORS : ");
		label.setBounds(325,10,70,30);
		errorField.setBounds(395,10,250,30);

		panel.add(coordinateText);
		panel.add(drawCoordinates);
		panel.add(label);
		panel.add(errorField);
		panel.add(g);
		panel.setLayout(null);


	}
}