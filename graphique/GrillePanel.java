package graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import jeu.*;


public class GrillePanel extends JPanel{

		//Variables
	
		private static final long serialVersionUID = 1L;		//Correction Eclipse
        
        protected final static String IMGPATH = "src/img/";
        protected final static int CELLDIM = 40;
        public static String theme = ".jpg";
        
        //Variables de l'objets

        private Image[][] cellules;
        private Espace E;
        private int dim;
        
        //Constructeurs
        
        public GrillePanel(Espace E){
			this.E = E;	
			setDim(E.getGrille().getDim());
			cellules = new Image[dim][dim];
			for(int y = 0; y<dim; y++)
				for(int x = 0; x<dim; x++)
					cellules[x][y] = Toolkit.getDefaultToolkit().getImage(IMGPATH+E.getGrille().getCellule(new Position(x,y)).getType()+theme);
			repaint();
        
        setPreferredSize(new Dimension(CELLDIM*E.getGrille().getDim(),CELLDIM*E.getGrille().getDim()));
        }
        
        
        public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        
	        for(int x = 0; x<dim; x++)
	                for(int y = 0; y<dim; y++)
	                        g.drawImage(cellules[x][y],x*CELLDIM,y*CELLDIM,null);
	
	        for(Robot r : E.getRobots()){
                   Position p = r.getPosition();
                   Color color = r.getColor();
                   Image AAA = Toolkit.getDefaultToolkit().getImage("src/img/robot-"+rgbToString(color.toString())+".png");
                   g.drawImage(AAA, p.getX()*CELLDIM+7, p.getY()*CELLDIM+7, null);         
	        }
	 
	        g.setColor(Color.DARK_GRAY);
	        g.fillRect(E.getCible().getX()*CELLDIM+5, E.getCible().getY()*CELLDIM+15, 25, 5);
	        g.fillRect(E.getCible().getX()*CELLDIM+15, E.getCible().getY()*CELLDIM+5, 5, 25);
	        repaint();
        }

        
        //Accesseurs && Mutateurs
        public void setDim(int dim) {
                this.dim = dim;
        }

        public int getTabDim() {
                return dim;
        }
        
        protected JPanel getPanel(){
    		return this;
    	}
        
        public String rgbToString(String a){
        	if (a.equals("java.awt.Color[r=0,g=255,b=0]")) return "green";
        	else if (a.equals("java.awt.Color[r=255,g=0,b=0]")) return "red";
        	else if (a.equals("java.awt.Color[r=0,g=0,b=255]")) return "blue";
        	else return "gray";
        }
        
 
}