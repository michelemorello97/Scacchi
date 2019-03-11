package model;

import java.awt.event.ActionEvent;

import interfaces.Colore;
import interfaces.Pezzo;
import javafx.geometry.Dimension2D;

public class Pedone extends Pezzo{

	public Pedone(Colore c, int x, int y) {
		super(c, x, y);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("sONO UN PEDONE "+ this.c);
		this.mossePossibili.add(new Dimension2D(this.posizione.getWidth()-1, this.posizione.getHeight()));
		this.mossePossibili.add(new Dimension2D(this.posizione.getWidth()-1, this.posizione.getHeight()+1));
		this.mossePossibili.add(new Dimension2D(this.posizione.getWidth()-1, this.posizione.getHeight()-1));
		
	}
}
