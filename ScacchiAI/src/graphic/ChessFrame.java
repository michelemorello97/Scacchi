package graphic;


import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ChessFrame extends JFrame{
	JFrame frame;
	ChessPanel panel;
	
	ChessFrame(){
		super();
		
		
		this.setSize((74*8)+6, (73*8)+7);
		this.setResizable(false);
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
		JOptionPane.showMessageDialog(f, "Cominciano i Bianchi!");
	}

}
