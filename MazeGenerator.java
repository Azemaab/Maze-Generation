import java.util.*;

public class MazeGenerator {
    private final int width, height;
    public final int[][][] maze; 
    private final boolean[][] visited;

    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        this.maze = new int[height][width][4];
        this.visited = new boolean[height][width];
        generateMaze(0, 0);
    }

    private void generateMaze(int x, int y) {
        visited[y][x] = true;
        Integer[] directions = {0, 1, 2, 3}; 
        Collections.shuffle(Arrays.asList(directions));

        for (int direction : directions) {
            int nx = x, ny = y;

            switch (direction) {
                case 0: nx = x - 1; break;
                case 1: ny = y - 1; break;
                case 2: nx = x + 1; break;
                case 3: ny = y + 1; break;
            }

            if (nx >= 0 && ny >= 0 && nx < width && ny < height && !visited[ny][nx]) {
                maze[y][x][direction] = 1;
                maze[ny][nx][(direction + 2) % 4] = 1;
                generateMaze(nx, ny);
            }
        }
    }
}
