package board;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import GamePieces.Person;
import Tiles.Corridor;
import Tiles.Doorway;
import Tiles.Room;
import Tiles.Tile;
import Tiles.Wall;
import board.BoardLoader.BoardReturn;

/**
 * Object to represent the games board, constructor is private and is called from a board loader
 * 
 * @author Elliot Wilde
 *
 */
public class Board {
	
	// these here are a whole collection of statics, so that the board can be constructed
	public static final Tile corridor = new Corridor();
	public static final Room kitchen = new Room("Kitchen");
	public static final Tile wall = new Wall();
	public static final Room ballRoom = new Room("Ball Room");
	public static final Room diningRoom = new Room("Dining Room");
	public static final Room lounge = new Room("Lounge");
	public static final Room hall = new Room("Hall");
	public static final Room study = new Room("Study");
	public static final Room library = new Room("Library");
	public static final Room billiardsRoom = new Room("Billiards Room");
	public static final Room conservatory = new Room("Conservatory");
	public static final Tile startPos = new Corridor();
	
	private boardTile board[][] = null;
	private boardTile startPositions[] = null;
	private int curStartPos =0;
	
	private final int width;
	private final int height;
	private final double aspectRatio;
	
	protected Board(BoardReturn b){
		width = b.board.length;
		height = b.board[0].length;
		aspectRatio = (double)width/(double)height;
		this.board = new boardTile[width][height];
		this.startPositions = new boardTile[6];
		int startposcount=0;
		
//		navNode tiles [][] = new navNode[width][height];
		List<boardTile> nodes = new ArrayList<>();
		
		for (int x=0; x<width; ++x){
			for (int y=0; y<height; ++y){
				switch(b.board[x][y]){
				// TODO: doorways?
				case '0':
					board[x][y] = new boardTile(wall,x ,y);
					break;
				case '.':
					board[x][y] = new boardTile(corridor,x ,y);
					break;
				case 'k':
					board[x][y] = new boardTile(kitchen,x ,y);
					break;
				case 'K':
					board[x][y] = new boardTile(new Doorway(kitchen, x, y),x ,y);
					break;
				case 'b':
					board[x][y] = new boardTile(ballRoom,x ,y);
					break;
				case 'B':
					board[x][y] = new boardTile(new Doorway(ballRoom, x, y),x ,y);
					break;
				case 'd':
					board[x][y] = new boardTile(diningRoom,x ,y);
					break;
				case 'D':
					board[x][y] = new boardTile(new Doorway(diningRoom, x, y),x ,y);
					break;
				case 'o':
					board[x][y] = new boardTile(lounge,x ,y);
					break;
				case 'O':
					board[x][y] = new boardTile(new Doorway(lounge, x, y),x ,y);
					break;
				case 'h':
					board[x][y] = new boardTile(hall,x ,y);
					break;
				case 'H':
					board[x][y] = new boardTile(new Doorway(hall, x, y),x ,y);
					break;
				case 't':
					board[x][y] = new boardTile(study,x ,y);
					break;
				case 'T':
					board[x][y] = new boardTile(new Doorway(study, x, y),x ,y);
					break;
				case 'l':
					board[x][y] = new boardTile(library,x ,y);
					break;
				case 'L':
					board[x][y] = new boardTile(new Doorway(library, x, y),x ,y);
					break;
				case 'i':
					board[x][y] = new boardTile(billiardsRoom,x ,y);
					break;
				case 'I':
					board[x][y] = new boardTile(new Doorway(billiardsRoom, x, y),x ,y);
					break;
				case 'c':
					board[x][y] = new boardTile(conservatory,x ,y);
					break;
				case 'C':
					board[x][y] = new boardTile(new Doorway(conservatory, x, y),x ,y);
					break;
				case 's':
					board[x][y] = new boardTile(startPos,x ,y);
					startPositions[startposcount] = board[x][y];
					startposcount++;
					break;
					default:
						System.out.println("invalid character found in board");
						System.exit(1);
				}
				nodes.add(board[x][y]);
				
			}
		}
		for (int i=0; i<nodes.size(); ++i){
//			System.out.print(i);
//			System.out.print(' ');
			nodes.get(i).build(board);
		}
	}

	
	public void draw(Graphics2D g){
		// first, we get how big our drawing space is
		Rectangle r=null;
		if((r=g.getClipBounds())==null){
			throw new IllegalArgumentException();
		} else {
			g.setColor(Color.blue);
		}
		int w = r.width-2;
		int h = r.height-2;
		int leftoffset = 1;
		int topoffset = 1;
		double tilesize=0;
		// here we determine how far from the sides the board should be drawn
		// this is based upon the size of the draw area, and the aspect ratio of the board
		// this will also determine how large the tiles on the board are.
		if ((w/h)<aspectRatio){ // this is what happens if the drawable area is wider than the board
			// so we want the top offset to increase
			tilesize=(double)w/(double)this.width;
			topoffset = 1+(int)((double)h - (this.height*tilesize)) /2;
		} else { // this is what happens if the drawable area is taller  than the board
			// so we want the left offset to increase
			tilesize=(double)h/(double)this.height;
			leftoffset =1+ (int)((double)w - (this.width*tilesize)) /2;
		}
		
//		g.draw(r);
		// now we draw a black box around the drawing area, because we can
		g.setColor(Color.BLACK);
		g.drawRect(leftoffset-1, topoffset-1, (int)(this.width*tilesize)+1, (int)(this.height*tilesize)+1);
		
		for (int x=0; x<width; ++x){
			for (int y=0; y<height; ++y){
				Tile t = board[x][y].tile;
				if (t==startPos) {
					g.setColor(Color.GRAY);
				} else if (t instanceof Room){
					g.setColor(Color.YELLOW.brighter());
				} else if (t instanceof Wall){
					g.setColor(Color.BLACK);
				} else if (t instanceof Corridor){
					g.setColor(Color.WHITE);
				} else if (t instanceof Doorway){
					g.setColor(Color.ORANGE);
				}
				
				
//				g.setColor(Color.green.darker());
				g.fillRect((int)(x*tilesize)+leftoffset, (int)(y*tilesize)+topoffset, (int)(tilesize), (int)(tilesize));
				g.setColor(Color.LIGHT_GRAY);
				g.drawRect((int)(x*tilesize)+leftoffset, (int)(y*tilesize)+topoffset, (int)(tilesize), (int)(tilesize));
			}
		}
		
	}
	
	/**
	 * Is the tile at (x,y) a room
	 * 
	 */
	public boolean isRoom(int x, int y){
		return board[x][y].tile.isRoom();
	}
	
	
	/**
	 * Can the person p move to the tile at (x,y)
	 */
	public boolean canMoveTo(Person p, int x, int y){
		// TODO: pathfinding... Away!
		int moves = p.moves();
		int px = p.getX();
		int py = p.getY();
		
		return board[px][py].pathTo(x, y, moves);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return The tile at (x,y), or <b><i>null</i></b> if no tile
	 */
	public Tile tileAt(int x, int y){
		return board[x][y].tile;
	}
	
	public int[] getNextStartPosition(){
		boardTile s = startPositions[curStartPos++];
		return new int[]{s.x, s.y};
//		return startPositions[curStartPos++].tile;
	}
	
	/**
	 * This should probably be scrapped <br>
	 * But I wanted the tiles on the board to be distinct from the 'room' type tiles
	 * @author Bandit
	 *
	 */
	private class boardTile {
		/**
		 * All of the adjacent navNodes
		 */
		protected List<boardTile> connected;
		/**
		 * The x and y position of the navNode on the board
		 */
		protected final int x, y;
		protected final Tile tile;
		
		public boardTile(Tile t, int x, int y){
			this.tile=t;
			this.connected = new ArrayList<boardTile>();
			this.x = x; this.y = y;
		}

		protected void build(boardTile[][] others){
			if (board[x][y] == null){
				throw new NullPointerException("part of the board hasn't been initialised");
			}
			// nothing to see here, really, you can't go here
			if(!tile.moveable()) return;
			// now things get interesting
			if (tile instanceof Tiles.Doorway){ // we then need to handle things differently
				Doorway door = (Doorway) tile;
				List<Doorway> linkeddoors = door.room().doorways();
				for (Doorway d: linkeddoors){
					if (d!=door) connected.add(others[d.x][d.y]);
				}
//				System.out.println("doorway");
			}
			if (x>0){
				if (board[x-1][y].tile.moveable()){
					boardTile other = others[x-1][y];
					connected.add(other);
				}
			}
			if (x<width-1){
				if (board[x+1][y].tile.moveable()){
					boardTile other = others[x+1][y];
					connected.add(other);
				}
			}
			if (y>0){
				if (board[x][y-1].tile.moveable()){
					boardTile other = others[x][y-1];
					connected.add(other);
				}
			}
			if (y<height-1){
				if (board[x][y+1].tile.moveable()){
					boardTile other = others[x][y+1];
					connected.add(other);
				}
			}
		}
		
		public boolean pathTo(int x, int y, int moves){
			if (x==this.x && y==this.y){
				return true;
			}
			if (moves==0) {
				return false;
			}
			for (boardTile n: connected){
				if (n.pathTo(x, y, moves-1))
					return true;
			}
			return false;
		}
		
		
	}
}
