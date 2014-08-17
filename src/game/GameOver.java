package game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameOver{

	public static void win(){
		JOptionPane.showMessageDialog(null, "Conragulations you have won the game");
	}
	
	public static void loose(){
		JOptionPane.showMessageDialog(null,"BAD LACK \n Game Over");
	}
	
	
	//used for testing
	/*public static void main(String[] args){
		loose();
		win();
	}
	*/
}
