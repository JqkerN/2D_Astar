package com.company;

import java.util.Arrays;


public class Astar {
    // Instance field
    private final int[][] pathMovers = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public Map map;
    private Node start;
    private Node goal;
    private Heap heap;

    // Constructor
    public Astar(Map map, int[] startCoordinates, int[] goalCoordinates){
        this.map = map;
        this.map.addStartAndGoal(startCoordinates, goalCoordinates);
        this.start = new Node(startCoordinates);
        this.goal = new Node(goalCoordinates);
        this.heap = new Heap();
    }

    public boolean findPath(){
        // Fills the map with the path from A*
        heap.add(start);

        while (heap.size != 0){
            // pops the Node with the smallest cost
            Node current = heap.popMin();
            // checks if we have reached the goal
            if (Arrays.equals(current.position, goal.position)){
                // generates the path
                this.generatePath(current);
                return true;
            }
            else {
                // Generates the next Nodes
                for (int[] pathMover : pathMovers) {
                    int[] nextPosition = {current.position[0]+pathMover[0], current.position[1]+pathMover[1]};
                    Node nextNode = new Node(nextPosition);
                    // if valid Node it is added to the heap
                    if (map.inMap(nextPosition) && map.isValid(nextPosition)){
                        // Calculates the cost with the heuristic
                        nextNode.costToHome = current.costToHome + 1.0;
                        nextNode.cost = this.heuristic(nextNode, start);
                        // update heap and map with the next valid Node
                        nextNode.setPreviousNode(current);
                        heap.add(nextNode);
                        map.addVisited(nextPosition);
                    }
                }
            }
        }
        return false;
    }

    private void generatePath(Node lastNode){
        // Backtraces the Nodes from goal -> start to recreate the path
        Node current = lastNode;
        while (current != null){
            map.addPath(current.position);
            current = current.getPreviousNode();
        }
    }
    private double heuristic(Node nextNode, Node start){
        // Calculates the heuristic for cost-to-goal + cost-to-home /w Manhattan Distance
        double dx = nextNode.position[0] - start.position[0];
        double dy = nextNode.position[1] - start.position[1];
        return Math.abs(dx) + Math.abs(dy) + nextNode.costToHome;
    }


}
