package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javafx.geometry.Dimension2D;

public abstract class Pezzo implements ActionListener{
	protected Colore c;
	protected Dimension2D posizione;
	protected List<Dimension2D> mossePossibili;
	
	
	public Pezzo(Colore c, int x, int y) {
		this.c=c;
		posizione=new Dimension2D(x, y);
		mossePossibili=new LinkedList<>();
	}
	
	public Dimension2D getPosizione() {
		return posizione;
	}

	public void setPosizione(Dimension2D posizione) {
		this.posizione = posizione;
	}

	public List<Dimension2D> getMossePossibili() {
		return mossePossibili;
	}

	public void setMossePossibili(List<Dimension2D> mossePossibili) {
		this.mossePossibili = mossePossibili;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

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
}
