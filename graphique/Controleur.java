package graphique;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import jeu.*;

public class Controleur extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public JButton Haut, Bas, Gauche, Droite;
    public static int compteur = 0;
	
	//Constructeurs
	
	public Controleur(Espace E){
				
    	BoutonC Haut = new BoutonC("HAUT",E,1);
    	BoutonC Bas = new BoutonC("BAS",E,3);
    	BoutonC Gauche = new BoutonC("GAUCHE",E,4);
    	BoutonC Droite = new BoutonC("DROITE",E,2);
    	
    	this.setLayout(new BorderLayout());

    	
        this.add(Haut, BorderLayout.NORTH);
        this.add(Bas, BorderLayout.SOUTH);
        this.add(Droite, BorderLayout.EAST);
        this.add(Gauche, BorderLayout.WEST);	
        
	}
	
}