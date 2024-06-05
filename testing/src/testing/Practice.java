package testing;
/*
 * Click `Run` to execute the snippet below!


Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","0","1","1","0"],
  ["0","0","0","1","0"],
  ["1","1","1","1","0"],
  ["0","0","0","0","0"]
]
Output: 2

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
public class Practice {

	public static void main(String[] args) {

		int M[][] = new int[][] { 
			{ 1, 1, 0, 0, 0 }, 
			{ 0, 1, 0, 0, 1 }, 
			{ 1, 0, 0, 1, 1 }, 
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1 } };
		int rowLength = M.length;
		int columnLength = M[0].length;
		int countIseland = 0;

		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < columnLength; j++) {
				if (M[i][j] == 1) {
					countIseland++;
					adjecent(M, i, j);

				}
			}
		}
		System.out.println(countIseland);

	}

	private static void adjecent(int[][] M, int i, int j) {
		if (i < 0 || i >= M.length || j < 0 || j >= M[0].length || M[i][j] != 1) {
			return;
		}
		M[i][j] = 0;
		adjecent(M, i + 1, j + 1);
		adjecent(M, i + 1, j - 1);
		adjecent(M, i - 1, j + 1);
		adjecent(M, i - 1, j - 1);
		adjecent(M, i, j + 1);
		adjecent(M, i, j - 1);
		adjecent(M, i + 1, j);
		adjecent(M, i - 1, j);
		;

	}
}