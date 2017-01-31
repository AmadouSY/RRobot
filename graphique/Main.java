package graphique;

import java.awt.Color;
import jeu.*;

public class Main {

    public static Robot red, blue, gray, green;

        public static void main(String[] args){
                
        		// Initialise un Espace
                Espace E = new Espace();
                                
                //Ajoute des Robots au hasard 
                E.ajouterRobotHasard(green = new Robot(Color.GREEN));
                E.ajouterRobotHasard(blue = new Robot(Color.BLUE));   
                E.ajouterRobotHasard(gray = new Robot(Color.GRAY));
                E.ajouterRobotHasard(red = new Robot(Color.RED));
                
                //Le Robot à utiliser
                E.setRobot(red);
                
                // La cible
                Position target = new Position(11,2);
                
                //Donne la cible target au robot red
                E.ajouterCible(red, target);
                
                Fenetre jeu = new Fenetre(E, red);
                
        }
        
}