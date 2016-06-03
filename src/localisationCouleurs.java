import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class localisationCouleurs extends JPanel{
	Couleur couleur;
	JPanel nivCouleur = new JPanel();
	JPanel nivGris = new JPanel();
	JTextField hexa;
	JTextField codeR;
	JTextField codeV;
	JTextField codeB;
	
	public localisationCouleurs(){
		
	}
	
	public localisationCouleurs(Couleur c){
		setPreferredSize(new Dimension(75, 200));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		couleur = c;
		nivCouleur.setBackground(new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue()));
		nivGris.setBackground(couleur.getGris());
		
		nivCouleur.setPreferredSize(new Dimension(75, 35));
		nivGris.setPreferredSize(new Dimension(75, 35));
		
		hexa = new JTextField(couleur.getHexa());
		codeR = new JTextField("" + couleur.getRed());
		codeV = new JTextField("" + couleur.getGreen());
		codeB = new JTextField("" + couleur.getBlue());
		
		hexa.setEditable(false);
		codeR.setEditable(false);
		codeV.setEditable(false);
		codeB.setEditable(false);
		
		//mettre des bordures
		nivCouleur.setBorder(new LineBorder(Color.BLACK));
		nivGris.setBorder(new LineBorder(Color.BLACK));
		hexa.setBorder(new LineBorder(Color.BLACK));
		//supprimer bordures JTextField
		codeB.setBorder(null);
		codeR.setBorder(null);
		codeV.setBorder(null);
		
		//fond des textfield
		hexa.setBackground(Color.WHITE);
		hexa.setHorizontalAlignment(JTextField.CENTER);
		codeR.setBackground(Color.WHITE);
		codeR.setHorizontalAlignment(JTextField.CENTER);
		codeB.setBackground(Color.WHITE);
		codeB.setHorizontalAlignment(JTextField.CENTER);
		codeV.setBackground(Color.WHITE);
		codeV.setHorizontalAlignment(JTextField.CENTER);
	
		//ajouter au this
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
	
	public void modifier(Couleur c){
		couleur = c;
		nivCouleur.setBackground(new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue()));
		nivGris.setBackground(couleur.getGris());
		
		hexa = new JTextField(couleur.getHexa());
		codeR = new JTextField("" + couleur.getRed());
		codeV = new JTextField("" + couleur.getGreen());
		codeB = new JTextField("" + couleur.getBlue());
	}
	
	public void selectionner(){
		//modifier les bordures en doré
		nivCouleur.setBorder(new LineBorder(new Color(204, 153, 0)));
		nivGris.setBorder(new LineBorder(new Color(204, 153, 0)));
		hexa.setBorder(new LineBorder(new Color(204, 153, 0)));
		codeB.setBorder(new LineBorder(new Color(204, 153, 0)));
		codeR.setBorder(new LineBorder(new Color(204, 153, 0)));
		codeV.setBorder(new LineBorder(new Color(204, 153, 0)));
	}
}
