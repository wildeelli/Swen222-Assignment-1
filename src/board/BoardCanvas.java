package board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;


public class BoardCanvas extends JComponent{
	// this stops java complaining
	private static final long serialVersionUID = -2936506367154755594L;

	private final Board board;
	
	public BoardCanvas(Board board){
		super();
		this.board=board;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println("drawing");
		Rectangle s = g.getClipBounds();
		BufferedImage b = new BufferedImage(s.width, s.height, BufferedImage.TYPE_INT_ARGB);
		// and we draw the board, or at least ask the board to draw itself on a blank image
		board.draw((Graphics2D) g.create());
		// and then we put the (not blank) image on the screen...
		g.drawImage(b, 0, 0, null);
		
	}

}
