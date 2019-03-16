package model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import graphic.ChessPanel;
import interfaces.Colore;
import interfaces.Pezzo;
import javafx.geometry.Dimension2D;

public class Pedone extends Pezzo{
	Boolean alreadyMoved;
	public Pedone(Colore c, int x, int y, ChessPanel ref) {
		super(c, x, y, ref);
		alreadyMoved=true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("sONO UN PEDONE "+ this.c+" "+posizione.getWidth()+" "+posizione.getHeight());
		List<Dimension2D> temp=new ArrayList<>();
		if(this.reference.getTurno()==this.c)
		{
			
			if(c==Colore.bianco) {
				if(posizione.getWidth()-1>=0) {
					//movimento
					if((reference.getCelle()[(int) posizione.getWidth()-1][(int) posizione.getHeight()].getP() instanceof Empty))
						temp.add(new Dimension2D(posizione.getWidth()-1, posizione.getHeight()));
					
					//due if per vedere se può mangiare
					if(posizione.getHeight()-1>=0 && !(reference.getCelle()[(int) posizione.getWidth()-1][(int) posizione.getHeight()-1].getP() instanceof Empty) && reference.getCelle()[(int) posizione.getWidth()-1][(int) posizione.getHeight()-1].getP().getC()!=this.c) {
						temp.add(new Dimension2D(posizione.getWidth()-1, posizione.getHeight()-1));
					}
					if(posizione.getHeight()+1<=7 && !(reference.getCelle()[(int) posizione.getWidth()-1][(int) posizione.getHeight()+1].getP() instanceof Empty) && reference.getCelle()[(int) posizione.getWidth()-1][(int) posizione.getHeight()+1].getP().getC()!=this.c) {
						temp.add(new Dimension2D(posizione.getWidth()-1, posizione.getHeight()+1));
					}
					
				}
				//se non si è ancora mosso
				if(alreadyMoved && (reference.getCelle()[(int) posizione.getWidth()-2][(int) posizione.getHeight()].getP() instanceof Empty)) 
					temp.add(new Dimension2D(posizione.getWidth()-2, posizione.getHeight()));
			}
			
			else
			{
				if(posizione.getWidth()+1<=7) {
					//movimento
					if((reference.getCelle()[(int) posizione.getWidth()+1][(int) posizione.getHeight()].getP() instanceof Empty))
						temp.add(new Dimension2D(posizione.getWidth()+1, posizione.getHeight()));
					
					//due if per vedere se può mangiare
					if(posizione.getHeight()-1>=0 && !(reference.getCelle()[(int) posizione.getWidth()+1][(int) posizione.getHeight()-1].getP() instanceof Empty) && reference.getCelle()[(int) posizione.getWidth()+1][(int) posizione.getHeight()-1].getP().getC()!=this.c) {
						temp.add(new Dimension2D(posizione.getWidth()+1, posizione.getHeight()-1));
					}
					if(posizione.getHeight()+1<=7 && !(reference.getCelle()[(int) posizione.getWidth()+1][(int) posizione.getHeight()+1].getP() instanceof Empty) && reference.getCelle()[(int) posizione.getWidth()+1][(int) posizione.getHeight()+1].getP().getC()!=this.c) {
						temp.add(new Dimension2D(posizione.getWidth()+1, posizione.getHeight()+1));
					}
				
				}
				//se non si è ancora mosso
				if(alreadyMoved && (reference.getCelle()[(int) posizione.getWidth()+2][(int) posizione.getHeight()].getP() instanceof Empty)) 
					temp.add(new Dimension2D(posizione.getWidth()+2, posizione.getHeight()));
			}
		
			
			if(reference.getPossibleMoves().size()!=0)
				reference.getPossibleMoves().clear();
			if(temp.size()!=0)
				reference.getPossibleMoves().addAll(temp);
			reference.setSelected(this);
			
			
			reference.stampamosse();
			
			reference.repaint();
		}	
		
		
	}

	public Boolean getAlreadyMoved() {
		return alreadyMoved;
	}

	public void setAlreadyMoved(Boolean alreadyMoved) {
		this.alreadyMoved = alreadyMoved;
	}
	
}
