package model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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
		
		if(!mangiato())
			if(possoMuovermi(reference.celleAttaccateIgnoringThis(this)))
				movimento();
		
			
		reference.riassestaPos();
		
		
	}
	@Override
	public boolean mangiato() {
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
					Pezzo pezzo2=new Empty(null, (int)reference.getSelected().getPosizione().getWidth(), (int)reference.getSelected().getPosizione().getHeight(), reference);
					
					
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
					
					if(reference.getPossibleMoves().size()!=0)
						reference.getPossibleMoves().clear();
					
					return true;
				}
			}
		return false;
	}
	
	public void movimento() {
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
			
			
			//reference.stampamosse();
			
			reference.repaint();
		}
	}

	public Boolean getAlreadyMoved() {
		return alreadyMoved;
	}

	public void setAlreadyMoved(Boolean alreadyMoved) {
		this.alreadyMoved = alreadyMoved;
	}
	
	@Override
	public List<Dimension2D> celleAttaccate() {
		List<Dimension2D> celle=new LinkedList<>();
		celle.add(posizione);
		int x=(int)this.getPosizione().getWidth();
		int y=(int)this.getPosizione().getHeight();
		
		if(this.c==Colore.bianco)
		{
			x--;
			y++;
			if(x>=0 && y<=7) 
				celle.add(new Dimension2D(x, y));
			
			y-=2;
			if(x>=0 && y>=0)
				celle.add(new Dimension2D(x, y));
		}
		
		
		else {
			x++;
			y++;
			if(x<=7 && y<=7) 
				celle.add(new Dimension2D(x, y));
			
			y-=2;
			if(x<=7 && y>=0)
				celle.add(new Dimension2D(x, y));
		}
		return celle;
	}
	public boolean possoMuovermi(List<Pezzo> toh) {
		if(toh!= null && toh.size()>=1) 
			return false;
		return true;
	}
	
	@Override
	public Pezzo celleAttaccateIgnoringTHAT(Pezzo p) {
		boolean arrivaAlRe=false;
		int x=(int)this.getPosizione().getWidth();
		int y=(int)this.getPosizione().getHeight();
		
		if(this.c==Colore.bianco)
		{
			x--;
			y++;
			if(x>=0 && y<=7) 
				if(x==(int)reference.getReNero().getPosizione().getWidth() && y==(int)reference.getReNero().getPosizione().getHeight())
			arrivaAlRe=true;
			
			y-=2;
			if(x>=0 && y>=0)
				if(x==(int)reference.getReNero().getPosizione().getWidth() && y==(int)reference.getReNero().getPosizione().getHeight())
					arrivaAlRe=true;
		}
		
		
		else {
			x++;
			y++;
			if(x<=7 && y<=7) 
				if((x==(int)reference.getReBianco().getPosizione().getWidth() && y==(int)reference.getReBianco().getPosizione().getHeight()))
					arrivaAlRe=true;
			
			y-=2;
			if(x<=7 && y>=0)
				if((x==(int)reference.getReBianco().getPosizione().getWidth() && y==(int)reference.getReBianco().getPosizione().getHeight()))
					arrivaAlRe=true;
		}
		if(arrivaAlRe)
			return this;
		else
			return null;
	}
	
}
