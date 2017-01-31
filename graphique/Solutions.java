package graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import jeu.*;

public class Solutions extends JPanel {

	private static final long serialVersionUID = 1L;

	public Espace E;
	public Solutions(Espace E){
		this.E = E;
		
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JButton Sol1Coups = new JButton("Sol1coups");
        this.add(Sol1Coups);
    	Sol1Coups.addActionListener(new BoutonListener1());
    	
		
		JButton Sol2Coups = new JButton("Solkcoups");
        this.add(Sol2Coups);
    	Sol2Coups.addActionListener(new BoutonListener2());
		

	}
	
	class BoutonListener1 implements ActionListener{
    	public void actionPerformed(ActionEvent arg0) {
    		System.out.println(E.sol1coups());
    	}
	}
	class BoutonListener2 implements ActionListener{
    	public void actionPerformed(ActionEvent arg0) {
    		System.out.println(E.sol2coups());
    	}
	}
}
