package fr.lille.iutinfo.kouleurala;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	public Fenetre() {
		setTitle("Kouleurala"); // On donne un titre à l'application
		setSize(500, 600); // On donne une taille à notre fenêtre
		setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
		setResizable(false); // On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à
														// l'application de se
														// fermer lors du clic
														// sur la croix

		JPanel panel = new JPanel(); // le principal
		panel.setLayout(new BorderLayout());

		JLabel label = new JLabel("Bienvenue dans ma modeste application");

		JPanel card1 = new JPanel();
		card1.setBackground(Color.blue);

		// GRILLE
		JPanel card2 = new JPanel();
		card2.setBackground(Color.red);
		card2.setLayout(new GridLayout(2, 4)); //ligne - colonne
		card2.add(new Button("1"));
		card2.add(new Button("2"));
		card2.add(new Button("3"));
		card2.add(new Button("4"));
		card2.add(new Button("5"));
		card2.add(new Button("6"));

		JPanel card3 = new JPanel();
		card3.setBackground(Color.green);

		card2.add(label);

		panel.add(card1, BorderLayout.NORTH);
		panel.add(card2, BorderLayout.CENTER);
		panel.add(card3, BorderLayout.SOUTH);

		this.setContentPane(panel); // On met le conteneur dans le JPanel

	}

}
