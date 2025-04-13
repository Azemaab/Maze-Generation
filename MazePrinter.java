public class MazePrinter {
    public static void printMaze(int[][][] maze, boolean[][] path) {
        int height = maze.length;
        int width = maze[0].length;

        for (int y = 0; y < height; y++) {
            
            for (int x = 0; x < width; x++) {
                System.out.print("+");
                System.out.print(maze[y][x][1] == 1 ? "   " : "---");
            }
            System.out.println("+");

         
            for (int x = 0; x < width; x++) {
                System.out.print(maze[y][x][0] == 1 ? " " : "|");
                System.out.print(path != null && path[y][x] ? " * " : "   ");
            }
            System.out.println("|");
        }

    
        for (int x = 0; x < width; x++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
}
