package com.company;


public class Map {
    private final int rows;
    private final int cols;
    public char[][] map;

    public Map(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.map = new char[rows][cols];

    }

    public void addObstacles(int[][] obstacles){
        for (int[] obstacle : obstacles) {
            this.map[obstacle[0]][obstacle[1]] = 'X';
        }
    }

    public void addVisited(int[] visited){
        if (!(this.map[visited[0]][visited[1]] == 'S') && !(this.map[visited[0]][visited[1]] == 'D')) {
            this.map[visited[0]][visited[1]] = ' ';
        }
    }

    public void addPath(int[] path){
        if (!(this.map[path[0]][path[1]] == 'S') && !(this.map[path[0]][path[1]] == 'D')){
            this.map[path[0]][path[1]] = '*';
        }
    }

    public boolean inMap(int[] position){
        return (position[0] >= 0 && position[0] <= this.rows-1) && (position[1] >= 0 && position[1] <= this.cols-1);
    }
    public boolean isValid(int[] position){
        return this.map[position[0]][position[1]] == '\0' || this.map[position[0]][position[1]] == 'S' || this.map[position[0]][position[1]] == 'D' ;
    }
    public void addStartAndGoal(int[] start, int[] goal){
        if (this.inMap(start) && this.isValid(start)){
            this.map[start[0]][start[1]] = 'S';
        }
        else {
            throw new Error("Not a valid starting position!");
        }
        if (this.inMap(goal) && this.isValid(goal)){
            this.map[goal[0]][goal[1]] = 'D';
        }
        else {
            throw new Error("Not a valid goal position!");
        }
    }


    public void printToTerminal(){
        for (char[] mapRow : this.map) {
            System.out.println(mapRow);
        }
    }


}
