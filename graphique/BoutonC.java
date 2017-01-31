package graphique;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import jeu.*;

public class BoutonC extends JButton implements MouseListener{
 
	private static final long serialVersionUID = 1L;
	
	public Espace E;
	public int  mouv;

	
	public BoutonC(String str, Espace E, int mouv){
	    super(str);
	    this.E = E;
	    this.mouv = mouv;
    
    this.addMouseListener(this);
  }

	public void mouseClicked(MouseEvent event) { 
	    Fenetre.RB.mouv(mouv,E);
	    Controleur.compteur++;
	    Fenetre.NBCoups.setText("Nombre de coups : " + Controleur.compteur); 
	    if(E.victoire()){
	    	String txt = "BRAVO VOUS AVEZ REUSSIS CE NIVEAU\n";
	        txt += "Vous avez réussis à résoudre le puzzle\n\n";
	        String nom = JOptionPane.showInputDialog(null, txt+"Quel est votre nom ??", "VICTOIRE", JOptionPane.QUESTION_MESSAGE);       
	    	JOptionPane.showMessageDialog(null, nom+", il vous a fallut "+Controleur.compteur+" deplacements !", "Victoire", JOptionPane.INFORMATION_MESSAGE);
	    }    
	}

  public void mouseEntered(MouseEvent event) { }
  public void mouseExited(MouseEvent event) { }
  public void mousePressed(MouseEvent event) { }
  public void mouseReleased(MouseEvent event) { }       
}