package arrays;

import java.util.*;

public class _83_MovingAverage_DataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
}

class MovingAverage {
	private double currSum;
	private int size;

	private Queue<Double> helperQueue = new LinkedList<>();
	public MovingAverage(int size) {
		this.size = size;
		this.currSum = 0; 
	}

	public double next(int val) {
		this.helperQueue.add((double)val);
		this.currSum = this.currSum + val;

		if(helperQueue.size() > this.size) {
			double itemRemoved = helperQueue.poll();
			this.currSum = this.currSum - itemRemoved;
		}
		return this.currSum/this.helperQueue.size();
	}
}