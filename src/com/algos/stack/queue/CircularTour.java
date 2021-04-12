package com.algos.stack.queue;

//https://practice.geeksforgeeks.org/problems/circular-tour/1#
public class CircularTour {
	
	//O(n) Time | O(1) Space
	public static void main(String[] args) {
		int num = tour(new int[] {87, 40, 71, 79, 2, 3, 93, 57, 81, 42, 90 ,20, 30},  new int[] {27, 95, 96, 35, 68 , 98, 18 , 53, 2, 87, 66, 45, 41});
		System.out.println(num);
	}
	
	static int tour(int petrol[], int distance[])
    {
	    int n = petrol.length;
	    int count = 0;
	    int front = 0;
	    int rear = 0;
	    int idx = 0;
	    int addOn = 0;
	    boolean canTravel = false;
	    while(count < 2*n){
	    	int ptrl = petrol[rear] + addOn;
	        if(ptrl  >= distance[rear] && (front == 0 && rear == n-1 || rear+1 == front)){
	            canTravel = true;
	            break;
	        }
	       
	       if(ptrl  >= distance[rear]){
	           addOn = ptrl - distance[rear];
	           rear = (rear+1)%n;
	       }
	       else{
	           rear = (rear+1)%n;
	           front = rear;
	           idx = front;
	           addOn = 0;
	       }
	       count++;
	    }
	   return canTravel ? idx : -1;
    }

}
