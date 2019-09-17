package com.bytetree.lintcode.array;

/**
 * 957. Radar Detection
 * <p>
 * There is a bunch of radars on a 2D plane(Radar has x, y coordinates, and a radius r which is the range can be detected). Now, there is a car that passes through the range of y = 0 and y = 1 and cannot be detected by the radar. If the car is detected, return YES, otherwise NO.(You can consider that the car is a line segment of length 1 and goes straight from x = 0 to the right)
 * <p>
 * The number of radars is n，n <= 1000。
 * The radar's coordinate x is a non-negative integer, y is an integer, and r is a positive integer.
 * <p>
 * Example
 * Example 1:
 * <p>
 * input:coordinates = [[0,2]], radius = [1]
 * outut:"NO"
 * Explanation:There is a radar at (0,2) that can detect a circle with a radius of 1 centered on (0,2) and the car will not be detected.
 * Example 2:
 * <p>
 * input: str = coordinates = [[0,2],[1,2]], radius = [1,2],
 * outut:"YES"
 * Explanation:There is a radar at (0,2) that can detect a circular area with a radius of 2 with a center of (0,2). Radars at (1,2) can detect (1,2) as Center, circular area with 2 radius. The No. 2 radar can detect the passing of the car.
 * <p>
 * <a href="https://www.lintcode.com/problem/radar-detection/description">957. Radar Detection</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class RadarDetection {

    /**
     * @param coordinates: The radars' coordinate
     * @param radius:      Detection radius of radars
     * @return: The car was detected or not
     */
    public String radarDetection(Point[] coordinates, int[] radius) {
        // Write your code here
        int flag = 0;
        for (int i = 0; i < coordinates.length; i++) {
            int left = coordinates[i].y - radius[i];
            int right = coordinates[i].y + radius[i];
            if (left < 0 && right > 0 || left < 1 && right > 1) {
                flag = 1;
                break;
            }
        }
        return flag == 0 ? "NO" : "YES";
    }

    // Definition for a point.
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
