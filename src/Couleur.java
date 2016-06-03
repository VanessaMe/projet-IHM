

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Couleur extends Color {

	static int num = 0;
	static ArrayList<Color> COULEURS;
	ArrayList<Color> couleursGris = new ArrayList<Color>();
	Random r = new Random();
	int gris;

	public Couleur() {
		this(255, 255, 255);	
		// on recupere la valeur du slide
		//gris = 7 / 255 * num + (7 / 255) / 2;
		gris=120;
		num++;
		listeGris();
	}

	static {
		COULEURS = new ArrayList<Color>();
		for (int r = 0; r < 256; r = r + 51)
			for (int g = 0; g < 256; g = g + 51)
				for (int b = 0; b < 256; b = b + 51)
					COULEURS.add(new Color(r, g, b));
	}
	
	void listeGris(){
		for(int i=0; i<COULEURS.size(); i++){
			Color c = Couleur.COULEURS.get(i);
			int niveauGris = (int) (0.3 * c.getRed() + 0.59 * c.getGreen() + 0.11 * c.getBlue());
			if(niveauGris > gris-7 && niveauGris < gris+7){
				couleursGris.add(c);
			}
		}
	}

	public Couleur(int r, int g, int b) {
		super(r, g, b);
	}

	public String getHexa() {
		return String.format("#%02x%02x%02x", this.getRed(), this.getGreen(), this.getBlue());
	}

	public Color getGris() {
		int niveau = (int) (0.3 * this.getRed() + 0.59 * this.getGreen() + 0.11 * this.getBlue());
		return new Color(niveau, niveau, niveau);
	}

	public static void main(String[] args) {
		ArrayList<Couleur> couleurs = new ArrayList<Couleur>();
		JFrame f = new JFrame();
		f.setSize(500, 600); // On donne une taille à notre fenêtre
		f.setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
		f.setResizable(false); // On interdit la redimensionnement de la fenêtre
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(); // le principal
		panel.setLayout(new BorderLayout());

		JLabel label = new JLabel("Bienvenue dans ma modeste application");
		panel.add(label);
		Couleur c = new Couleur();
		panel.setBackground(c);

		f.setContentPane(panel); // On met le conteneur dans le JPanel
		f.setVisible(true);

	}
}

