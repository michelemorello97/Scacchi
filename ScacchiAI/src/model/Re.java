package model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import graphic.ChessPanel;
import interfaces.Colore;
import interfaces.Pezzo;
import javafx.geometry.Dimension2D;

public class Re extends Pezzo {

	public Re(Colore c, int x, int y, ChessPanel ref) {
		super(c, x, y, ref);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("sono un re "+c);
		
		
		
		
		movimento();
		reference.riassestaPos();
	}
	
	
	
	public void movimento() {
		List<Dimension2D> temp=new ArrayList<>();
		if(this.reference.getTurno()==this.c)
		{
			
		
				int x=(int)this.getPosizione().getWidth();
				int y=(int)this.getPosizione().getHeight();
				//posizioni verso l'alto
				x--;
				if(x>=0) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						temp.add(new Dimension2D(x, y));
					}
					
					y-=1;
					if(y>=0) {
						if(reference.getCelle()[x][y].getP() instanceof Empty)
							temp.add(new Dimension2D(x, y));
						else if(reference.getCelle()[x][y].getP().getC()!=this.c)
						{
							temp.add(new Dimension2D(x, y));
						}
					}
					
					y+=2;
					if(y<=7) {
						if(reference.getCelle()[x][y].getP() instanceof Empty)
							temp.add(new Dimension2D(x, y));
						else if(reference.getCelle()[x][y].getP().getC()!=this.c)
						{
							temp.add(new Dimension2D(x, y));
						}
					}
				}
					
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();	
				
				x++;
				if(x<=7) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						temp.add(new Dimension2D(x, y));
					}
					y-=1;
					if(y>=0) {
						if(reference.getCelle()[x][y].getP() instanceof Empty)
							temp.add(new Dimension2D(x, y));
						else if(reference.getCelle()[x][y].getP().getC()!=this.c)
						{
							temp.add(new Dimension2D(x, y));
						}
					}
					
					y+=2;
					if(y<=7) {
						if(reference.getCelle()[x][y].getP() instanceof Empty)
							temp.add(new Dimension2D(x, y));
						else if(reference.getCelle()[x][y].getP().getC()!=this.c)
						{
							temp.add(new Dimension2D(x, y));
						}
					}
					
				}
			
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();	
				
				
				y-=1;
				if(y>=0) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						temp.add(new Dimension2D(x, y));
					}
				}
				
				y+=2;
				if(y<=7) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()!=this.c)
					{
						temp.add(new Dimension2D(x, y));
					}
				}
				
			
		List<Dimension2D> vediamo=this.reference.cellaAttaccata(this);
		if(vediamo!=null)
			for(Dimension2D pos: vediamo) {
				temp.remove(pos);
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
				//posizioni verso l'alto
				x--;
				if(x>=0) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()==this.c)
					{
						temp.add(new Dimension2D(x, y));
					}
					
					y-=1;
					if(y>=0) {
						if(reference.getCelle()[x][y].getP() instanceof Empty)
							temp.add(new Dimension2D(x, y));
						else if(reference.getCelle()[x][y].getP().getC()==this.c)
						{
							temp.add(new Dimension2D(x, y));
						}
					}
					
					y+=2;
					if(y<=7) {
						if(reference.getCelle()[x][y].getP() instanceof Empty)
							temp.add(new Dimension2D(x, y));
						else if(reference.getCelle()[x][y].getP().getC()==this.c)
						{
							temp.add(new Dimension2D(x, y));
						}
					}
				}
					
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();	
				
				x++;
				if(x<=7) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()==this.c)
					{
						temp.add(new Dimension2D(x, y));
					}
					y-=1;
					if(y>=0) {
						if(reference.getCelle()[x][y].getP() instanceof Empty)
							temp.add(new Dimension2D(x, y));
						else if(reference.getCelle()[x][y].getP().getC()==this.c)
						{
							temp.add(new Dimension2D(x, y));
						}
					}
					
					y+=2;
					if(y<=7) {
						if(reference.getCelle()[x][y].getP() instanceof Empty)
							temp.add(new Dimension2D(x, y));
						else if(reference.getCelle()[x][y].getP().getC()==this.c)
						{
							temp.add(new Dimension2D(x, y));
						}
					}
					
				}
			
				x=(int)this.getPosizione().getWidth();
				y=(int)this.getPosizione().getHeight();	
				
				
				y-=1;
				if(y>=0) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()==this.c)
					{
						temp.add(new Dimension2D(x, y));
					}
				}
				
				y+=2;
				if(y<=7) {
					if(reference.getCelle()[x][y].getP() instanceof Empty)
						temp.add(new Dimension2D(x, y));
					else if(reference.getCelle()[x][y].getP().getC()==this.c)
					{
						temp.add(new Dimension2D(x, y));
					}
				}
				
		return temp;
	}
	
	@Override
	public boolean mangiato() {
		// TODO Auto-generated method stub
		return false;
	}
}
