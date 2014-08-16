package board;

import java.util.ArrayList;
import java.util.List;

import Tiles.Tile;
import board.BoardLoader.BoardReturn;

public class Board {
	
	private boardTile board[][] = null;
	
	protected Board(BoardReturn b){
		char tiles [][] = b.board;
		this.board = new boardTile[b.board.length][b.board[0].length];
		for (int x=0; x<b.board.length; ++x){
			for (int y=0; y<b.board[0].length; ++y){
				
			}
		}
		
		
	}

	
	
	/**
	 * Node used for pathfinding
	 * @author Bandit
	 *
	 */
	private class navNode {
		/**
		 * All of the adjacent navNodes
		 */
		protected final List<navNode> connected;
		/**
		 * The x and y position of the navNode on the board
		 */
		protected final int x, y;
		public navNode(int x, int y){
			connected = new ArrayList<navNode>();
			this.x = x; this.y = y;
			
		}
		
		
		
		
		
	}
	
	private class boardTile {
		protected final Tile tile;
		
		public boardTile(){
			tile=null;
		}
		
	}
}
