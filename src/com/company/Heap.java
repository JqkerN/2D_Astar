package com.company;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Node> heap;
    public int size;

    public Heap(){
        this.heap = new ArrayList<Node>();
        this.heap.add(null);
        this.size = 0;
    }

    public void add(Node node){
        this.heap.add(node);
        this.size++;
        this.bubbleUp();
    }

    public Node popMin(){
        if (this.size == 0){
            System.out.println("The Heap is empty!");
        }
        // Swaps place on the last and first index
        this.swap(1, this.size);

        // removes the max Node
        Node min = this.heap.remove(this.size);
        this.size--;

        // heapify the heap
        this.heapify();
        return min;
    }

    private void bubbleUp(){
        // Bubble up the current value to the top if less than its parent value
        int current = this.size;
        while (current > 1 && this.heap.get(current).cost < this.heap.get(this.getParent(current)).cost){
            this.swap(current, this.getParent(current));
            current = this.getParent(current);
        }
    }

    private void heapify(){
        // swaps Nodes until heap structure is restored
        int current = 1;
        int leftChild = this.getLeft(current);
        int rightChild = this.getRight(current);
        while (this.canSwap(current, leftChild, rightChild)){
            if (this.exists(leftChild) && this.exists(rightChild)){
                if (this.heap.get(leftChild).cost < this.heap.get(rightChild).cost){
                    this.swap(current, leftChild);
                    current = leftChild;
                }
                else {
                    this.swap(current, rightChild);
                    current = rightChild;
                }
            }
            else {
                this.swap(current, leftChild);
                current = leftChild;
            }
            leftChild = this.getLeft(current);
            rightChild = this.getRight(current);
        }
    }

    private void swap(int a, int b){
        // Swaps two Nodes with index a with index b
        Node temp = this.heap.get(b);
        this.heap.set(b, this.heap.get(a));
        this.heap.set(a, temp);
    }

    private boolean exists(int index){
     return index <= this.size;
    }

    private boolean canSwap(int current, int leftChild, int rightChild){
        return (this.exists(leftChild) && (this.heap.get(current).cost > this.heap.get(leftChild).cost))
                || (this.exists(rightChild) && (this.heap.get(current).cost > this.heap.get(rightChild).cost));
    }

    public int getParent(int current){
        return (int) Math.floor(current / 2);
    }

    public int getLeft(int current){
        return current * 2;
    }

    public int getRight(int current){
        return (current * 2) + 1;
    }
}
