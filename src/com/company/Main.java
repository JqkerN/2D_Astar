package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] obstacles = {{0,0}, {1,1}, {2,2}, {3,3}, {4,4}, {5,5}, {6,6}, {7,7}};
        int[] start = {0,1};
        int[] goal = {90,1};

        Map myMap = new Map(100,100);
        myMap.addObstacles(obstacles);

        Astar searchAlgorithm = new Astar(myMap, start, goal);
        boolean pathFound = searchAlgorithm.findPath();
        System.out.println("Path was found: " + pathFound);
        myMap.printToTerminal();

    }
}
