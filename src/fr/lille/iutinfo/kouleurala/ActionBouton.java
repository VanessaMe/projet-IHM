package fr.lille.iutinfo.kouleurala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class ActionBouton implements ActionListener {
	Application fond;
	JSlider slide;
	int saveValeur;

	public ActionBouton(Application application, JSlider slide) {
		this.fond = application;
		this.slide = slide;
		this.saveValeur = slide.getValue();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (saveValeur != slide.getValue()) {
			Object[] options = { "Ok", "Annuler" };
			if (JOptionPane.showOptionDialog(fond, "Les couleurs selectionnées vont être perdues. \n Continuer ?",
					"Attention", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
					options[0]) == 0) {
				fond.choixCouleursCentre(slide.getValue());
				fond.choixCouleursSud(null);
				saveValeur = slide.getValue();
			} else {
				slide.setValue(saveValeur);
			}
		}
	}
}
