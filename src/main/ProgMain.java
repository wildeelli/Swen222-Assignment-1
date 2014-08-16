package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.MenuItem;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import board.Board;
import board.BoardCanvas;
import board.BoardLoader;


public class ProgMain implements MouseListener, MenuListener, ActionListener {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem[] menus;
	private JButton[] buttons;
	private BoardCanvas canvas;
	private JTextField textField;
	private JRadioButton[] radios;
	private JFrame window;
	
	private final Board board;
	
	
	
	public ProgMain() {

		board = new BoardLoader().loadBoard("board.txt");
		
		BorderLayout b = new BorderLayout();
		window = new JFrame("Swen 222 Assignment");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(b);
//		window.setResizable(false);
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
		menuBar.add(menu);
//		JPanel upperPanel = new JPanel();
//		upperPanel.setSize(640,400);
		canvas = new BoardCanvas(board);
		canvas.setPreferredSize(new Dimension( 640, 400));
		canvas.setSize(640, 400);
//		canvas.setBackground(Color.cyan);
		// TODO: pick sizes for all the elements
//		canvas.setPreferredSize(new Dimension(640,  480));
//		upperPanel.add(canvas);
		window.add(canvas, BorderLayout.CENTER);
		
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
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		out.println(e);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		out.println(e);
	}
}
