package main;

import game.newPlayerWindow;
import game.rumorWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.System.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import GamePieces.Card;
import GamePieces.Person;
import Tiles.Room;
import Tiles.Tile;
import board.Board;
import board.BoardCanvas;
import board.BoardLoader;


public class ProgMain implements MouseListener, ActionListener {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem[] menus;
	private JButton[] buttons;
	private BoardCanvas canvas;
//	private JTextField textField;
//	private JRadioButton[] radios;
	private JFrame window;
	
	public static Board board;
	
	private Game game;
	
	
	public ProgMain() {

		board = new BoardLoader().loadBoard("board.txt");
		// create a window
		BorderLayout b = new BorderLayout();
		window = new JFrame("Swen 222 Assignment");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(b);
//		window.setResizable(false);
		
		// create some buttons
		menuBar = new JMenuBar();
		menu = new JMenu("File");
//		menu.addMenuListener(this);
		menuBar.add(menu, BorderLayout.PAGE_START);
		JMenuItem menuItem = new JMenuItem("New Game");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		
		menu.add(menuItem);
		window.setJMenuBar(menuBar);
//		menuBar.setVisible(true);
		menu = new JMenu("Game");
		
		menuItem = new JMenuItem("Make Suggestion");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Make Accusation");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		//create the drawable area
		canvas = new BoardCanvas(board);
		canvas.setPreferredSize(new Dimension( 640, 400));
		canvas.setMinimumSize(new Dimension(100,100));
		canvas.setSize(640, 400);
//		canvas.setBackground(Color.cyan);
		// TODO: pick sizes for all the elements
//		canvas.setPreferredSize(new Dimension(640,  480));
//		upperPanel.add(canvas);
		window.add(canvas, BorderLayout.CENTER);
		
		// make the bit on the bottom of the window
		JPanel lowerPanel = new JPanel();
		JPanel dicePanel = new JPanel();
//		dicePanel.setBackground(Color.black);
//		dicePanel.setSize(60,100);
		dicePanel.setPreferredSize(new Dimension(60, 90));
		lowerPanel.add(dicePanel);
		lowerPanel.setBackground(Color.gray);
//		lowerPanel.setSize(640, 100);
		lowerPanel.setPreferredSize(new Dimension(640, 100));
		window.add(lowerPanel, BorderLayout.PAGE_END);
		window.pack();
//		window.setSize(640, 480);
		
		
		window.setVisible(true);
		
		// here we make a new game
		game = new Game();
		Person p = game.getCurPlayer();
		
		
		
//		newPlayerWindow w = new newPlayerWindow(3, window);
//		rumorWindow rum= new rumorWindow(board.ballRoom, window);
//		String[] rum = rumorWindow.makeRumor(board.ballRoom, window);
//		while (!rum.hasRumor()){
//			System.out.println("crap");
//			rum.is
//		} 
//		System.out.println("done");
//		System.out.printf("%s %s\n", rum.getRumor()[0], rum.getRumor()[1], rum.getRumor()[2]);
//		System.out.printf("%s %s %s\n", rum[0], rum[1], rum[2]);
	
		
		
		// remove this line when board construction is complete
//		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		// trollolololol just start the application then die...
		new ProgMain();
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem m = (JMenuItem)e.getSource();
		
		if (m.getText().equals("Make Suggestion")){
			Person p = game.getCurPlayer();
			System.out.println(p==null);
			Tile t = board.tileAt(p.getX(), p.getY());
			
			if (!(t instanceof Room)){
				return;
			}
			Room r = (Room) t;
				
			String[] sug = rumorWindow.makeRumor(r, window);
			if (sug.length==3){
				game.makeSuggestion(new Card(sug[0], null, Card.Type.WEAPON),
						new Card(sug[1], null, Card.Type.ROOM),
						new Card(sug[2], null, Card.Type.PERSON));
			}
			
			
		} else if (m.getText().equals("Make Accusation")){
			Person p = game.getCurPlayer();
			System.out.println(p==null);
			Tile t = board.tileAt(p.getX(), p.getY());
			
			if (!(t instanceof Room)){
				return;
			}
			Room r = (Room) t;
				
			String[] sug = rumorWindow.makeRumor(r, window);
			if (sug.length==3){
				game.MakeAcusation(new Card(sug[0], null, Card.Type.WEAPON),
						new Card(sug[1], null, Card.Type.ROOM),
						new Card(sug[2], null, Card.Type.PERSON));
			}
		} else if (m.getText().equals("New Game")){
			game=new Game();
		} else if (m.getText().equals("Exit")){
			System.exit(0);
		}
		
		out.println(m.getText());
		canvas.repaint();
	}
}
