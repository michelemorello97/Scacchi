package model;

import java.awt.event.ActionEvent;

import interfaces.Colore;
import interfaces.Pezzo;

public class Re extends Pezzo {

	public Re(Colore c, int x, int y) {
		super(c, x, y);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("sono un re "+c);
	}
}
