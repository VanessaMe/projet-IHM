package fr.lille.iutinfo.kouleurala;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class LocalisationCouleur extends JPanel {

	Couleur couleur;
	JPanel nivCouleur = new JPanel();
	JPanel nivGris = new JPanel();
	SelectionEmplacement ecoute;
	JTextField hexa;
	JTextField codeR;
	JTextField codeV;
	JTextField codeB;
	Application appli;

	public LocalisationCouleur() {

	}

	public LocalisationCouleur(Couleur c, Application application) {
		this.appli = application;
		setPreferredSize(new Dimension(75, 200));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		couleur = c;
		nivCouleur.setBackground(
				new Color(couleur.couleur.getRed(), couleur.couleur.getGreen(), couleur.couleur.getBlue()));
		nivGris.setBackground(couleur.getGris());

		nivCouleur.setPreferredSize(new Dimension(75, 40));
		ecoute = new SelectionEmplacement(application, this);
		nivCouleur.addMouseListener(ecoute);
		nivGris.setPreferredSize(new Dimension(75, 40));

		hexa = new JTextField(couleur.getHexa());
		codeR = new JTextField("" + couleur.couleur.getRed());
		codeV = new JTextField("" + couleur.couleur.getGreen());
		codeB = new JTextField("" + couleur.couleur.getBlue());

		hexa.setEditable(false);
		codeR.setEditable(false);
		codeV.setEditable(false);
		codeB.setEditable(false);

		// mettre des bordures
		nivCouleur.setBorder(new LineBorder(Color.BLACK));
		nivGris.setBorder(new LineBorder(Color.BLACK));
		hexa.setBorder(new LineBorder(Color.BLACK));
		// supprimer bordures JTextField
		codeB.setBorder(null);
		codeR.setBorder(null);
		codeV.setBorder(null);

		// fond des textfield
		hexa.setBackground(Color.WHITE);
		hexa.setHorizontalAlignment(JTextField.CENTER);
		codeR.setBackground(Color.WHITE);
		codeR.setHorizontalAlignment(JTextField.CENTER);
		codeB.setBackground(Color.WHITE);
		codeB.setHorizontalAlignment(JTextField.CENTER);
		codeV.setBackground(Color.WHITE);
		codeV.setHorizontalAlignment(JTextField.CENTER);

		// ajouter au this
		add(nivCouleur);
		add(nivGris);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(hexa);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(codeR);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(codeV);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(codeB);

	}

	public void modifier(Color c) {
		couleur.couleur = c;
		nivCouleur.setBackground(c);
		nivGris.setBackground(couleur.getGris());

		hexa.setText(couleur.getHexa());
		codeR.setText("" + c.getRed());
		codeV.setText("" + c.getGreen());
		codeB.setText("" + c.getBlue());
		appli.pack();
	}

	public void selectionner() {
		// modifier les bordures en dore
		nivCouleur.setBorder(new LineBorder(new Color(204, 153, 0)));
		nivGris.setBorder(new LineBorder(new Color(204, 153, 0)));
		hexa.setBorder(new LineBorder(new Color(204, 153, 0)));
		codeB.setBorder(new LineBorder(new Color(204, 153, 0)));
		codeR.setBorder(new LineBorder(new Color(204, 153, 0)));
		codeV.setBorder(new LineBorder(new Color(204, 153, 0)));
	}

	public void desactiver() {
		codeR.setEnabled(false);
		codeV.setEnabled(false);
		codeB.setEnabled(false);
		hexa.setEnabled(false);
		nivCouleur.removeMouseListener(ecoute);
		codeR.setText("0");
		codeV.setText("0");
		codeB.setText("0");
		hexa.setText("#000000");
		hexa.setBorder(new LineBorder(Color.LIGHT_GRAY));
		nivCouleur.setBorder(new LineBorder(Color.GRAY));
		nivCouleur.setBackground(Color.LIGHT_GRAY);
		nivGris.setBorder(new LineBorder(Color.GRAY));
		nivGris.setBackground(Color.LIGHT_GRAY);
	}
}
