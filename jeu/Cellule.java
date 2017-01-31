package jeu;

public class Cellule {

	//VARIABLES
	public boolean haut;
	public boolean droite;
	public boolean bas;
	public boolean gauche;
	public int type;

	
	//CONSTRUCTEURS
	
	public Cellule(boolean haut, boolean droite, boolean bas, boolean gauche){
		this.haut = haut;
		this.droite = droite;
		this.bas = bas;
		this.gauche = gauche;
	}
	
	public Cellule(boolean A){
		this.haut = this.droite = this.bas = this.gauche = A;
	}
	
	public void setType(int type){
		this.type = type;
	}
	
	public int getType(){
		return type;
	}
	
    public boolean getMur(int i) {
        switch (i) {
	        case 1 : return haut;
	        case 2 : return droite;
	        case 3 : return bas;
	        default : return gauche;
        }
    }
	
	//Methode qui compte le nombre de murs
	public int getNbMurs(){
		
		int nbMurs = 0;
		if(!haut) nbMurs++;
		if(!droite) nbMurs++;
		if(!bas) nbMurs++;
		if(!gauche) nbMurs++;
		
		return nbMurs;

	}

}
