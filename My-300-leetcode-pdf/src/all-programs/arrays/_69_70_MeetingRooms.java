package arrays;

import java.util.*;

public class _69_70_MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minMeetingRooms(int[][] intervals) {

		// Create startTimings[] EndTimings[]
		int[] startTimings = new int[intervals.length];
		int[] endTimings = new int[intervals.length];


		for(int i = 0; i < intervals.length; i++) {
			startTimings[i] = intervals[i][0];
			endTimings[i] = intervals[i][1];
		}

		// Sort both arrays           
		Arrays.sort(startTimings);
		Arrays.sort(endTimings);

		// 
		int startPtr = 1;
		int endPtr = 0;
		int resRoomsNeeded = 1;
		while(startPtr < startTimings.length) {
			if(endTimings[endPtr] <= startTimings[startPtr] ) {
				endPtr++;
			}
			else {
				resRoomsNeeded++;
			}
			startPtr ++;
		}

		return resRoomsNeeded;
	}
}
