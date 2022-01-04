package com.algos.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Job {
	int id;
	int delay;
	int profit;
	
	public Job(int id, int delay, int profit) {
		super();
		this.id = id;
		this.delay = delay;
		this.profit = profit;
	}
}

public class JobSequencing {

	public static void main(String[] args) {
		Job job1 = new Job(1, 2, 100);
		Job job2 = new Job(2, 1, 19);
		Job job3 = new Job(3, 2, 27);
		Job job4 = new Job(4, 1, 25);
		Job job5 = new Job(5, 3, 15);
		
		List<Job> list = new ArrayList<Job>();
		list.add(job1);
		list.add(job2);
		list.add(job3);
		list.add(job4);
		list.add(job5);
		solve(list);
		
	}

	static void solve(List<Job> jobs){
		Collections.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));
		for(Job job:jobs) {
			System.out.println(job.id+" ------- "+job.delay+" ------- "+job.profit);
		}
		int totalProfit = 0;
		int[] arr = new int[jobs.size()];
		Arrays.fill(arr, -1);
		for(int i=0; i<jobs.size(); i++) {
			int currDelay = jobs.get(i).delay - 1;
			int currJob = jobs.get(i).id;
			int currProfit = jobs.get(i).profit;
			if(arr[currDelay] == -1) {
				arr[currDelay] = currJob;
				totalProfit += currProfit;
				System.out.println(currJob);
			}
			else {
				for(int j=currDelay-1; j>=0; j--) {
					if(arr[j] == -1) {
						arr[j] = currJob;
						totalProfit += currProfit;
						System.out.println(currJob);
						break;
					}
				}
			}
		}
		System.out.println(totalProfit);
	}
}
