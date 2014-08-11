package board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;


/**
 * Board Loader:<br>
 * INCOMPLETE <p>
 * Attempts to create a board from a file, or something like that...
 *
 * @author Elliot Wilde
 *
 */
public class BoardLoader {
	
	public BoardLoader(){}
	
	public BoardReturn loadBoard(String boardFile){
		BoardReturn b = new BoardReturn();
		StringBuilder file = new StringBuilder();
		try {
			BufferedReader r = new BufferedReader(new FileReader(boardFile));
			int input;  
			do {
				input = r.read();
				if (input == '\n' || input == '\r') continue;
				if (input == -1) break;
				file.append((char)input);
			} while (input != -1);
				
			r.close();
		} catch (Exception e) {e.printStackTrace(); }
//		System.out.println(file);
		
		String lines[] = file.toString().split("><");
		System.out.println(lines.length);
		for (String s: lines){
			System.out.println(s);
		}
		return b;
	}

	public class BoardReturn{
		public char board [];
		public Map<Character, String> tiles;
	}
}
