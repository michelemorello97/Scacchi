package model;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import graphic.ChessPanel;
import interfaces.Colore;
import interfaces.Pezzo;
import javafx.geometry.Dimension2D;

public class Cell{

	Pezzo p;
	int x;
	int y;
	JButton btn;

	
	
	public Cell(int x, int y, ChessPanel ref){
		this.x=x;
		this.y=y;
		
		btn=new JButton();
		p=new Empty(null, x, y, ref);
		if(x<=1 || x>=6)
		try {
			Image img=null;
			
			//pedoni
			if(x==1) {
				img = ImageIO.read(getClass().getResource("../resources/pedoneNero.png"));
				p=new Pedone(Colore.nero, x, y, ref);
			}
			else if(x==6) {
				img = ImageIO.read(getClass().getResource("../resources/pedoneBianco.png"));
				p=new Pedone(Colore.bianco, x, y, ref);
			}
			//pezzi neri
			else if(x==0)
			{
					if(y==0 || y==7) {
						img = ImageIO.read(getClass().getResource("../resources/torreNera.png"));
						p=new Torre(Colore.nero, x, y, ref);
						}
					
					else if(y==1 || y==6) {
						img = ImageIO.read(getClass().getResource("../resources/cavalloNero.png"));
						p=new Cavallo(Colore.nero, x, y, ref);
						}
					
					else if(y==2 || y==5) {
						img = ImageIO.read(getClass().getResource("../resources/alfiereNero.png"));
						p=new Alfiere(Colore.nero, x, y, ref);
						}
					
					else if(y==3) {
						img = ImageIO.read(getClass().getResource("../resources/reginaNera.png"));
						p=new Regina(Colore.nero, x, y, ref);
						}
					
					else if(y==4) {
						img = ImageIO.read(getClass().getResource("../resources/reNero.png"));
						p=new Re(Colore.nero, x, y, ref);
						}
			}
			
			else if(x==7)
			{
				if(y==0 || y==7) {
					img = ImageIO.read(getClass().getResource("../resources/torreBianca.png"));
					p=new Torre(Colore.bianco, x, y, ref);
					}
				
				else if(y==1 || y==6) {
					img = ImageIO.read(getClass().getResource("../resources/cavalloBianco.png"));
					p=new Cavallo(Colore.bianco, x, y, ref);
					}
				
				else if(y==2 || y==5) {
					img = ImageIO.read(getClass().getResource("../resources/alfiereBianco.png"));
					p=new Alfiere(Colore.bianco, x, y, ref);
					}
				
				else if(y==3) {
					img = ImageIO.read(getClass().getResource("../resources/reginaBianca.png"));
					p=new Regina(Colore.bianco, x, y, ref);
					}
				
				else if(y==4) {
					img = ImageIO.read(getClass().getResource("../resources/reBianco.png"));
					p=new Re(Colore.bianco, x, y, ref);
					}
			}
				
			
			
			if(img!=null) {
				btn.setIcon(new ImageIcon(img));
			}
			
		   
		  } catch (Exception ex) {
		   ex.printStackTrace();
		  }
		
		btn.addActionListener(p);
		
	}
	
	public Pezzo getP() {
		return p;
	}

	public void setP(Pezzo p) {
		this.p = p;
		
	}

	

	public Cell(){
		x=0;
		y=0;
		btn=null;
		p=null;
	}
	
	@Override
	public String toString() {
		return "Cell [x=" + x + ", y=" + y + ", btn=" + btn + "]";
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public JButton getBtn() {
		return btn;
	}
	public void setBtn(JButton btn) {
		this.btn = btn;
	}
	
	
	
	
	
	
}
