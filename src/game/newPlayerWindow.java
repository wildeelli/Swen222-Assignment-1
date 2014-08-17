package game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import main.ProgMain;

public class newPlayerWindow extends JFrame implements ActionListener{
	private static final long serialVersionUID = -62119174601237503L;
	
	private JTextField enterName;
	private JRadioButton mustard;
	private JRadioButton scarlet;
	private JRadioButton green;
	private JRadioButton peacock;
	private JRadioButton white;
	private JRadioButton plum;
	private ButtonGroup choices;
	private JButton next;
	
	private int players;
	private int playerRemain;
	
	private GamePieces.Person[] playerList;
	
	private newPlayerWindow(int playerCount){
		super("New Player");
		if (playerCount>6 || playerCount == 0) throw new IllegalArgumentException("Too many players");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// make the name box
		JLabel text = new JLabel("Player Name: ");
		enterName=new JTextField(20);
		JPanel layoutpanel = new JPanel(new FlowLayout());
		layoutpanel.add(text);
		layoutpanel.add(enterName);
		add(layoutpanel);
		
		// make the radio buttons
		mustard = new JRadioButton("Colonel Mustard", true);
		scarlet = new JRadioButton("Miss Scarlet");
		green = new JRadioButton("Mr. Green");
		peacock = new JRadioButton("Mrs. Peacock");
		white = new JRadioButton("Mrs. White");
		plum = new JRadioButton("Prof. Plum");
		choices = new ButtonGroup();
		choices.add(mustard);
		choices.add(scarlet);
		choices.add(green);
		choices.add(peacock);
		choices.add(white);
		choices.add(plum);
		
		layoutpanel = new JPanel(new GridLayout(6, 1));
		layoutpanel.add(mustard);
		layoutpanel.add(scarlet);
		layoutpanel.add(green);
		layoutpanel.add(peacock);
		layoutpanel.add(white);
		layoutpanel.add(plum);
		layoutpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Players: "));
		
		add(layoutpanel);
		
		next = new JButton("Confirm");
		add(next);
		next.addActionListener(this);
		
		setPreferredSize(new Dimension(330, 240));
		setResizable(false);
		pack();
		setVisible(true);
		
		players = playerRemain = playerCount;
		playerRemain =0;
		playerList = new GamePieces.Person[players];
		
	}
	
	private void nextPlayer(){
		String playerName = enterName.getText();
		if (playerName == null || playerName.length()==0){
			JOptionPane.showMessageDialog(this,
				    "Player Name is too short.",
				    "Data input Error: please try again on tuesday",
				    JOptionPane.WARNING_MESSAGE);
			return;
		}
		String playerToken = selectedRadioButton();
		// TODO: now we need to add this 'player' to the list of players
		int[] loc = ProgMain.board.getNextStartPosition();
		GamePieces.Person player = new GamePieces.Person(playerName, playerToken, loc[0], loc[1]);
		playerList[playerRemain] = player;
		
		playerRemain++;
		if (allPlayersDone()){
			this.setVisible(false);
			this.setEnabled(false);
		}
		
	}
	
	public static GamePieces.Person[] playerWindow(int playerCount){
		newPlayerWindow n = new newPlayerWindow(playerCount);
		while (!n.allPlayersDone()){
			n.setTitle(n.getTitle());
		};
		
		return n.players();
	}
	
	
	private String selectedRadioButton(){
		JRadioButton selected=null;
		for (Enumeration<AbstractButton> buttons = choices.getElements(); buttons.hasMoreElements();){
			AbstractButton b = buttons.nextElement();
			if (!b.isEnabled())
				continue;
			if (b.isSelected() && selected==null){
				selected = (JRadioButton)b;
				selected.setEnabled(false);
			}
		}
		for (Enumeration<AbstractButton> buttons = choices.getElements(); buttons.hasMoreElements();){
			AbstractButton b = buttons.nextElement();
			if (!b.isEnabled())
				continue;
			b.setSelected(true);
			break;
		}
		
		
		
		return selected.getText();
	}
	
	/**
	 * Is the window done making new players
	 * @return
	 */
	private boolean allPlayersDone(){
		// this makes it actually work
		setTitle(getTitle());
		return playerRemain==players;
	}
	
	
	// TODO: change to player type
	private GamePieces.Person[] players(){
		if (playerRemain!=players) throw new IllegalStateException("Not ready to return players");
		return playerList;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		nextPlayer();
	}
}
