package board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
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
	
	public Board loadBoard(String boardFile){
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
		file.deleteCharAt(0);
		file.deleteCharAt(file.length()-1);
		String lines[] = file.toString().split("><");
//		System.out.println(lines.length);
		for (String s: lines){
//			System.out.println(s);
			String[] line = s.split(" ");
			if (line[0].startsWith("t")){
				char token='\0';
				String name="";
				int type;
				for (String l: line){
					String[] tokens = l.split("=");
					switch(tokens[0]){
					case "t":
						token = tokens[1].charAt(0);
						break;
					case "n":
						name = tokens[1];
						break;
					case "r":
						type = Integer.parseInt(tokens[1]);
						break;
						default:
							System.out.println("unexpected token occured");
					}
				}
				b.tiles = new HashMap<>();
				b.tiles.put(token, name);
			} else if (line[0].startsWith("b")){
				int width=0, height=0;
				for (String l: line){
					if (l.startsWith("w")){
						width = Integer.parseInt(l.split("=")[1]);
					} else if (l.startsWith("h")){
						height = Integer.parseInt(l.split("=")[1]);
					}
				}
				b.board = new char[width][height];
				for (String l: line){
					if (l.startsWith("m")){
						String board = l.split("=")[1];
						for (int i=0, h=0; h<height; h++){
							for (int w=0; w<width; w++, i++){
								b.board[w][h] = board.charAt(i);
							}
						}
					}
				}
			}
			
			
			
			
		}
		return new Board(b);
	}

	protected class BoardReturn{
		public char board [][];
		public Map<Character, String> tiles;
	}
}
