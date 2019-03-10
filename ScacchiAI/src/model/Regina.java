package model;

import java.awt.event.ActionEvent;

import interfaces.Colore;
import interfaces.Pezzo;

public class Regina extends Pezzo {

	public Regina(Colore c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("sono una regina "+c);
		}

}
