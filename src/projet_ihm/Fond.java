package projet_ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class Fond {

	public Fond() {
		JFrame fenetre = new JFrame();
		JPanel nord = new JPanel();
		JPanel sud = new JPanel();
		JPanel centre = new JPanel();

		// creation de la fenetre du haut, avec le slider
		FlowLayout flow = new FlowLayout();
		nord.setLayout(flow);

		JLabel label = new JLabel(" Nombre de couleurs :");
		JSlider slider = new JSlider();
		JButton bouton = new JButton("Effacer");
		nord.add(label);
		nord.add(slider);
		nord.add(bouton);

		// creation du deuxieme panneau
		GridLayout grid = new GridLayout(1, 11, 5, 5);
		centre.setLayout(grid);

		JPanel texte = new JPanel();
		// BoxLayout box = new BoxLayout(centre, BoxLayout.Y_AXIS);
		// texte.setLayout(box);

		JLabel couleur = new JLabel("Couleur");
		JLabel gris = new JLabel("Gris");
		JLabel hexa = new JLabel("Hexadécimal");
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

		// creation troisieme volet
		GridLayout gridLay = new GridLayout();
		gridLay.setColumns(15);
		gridLay.setRows(15);
		//gridLay.setHgap(25);
		//gridLay.setVgap(25);
		sud.setLayout(gridLay);

		sud.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		sud.setPreferredSize(new Dimension(600, 150));
		sud.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 200, 10, 50), sud.getBorder()));
		
		Couleur couleur1 = new Couleur();
		System.out.println(couleur1.couleursGris.size());
		System.out.println(couleur1.gris);
		for (int i = 0; i < couleur1.couleursGris.size(); i++) {
			JPanel pan = new JPanel();
			pan.setBackground(couleur1.couleursGris.get(i));
			sud.add(pan);
		}

		// creation de la fenetre principale
		fenetre.setTitle("Kouleurala, votre logiciel de selection de couleurs");
		fenetre.setPreferredSize(new Dimension(800, 550));

		fenetre.getContentPane().add(nord, BorderLayout.PAGE_START);
		fenetre.getContentPane().add(sud, BorderLayout.SOUTH);
		fenetre.getContentPane().add(centre, BorderLayout.CENTER);

		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Fond();
			}
		});
	}

}