/*
 * N皇后问题
 */
package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author ZhangChao
 * @since 2020/5/27
 */
public class Test51Th {
    public List<List<String>> solveNQueens(int n) {
        int[][] grid = new int[n][n];
        Stack<Queen> queens = new Stack<>();
        Point zero = new Point(0, 0);
        Queen first = new Queen(zero);
        first.setOccupy(occupy(zero, grid));
        queens.push(first);
        int index = 0;
        List<List<String>> result = new ArrayList<>();
        while (index <= n){
            Point point = null;
            if (queens.size() < n){
                point = isRowOccupied(grid, queens.size());
            }
            if (point != null){
                Queen queen = new Queen(point);
                queen.setOccupy(occupy(point, grid));
                queens.push(queen);
            }else {
                Queen queen = queens.pop();
                backtrack(queen, grid);
                Point next = getNextPosition(queen, grid, queens.size());
                while (next == null && !queens.empty()){
                    queen = queens.pop();
                    backtrack(queen, grid);
                    next = getNextPosition(queen, grid, queens.size());
                }
                if (queen == first){
                    queen.setCurrentPosition(new Point(0, ++index));
                    if (index == n){
                        break;
                    }
                }else {
                    queen.setCurrentPosition(next);
                }
                queen.setOccupy(occupy(queen.getCurrentPosition(), grid));
                queens.push(queen);
            }
            if (queens.size() == n){
                if (index == n){
                    break;
                }
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++){
                    StringBuilder builder = new StringBuilder();
                    Queen queen = queens.get(i);
                    for (int j = 0; j < n; j++){
                        if (j == queen.getCurrentPosition().getY()){
                            builder.append('Q');
                        }else {
                            builder.append('.');
                        }
                        if (j != n - 1){
                            builder.append(',');
                        }
                    }
                    list.add(builder.toString());
                }
                result.add(list);
            }
        }

        return result;
    }

    private List<Point> occupy(Point point, int[][] grid){
        List<Point> occupied = new ArrayList<>();
        occupied.add(point);
        int x = point.getX(), y = point.getY();
        grid[x][y] = 1;
        for (int i = 0; i < grid.length; i++){
            if (i == y){
                continue;
            }
            int g = grid[x][i];
            if (g == 0){
                grid[x][i] = 1;
                occupied.add(new Point(x, i));
            }
        }
        for (int i = 0; i < grid.length; i++){
            if (i == x){
                continue;
            }
            int g = grid[i][y];
            if (g == 0){
                grid[i][y] = 1;
                occupied.add(new Point(i, y));
            }
        }
        int n = grid.length;
        for (int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--){
            int g = grid[i][j];
            if (g == 0){
                grid[i][j] = 1;
                occupied.add(new Point(i, j));
            }
        }
        for (int i = x+1, j = y+1; i < n && j < n; i++, j++){
            int g = grid[i][j];
            if (g == 0){
                grid[i][j] = 1;
                occupied.add(new Point(i, j));
            }
        }
        for (int i = x+1, j = y-1; i < n && j >= 0; i++, j--){
            int g = grid[i][j];
            if (g == 0){
                grid[i][j] = 1;
                occupied.add(new Point(i, j));
            }
        }
        for (int i = x-1, j = y+1; i >= 0 && j < n; i--, j++){
            int g = grid[i][j];
            if (g == 0){
                grid[i][j] = 1;
                occupied.add(new Point(i, j));
            }
        }
        return occupied;
    }

    private void backtrack(Queen queen, int[][] grid){
        List<Point> occupied = queen.getOccupy();
        for (Point point : occupied){
            grid[point.getX()][point.getY()] = 0;
        }
    }

    private Point isRowOccupied(int[][] grid, int row){
        int n = grid.length;
        for (int j = 0; j < n; j++){
            if (grid[row][j] == 0){
                return new Point(row, j);
            }
        }
        return null;
    }

    private Point getNextPosition(Queen queen, int[][] grid, int row){
        int n = grid.length;
        for (int j = 0; j < n; j++){
            if (grid[row][j] == 0){
                Point p = new Point(row, j);
                if (!queen.isPath(p)){
                    return p;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        Test51Th test51Th = new Test51Th();
//        List<List<String>> list = test51Th.solveNQueens(5);
//        list.forEach(sub -> {
//            sub.forEach(System.out::println);
//            System.out.println();
//        });
        System.out.println(12|11);
    }
}

class Queen{
    private Point currentPosition;
    private List<Point> path;
    private List<Point> occupy;

    public Queen(Point currentPosition){
        this.currentPosition = currentPosition;
        path = new ArrayList<>();
        path.add(currentPosition);
        occupy = new ArrayList<>();
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
        path.add(currentPosition);
        occupy.clear();
    }

    public void addPoint(Point point){
        path.add(point);
    }

    public boolean isPath(Point point){
        return path.contains(point);
    }

    public void setOccupy(List<Point> occupy) {
        this.occupy = occupy;
    }

    public List<Point> getOccupy() {
        return occupy;
    }
}

class Point{
    private final int x, y;
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