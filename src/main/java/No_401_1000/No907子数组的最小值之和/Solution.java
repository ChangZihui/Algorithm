package No_401_1000.No907子数组的最小值之和;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[queue.peek()] > arr[i]) {
                queue.pop();
            }
            if (queue.isEmpty()) left[i] = -1;
            else left[i] = queue.peek();
            queue.push(i);
        }
        queue.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!queue.isEmpty() && arr[queue.peek()] >= arr[i]) {
                queue.pop();
            }
            if (queue.isEmpty()) right[i] = arr.length;
            else right[i] = queue.peek();
            queue.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            sum = (sum + (long) arr[i] * (i - left[i]) * (right[i] - i)) % 1000000007;
        }
        return (int)sum;
    }

}
