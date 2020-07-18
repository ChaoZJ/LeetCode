/*
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package solution;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author zhangchao
 *
 */
public class Test37th {
	public void solveSudoku(char[][] board) {
		//todo
		Map<Point, boolean[]> map = new HashMap<>();
		fun(board, map);
		while (!map.isEmpty()){
			reFullBoard(board, map);
			System.out.println('{');
			for (int i = 0 ; i < 9; i++){
				System.out.print('{');
				for (int j = 0; j < 9; j++){
					System.out.print('\'');
					System.out.print(board[i][j]);
					System.out.print('\'');
					System.out.print(',');
				}
				System.out.print('}');
				System.out.print(',');
				System.out.println();
			}
			System.out.println("}");
			map.clear();
			fun(board, map);
		}
	}

	private void fun(char[][] board, Map<Point, boolean[]> map){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if (board[i][j] == '.'){
					Point point = new Point(i, j);
					map.put(point, getPossibles(board, i, j));
				}
			}
		}
		Set<Point> keySet = map.keySet();
		Iterator<Point> iterator = keySet.iterator();
		while (iterator.hasNext()){
			count(board, iterator.next(), map);
		}
	}

	private void reFullBoard(char[][] board, Map<Point, boolean[]> map){
		Set<Point> keySet = map.keySet();
		Iterator<Point> iterator = keySet.iterator();
		while (iterator.hasNext()){
			Point point = iterator.next();
			boolean[] bs = map.get(point);
			int i = 0;
			for (boolean b : bs){
				if (b){
					i++;
					if (i > 1){
						break;
					}
				}
			}
			if (i == 1){
				for (i = 0; i < bs.length; i++){
					if (bs[i]){
						int x = point.getX();
						int y = point.getY();
						int code = '1' + i;
						board[x][y] = (char)code;
						break;
					}
				}
			}
		}
	}

	private boolean[] getPossibles(char[][] board, int x, int y){
		int i = x - x%3;
		int j = y - y%3;
		boolean[] pieceNums = new boolean[9];
		for (int n = 0; n < 3; n++){
			for (int m = 0; m < 3; m++){
				if (board[i + n][j + m] == '.'){
					continue;
				}
				pieceNums[board[i + n][j + m] - '1'] = true;
			}
		}
		boolean[] hNums = new boolean[9];
		for(int n = 0; n < 9; n++){
			if (board[x][n] == '.'){
				continue;
			}
			hNums[board[x][n] - '1'] = true;
		}
		boolean[] vNums = new boolean[9];
		for(int n = 0; n < 9; n++){
			if (board[n][y] == '.'){
				continue;
			}
			vNums[board[n][y] - '1'] = true;
		}
		boolean[] result = new boolean[9];
		for (int k = 0; k < 9; k++){
			result[k] = !(pieceNums[k] || hNums[k] || vNums[k]);
		}
		return result;
	}

	/**
	 * 行、列、宫的元素交集
	 * @param board
	 * @param target
	 * @param map
	 */
	private void count(char[][] board, Point target, Map<Point, boolean[]> map){
		Set<Point> row = new HashSet<>();
		Set<Point> col = new HashSet<>();
		Set<Point> block = new HashSet<>();
		int x = target.getX(), y = target.getY();
		for (int i = 0; i < 9; i++){
			if (board[x][i] == '.'){
				row.add(new Point(x, i));
			}
		}
		for (int i = 0; i < 9; i++){
			if (board[i][y] == '.'){
				col.add(new Point(i, y));
			}
		}
		int right = x - x%3, up = y - y%3;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j<3; j++){
				if (board[right + i][up + j] == '.'){
					block.add(new Point(right + i, up + j));
				}
			}
		}
		boolean[] rowb = new boolean[9];
		boolean[] colb = new boolean[9];
		boolean[] blockb = new boolean[9];
		boolean[] booleans = map.get(target);
		Iterator<Point> pointIterator = row.iterator();
		while (pointIterator.hasNext()){
			Point point = pointIterator.next();
			boolean[] temp = map.get(point);
			for (int i = 0; i < 9; i++){
				rowb[i] = booleans[i] || temp[i];
			}
		}
		pointIterator = col.iterator();
		while (pointIterator.hasNext()){
			Point point = pointIterator.next();
			boolean[] temp = map.get(point);
			for (int i = 0; i < 9; i++){
				colb[i] = colb[i] || temp[i];
			}
		}
		pointIterator = block.iterator();
		while (pointIterator.hasNext()){
			Point point = pointIterator.next();
			boolean[] temp = map.get(point);
			for (int i = 0; i < 9; i++){
				blockb[i] = blockb[i] || temp[i];
			}
		}
		for (int i = 0 ; i < 9; i++){
			booleans[i] = rowb[i] && colb[i] && blockb[i];
		}
		map.put(target, booleans);
	}

	static class Point{
		private final int x;
		private final int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Point point = (Point) o;
			return x == point.x &&
					y == point.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	public static void main(String[] args) {
		char[][] b = {
				{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}
		};
		Test37th test37th = new Test37th();
		test37th.solveSudoku(b);
		for (int i = 0 ; i < 9; i++){
			for (int j = 0; j < 9; j++){
				System.out.print(b[i][j]);
				System.out.print(',');
			}
			System.out.println();
		}
	}


}
