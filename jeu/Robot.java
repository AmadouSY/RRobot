package jeu;

import java.awt.Color;

public class Robot /*implements Joueur */{
//Objet Robot controlé par l'utilisateur
	
	//Variables
	private Color couleur;
	private int id;
	private int idSuivant = 0;
	public Position position;
	
	//Constructeurs
	public Robot(){
		this.couleur = Color.GRAY;
	}
	
	public Robot(Position p){
		this.couleur = Color.GRAY;
		this.position = p;
	}
	
	public Robot(Color c){
		this.couleur = c;
		this.id = idSuivant;
		this.idSuivant++;
	}
	
	public Robot(Color c, Position p){
		this.couleur = c;
		this.position = p;
	}
	
	//Accesseurs
	public Color getColor(){
		return this.couleur;
	}
	
	public int getId(){
		return this.id;
	}
	
	public Position getPosition(){
		return this.position;
	}
	
	//Mutateurs
	public void setColor(Color c){
		this.couleur = c;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public void setPositon(Position p){
		this.position = p;
	}
	//Methodes (essentiellement de deplacement)
	
    public void mouv(int i, Espace E) {
        Cellule c = E.modif(this,i);
        if(c!=null && c.getMur(i)) mouv(i, E);
    }
	
	public void mouvHaut(Espace E){
        Cellule c = E.modif(this,1);
        if(c!=null && c.haut) mouvHaut(E);
	}
	
	public void mouvBas(Espace E){
		Cellule c = E.modif(this,2);
		if(c!=null && c.bas) mouvBas(E);
		
	}
	
	public void mouvGauche(Espace E){
		Cellule c = E.modif(this,3);
		if(c!=null && c.gauche) mouvGauche(E);
	}
	
	public void mouvDroite(Espace E){
		Cellule c = E.modif(this,4);
		if(c!=null && c.droite) mouvDroite(E);
	}
	

	/*
	 *					Haut = 1
	 *		Gauche = 4			Droite = 2
	 *					Bas = 3
	 */
	
}
