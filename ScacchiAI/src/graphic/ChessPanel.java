package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import interfaces.Colore;
import interfaces.Pezzo;
import javafx.geometry.Dimension2D;
import model.Cell;
import model.Empty;
import model.Pedone;

public class ChessPanel extends JPanel{

	Cell[][] celle;

	Image ok=null;
	Pezzo selected;
	List<Dimension2D> possibleMoves;
	Colore turno;
	
	public ChessPanel(int w, int h) {
		super();
		turno=Colore.bianco;
		try {
			ok= ImageIO.read(getClass().getResource("../resources/mossa_permessa.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setSize(w, h);
		
		possibleMoves=new ArrayList<Dimension2D>();
		
		celle=new Cell[8][8];
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++) {
				celle[i][j]=new Cell(i, j, this);
			
				this.add(celle[i][j].getBtn());
			}
		
	
		
		
	
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				celle[i][j].getBtn().setBounds(j*70, i*70, 73, 70);
				if((i+j)%2==0)
					celle[i][j].getBtn().setBackground(new Color(245,	245,	220));
					
				else
					celle[i][j].getBtn().setBackground(new Color(150,	75,	0));
					
			}
		}
		
		if(possibleMoves!=null && possibleMoves.size()!=0) {
			for(Dimension2D d: possibleMoves) {
				celle[(int)d.getWidth()][(int)d.getHeight()].getBtn().setBackground(new Color(127,	255,	0));
			}
		}
		
		
		
		
	}

	public Cell[][] getCelle() {
		return celle;
	}

	public void setCelle(Cell[][] celle) {
		this.celle = celle;
	}

	public Colore getTurno() {
		return turno;
	}

	public void setTurno(Colore turno) {
		this.turno = turno;
	}

	public List getPossibleMoves() {
		return possibleMoves;
	}

	public void setPossibleMoves(List possibleMoves) {
		this.possibleMoves = possibleMoves;
	}
	
	public void stampamosse() {
		if(possibleMoves!=null && possibleMoves.size()!=0)
			for(Dimension2D d: possibleMoves) {
				System.out.println(d.getWidth()+" "+d.getHeight());
			}
	}

	public Pezzo getSelected() {
		return selected;
	}

	public void setSelected(Pezzo selected) {
		this.selected = selected;
	}
	
	public void cambiaTurno() {
		if(turno==Colore.bianco)
			turno=Colore.nero;
		else
			turno=Colore.bianco;
	}
	
	public void riassestaPos() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				celle[i][j].getP().setPosizione(new Dimension2D(i, j));
			}
		}
	}
	
	public void stampaPos() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				System.out.print((int)celle[i][j].getP().getPosizione().getWidth()+"-"+(int)celle[i][j].getP().getPosizione().getHeight()+" ");
			}
			System.out.println(" ");
		}
	}
	
	public List<Dimension2D> cellaAttaccata(Pezzo p) {
		List<Dimension2D> toh=new LinkedList<>();
		
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				if(celle[i][j].getP().getC()!=p.getC())
				{
					List<Dimension2D> temp=celle[i][j].getP().celleAttaccate();
					if(temp!=null)
						toh.addAll(temp);
				}
			}
		}
		
		return toh;
	}
	
}
