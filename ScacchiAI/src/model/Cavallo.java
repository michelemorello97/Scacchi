package model;

import java.awt.event.ActionEvent;

import interfaces.Colore;
import interfaces.Pezzo;

public class Cavallo extends Pezzo {

	public Cavallo(Colore c, int x, int y) {
		super(c, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("sono un cavallo "+c);
	}

}
