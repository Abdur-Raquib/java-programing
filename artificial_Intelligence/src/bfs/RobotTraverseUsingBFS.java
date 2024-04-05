package bfs;

import java.util.*;

public class RobotTraverseUsingBFS {
	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(Object o) {
			if (o instanceof Position) {
				Position p = (Position) o;
				return p.x == x && p.y == y;
			}
			return false;
		}

		public int hashCode() {
			return Objects.hash(x, y);
		}

		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static ArrayList<Position> findPath(int[][] plane, Position start, Position dest) {
		LinkedList<Position> queue = new LinkedList<>();
		Map<Position, Position> parent = new HashMap<>();

		queue.add(start);
		parent.put(start, null);

		while (!queue.isEmpty()) {
			Position curr = queue.remove();

			if (curr.equals(dest)) {
				return getPath(parent, curr);
			}

			for (int[] direction : dir) {
				int x = curr.x + direction[0];
				int y = curr.y + direction[1];

				if (x >= 0 && x < plane.length && y >= 0 && y < plane[0].length && plane[x][y] == 0
						&& !parent.containsKey(new Position(x, y))) {
					Position next = new Position(x, y);
					queue.add(next);
					parent.put(next, curr);
				}
			}
		}

		return null;
	}

	public static ArrayList<Position> getPath(Map<Position, Position> parent, Position dest) {
		ArrayList<Position> path = new ArrayList<>();
		Position curr = dest;
		while (curr != null) {
			path.add(0, curr);
			curr = parent.get(curr);
		}
		return path;
	}

	public static void main(String[] args) {
		int[][] plane = { { 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 1, 0 }, 
				{ 0, 1, 0, 0, 0 }, 
				{ 0, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 } };
		Position starting = new Position(0, 0);
		Position destination = new Position(4, 4);
		ArrayList<Position> path = findPath(plane, starting, destination);
		if (path != null) {
			System.out.println("Path: " + path);
		} else {
			System.out.println("No path found.");
		}
	}
}
