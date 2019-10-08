package com.bytetree.lintcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 787. The Maze
 * <p>
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 * <p>
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 * <p>
 * 1.There is only one ball and one destination in the maze.
 * 2.Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 * 3.The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 * 5.The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:
 * map =
 * [
 * [0,0,1,0,0],
 * [0,0,0,0,0],
 * [0,0,0,1,0],
 * [1,1,0,1,1],
 * [0,0,0,0,0]
 * ]
 * start = [0,4]
 * end = [3,2]
 * Output:
 * false
 * Example 2:
 * <p>
 * Input:
 * map =
 * [[0,0,1,0,0],
 * [0,0,0,0,0],
 * [0,0,0,1,0],
 * [1,1,0,1,1],
 * [0,0,0,0,0]
 * ]
 * start = [0,4]
 * end = [4,4]
 * Output:
 * true
 * <p>
 * <a href="https://www.lintcode.com/problem/the-maze/description">787. The Maze</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class TheMaze {

    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();

        visited[start[0]][start[1]] = true;

        queue.offer(start[0] * n + start[1]);

        int[] dirs = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int curPosition = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = curPosition / n;
                int y = curPosition % n;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                    x += dirs[i];
                    y += dirs[i + 1];
                }

                x -= dirs[i];
                y -= dirs[i + 1];

                if (x == destination[0] && y == destination[1]) {
                    return true;
                }

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(x * n + y);
                }

            }

        }

        return false;
    }
}
