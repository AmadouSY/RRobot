package graphique;

import graphique.ChoixRobot.BoutonListenerBLUE;
import graphique.ChoixRobot.BoutonListenerGRAY;
import graphique.ChoixRobot.BoutonListenerGREEN;
import graphique.ChoixRobot.BoutonListenerRED;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeu.*;


public class Fenetre extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel conteneur = new JPanel();
	private JMenuBar BardeMenu = new JMenuBar();
	
	
	private JMenu Partie = new JMenu("Partie");
		private JMenuItem NPartie = new JMenuItem("Nouvelle Partie");
		private JMenuItem RPartie = new JMenuItem("Recommencer");
		private JMenu Options = new JMenu("Options");
			private JMenu Theme = new JMenu("Theme");
			  private JRadioButtonMenuItem Classique = new JRadioButtonMenuItem("Classique"),
			  POP = new JRadioButtonMenuItem("POP");

		private JMenuItem Fermer = new JMenuItem("Fermer");

	private JMenu Aide = new JMenu("Aide");
		private JMenuItem Regles = new JMenuItem("Regles du Jeu");
		private JMenuItem APropos = new JMenuItem("A Propos");

	    public static JLabel NBCoups= new JLabel("Nombre de coups : 0");
	    
	    
    public static Robot RB = Main.red;
	

    public Espace E;

    
    public Fenetre(final Espace E, Robot R){
    	
    	this.E = E;
    	/****** OPTIONS FENETRES *********/
    	
    	this.setTitle("Robot Ricochet");
    	this.setSize(700, 700);
    	this.setLocationRelativeTo(null);
    	this.setResizable(false);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    	GrillePanel LaGrille = new GrillePanel(E);
    	
    	Controleur C2 = new Controleur(E);
    	JPanel ContEast = new JPanel();
    	ChoixRobot CR = new ChoixRobot();
    	Solutions Test = new Solutions(E);
    	ContEast.setLayout(new BorderLayout());
    	
    	/*ContEast.add(NBCoups, BorderLayout.PAGE_START);
    	ContEast.add(Test, BorderLayout.EAST);
        ContEast.add(C2, BorderLayout.SOUTH);
        ContEast.add(CR,BorderLayout.CENTER);
    	*/
    	
      //Mise en forme Box Layout
    	JPanel A1 = new JPanel();


    	A1.setLayout(new BoxLayout(A1, BoxLayout.Y_AXIS));
    	//CR.setLayout(new BoxLayout(A2, BoxLayout.Y_AXIS));
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

     	CR.setAlignmentX(Component.CENTER_ALIGNMENT);
        A1.add(CR);
        
		C2.setAlignmentX(Component.CENTER_ALIGNMENT);
        A1.add(C2);
    	
    	Test.setAlignmentY(Component.CENTER_ALIGNMENT);
        A1.add(Test);
    	
		NBCoups.setAlignmentY(Component.CENTER_ALIGNMENT);
        A1.add(NBCoups);
    	
		//A1.setAlignmentX(Component.CENTER_ALIGNMENT);

    	//A1.add(A1);
        
        
        
        
        
        
        
        
        
        JPanel all = new JPanel();
    	
    	
    	
    	
    	
        
        all.setLayout(new BorderLayout());
        all.add(LaGrille, BorderLayout.WEST);
        all.add(A1, BorderLayout.EAST);
        
        /****** BAR DE MENU ****/
        	
	    NPartie.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				conteneur.removeAll();
				GrillePanel gp = new GrillePanel(E);
				conteneur.add(gp.getPanel(), BorderLayout.CENTER);
				conteneur.revalidate();
			}	    	
	    });
		Partie.add(NPartie);
		Partie.add(RPartie);
		
		Theme.add(Classique);
		Theme.add(POP);
		
		Theme.addActionListener(new ThemeListener());
		
		
		Options.add(Theme);
		
		Partie.add(Options);
		
		Partie.addSeparator();
		
		Fermer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}
		});
		Partie.add(Fermer);
		
	    Regles.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    	        String txt = "Le but du jeu est de placer le robot ciblé dans la cible.";
	    	        txt += "\nMais vous ne pouvez effectuer que des deplacements en ligne droite, et votre robot ne s'arretera pas ";
	    	        txt += "avant d'avoir rencontrer un obstacle (un autre robot ou bien un mur). ";
	    	        txt += "\nVous pouvez donc vous servir des autres robot pour atteindre votre cible :)";
	    	        txt += "Mais attention, il faut réussir la mission en un minimum de déplacements ";
	    	        txt += "\nVous voulez plus de pression ? Un timer est disponible dans les options.";
	    	        txt += "\nBon courage :D";
	    	        JOptionPane.showMessageDialog(null, txt, "Regles du jeu", JOptionPane.INFORMATION_MESSAGE);        
	          }            
	    	    });
		Aide.add(Regles);
	    APropos.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    	        String txt = "HELLO :)\n" + "Vous Jouez à Ricochet ROBOT!\n";
	    	        txt += "Ce jeu a été réalisé par Amadou SY, Kevin HEGO et Marc Tai\n";
	    	        txt += "\n Amusez vous bien :D";        
	    	        JOptionPane.showMessageDialog(null, txt, "À propos", JOptionPane.INFORMATION_MESSAGE);        
	          }            
	    	    });
	    	    
		Aide.add(APropos);
		
		this.BardeMenu.add(Partie);
		this.BardeMenu.add(Aide);

                
        this.setJMenuBar(BardeMenu);
    	this.setContentPane(all);
    	
  
    	this.setVisible(true);
    	this.pack();
    }
    
    class ThemeListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    	//Si la case est cochée, activation du mode morphing
    	if(POP.isSelected()){
    		GrillePanel.theme = "POP";
    		System.out.println("Theme POP activé");
    	}

    	//Sinon rien !
    	else {
    		GrillePanel.theme = "Classique";
    		System.out.println("Theme Classique activé");
    	}
    	
    } 
    
}
    
}