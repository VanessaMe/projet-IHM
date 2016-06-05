package fr.lille.iutinfo.kouleurala;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Application extends JFrame {

	JPanel nord = new JPanel();
	JPanel centre = new JPanel();
	JPanel sud = new JPanel();
	// le tableau sud
	JPanel tableauCouleurs = new JPanel();

	public Application() {
		// creation de la this du haut, avec le slider
		FlowLayout flow = new FlowLayout();
		nord.setLayout(flow);

		JLabel label = new JLabel("Nombre de couleurs :");
		JLabel nbCouleursChoix = new JLabel("5");
		JSlider slide = new JSlider();
		JButton valider = new JButton("Valider");
		slide.setMaximum(10);
		slide.setMinimum(1);
		slide.setValue(5);
		slide.setPaintTicks(true); // pour les petits traits
		slide.setPaintLabels(true);
		slide.setMajorTickSpacing(1);
		ActionBouton actionBouton = new ActionBouton(this, slide);
		valider.addActionListener(actionBouton);
		JButton bouton = new JButton("Effacer tout");
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choixCouleursCentre(slide.getValue());
				choixCouleursSud(null);
			}
		});
		nord.add(label);
		nord.add(nbCouleursChoix);
		nord.add(slide);
		nord.add(valider);
		nord.add(bouton);

		choixCouleursCentre(slide.getValue());

		// creation de la this principale
		this.setTitle("Kouleurala, votre logiciel de selection de couleurs");
		this.setPreferredSize(new Dimension(850, 550));

		this.getContentPane().add(nord, BorderLayout.NORTH);
		centre.setBorder(new EmptyBorder(20, 10, 20, 10));
		this.getContentPane().add(centre, BorderLayout.CENTER);
		sud.setLayout(new FlowLayout(FlowLayout.RIGHT));
		choixCouleursSud(null);
		sud.add(tableauCouleurs);
		this.getContentPane().add(sud, BorderLayout.SOUTH);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// initialise le tableau centrale
	void choixCouleursCentre(int nbreCouleurs) {
		// on supprime les anciens elements
		centre.removeAll();
		centre.setLayout(new GridLayout(1, 0, 10, 0));

		// colonne de texte
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

		Couleur c;
		LocalisationCouleur colonne;
		for (int i = 0; i < 10; i++) { // on affiche tjrs 10 colonnes
			if (i < nbreCouleurs) {
				c = new Couleur(nbreCouleurs);
				colonne = new LocalisationCouleur(c, this);
			} else {
				// on cree une colonne de couleur blanc
				colonne = new LocalisationCouleur(new Couleur(255, 255, 255), this);
				// on desactive cette colonne
				colonne.desactiver();
			}
			centre.add(colonne);
		}
		Couleur.num = 0;// compteur de couleurs a 0
		this.pack();
	}

	// initialise le tableau du bas
	void choixCouleursSud(LocalisationCouleur colonne) {
		// on supprime l ancien tableau
		tableauCouleurs.removeAll();
		tableauCouleurs.setPreferredSize(new Dimension(600, 200));
		tableauCouleurs.setBackground(Color.LIGHT_GRAY);
		CompoundBorder bordure = BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK),
				new EmptyBorder(10, 100, 10, 10));
		tableauCouleurs.setBorder(bordure);
		GridLayout gridLay = new GridLayout(3, 0, 20, 20); // nbre colonne auto
		tableauCouleurs.setLayout(gridLay);

		// Proposition des couleurs
		if (colonne != null) {
			System.out.println("nbre couleurs : " + colonne.couleur.listeColor.size());
			System.out.println("code gris : " + colonne.couleur.gris);
			// on affiche les couleurs proposees
			for (int i = 0; i < colonne.couleur.listeColor.size(); i++) {
				JPanel pan = new JPanel();
				pan.setBackground(colonne.couleur.listeColor.get(i));
				pan.setBorder(new LineBorder(Color.BLACK, 2));
				pan.addMouseListener(new ChoixCouleur(colonne));
				tableauCouleurs.add(pan);
			}
		}
		this.pack();
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Application();
			}
		});
	}

}