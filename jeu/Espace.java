package jeu;

import java.util.ArrayList;
import java.util.Random;

public class Espace {
	
	//Variables
	protected static Grille grille;
	protected Position cible;
	private Robot lerobot;
	protected ArrayList<Robot> robots;    
	public static Robot red, blue, gray, green;

	
	//Constructeurs
    
	public Espace(){
        if(grille == null)
                this.setGrille(new Grille("src/grilles/Niveau0.txt"));
        robots = new ArrayList<Robot>();
  	}
	
    public Espace(Grille g,ArrayList<Robot> robots){
        if(g == null)
                this.setGrille(g);
        for(Robot r : robots){
                while(! ajouterRobotHasard(r));
        }
                
    }
    	
	//Accesseurs
	public Grille getGrille(){
		return grille;
	}
	
	public Position getCible(){
		return this.cible;
	}
	
	public Robot getRobot(){
		return this.lerobot;
	}
	
	public ArrayList<Robot> getRobots(){
		return this.robots;
	}
	
	public Robot getRobot(Robot r){
		for(Robot robot : robots)
			if(robot.equals(r))
				return robot;
		return null;
	}
	
    public Robot getRobot(Position p){
        for(Robot r : robots)
                if(r.position.compare(p))
                        return r;
        return null;
    }

	//Mutateurs
	@SuppressWarnings("static-access")
	public void setGrille(Grille g){
		this.grille = g;
	}
	
	public void setCible(Position p){
		this.cible = p;
	}
	
	public void setRobot(Robot r){
		this.lerobot = r;
	}
	
	public void setRobots(ArrayList<Robot> robots){
		this.robots = robots;
	}

	/************* Methodes **************/
	
	//Ajoute un robot dans la grille à un emplacement donné
	public boolean ajouterRobot(Robot r, Position p){
		if(isEmpty(p) && grille.getCellule(p).getType()<11){
			r.position = p;
			//robots.add(new Robot(r.getColor(),p));
			robots.add(r);
			return true;
		}else return false;
	}
	
	//Ajoute un robot dans la grille aléatoirement
	public boolean ajouterRobotHasard(Robot r){
		return ajouterRobot(r,RandomCible());
	}
	
	//Ajoute une cible pour un robot
	public void ajouterCible(Robot r, Position p){
		this.lerobot = r;
		this.cible = p;
	}
	
	//Ajoute une cible au hasard
	public Position RandomCible(){
		return new Position(random(getGrille()),random(getGrille()));
 	}
	
	// Ce que le prof nous a demandé de faire
	public static int random(Grille g){
		Random r = new Random();
		return r.nextInt(g.getDim()-1);
	}
	
	//Verifie si une cellule contient la cible
	public  boolean estCible(Espace E,Position P){
			if (E.getCible() == P) return true;
			else return false;
	}
	
	//Verifie si une position de l'espace est vide
	public boolean isEmpty(Position p){
		for(Robot r : robots)
			if(r.position.compare(p))
					return false; 		
		return true;
	}
	
	//Modifie le contenu d'une cellule (ajoute/enleve un robot)
	public Cellule modif(Robot r, int mouv){
		Robot robot = getRobot(r);
		Cellule c = getGrille().getCellule(robot.position);
		Position p = null;
		switch(mouv){
			case 1:
				if(c.haut) p = new Position(robot.position.x,robot.position.y-1);
				break;
			case 2:
				if(c.droite) p = new Position(robot.position.x+1,robot.position.y);
				break;
			case 3:
				if(c.bas) p = new Position(robot.position.x,robot.position.y+1);
				break;
			case 4:
				if(c.gauche) p = new Position(robot.position.x-1,robot.position.y);
				break;
		}
		if(p == null || !isEmpty(p))
			return null;
		robot.position = p;
		victoire();
		return getGrille().getCellule(robot.position);
	}
	
	
	public boolean sol1coups(){
		for(int i = 1; i<=4; i++){
			Position a = lerobot.position;
			lerobot.mouv(i,this);
			if (cible.compare(lerobot.position)) return true;
			else lerobot.position = a;
		}
		return false;
	}
	
	public boolean soloups(){
		if (sol1coups()) return true;
		for(int i = 1; i<=4; i++){
			Position a = lerobot.position;
			lerobot.mouv(i,this);
			if (cible.compare(lerobot.position)) return true;
			else lerobot.position = a;
		}
		return false;
	}
	
	public boolean sol2coups(){
		if (sol1coups()) return true;
		else{
			for(int i=1; i<=4;i++){
				Position a = lerobot.position;
				lerobot.mouv(i,this);
				for(int j=1; j<=4;j++){
					Position b = lerobot.position;
					lerobot.mouv(j,this);
					if (cible.compare(lerobot.position)) return true;
					else lerobot.position = b;
				}
				lerobot.position = a;
			}	
		}
		return false;
			
	}
	
	
	public boolean victoire(){
		if (cible.compare(lerobot.position)){
			System.out.println("WIIIIIN");
			return true;
		}
		return false;
	}


}