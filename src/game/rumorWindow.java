package game;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Tiles.Room;

public class rumorWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1992805890362253571L;
	
	private ButtonGroup person;
	private ButtonGroup weapon;
	private String room;
	
	private String[] rumor;
	
	private String []persons = new String[]{
			"Colonel Mustard",
			"Miss Scarlet",
			"Mr. Green",
			"Mrs. Peacock",
			"Mrs. White",
			"Prof. Plum"};
	private String []weapons = new String[]{
			"Candlestick",
			"Knife",
			"Lead Pipe",
			"Revolver",
			"Rope",
			"Wrench"};
	
	private rumorWindow(Room currentRoom){
		super("Start a rumor");
		setLayout(new BorderLayout());
		setResizable(false);
		person = new ButtonGroup();
		JPanel list = new JPanel(new GridLayout(persons.length, 1));
		for (String s: persons){
			JRadioButton r = new JRadioButton(s);
			person.add(r);
			list.add(r);
		}
		list.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Persons: "));
		JPanel j = new JPanel(new BorderLayout());
		j.add(list, BorderLayout.WEST);
		
		room = currentRoom.roomName();
		weapon = new ButtonGroup();
		list = new JPanel(new GridLayout(weapons.length, 1));
		for (String s: weapons){
			JRadioButton r = new JRadioButton(s);
			weapon.add(r);
			list.add(r);
		}
		list.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Weapons: "));
		j.add(list, BorderLayout.EAST);
		
		add(j, BorderLayout.PAGE_START);
		
		j = new JPanel(new FlowLayout());
		
		JButton b = new JButton("Make a Suggestion");
		b.addActionListener(this);
		j.add(b);
		
		b = new JButton("Cancel");
		b.addActionListener(this);
		j.add(b);
		
		add(j);
		
		pack();
		setVisible(true);
	}
	
	/**
	 * Here, we make a rumor.<br>
	 * Here, we make destiny.
	 * 
	 * @param currentRoom The room that the player is currently in.
	 * @param parent The parent window (so we can disable it).
	 * @return A length 3 string array {weapon, person, room}, or null if the player clicked cancel.
	 */
	public static String[] makeRumor(Room currentRoom, JFrame parent){
		rumorWindow r = new rumorWindow(currentRoom);
		while (r.rumor==null){
			r.setTitle(r.getTitle());
		}
		parent.setEnabled(true);
		return r.rumor;
	}
	
	private void rumor(){
		String p = selectedRadioButton(person);
		String w = selectedRadioButton(weapon);
		if (p==null || w==null || p.isEmpty()  || w.isEmpty()){
			return;
		}
		dispose();
		setVisible(false);
		rumor = new String[]{w, p, room};
	}
	
	private String selectedRadioButton(ButtonGroup group){
		JRadioButton selected=null;
		for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();){
			AbstractButton b = buttons.nextElement();
			if (b.isSelected() && selected==null){
				selected = (JRadioButton)b;
			}
		}
		if (selected==null) return null;
		return selected.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = ((JButton)e.getSource()).getText();
		if (s.equals("Cancel")){
			rumor= new String[0];
			dispose();
			setVisible(false);
		} else rumor();
		
	}

}
