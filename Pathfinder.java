public class Pathfinder {
    public static boolean[][] findPath(int[][][] maze) {
        int height = maze.length;
        int width = maze[0].length;
        boolean[][] visited = new boolean[height][width];
        boolean[][] path = new boolean[height][width];

        dfs(maze, 0, 0, visited, path);
        return path;
    }

    private static boolean dfs(int[][][] maze, int x, int y, boolean[][] visited, boolean[][] path) {
        if (x == maze[0].length - 1 && y == maze.length - 1) {
            path[y][x] = true;
            return true;
        }
        visited[y][x] = true;

        int[][] directions = {{-1, 0, 0}, {0, -1, 1}, {1, 0, 2}, {0, 1, 3}};

        for (int[] dir : directions) {
            int nx = x + dir[0], ny = y + dir[1], wall = dir[2];

            if (nx >= 0 && ny >= 0 && nx < maze[0].length && ny < maze.length &&
                maze[y][x][wall] == 1 && !visited[ny][nx]) {

                if (dfs(maze, nx, ny, visited, path)) {
                    path[y][x] = true;
                    return true;
                }
            }
        }
        return false;
    }
}
// Updated DFS to include base case
    
