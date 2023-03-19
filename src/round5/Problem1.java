package round5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {
    public static void main(String[] args) {
//        mineSweeper(10, 10, 82);
        File inputSmall = new File("D:\\raofinal\\src\\round5\\Custom.txt");
        File inputLarge = new File("D:\\raofinal\\src\\round5\\large.txt");

        File outputSmall = new File("D:\\raofinal\\src\\round5\\outputSmall.txt");
        File outputLarge = new File("D:\\raofinal\\src\\round5\\outputLarge.txt");

        mainFun(inputSmall, outputSmall);
        mainFun(inputLarge, outputLarge);
//        for (String s: answers) System.out.println(s);
//        answers = new ArrayList<>();
//        mainFun(inputLarge, outputLarge);
    }

    static List<int[][]> generatedMazes = new ArrayList<>();

    static void mainFun(File input, File output) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line = br.readLine();
            int noOfTestcase = Integer.parseInt(line);

            for (int i = 0; i < noOfTestcase; i++) {
                line = br.readLine();
                String[] inputs = line.split(" ");
                mineSweeper(Integer.parseInt(inputs[0]),
                        Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
                for (String s: answers) System.out.println(s);

                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(output));
                    PrintWriter pw = new PrintWriter(bw);
                    pw.printf("Case #%d: \n%s", (i+1), answers.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void mineSweeper(int r, int c, int m) {
        boolean[][] visited = new boolean[r][c];
        generateMaze(new int[r][c], 0, 0, m, visited);
        boolean possible = false;
        for (int[][] maze: generatedMazes) {
            if (printPossible(maze)) {
                possible = true;
                generatedMazes = new ArrayList<>();
                break;
            }
        }
        if (!possible) answers.add("Impossible");
//        if (!possible) System.out.println("Impossible");
    }

    static List<String> answers = new ArrayList<>();

    static boolean printPossible(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                int[][] newMaze = new int[maze.length][maze[0].length];
                for (int row = 0; row < newMaze.length; row++) {
                    for (int col = 0; col < newMaze[0].length; col++) {
                        newMaze[row][col] = maze[row][col];
                    }
                }
                ifPossible(newMaze, new int[]{i, j});
                boolean possible = true;
                for (int[] row: newMaze) {
                    for (int e: row) {
                        if (e == 0) {
                            possible = false;
                            break;
                        }
                    }
                }
                if (possible) {
//                    System.out.println("Possible");
                    StringBuilder answer = new StringBuilder();
                    char[][] ans = getPossibleMaze(newMaze, new int[]{i, j});
//                    for (char[] row: ans) {
//                        for (char ch: row) {
//                            System.out.print(ch + " ");
//                        }
//                        System.out.println();
//                    }
                    for (char[] row: ans) {
                        for (char c: row) {
                            answer.append(c).append(" ");
                        }
                        answer.append("\n");
                    }
                    answers.add(answer.toString());
                    return true;
                }
            }
        }
//        System.out.println("Impossible");
        return false;
    }

    static char[][] getPossibleMaze(int[][] maze, int[] click) {
        char[][] ans = new char[maze.length][maze[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                if (maze[i][j] == -1) {
                    ans[i][j] = '*';
                }else ans[i][j] = '.';
            }
        }
        int x = click[0], y = click[1];
        ans[x][y] = 'c';
        return ans;
    }

    static void generateMaze(int[][] maze, int r, int c, int m, boolean[][] visited) {
        if (m == 0) {
            int[][] newMaze = new int[maze.length][maze[0].length];
            for (int i = 0; i < newMaze.length; i++) {
                System.arraycopy(maze[i], 0, newMaze[i], 0, newMaze[0].length);
            }
            generatedMazes.add(numberMazes(newMaze));
//            for (int[] row: maze) Arrays.fill(row, 0);
            return;
        }
//        if (r > maze.length-1 || c == maze[0].length-1) return;
        if (r < 0 || c < 0) return;
        if (r >= maze.length || c >= maze[0].length) return;

        if (visited[r][c]) return;

        visited[r][c] = true;
        // Case 1: Fix the mine
        maze[r][c] = -1;
        generateMaze(maze, r-1, c-1, m-1, visited);
        generateMaze(maze, r-1, c, m-1, visited);
        generateMaze(maze, r-1, c+1, m-1, visited);
        generateMaze(maze, r, c-1, m-1, visited);
        generateMaze(maze, r, c+1, m-1, visited);
        generateMaze(maze, r+1, c-1, m-1, visited);
        generateMaze(maze, r+1, c, m-1, visited);
        generateMaze(maze, r+1, c+1, m-1, visited);

        maze[r][c] = 0;

        generateMaze(maze, r-1, c-1, m, visited);
        generateMaze(maze, r-1, c, m, visited);
        generateMaze(maze, r-1, c+1, m, visited);
        generateMaze(maze, r, c-1, m, visited);
        generateMaze(maze, r, c+1, m, visited);
        generateMaze(maze, r+1, c-1, m, visited);
        generateMaze(maze, r+1, c, m, visited);
        generateMaze(maze, r+1, c+1, m, visited);

        maze[r][c] = 0;
    }

    static int[][] numberMazes(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == -1) {
                }
                else {
                    int count = 0;
                    if (i > 0 && maze[i-1][j] == -1) count++;
                    if (i > 0 && j > 0 && maze[i-1][j-1] == -1) count++;
                    if (i > 0 && j < maze[0].length-1 && maze[i-1][j+1] == -1) count++;
                    if (j > 0 && maze[i][j-1] == -1) count++;
                    if (j < maze[0].length-1 && maze[i][j+1] == -1) count++;
                    if (i < maze.length-1 && j > 0 && maze[i+1][j-1] == -1) count++;
                    if (i < maze.length-1 && maze[i+1][j] == -1) count++;
                    if (i < maze.length-1 && j < maze[0].length-1 && maze[i+1][j+1] == -1) count++;
                    maze[i][j] = count;
                }
            }
        }
        return maze;
    }

    static void ifPossible(int[][] maze, int[] clickPos) {
        int i = clickPos[0], j = clickPos[1];
//        if (i < 0 || j < 0 || i > maze.length-1 || j > maze[0].length-1) return false;
        if (maze[i][j] != 0) {
            maze[i][j] = 0;
            return;
        }
//        else {
//            for (int[] row: maze) {
//                for (int e: row) {
//                    if (e != 0) {
//                        if (e != 1) return false;
//                    }
//                }
//            }
//            return true;
//        }
        maze[i][j] = 1;

        if (i > 0 && maze[i-1][j] == 0) {
//            maze[i-1][j] = 1;
            ifPossible(maze, new int[]{i-1, j});
        }
        if (i > 0 && j > 0 && maze[i-1][j-1] == 0) {
//            maze[i-1][j-1] = 1;
            ifPossible(maze, new int[]{i-1, j-1});
        }
        if (i > 0 && j < maze[0].length-1 && maze[i-1][j+1] == 0) {
//            maze[i-1][j+1] = 1;
            ifPossible(maze, new int[]{i-1, j+1});
        }
        if (j > 0 && maze[i][j-1] == 0) {
//            maze[i][j-1] = 1;
            ifPossible(maze, new int[]{i, j-1});
        }
        if (j < maze[0].length-1 && maze[i][j+1] == 0) {
//            maze[i][j] = 1;
            ifPossible(maze, new int[]{i, j+1});
        }
        if (i < maze.length-1 && j > 0 && maze[i+1][j-1] == 0) {
//            maze[i+1][j-1] = 1;
            ifPossible(maze, new int[]{i+1, j-1});
        }
        if (i < maze.length-1 && maze[i+1][j] == 0) {
//            maze[i+1][j] = 1;
            ifPossible(maze, new int[]{i+1, j});
        }
        if (i < maze.length-1 && j < maze[0].length-1 && maze[i+1][j+1] == 0) {
//            maze[i+1][j+1] = 1;
            ifPossible(maze, new int[]{i+1, j+1});
        }
//        return false;
    }
}
