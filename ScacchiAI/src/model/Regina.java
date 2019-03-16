package model;

import java.awt.event.ActionEvent;

import graphic.ChessPanel;
import interfaces.Colore;
import interfaces.Pezzo;

public class Regina extends Pezzo {

	public Regina(Colore c, int x, int y, ChessPanel ref) {
		super(c, x, y, ref);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("sono una regina "+c);
		
		
		
		if(reference.getPossibleMoves().size()!=0)
			reference.getPossibleMoves().clear();
		reference.repaint();
		}

}
