package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import interfaces.Pezzo;
import javafx.geometry.Dimension2D;
import model.Cell;

public class ChessPanel extends JPanel{

	Cell[][] celle;
	boolean selected;
	Image ok=null;
	
	public ChessPanel(int w, int h) {
		super();
		try {
			ok= ImageIO.read(getClass().getResource("../resources/mossa_permessa.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setSize(w, h);
		selected=false;
		
		celle=new Cell[8][8];
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++) {
				celle[i][j]=new Cell(i, j);
			
				this.add(celle[i][j].getBtn());
			}
		
	
		
		
		new Thread() {
			@Override
			public void run() {
				
				while(true) {
					
					repaint();
					try {
						Thread.sleep(16);
					} 
					catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
		
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
		
		if(isClicked()) {
			Pezzo p=whoIsClicked();
			for(Dimension2D d: p.getMossePossibili()) {
				g.drawImage(ok,(int) d.getWidth(), (int) d.getWidth(), null);
			}
		}
		
		
	}
	
	public Boolean isClicked() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(celle[i][j].getClicked())
					return true;
			}
		}
		return false;
	}
	
	public Pezzo whoIsClicked() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(celle[i][j].getClicked())
					return celle[i][j].getP();
			}
		}
		return null;
	}
	
	
}
