package model;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.Icon;

import graphic.ChessPanel;
import interfaces.Colore;
import interfaces.Pezzo;
import javafx.geometry.Dimension2D;

public class Empty extends Pezzo {

	public Empty(Colore c, int x, int y, ChessPanel col) {
		super(c, x, y, col);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	System.out.println("sono empty "+ posizione.getWidth()+ " "+posizione.getHeight());
		
		if(reference.getPossibleMoves().size()!=0)
		for(int i=0; i<reference.getPossibleMoves().size(); i++) {
			if(posizione.equals(reference.getPossibleMoves().get(i))) {
				
				
				
				//salvo l'icona in G
				Icon G=reference.getCelle()[(int)reference.getSelected().getPosizione().getWidth()][(int)reference.getSelected().getPosizione().getHeight()].getBtn().getIcon();
				
				//cancello l'icona dalla vecchia posizione
				reference.getCelle()[(int)reference.getSelected().getPosizione().getWidth()][(int)reference.getSelected().getPosizione().getHeight()].getBtn().setIcon(null);
				//aggiungo G alla nuova posizione
				reference.getCelle()[(int)posizione.getWidth()][(int)posizione.getHeight()].btn.setIcon(G); 
				
				Pezzo pezzo=reference.getSelected();
				
				Dimension2D poss=new Dimension2D(pezzo.getPosizione().getWidth(), pezzo.getPosizione().getHeight());
				Pezzo pezzo2=this;
				
				
				
				//tolgo il listener del pezzo dalla vecchia casella e lo sostituisco con una vuota
				reference.getCelle()[(int) pezzo.getPosizione().getWidth()][(int) pezzo.getPosizione().getHeight()].btn.removeActionListener(pezzo);
				reference.getCelle()[(int) pezzo.getPosizione().getWidth()][(int) pezzo.getPosizione().getHeight()].btn.addActionListener(pezzo2);
				reference.getCelle()[(int) pezzo.getPosizione().getWidth()][(int) pezzo.getPosizione().getHeight()].p=pezzo2;
				
				//sposto il pezzo nella casella selezionata
				reference.getCelle()[(int)posizione.getWidth()][(int)posizione.getHeight()].setP(pezzo);
				reference.getCelle()[(int)posizione.getWidth()][(int)posizione.getHeight()].getBtn().removeActionListener(this);
				reference.getCelle()[(int)posizione.getWidth()][(int)posizione.getHeight()].getBtn().addActionListener(pezzo);
				reference.getCelle()[(int)posizione.getWidth()][(int)posizione.getHeight()].p.setPosizione(new Dimension2D(posizione.getWidth(), posizione.getHeight())); 
				if(pezzo instanceof Pedone)
				{
					Pedone p=(Pedone) pezzo;
					p.alreadyMoved=false;
					reference.getCelle()[(int)posizione.getWidth()][(int)posizione.getHeight()].setP(p);
				}
				
				reference.cambiaTurno();
				//reference.riassestaPos();
				break;
			}//fine if
		}//fina for
		reference.riassestaPos();
		reference.getPossibleMoves().clear();
		reference.repaint();
		
		
	}
	
	@Override
	public void cosasono() {
		System.out.println("sono empty");
	}

	@Override
	public List<Dimension2D> celleAttaccate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean mangiato() {
		// TODO Auto-generated method stub
		return false;
	}
}
