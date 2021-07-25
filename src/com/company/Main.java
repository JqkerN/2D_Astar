package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] obstacles = {{1,0}, {1,1}, {1,2}, {1,3}, {1,4}, {1,5}, {1,6}, {1,7}, {1,8},
                             {5,1}, {5,2}, {5,3}, {5,4}, {5,5}, {5,6}, {5,7}, {5,8}, {5,9}
                            };
        int[] start = {0,0};
        int[] goal = {6,9};

        Map myMap = new Map(10,10);
        myMap.addObstacles(obstacles);

        Astar searchAlgorithm = new Astar(myMap, start, goal);
        boolean pathFound = searchAlgorithm.findPath();
        myMap.printToTerminal();
        System.out.println("Path was found: " + pathFound);

    }
}
