package model;

import java.awt.event.ActionEvent;

import graphic.ChessPanel;
import interfaces.Colore;
import interfaces.Pezzo;

public class Cavallo extends Pezzo {

	public Cavallo(Colore c, int x, int y, ChessPanel ref) {
		super(c, x, y, ref);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("sono un cavallo "+c);
		
		
		
		if(reference.getPossibleMoves().size()!=0)
			reference.getPossibleMoves().clear();
		reference.repaint();
	}

}
