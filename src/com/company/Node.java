package com.company;

public class Node {
    private Node next;
    private Node previous;
    public int[] position;
    public double cost;
    public double costToHome;

    public Node(int[] position){
        this.next = null;
        this.previous = null;
        this.position = position;
        this.cost = 0;
        this.costToHome = 0;
    }

    // setter function:
    public void setNextNode(Node nextNode){
        this.next = nextNode;
    }
    public void setPreviousNode(Node PreviousNode){
        this.previous = PreviousNode;
    }

    // getter function:
    public Node getNextNode(){
        return this.next;
    }
    public Node getPreviousNode(){
        return this.previous;
    }
}
