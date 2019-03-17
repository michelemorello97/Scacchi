package model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

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
		
		
		
		movimento();
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

}
