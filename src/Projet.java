import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class Projet {

	public Projet(){
		JFrame fenetre = new JFrame();
		JPanel nord = new JPanel();
		JPanel sud = new JPanel();
		JPanel centre = new JPanel();
	
		
		//creation de la fenetre du haut, avec le slider
		FlowLayout flow = new FlowLayout();
		nord.setLayout(flow);
		
		JLabel label = new JLabel(" Nombre de couleurs :");
		JSlider slider = new JSlider();
		JButton bouton = new JButton("Effacer");
		nord.add(label);
		nord.add(slider);
		nord.add(bouton);
		
		
		//creation du deuxieme panneau
		GridLayout grid = new GridLayout(1, 0, 10, 0);
		centre.setLayout(grid);
		
		
		//colonne de texte
		JPanel texte = new JPanel();
		texte.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel couleur = new JLabel("Couleur");
		JLabel gris = new JLabel("Gris");
		JLabel hexa = new JLabel("Hexa");
		JLabel rouge = new JLabel("Rouge");
		JLabel vert = new JLabel("Vert");
		JLabel bleu = new JLabel("Bleu");
		
		texte.add(couleur);
		texte.add(gris);
		texte.add(hexa);
		texte.add(rouge);
		texte.add(vert);
		texte.add(bleu);
		
		centre.add(texte);
		
		//couleurs
		localisationCouleurs couleurUn = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurUn);
		
		localisationCouleurs couleurDeux = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurDeux);
		
		localisationCouleurs couleurTrois = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurTrois);
		
		localisationCouleurs couleurQuatre = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurQuatre);
		
		localisationCouleurs couleurCinq = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurCinq);
		
		localisationCouleurs couleurUSix = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurUSix);
		
		localisationCouleurs couleurSept = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurSept);
		
		localisationCouleurs couleurHuit = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurHuit);
		
		localisationCouleurs couleurNeuf = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurNeuf);
		
		localisationCouleurs couleurDix = new localisationCouleurs(new Couleur(152, 12, 25));
		centre.add(couleurDix);
		
		
		
		
		
		
		//creation troisieme volet
		GridLayout gridLay = new GridLayout();
		gridLay.setColumns(7);
		gridLay.setRows(3);
		gridLay.setHgap(25); 
		gridLay.setVgap(25);
		sud.setLayout(gridLay);
		
		sud.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		sud.setPreferredSize(new Dimension(600, 150));
		sud.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,200,10,50),sud.getBorder()));
		
		JPanel couleur1 = new JPanel();
		JPanel couleur2 = new JPanel(); 
		JPanel couleur3 = new JPanel(); 
		couleur1.setBackground(Color.BLACK);
		couleur2.setBackground(Color.DARK_GRAY);
		couleur3.setBackground(Color.GRAY);
		sud.add(couleur1);
		sud.add(couleur2);
		sud.add(couleur3);
		
		for(int i=0 ; i < 18; i++){
			JPanel pan = new JPanel();
			pan.setBackground(Color.ORANGE);
			sud.add(pan);
		}
		
	
		
		
		
		//creation de la fenetre principale
		fenetre.setTitle("Kouleurala, votre logiciel de selection de couleurs");
		fenetre.setPreferredSize(new Dimension(800, 450));
		
		fenetre.getContentPane().add(nord, BorderLayout.PAGE_START);
		fenetre.getContentPane().add(sud, BorderLayout.SOUTH);
		fenetre.getContentPane().add(centre, BorderLayout.CENTER);
		
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
	    fenetre.setVisible(true);
	}
	
	
	
	
	
	

	public static void main(String[] args) {
	      javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          new Projet();
	        }
	    });
	}
	
}
