package view;


import model.Tab1Model;
import model.Tab2Model;

import java.awt.*;

public class DisplayGraphics extends Canvas{

	Tab1Model tab1Model;
	Tab2Model tab2Model;

	int scaleX, scaleY;
	int posX, posY;
	String buttonName;



	DisplayGraphics(){

	}
	public void paint(Graphics g){
		//System.out.println("barmyn");

	    if(buttonName == "calculate"){
	    	drawScaleBack(g);
	    	drawFunc(g);
	    }

	    if(buttonName == "findRoot_1"){
	    	drawScaleBack(g);
	    	drawFunc(g);
	    	findRoot_1(g);
	    }
	    else if(buttonName == "findRoot_2"){
	    	drawScaleBack(g);
	    	drawFunc(g);
	    	findRoot_2(g);
	    }
	    else if(buttonName == "drawText"){
	    	drawScaleBack(g);
	    	drawFromText(g);

	    }

	}
	private void findRoot_1(Graphics g){
// bisectioin method
		float a = tab1Model.xStart;
		float b = tab1Model.xEnd;

		if (tab1Model.calculateY(a) * tab1Model.calculateY(b) > 0) {

			// System.out.println("You have not assumed"
			// 				+ " right a and b");
		}
         else {
				
		     float ans = tab1Model.findRoot();

			g.drawOval(Math.round(ans * scaleX) + posX - 4, posY - 4 - Math.round(tab1Model.calculateY(ans) * scaleY), 8, 8);
			g.drawString(Float.toString(ans), Math.round(ans * scaleX) + posX - 4,
							posY - 10 - Math.round(tab1Model.calculateY(ans) * scaleY));
		}		

	}
	private void findRoot_2(Graphics g){
		float x0;
		if (tab1Model.calculateY(tab1Model.xStart) * tab1Model.calculateY(tab1Model.xEnd) <= 0){
			x0 = tab1Model.findRootSecant();

			g.setColor(Color.BLUE);
			g.drawOval(Math.round(x0 * scaleX) + posX - 5, posY - 5 - Math.round(tab1Model.calculateY(x0) * scaleY), 10, 10);

			g.drawString(Float.toString(x0), Math.round(x0 * scaleX) + posX - 5,
							posY - 25 - Math.round(tab1Model.calculateY(x0) * scaleY));
		}

	}
	private void drawFunc(Graphics g){
	    g.setColor(Color.BLACK);

		float v = (float) 1 / scaleX,y1,y;

		for (float x = Math.round(tab1Model.xStart * scaleX); x <= Math.ceil(tab1Model.xEnd * scaleX); x++) {

				y1 = (tab1Model.calculateY((x / scaleX)));
				y = (tab1Model.calculateY((x / scaleX) + v));
				g.drawLine(Math.round(x) + posX, getHeight() - (Math.round(y1 * scaleY) + posY),
						   Math.round(x) + 1 + posX, getHeight() - (Math.round(y * scaleY) + posY));
			}
	
	}
	private void drawScaleBack(Graphics g) {

		g.setColor(Color.GREEN);

		for (int j = 0; j <= posY; j += scaleY) {

			//float yt = (posY-j)/scaleY;
			g.drawLine(0, j + posY, getWidth(), j + posY);
			g.drawLine(0, posY - j, getWidth(), posY - j);
			//g.drawString(String.format("%.2f",yt),posX,(int)j);

		}
		for (int j = 0; j <= posX; j += scaleX) {

			g.drawLine(j + posX, 0, j + posX, getHeight());
			g.drawLine(posX - j, 0, posX - j, getHeight());
		}

		g.setColor(Color.RED);
		g.drawLine(posX, 0, posX, getHeight());
		g.drawLine(0, posY, getWidth(), posY);

	}


	public void setInit(Tab1Model model,String buttonName){
		this.tab1Model = model;

		this.buttonName = buttonName;

		scaleX = (int) Math.floor((double) getWidth() / Math.ceil(tab1Model.rangeX() + 2));
		if (tab1Model.rangeY() != 0) scaleY = (int) Math.ceil((double) getHeight() / Math.ceil(tab1Model.rangeY() + 2));
		else scaleY = scaleX;

		posX = getWidth() / 2;
		posY = getHeight() / 2;
	}

	public void setInit(Tab2Model tab2Model,String buttonName)
	{
        this.tab2Model = tab2Model;
        this.buttonName = buttonName;

        scaleX = (int) Math.floor((double) getWidth() / Math.ceil(tab2Model.rangeX() + 2));
		if (tab2Model.rangeY() != 0) scaleY = (int) Math.ceil((double) getHeight() / Math.ceil(tab2Model.rangeY() + 2));
		else scaleY = scaleX;

		posX = getWidth() / 2;
		posY = getHeight() / 2;


	}



	public void drawFromText(Graphics g)
	{  
      g.setColor(Color.BLACK);
      for(int i =0; i<tab2Model.vecY.size()-1;i++)
      {
      	g.drawLine(Math.round(tab2Model.vecX.get(i)*scaleX) + posX, getHeight() - (Math.round(tab2Model.vecY.get(i)* scaleY) + posY),
						   Math.round(tab2Model.vecX.get(i+1)*scaleX) + posX, getHeight() - (Math.round(tab2Model.vecY.get(i+1)* scaleY) + posY));

      }
		
	}


	
}