import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test2 {

	static class TrainInfo {
		int arrival;
		int departure;
		int platformNo;

		public TrainInfo(int arrival, int departure, int platformNo) {
			this.arrival = arrival;
			this.departure = departure;
			this.platformNo = platformNo;
		}
		
		public int getPlatformNo() {
			return platformNo;
		}
		
		public int getArrival() {
			return arrival;
		}
		
		public int getDeparture() {
			return departure;
		}
	}
	

	public static int maxStop(int[][] arr) {
		List<TrainInfo> list = new ArrayList<Test2.TrainInfo>();
		for(int i=0; i<arr.length; i++)
			list.add(new TrainInfo(arr[i][0], arr[i][1], arr[i][2]));
		Comparator<Test2.TrainInfo> compearor = Comparator.comparing(TrainInfo::getDeparture).thenComparing(TrainInfo::getPlatformNo);
		List<Test2.TrainInfo> newList = list.stream().sorted(compearor).collect(Collectors.toList());
		int count=0;
		int prevDeparture= -1;
		int prevPlatform = newList.get(0).platformNo;
		for(int i=0; i<newList.size(); i++) {
			int arrival = newList.get(i).arrival;
			int departure = newList.get(i).departure;
			int platformNo = newList.get(i).platformNo;
			if(prevPlatform == platformNo && arrival > prevDeparture) {
				prevDeparture = departure;
				count++;
			}
			else if(prevPlatform != platformNo) {
				prevPlatform = platformNo;
				prevDeparture = departure;
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[9][3];
		arr[0] = new int[]{1000, 1030, 1};
		arr[1] = new int[]{1010, 1030, 1};
		arr[2] = new int[]{1000, 1020, 2};
		arr[3] = new int[]{1030, 1230, 2};
		arr[4] = new int[]{1200, 1230, 3};
		arr[5] = new int[]{900, 1005, 1};
		arr[6] = new int[]{905, 929, 1};
		arr[7] = new int[]{930, 945, 1};
		arr[8] = new int[]{946, 1000, 1};
		System.out.println(maxStop(arr));
	}

	static class Job {
		int id;
		int profit;
		int deadline;

		public Job(int id, int profit, int deadline) {
			this.id = id;
			this.profit = profit;
			this.deadline = deadline;
		}

	}

	int[] JobScheduling(Job arr[], int n) {
		List<Job> list = new ArrayList<Job>();
		for (int i = 0; i < arr.length; i++)
			list.add(arr[i]);

		Collections.sort(list, (o1, o2) -> o2.profit - o1.profit);

		Job maxJobDuration = Collections.max(list, Comparator.comparing(o -> o.deadline));
		int[] days = new int[maxJobDuration.deadline];
		Arrays.fill(days, -1);
		int maxProfit = 0;
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			int curr = list.get(i).deadline - 1;
			while (curr >= 0 && days[curr] != -1) {
				curr--;
			}

			if (curr >= 0 && days[curr] == -1) {
				days[curr] = list.get(i).profit;
				maxProfit += days[curr];
				count++;
			}
		}

		return new int[] { count, maxProfit };
	}

	static class Item {
		double value, weight;

		Item(int x, int y) {
			this.value = x;
			this.weight = y;
		}
	}

	static class ItemValue {
		Double cost;
		double weight, value;

		// item value function
		public ItemValue(double weight2, double value2) {
			this.weight = weight2;
			this.value = value2;
			cost = (double) value2 / (double) weight2;
		}
	}

	static double fractionalKnapsack(int capacity, Item arr[], int n) {
		ItemValue[] iVal = new ItemValue[arr.length];

		for (int i = 0; i < arr.length; i++) {
			iVal[i] = new ItemValue(arr[i].weight, arr[i].value);
		}

		// sorting items by value;
		Arrays.sort(iVal, (o1, o2) -> o2.cost.compareTo(o1.cost));

		double totalValue = 0d;
		int i = 0;
		while (i < arr.length && iVal[i].weight <= capacity) {
			capacity -= iVal[i].weight;
			totalValue += iVal[i].value;
			i++;
		}

		while (capacity > 0 && i < n) {
			double fraction = capacity / (double) iVal[i].weight;
			double fractionValue = (double) iVal[i].value * fraction;
			totalValue += fractionValue;
			capacity -= capacity;
			i++;
		}
		return totalValue;
	}


	static String chooseandswap(String A) {
		Set<Character> set = new TreeSet<Character>();
		for (int i = 0; i < A.length(); i++) {
			set.add(A.charAt(i));
		}

		List<Character> list = new ArrayList<Character>();
		for (Character c : set) {
			list.add(c);
		}
		int i = 0;
		int count = 0;
		while (i < A.length()) {
			if (count > 0)
				break;
			char c = A.charAt(i);

			if (list.contains(c)) {
				list.remove(list.indexOf(c));
			}

			if (list.size() > 0 && list.get(0) < c) {
				char smallestChar = list.get(0);
				list.remove(list.indexOf(smallestChar));
				A = replace(A, c, smallestChar);
				count++;
			}
			i++;
		}
		return A;
	}

	public static String replace(String A, char c1, char c2) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if (c == c1)
				c = c2;
			else if (c == c2)
				c = c1;
			str.append(c);
		}
		return str.toString();
	}

}
