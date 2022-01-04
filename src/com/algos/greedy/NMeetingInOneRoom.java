package com.algos.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NMeetingInOneRoom {
	
	public static void main(String[] args) {
		int start[] = new int[]{0,1,3,5,8,5};
		int end[] =  new int[]{6,2,4,7,9,9};
		solve(start, end);
	}
	
	static void solve(int[] start, int[] end){
		List<MeetingObj> list = new ArrayList<>();
		for(int i=0; i<start.length; i++)
			list.add(new MeetingObj(start[i], end[i]));
		
		Collections.sort(list,  (a, b)-> Integer.compare(a.end, b.end));
		
		int prevend = -1;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).start > prevend) {
				System.out.println(list.get(i).start+"------------------"+list.get(i).end);
				prevend = list.get(i).end;
			}
		}
	}
}

class MeetingObj{
	int start;
	int end;
	
	public MeetingObj(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
