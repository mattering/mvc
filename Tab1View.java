


import javax.swing.*;
import java.awt.*;


class  Tab1View{
    
    JPanel panel = new JPanel();
	JButton calculate = new JButton("calculate");
    JRadioButton y1 = new JRadioButton("y=ax+b+c");
    JRadioButton y2 = new JRadioButton("y=ax^2+bx-c");
    JRadioButton y3 = new JRadioButton("y=ax^3+bx^2+c");

    JTextField xStartField = new JTextField("0");
    JTextField xEndField = new JTextField("5");
    JTextField fileName = new JTextField("Type text name");

    JTextField af = new JTextField("1");
    JTextField bf = new JTextField("2");
    JTextField cf = new JTextField("-2");
    JTextField stepf = new JTextField("0.0001");
    DisplayGraphics g = new DisplayGraphics() ;
    JButton findR = new JButton("Find root");
    JButton findR2 = new JButton("Find Root 2");

   Tab1View(){

	     JLabel var1 = new JLabel("X start: ");
        JLabel var2 = new JLabel("X end: ");

        var1.setBounds(15, 15, 70, 30);
        var2.setBounds(15, 55, 70, 30);

        panel.add(var1);
        panel.add(var2);

        xStartField.setBounds(90, 15, 70, 30);
        xEndField.setBounds(90, 55, 70, 30);

        panel.add(this.xStartField);
        panel.add(this.xEndField);

        JLabel var3 = new JLabel("a :");
        JLabel var4 = new JLabel("b :");
        JLabel var5 = new JLabel("c :");
        JLabel var6 = new JLabel("accuracy :");

        y1.setBounds(20, 100, 150, 30);
        y2.setBounds(20, 140, 150, 30);
        y3.setBounds(20, 180, 150, 30);

        var3.setBounds(20, 230, 30, 20);
        var4.setBounds(20, 260, 30, 20);
        var5.setBounds(20, 290, 30, 20);
        var6.setBounds(5, 320, 65, 30);

        g.setBounds(340,10,545,750);



        af.setBounds(50, 230, 90, 30);
        bf.setBounds(50, 260, 90, 30);
        cf.setBounds(50, 290, 90, 30);
        stepf.setBounds(70, 320, 90, 30);
        calculate.setBounds(50, 400, 100, 30);
        findR.setBounds(50,440,100,30);
        findR2.setBounds(50,480,100,30);

        panel.add(findR2);
        panel.add(this.findR);
        panel.add(this.calculate);

        ButtonGroup var7 = new ButtonGroup();
        var7.add(this.y1);
        var7.add(this.y2);
        var7.add(this.y3);

        panel.add(this.y1);
        panel.add(this.y2);
        panel.add(this.y3);

        panel.add(var3);
        panel.add(var4);
        panel.add(var5);
        panel.add(var6);

        panel.add(this.af);
        panel.add(this.bf);
        panel.add(this.cf);
        panel.add(this.stepf);
        panel.add(g);
        panel.setLayout(null);
      
        



    }
   

	
}