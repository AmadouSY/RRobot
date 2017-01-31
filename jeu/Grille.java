package jeu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grille {
	
	// Variables
	
	private int dim;
	private Cellule[][] tab;
	public final boolean FAUX = false;
	
	//Constructeurs
	public Grille(int dimension){
		this.dim = dimension;
		this.tab = new Cellule[dimension][dimension];
	}
	
	public Grille(String fichier){
		this.tab = importGrille(fichier);
	}
	
	//A&M		
	public Cellule getCellule(Position p){
		if(p.x >= 0 && p.x < dim && p.y >= 0 && p.y < dim)
			return tab[p.x][p.y];
		return null;
	}
	
	
	public int getDim(){
		return dim;
	}
	
	public Cellule[][] getTab(){
		return tab;
	}
	
	public void setDim(int dim){
		this.dim = dim;
	}
	
	public void setTab(Cellule[][] tab){
		this.tab = tab;
	}
	
	//Methodes
	
	//Methode pour charger une MAP
	private Cellule[][] importGrille(String fichier){
		try{
			BufferedReader br = new BufferedReader(new FileReader(fichier));
			dim = Integer.parseInt(br.readLine());
			Cellule[][] t = new Cellule[dim][dim];
			int y = 0;
			String current = br.readLine();
			do{
				String[] tabChar = current.split("\t");
                for(int x=0;x<dim;x++){
                	Cellule c = new Cellule(true);
                	switch(Integer.parseInt(String.valueOf(tabChar[x]))){
	                	case 0: c = new Cellule(true);
	               		break;
	                	case 1: c = new Cellule(false,true,true,true);
	                	break;
	                    case 2: c = new Cellule(true,false,true,true);
	                   	break;
	                    case 3: c = new Cellule(true,true,false,true);
	                   	break;
	                    case 4: c = new Cellule(true,true,true,false);
	                    break;
	                    case 5: c = new Cellule(false,true,true,false);
	                    break;
	                    case 6: c = new Cellule(false,false,true,true);                                                            
	                    break;
	                    case 7: c = new Cellule(true,false,false,true);
	                    break;
	                    case 8: c = new Cellule(true,true,false,false);
	                    break;
	                    case 9: c = new Cellule(false,true,false,true);
	                    break;
	                    case 10: c = new Cellule(true,false,true,false);
	                    break;
	                    case 11: c = new Cellule(false);
	                    break;
                	}
            	c.setType(Integer.parseInt(String.valueOf(tabChar[x])));
                if(FAUX) System.out.print(c.getType()+"\t");
                t[x][y] = c;
            }
            current = br.readLine();
            y++;
            if(FAUX) System.out.println();
			} while(current != null);
			br.close();
  
			System.out.println("Importation de la grille \""+fichier+"\" de dimension: "+getDim()+")");
  
			return t;
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
}
