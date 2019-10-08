package com.bytetree.lintcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 788. The Maze II
 * <p>
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 * <p>
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 * <p>
 * 1.There is only one ball and one destination in the maze.
 * 2.Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 * 3.The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 * 4.The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 * <p>
 * Example
 * Example 1:
 * Input:
 * (rowStart, colStart) = (0,4)
 * (rowDest, colDest)= (4,4)
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * Output:  12
 * <p>
 * Explanation:
 * (0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(2,0)->(2,1)->(2,2)->(3,2)->(4,2)->(4,3)->(4,4)
 * <p>
 * Example 2:
 * Input:
 * (rowStart, colStart) = (0,4)
 * (rowDest, colDest)= (0,0)
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * Output:  6
 * <p>
 * Explanation:
 * (0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(0,0)
 * <p>
 * <a href="https://www.lintcode.com/problem/the-maze-ii/description">788. The Maze II</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class TheMazeII {

    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int m = maze.length;
        int n = maze[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1], 0));
        int[] dirs = {-1, 0, 1, 0, -1};
        while(!queue.isEmpty()) {

            Point cur = queue.poll();

            if (cur.l >= result[cur.x][cur.y]) {
                continue;
            }

            result[cur.x][cur.y] = cur.l;

            for (int i = 0; i < 4; i++) {
                int x = cur.x;
                int y = cur.y;
                int l = cur.l;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                    x += dirs[i];
                    y += dirs[i + 1];
                    l++;
                }

                x -= dirs[i];
                y -= dirs[i + 1];
                l--;

                queue.offer(new Point(x, y, l));
            }

        }

        return result[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : result[destination[0]][destination[1]];
    }

    class Point {
        int x;
        int y;
        int l;

        Point(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }
}
