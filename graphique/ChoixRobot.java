package graphique;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoixRobot extends JPanel{
	
	private static final long serialVersionUID = 1L;

	JPanel A1 = new JPanel();
	JPanel A2 = new JPanel();

	public ChoixRobot(){
		
		//Mise en forme Box Layout

    	A1.setLayout(new BoxLayout(A1, BoxLayout.Y_AXIS));
    	A2.setLayout(new BoxLayout(A2, BoxLayout.Y_AXIS));
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    	
    	JButton red = new  JButton(new ImageIcon("src/img/robot-red.png"));
    	red.setAlignmentX(Component.CENTER_ALIGNMENT);
        A1.add(red);
    	red.addActionListener(new BoutonListenerRED());
        
		JButton blue = new  JButton(new ImageIcon("src/img/robot-blue.png"));
		blue.setAlignmentX(Component.CENTER_ALIGNMENT);
        A1.add(blue);
    	blue.addActionListener(new BoutonListenerBLUE());
    	
    	JButton green = new  JButton(new ImageIcon("src/img/robot-green.png"));
    	green.setAlignmentY(Component.CENTER_ALIGNMENT);
        A2.add(green);
        green.addActionListener(new BoutonListenerGREEN());
    	
		JButton gray = new  JButton(new ImageIcon("src/img/robot-gray.png"));
		gray.setAlignmentY(Component.CENTER_ALIGNMENT);
        A2.add(gray);
    	gray.addActionListener(new BoutonListenerGRAY());
    	
		A1.setAlignmentX(Component.CENTER_ALIGNMENT);
		A2.setAlignmentX(Component.CENTER_ALIGNMENT);

    	this.add(A1);
    	this.add(A2);

	}
	
	class BoutonListenerRED implements ActionListener{
    	public void actionPerformed(ActionEvent arg0) {
    		System.out.println("Controle du robot red" +Fenetre.RB.getColor());
    		Fenetre.RB = Main.red;
    	}
	}
	class BoutonListenerBLUE implements ActionListener{
    	public void actionPerformed(ActionEvent arg0) {
    		System.out.println("Controle du robot blue" +Fenetre.RB.getColor());
    		Fenetre.RB = Main.blue;
    	}
	}
	class BoutonListenerGREEN implements ActionListener{
    	public void actionPerformed(ActionEvent arg0) {
    		System.out.println("Controle du robot green" +Fenetre.RB.getColor());
    		Fenetre.RB = Main.green;
    	}
	}
	class BoutonListenerGRAY implements ActionListener{
    	public void actionPerformed(ActionEvent arg0) {
    		System.out.println("Controle du robot gray" +Fenetre.RB.getColor());
    		Fenetre.RB = Main.gray;
    	}
	}
}
