package bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


public class Knight {
	
	class Cell{
		int x, y, dist;
		
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Cell(int x, int y, int dist) {
			this.x=x;
			this.y=y;
			this.dist = dist;
		}

		public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			else if(o==null || getClass() != o.getClass()) {
				return false;
			}
			
			Cell cell = (Cell) o;
			return x == cell.x && y == cell.y && dist == cell.dist;
		}
		
		public int hashCode() {
			return Objects.hash(x,y,dist);
		}
	}
	
	static int row[] = {2, -1, 1, 2, -2, -1, 1, -2};
	static int col[] = {1, -2, -2, -1, 1, 2, 2, -1 };
	
	public static boolean isValid(int x,int y, int n) {
		return(x>=0 && x<n) && (y >= 0 && y<n);
	}
	
	public static int findPath(Cell src, Cell dest, int n) {
		Set<Cell> visited = new HashSet();
		Queue<Cell> node = new ArrayDeque<>();
		node.add(src);		
		while(!node.isEmpty()) {
			Cell cell = node.poll();
			int x = cell.x;
			int y = cell.y;
			int dist = cell.dist;
			
			if(x==dest.x && y==dest.y) {
				return dist;
			}
			
			if(!visited.contains(cell)) {
				visited.add(cell);
				for(int i=0; i<row.length; i++) {
					int x1 = x+row[i];
					int y1 = y+col[i];
					
					if(isValid(x1,y1,n)) {
						node.add(new Knight().new Cell(x1,y1,dist+1));
					}
				}
				
			}
			
		}
		
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] a) {
		int N = 8;
		Cell src = new Knight().new Cell(0,7);
		Cell dest = new Knight().new Cell(7,0);
		
		System.out.println("the minimum step of required is "+ findPath(src,dest,N));
	}
}
