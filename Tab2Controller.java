

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Tab2Controller implements ActionListener{
	Tab2Model model;
	View view;
	Tab2View viewTab2;
	Tab2Controller(Tab2Model model,View view){
		this.model = model;
		this.view = view;
	    viewTab2 = this.view.tab2View;

		addListeners();


	}
	private void addListeners()
	{
		viewTab2.drawCoordinates.addActionListener(this);

	}

	public void actionPerformed(ActionEvent event){

		model.fileName = viewTab2.coordinateText.getText();
		model.vecX.clear();
		model.vecY.clear();

		Boolean isRead = false;

		if (model.fileName.length() > 4)
		{	
			FileInputStream fin = null;
	        try {
		              // File file = new File("./tmp.txt");
		              //  inputStream = new FileInputStream(file);
		
		              //     // use the inputStream to read a file
		
		              //     // do NOT do this
		              //   inputStream.close();

	            	fin = new FileInputStream(model.fileName);
   			   	    BufferedReader br = new BufferedReader(new InputStreamReader(fin));

   						 /*Path pathToFile = Paths.get(fileName);
   						 br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII);*/

   					String line = br.readLine();
    				while (line != null) {
        					
                        String[] attributes = line.split(" ");

                        if(attributes.length==2)
                        {
                            	float tmpX;
                            	float tmpY;

                            	try { 
                                       // returns the float value 
                                       // represented by the string argument 
                                    tmpX = Float.parseFloat(attributes[0]); 
                                    tmpY = Float.parseFloat(attributes[1]);      
                                 } 
  
                                 catch (Exception e) { 
                                    
                                    viewTab2.errorField.setText("Exception: " + e);
                                    break;
                                 } 

                                model.vecX.add(tmpX);
        					    model.vecY.add(tmpY);

        					   
        					    viewTab2.errorField.setText("No Problem :) perfect");
        					    isRead = true;
                        }
                        else{
                            viewTab2.errorField.setText("Error with format in text");
                            break;
                        } 
        				line = br.readLine();
    				}
    						 
   					fin.close();
    				br.close();
		    }
				catch (FileNotFoundException exception) {
					viewTab2.errorField.setText("File Not Found");
		                
	            } 
	            catch (IOException exception) {
	            	viewTab2.errorField.setText("IOException");
		                 //
	            }
			}
			else{

                 viewTab2.errorField.setText("Too short name or has no format");
			}


			if(isRead)
			{   
		        viewTab2.g.setBounds(10,50,view.getWidth()-40,view.getHeight()-120);
				viewTab2.g.setInit(model,"drawText");
				viewTab2.g.repaint();
			}
        

	}
}