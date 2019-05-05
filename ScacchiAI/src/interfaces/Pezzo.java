package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import graphic.ChessPanel;
import javafx.geometry.Dimension2D;

public abstract class Pezzo implements ActionListener{
	protected Colore c;
	protected Dimension2D posizione;
	
	protected ChessPanel reference;
	
	public Pezzo(Colore c, int x, int y, ChessPanel col) {
		this.c=c;
		posizione=new Dimension2D(x, y);
		reference=col;
		
	}
	
	public Dimension2D getPosizione() {
		return posizione;
	}

	public void setPosizione(Dimension2D posizione) {
		this.posizione = posizione;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void cosasono() {}

	@Override
	public String toString() {
		return "Pezzo [c=" + c + "]";
	}

	public Colore getC() {
		return c;
	}

	public void setC(Colore c) {
		this.c = c;
	}
	
	public abstract List<Dimension2D> celleAttaccate();
	
	public abstract boolean mangiato();
	public abstract Pezzo celleAttaccateIgnoringTHAT(Pezzo p);
	public abstract boolean possoMuovermi(List<Pezzo> toh);
}
