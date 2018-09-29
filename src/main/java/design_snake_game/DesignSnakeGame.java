package design_snake_game;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DesignSnakeGame {
//    Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
//
//    The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
//
//    You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
//
//    Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
//
//    When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
//
//    Example:
//
//    Given width = 3, height = 2, and food = [[1,2],[0,1]].
//
//    Snake snake = new Snake(width, height, food);
//
//    Initially the snake appears at position (0,0) and the food at (1,2).
//
//            |S| | |
//            | | |F|
//
//            snake.move("R"); -> Returns 0
//
//            | |S| |
//            | | |F|
//
//            snake.move("D"); -> Returns 0
//
//            | | | |
//            | |S|F|
//
//            snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
//
//            | |F| |
//            | |S|S|
//
//            snake.move("U"); -> Returns 1
//
//            | |F|S|
//            | | |S|
//
//            snake.move("L"); -> Returns 2 (Snake eats the second food)
//
//            | |S|S|
//            | | |S|
//
//            snake.move("U"); -> Returns -1 (Game over because snake collides with border)

    // Insert your Solution class here
    class SnakeGame {

        int width, height;
        int point;
        boolean[][] set;
        int[] pos;
        List<int[]> snake;
        int foodIndex;
        int[][] food;
        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            set = new boolean[height][width];
            point = 0;
            pos = new int[2];
            set[0][0] = true;
            snake = new LinkedList<int[]>();
            snake.add(pos);
            foodIndex = 0;
            this.food = food;
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int[] cur = snake.get(snake.size()-1).clone();
            if (direction.equals("U")) {
                cur[0]--;
            }
            else if (direction.equals("D")) {
                cur[0]++;
            }
            else if (direction.equals("L")) {
                cur[1]--;
            }
            else if (direction.equals("R")) {
                cur[1]++;
            }
            // System.out.println(direction);
            // System.out.println(cur[0]);
            // System.out.println(cur[1]);
            if (cur[0] < 0 || cur[0] >= height || cur[1] < 0 || cur[1] >= width) return -1;

            if (foodIndex < food.length && food[foodIndex][0] == cur[0] && food[foodIndex][1] == cur[1]) {
                point++;
                foodIndex++;
            }
            else {
                int[] tail = snake.remove(0);
                set[tail[0]][tail[1]] = false;
            }

            if (set[cur[0]][cur[1]]) return -1;
            snake.add(cur);
            set[cur[0]][cur[1]] = true;

            return point;
        }
    }

    /**
     * Your SnakeGame object will be instantiated and called as such:
     * SnakeGame obj = new SnakeGame(width, height, food);
     * int param_1 = obj.move(direction);
     */
    public static class UnitTest {
        @Test
        public void testDesignSnakeGame() {
            //Solution s = new DesignSnakeGame().new Solution();
        }
    }
}

