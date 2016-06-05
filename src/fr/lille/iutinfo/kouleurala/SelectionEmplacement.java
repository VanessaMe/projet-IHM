package fr.lille.iutinfo.kouleurala;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SelectionEmplacement implements MouseListener {

	Application application;
	LocalisationCouleur colonne;

	public SelectionEmplacement(Application application, LocalisationCouleur colonne) {
		this.application = application;
		this.colonne = colonne;
	}

	public void mouseClicked(MouseEvent arg0) {
		application.choixCouleursSud(colonne);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		JPanel s = (JPanel) arg0.getSource();
		s.setBorder(new LineBorder(new Color(204, 153, 0), 2));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		JPanel s = (JPanel) arg0.getSource();
		s.setBorder(new LineBorder(Color.BLACK));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
