package model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import graphic.ChessPanel;
import interfaces.Colore;
import interfaces.Pezzo;
import javafx.geometry.Dimension2D;

public class Alfiere extends Pezzo {

	public Alfiere(Colore c, int x, int y, ChessPanel ref) {
		super(c, x, y, ref);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("sono un alfiere " +c);
		
		
		
		
		if(!mangiato())
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
				y++;
				//posizioni verso su e destra
				while(x>=0 && y<=7) {
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
					y++;
				}
				
				
				
				
				
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();
				//posizioni verso giù e destra
				x++;
				y++;
				while(x<=7 && y<=7) {
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
					y++;
				}
				
				
				
				
				
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();
				//posizioni verso su e sinistra
				x--;
				y--;
				while(x>=0 && y>=0) {
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
					y--;
				}
				
				
				
				
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();
				//posizioni verso giù e sinistra
				x++;
				y--;
				while(x<=7 && y>=0) {
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
		
			
		
				int x=(int)this.getPosizione().getWidth();
				int y=(int)this.getPosizione().getHeight();
				x--;
				y++;
				//posizioni verso su e destra
				while(x>=0 && y<=7) {
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
					y++;
				}
				
				
				
				
				
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();
				//posizioni verso giù e destra
				x++;
				y++;
				while(x<=7 && y<=7) {
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
					y++;
				}
				
				
				
				
				
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();
				//posizioni verso su e sinistra
				x--;
				y--;
				while(x>=0 && y>=0) {
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
					y--;
				}
				
				
				
				
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();
				//posizioni verso giù e sinistra
				x++;
				y--;
				while(x<=7 && y>=0) {
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
}
