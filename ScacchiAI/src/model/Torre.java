package model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import graphic.ChessPanel;
import interfaces.Colore;
import interfaces.Pezzo;
import javafx.geometry.Dimension2D;

public class Torre extends Pezzo{

	public Torre(Colore c, int x, int y, ChessPanel ref) {
		super(c, x, y, ref);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("sono una torre "+c+" "+posizione.getWidth()+" "+posizione.getHeight());
		
		
		if(!mangiato())
			if(possoMuovermi(reference.celleAttaccateIgnoringThis(this)))
				movimento();
		
			
		reference.riassestaPos();
	}
	
	
	public void movimento() {
		List<Dimension2D> temp=new ArrayList<>();
		if(this.reference.getTurno()==this.c)
		{
			
		
				int x=(int)this.getPosizione().getWidth();
				int y=(int)this.getPosizione().getHeight();
				x--;
				//posizioni verso l'alto
				while(x>=0) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						temp.add(new Dimension2D(x, y));
						break;
					}
					else if(reference.getCelle()[x][y].getP().getC()==this.c){
						break;
					}
					x--;
				}
				x=(int)this.getPosizione().getWidth();
				x++;
				//posizioni verso il basso
				while(x<=7) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						temp.add(new Dimension2D(x, y));
						break;
					}
					else if(reference.getCelle()[x][y].getP().getC()==this.c){
						break;
					}
					x++;
				}
				x=(int)this.getPosizione().getWidth();
				
				y++;
				//posizioni verso destra
				while(y<=7) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						temp.add(new Dimension2D(x, y));
						break;
					}
					else if(reference.getCelle()[x][y].getP().getC()==this.c){
						break;
					}
					y++;
				}
				
				y=(int)this.getPosizione().getHeight();
				y--;
				//posizioni verso sinistra
				while(y>=0) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						temp.add(new Dimension2D(x, y));
						break;
					}
					else if(reference.getCelle()[x][y].getP().getC()==this.c){
						break;
					}
					y--;
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
	
	@Override
	public List<Dimension2D> celleAttaccate() {
		List<Dimension2D> temp=new ArrayList<>();
		temp.add(posizione);
		
				int x=(int)this.getPosizione().getWidth();
				int y=(int)this.getPosizione().getHeight();
				x--;
				//posizioni verso l'alto
				while(x>=0) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						
						break;
					}
					else if(reference.getCelle()[x][y].getP().getC()==this.c){
						temp.add(new Dimension2D(x, y));
						break;
					}
					x--;
				}
				x=(int)this.getPosizione().getWidth();
				x++;
				//posizioni verso il basso
				while(x<=7) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						
						break;
					}
					else if(reference.getCelle()[x][y].getP().getC()==this.c){
						temp.add(new Dimension2D(x, y));
						break;
					}
					x++;
				}
				x=(int)this.getPosizione().getWidth();
				
				y++;
				//posizioni verso destra
				while(y<=7) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						
						break;
					}
					else if(reference.getCelle()[x][y].getP().getC()==this.c){
						temp.add(new Dimension2D(x, y));
						break;
					}
					y++;
				}
				
				y=(int)this.getPosizione().getHeight();
				y--;
				//posizioni verso sinistra
				while(y>=0) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						
						break;
					}
					else if(reference.getCelle()[x][y].getP().getC()==this.c){
						temp.add(new Dimension2D(x, y));
						break;
					}
					y--;
				}
				
		return temp;
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
	
	@Override
	public Pezzo celleAttaccateIgnoringTHAT(Pezzo p) {
		boolean arrivaAlRe=false;
		//TODO ricorda di dividere l'algoritmo sia per i pezzi bianchi che neri
				int x=(int)this.getPosizione().getWidth();
				int y=(int)this.getPosizione().getHeight();
				x--;
				//posizioni verso l'alto
				while(x>=0 && arrivaAlRe==false) {
					
					if(reference.getCelle()[x][y].getP().getC()==this.c){
						break;
					}
					else if((x==(int)reference.getReBianco().getPosizione().getWidth() && y==(int)reference.getReBianco().getPosizione().getHeight())
							|| (x==(int)reference.getReNero().getPosizione().getWidth() && y==(int)reference.getReNero().getPosizione().getHeight()))
						arrivaAlRe=true;
					
					else if(!(reference.getCelle()[x][y].getP() instanceof Empty) && reference.getCelle()[x][y].getP().getC()!=this.c &&
							(x!=(int)p.getPosizione().getWidth() || y!=(int)p.getPosizione().getHeight()))
					{
						
						break;
					}
					x--;
				}
				x=(int)this.getPosizione().getWidth();
				x++;
				//posizioni verso il basso
				while(x<=7 && arrivaAlRe==false) {
					
					if(reference.getCelle()[x][y].getP().getC()==this.c){
						break;
					}
					else if((x==(int)reference.getReBianco().getPosizione().getWidth() && y==(int)reference.getReBianco().getPosizione().getHeight())
							|| (x==(int)reference.getReNero().getPosizione().getWidth() && y==(int)reference.getReNero().getPosizione().getHeight()))
						arrivaAlRe=true;
					
					else if(!(reference.getCelle()[x][y].getP() instanceof Empty) && reference.getCelle()[x][y].getP().getC()!=this.c &&
							(x!=(int)p.getPosizione().getWidth() || y!=(int)p.getPosizione().getHeight()))
					{
						
						break;
					}
					x++;
				}
				x=(int)this.getPosizione().getWidth();
				
				y++;
				//posizioni verso destra
				while(y<=7 && arrivaAlRe==false) {
					
					if(reference.getCelle()[x][y].getP().getC()==this.c){
						break;
					}
					else if((x==(int)reference.getReBianco().getPosizione().getWidth() && y==(int)reference.getReBianco().getPosizione().getHeight())
							|| (x==(int)reference.getReNero().getPosizione().getWidth() && y==(int)reference.getReNero().getPosizione().getHeight()))
						arrivaAlRe=true;
					
					else if(!(reference.getCelle()[x][y].getP() instanceof Empty) && reference.getCelle()[x][y].getP().getC()!=this.c &&
							(x!=(int)p.getPosizione().getWidth() || y!=(int)p.getPosizione().getHeight()))
					{
						
						break;
					}
					y++;
				}
				
				y=(int)this.getPosizione().getHeight();
				y--;
				//posizioni verso sinistra
				while(y>=0 && arrivaAlRe==false) {
					
					if(reference.getCelle()[x][y].getP().getC()==this.c){
						break;
					}
					else if((x==(int)reference.getReBianco().getPosizione().getWidth() && y==(int)reference.getReBianco().getPosizione().getHeight())
							|| (x==(int)reference.getReNero().getPosizione().getWidth() && y==(int)reference.getReNero().getPosizione().getHeight()))
						arrivaAlRe=true;
					
					else if(!(reference.getCelle()[x][y].getP() instanceof Empty) && reference.getCelle()[x][y].getP().getC()!=this.c &&
							(x!=(int)p.getPosizione().getWidth() || y!=(int)p.getPosizione().getHeight()))
					{
						
						break;
					}
					y--;
				}
				
		if(arrivaAlRe)
			return this;
		else
			return null;
	}
	
	@Override
	public boolean possoMuovermi(List<Pezzo> toh) {
		if(toh!= null && toh.size()>=1)
			return false;

		return true;
	}
}
