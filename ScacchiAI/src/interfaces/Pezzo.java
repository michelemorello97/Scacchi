package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Pezzo implements ActionListener{
	protected Colore c;
	
	public Pezzo(Colore c) {
		this.c=c;
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
