package fr.lille.iutinfo.kouleurala;

import java.awt.Color;
import java.util.ArrayList;

public class Couleur {

	static int num = 0;
	static ArrayList<Color> COULEURS;
	ArrayList<Color> listeColor = new ArrayList<Color>();
	int gris;
	Color couleur;

	public Couleur(int nbre) {
		this(255, 255, 255);
		gris = 255 / nbre * num + (255 / nbre) / 2;
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

	void listeGris() {
		for (int i = 0; i < COULEURS.size(); i++) {
			Color c = Couleur.COULEURS.get(i);
			int niveauGris = (int) (0.3 * c.getRed() + 0.59 * c.getGreen() + 0.11 * c.getBlue());
			if (niveauGris > gris - 7 && niveauGris < gris + 7) {
				listeColor.add(c);
			}
		}
	}

	public Couleur(int r, int g, int b) {
		couleur = new Color(r, g, b);
	}

	public String getHexa() {
		return String.format("#%02x%02x%02x", couleur.getRed(), couleur.getGreen(), couleur.getBlue());
	}

	public Color calculGris() {
		int niveau = (int) (0.3 * couleur.getRed() + 0.59 * couleur.getGreen() + 0.11 * couleur.getBlue());
		return new Color(niveau, niveau, niveau);
	}

	public Color getGris() {
		return new Color(gris, gris, gris);
	}

}
