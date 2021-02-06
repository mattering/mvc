import javax.swing.*;
import java.awt.*;
public class View extends JFrame{

	Model model;

	JTabbedPane tp = new JTabbedPane();
	Tab1View tab1View = new Tab1View();
	Tab2View tab2View;





	 View(Model model)
	 {
	 	this.model = model;

	 	tab2View = new Tab2View(model.tab2Model);

	   tp.addTab("tab1",tab1View.panel);
	   tp.addTab("tab2",tab2View.panel);

       this.add(tp,BorderLayout.CENTER);
       setSize(600,760);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	 }


      
	
	
}