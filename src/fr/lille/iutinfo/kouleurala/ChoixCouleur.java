package fr.lille.iutinfo.kouleurala;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ChoixCouleur implements MouseListener {

	LocalisationCouleur colonne;

	public ChoixCouleur(LocalisationCouleur colonne) {
		this.colonne = colonne;
	}

	public void mouseClicked(MouseEvent arg0) {
		JPanel s = (JPanel) arg0.getSource();
		System.out.println(s.getBackground());
		colonne.modifier(s.getBackground());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		JPanel s = (JPanel) arg0.getSource();
		s.setBorder(new LineBorder(new Color(204, 153, 0), 2));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		JPanel s = (JPanel) arg0.getSource();
		s.setBorder(new LineBorder(Color.BLACK, 2));
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
