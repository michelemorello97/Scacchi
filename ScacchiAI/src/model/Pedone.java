package model;

import java.awt.event.ActionEvent;

import interfaces.Colore;
import interfaces.Pezzo;

public class Pedone extends Pezzo{

	public Pedone(Colore c) {
		super(c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("sONO UN PEDONE "+ this.c);
	}
}
