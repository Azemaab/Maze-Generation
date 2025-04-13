import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the height of the maze:");
        int height = scanner.nextInt();

        MazeGenerator generator = new MazeGenerator(width,height);
        int[][][] maze = generator.generateMaze();

        boolean[][] path = Pathfinder.findPath(maze);
        MazePrinter.printMaze(maze, path);
    }
}

