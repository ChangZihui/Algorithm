import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 10, 2, 3, 4, 5, 6};
        System.out.println(method(nums, 8));
//        System.out.println("hello world");
    }

    public static int method(int[] nums, int num) {
        int a = nums[0];
        int start = 0, end = nums.length - 1;
        int split = 0;
        int max = 0, min = 0;
        while (start < end) {
            int mid = (end - start) / 2;
            int b = nums[mid];
            if (b > nums[mid - 1] && b < nums[mid + 1]) {
                //mid在递增序列里
                if (a > b) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (b < nums[mid - 1]) {
                split = mid;
                max = nums[mid - 1];
                min = b;
                break;
            } else if (b > nums[mid + 1]) {
                split = mid + 1;
                min = nums[mid - 1];
                max = b;
                break;
            }
        }
        //可以先做一个判断
        //在0-split-1上和split到nums.length-1上分别进行二分查找；
        if (num > max || num < min) {
            return -1;
        }
        if (num > nums[0]) {
            //在前半段进行二分查找
            return Arrays.binarySearch(nums, 0, split - 1, num);
        }
        if (num < nums[nums.length - 1]) {
            //在后半段进行二分查找
            return Arrays.binarySearch(nums, split, nums.length - 1, num);
        }
        return -1;
    }
}
