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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ai_manager.Ai_Test;
import interfaces.Colore;
import interfaces.Pezzo;
import javafx.geometry.Dimension2D;
import model.Cell;
import model.Empty;
import model.Pedone;
import model.Re;
import model.Regina;

public class ChessPanel extends JPanel{

	Cell[][] celle;
	Ai_Test ai;
	Pezzo selected;
	List<Dimension2D> possibleMoves;
	Colore turno;
	Image regina_bianca;
	Image regina_nera;
	boolean scaccoAlReBianco;
	boolean scaccoAlReNero;
	List<Pezzo> pezziBianchi;
	List<Pezzo> pezziNeri;
	Pezzo reNero;
	Pezzo reBianco;
	
	public ChessPanel(int w, int h) {
		super();
		scaccoAlReBianco=false;
		scaccoAlReNero=false;
		try {
			regina_bianca = ImageIO.read(getClass().getResource("../resources/reginaBianca.png"));
			regina_nera = ImageIO.read(getClass().getResource("../resources/reginaNera.png"));
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		turno=Colore.bianco;
		ai=new Ai_Test();
		this.setSize(w, h);
		
		possibleMoves=new ArrayList<Dimension2D>();
		
		celle=new Cell[8][8];
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++) {
				celle[i][j]=new Cell(i, j, this);
			
				this.add(celle[i][j].getBtn());
			}
		pezziBianchi=new LinkedList<Pezzo>();
		pezziNeri=new LinkedList<Pezzo>();
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<8; j++)
			{
				pezziNeri.add(celle[i][j].getP());
				pezziBianchi.add(celle[i+6][j].getP());
			}
		}
		
		reNero=celle[0][4].getP();
		reBianco=celle[7][4].getP();
	
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				celle[i][j].getBtn().setBounds(j*74, i*70, 74, 70);
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
				if(celle[i][j].getP() instanceof Pedone && (i==0 || i==7))
					turnToQueen( i, j);
					
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
	
	public List<Pezzo> celleAttaccateIgnoringThis(Pezzo p){
		List<Pezzo> toh=new LinkedList<>();
	
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				//if(celle[i][j].getP().getC()!=p.getC()) vecchio controllo
				if(celle[i][j].getP().getC()!=turno)
				{
					Pezzo temp=celle[i][j].getP().celleAttaccateIgnoringTHAT(p);
					if(temp!=null)
						toh.add(temp);
				}
			}
		}
		if(toh!=null && toh.size()!=0)
			System.out.println(toh.get(0).getPosizione());
		return toh;
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

	public Ai_Test getAi() {
		return ai;
	}

	public void setAi(Ai_Test ai) {
		this.ai = ai;
	}
	
	public List<Dimension2D> pezzidelColoreCorrente(Colore c) {
		List<Dimension2D> toh=new LinkedList<>();
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				if(celle[i][j].getP().getC()==c)
					toh.add(new Dimension2D(i, j));
		return toh;
	}
	
public void turnToQueen(int i, int j) {
		
		if(i==0) {
		celle[i][j].getBtn().setIcon(new ImageIcon(regina_bianca));
		
		
		Pezzo pezzo=new Regina(Colore.bianco, i, j, this);
		Pezzo veccio=celle[i][j].getP();
		//sposto il pezzo nella casella selezionata
		celle[i][j].setP(pezzo);
		celle[i][j].getBtn().removeActionListener(veccio);
		celle[i][j].getBtn().addActionListener(pezzo);
		}
		else {
			celle[i][j].getBtn().setIcon(new ImageIcon(regina_nera));
			
			
			Pezzo pezzo=new Regina(Colore.nero, i, j, this);
			Pezzo veccio=celle[i][j].getP();
			//sposto il pezzo nella casella selezionata
			celle[i][j].setP(pezzo);
			celle[i][j].getBtn().removeActionListener(veccio);
			celle[i][j].getBtn().addActionListener(pezzo);
		}
		
		
		
		
		repaint();
	}

public boolean isScaccoAlReBianco() {
	return scaccoAlReBianco;
}

public void setScaccoAlReBianco(boolean scaccoAlReBianco) {
	this.scaccoAlReBianco = scaccoAlReBianco;
}

public boolean isScaccoAlReNero() {
	return scaccoAlReNero;
}

public void setScaccoAlReNero(boolean scaccoAlReNero) {
	this.scaccoAlReNero = scaccoAlReNero;
}

public List<Pezzo> getPezziBianchi() {
	return pezziBianchi;
}

public void setPezziBianchi(List<Pezzo> pezziBianchi) {
	this.pezziBianchi = pezziBianchi;
}

public List<Pezzo> getPezziNeri() {
	return pezziNeri;
}

public void setPezziNeri(List<Pezzo> pezziNeri) {
	this.pezziNeri = pezziNeri;
}

public Pezzo getReNero() {
	return reNero;
}

public void setReNero(Pezzo reNero) {
	this.reNero = reNero;
}

public Pezzo getReBianco() {
	return reBianco;
}

public void setReBianco(Pezzo reBianco) {
	this.reBianco = reBianco;
}


	
}
