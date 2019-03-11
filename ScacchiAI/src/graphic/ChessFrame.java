package graphic;


import javax.swing.JFrame;


public class ChessFrame extends JFrame{
	JFrame frame;
	ChessPanel panel;
	
	ChessFrame(){
		super();
		
		
		this.setSize(600, 600);
		
		panel= new ChessPanel(600, 600);

		this.setContentPane(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
public static void main(String[] args) {
		
		ChessFrame f=new ChessFrame();
		f.setTitle("Chess I.A.");
	//	f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	//	f.setUndecorated(true);
		f.setVisible(true);
	}

}
