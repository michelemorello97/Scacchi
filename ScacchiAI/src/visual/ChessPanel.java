package visual;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Cell;

public class ChessPanel extends JPanel{

	Cell[][] celle;
	boolean selected;
	
	public ChessPanel(int w, int h) {
		super();
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
		
		
	}
	
	
}
