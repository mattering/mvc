package controller;

import model.Tab1Model;
import view.Tab1View;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Tab1Controller implements ActionListener{   

	Tab1Model model;
	Tab1View view;
	View v;

	Tab1Controller(Tab1Model model, View v)
	{
                this.model = model;
                this.v = v;
                this.view = this.v.tab1View;

                addListener();



	}
	private void addListener()
	{
        view.calculate.addActionListener(this);
        view.findR.addActionListener(this);
        view.findR2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){

		view.g.setBounds(200,20,v.getWidth()-220,v.getHeight()-50);

        // System.out.println(getHeight()+"  "+getWidth());

        //a,b,c,fun_Id,xStart,xEnd,accuracy
        model.setInit(Float.parseFloat(view.af.getText()),
        	          Float.parseFloat(view.bf.getText()),
        	          Float.parseFloat(view.cf.getText()),
        	          view.y1.isSelected()?1:view.y2.isSelected()?2:view.y3.isSelected()?3:0,
        	          Float.parseFloat(view.xStartField.getText()),
        	          Float.parseFloat(view.xEndField.getText()),
        	          Float.parseFloat(view.stepf.getText())
        	          );


        String buttonName = "nothing";

        if(e.getSource() == view.calculate)
        {
        	buttonName = "calculate";
        	
        }
        else if(e.getSource() == view.findR)
        {
        	buttonName = "findRoot_1";
        }
        else if(e.getSource() == view.findR2)
        {
        	buttonName = "findRoot_2";

        }
       // System.out.println("Men");
        view.g.setInit(model,buttonName);
        view.g.repaint();

      


        // bl=(var1.getSource()==this.findR)?true:bl;
        // bl2=(var1.getSource()==this.findR2)?true:bl2;

        



       // g.setInit(this);

       // g.repaint();




	}



}

