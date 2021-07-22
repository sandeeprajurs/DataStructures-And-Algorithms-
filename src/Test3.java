import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test3 {

	static class TrainInfo {
		int arrival;
		int departure;

		public TrainInfo(int arrival, int departure) {
			this.arrival = arrival;
			this.departure = departure;
		}
	}

	static int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int prevDepartureIndex = 0;
		int noOfPlatforms = 1;
		int max = 1;
		int i = 1;
		while (i < arr.length) {
			int arrival = arr[i];
			int departure = dep[i];
			while (arrival > dep[prevDepartureIndex]) {
				prevDepartureIndex++;
				noOfPlatforms--;
			}
			if (arrival <= dep[prevDepartureIndex]) {
				noOfPlatforms++;
			}
			max = Math.max(max, noOfPlatforms);
			i++;
		}
		return max;
	}

	static class StockInfo {
		int day;
		int price;

		public StockInfo(int day, int price) {
			this.day = day;
			this.price = price;
		}
	}

	public static int maxStock(int[] prices, int amount) {
		List<StockInfo> list = new ArrayList<StockInfo>();
		for (int i = 0; i < prices.length; i++)
			list.add(new StockInfo(i + 1, prices[i]));
		Collections.sort(list, (o1, o2) -> o1.price - o2.price);
		int sharesCount = 0;

		for (int i = 0; i < list.size(); i++) {
			int day = list.get(i).day;
			int price = list.get(i).price;
			while (day > 0 && day * price > amount) {
				day--;
			}
			if (day * price <= amount) {
				sharesCount += day;
				amount -= day * price;
			}
		}
		return sharesCount;
	}

	static void survival(int S, int N, int M) {
		if (M > N) {
			System.out.println("No");
			return;
		}

		int remainingDays = S;
		int buyingCount = 0;
		while (remainingDays > 0) {
			int foodForNoOfDays = N / M;
			remainingDays -= foodForNoOfDays;
			buyingCount++;
		}

		System.out.println(buyingCount);
	}

	public static long findMinDiff(ArrayList<Long> a, long n, long m) {
		Collections.sort(a);
		int end = (int) m - 1;
		int start = 0;
		long diff = Integer.MAX_VALUE;
		while (end < a.size()) {
			long min = a.get(start);
			long max = a.get(end);
			diff = Math.min(diff, max - min);
			start++;
			end++;
		}
		return diff;
	}

	public static void main(String[] args) {
		int stack1[] = { 3, 2, 1, 1, 1 };
		int stack2[] = { 4, 3, 2 };
		int stack3[] = { 1, 1, 4, 1 };
		System.out.println(maxSum(stack1, stack2, stack3));
	}

	public static int maxSum(int stack1[], int stack2[], int stack3[]) {
		int stack1Sum = getSum(stack1);
		int stack2Sum = getSum(stack2);
		int stack3Sum = getSum(stack3);
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < stack1.length && j < stack2.length && k < stack2.length) {
			if(stack1Sum == stack2Sum && stack2Sum == stack3Sum) {
				return stack1Sum;
			}
			if (stack1Sum > stack2Sum && stack1Sum > stack3Sum) {
				stack1Sum -= stack1[i++];
			} else if (stack2Sum > stack1Sum && stack2Sum > stack3Sum) {
				stack2Sum -= stack2[j++];
			} else if (stack3Sum > stack1Sum && stack3Sum > stack2Sum) {
				stack3Sum -= stack3[k++];
			}
		}
		return 0;
	}
	
	public static int getSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		return sum;
	}
}
