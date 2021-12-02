import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 
 */
public class SetColors {


    /**
     * Given an array nums with n objects colored red, white, or blue, 
     * sort them in-place so that objects of the same color are adjacent, 
     * with the colors in the order red, white, and blue.
     * 
     * 87 / 87 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * Memory Usage: 37.5 MB
     * 
     * Execution: O(n) - Space: O(n)
     */
    static public void sortColors0(int[] nums) {
        
        // **** sanity checks ****
        if (nums.length == 1) return;

        // **** initialization ****
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // **** insert int[] nums contents into the priority queue - O(n) ****
        for (int n : nums) pq.add(n);

        // **** copy contents from pq into nums - O(n) ****
        for (int i = 0; !pq.isEmpty(); i++)
            nums[i] = pq.remove();
    }


    /**
     * Given an array nums with n objects colored red, white, or blue, 
     * sort them in-place so that objects of the same color are adjacent, 
     * with the colors in the order red, white, and blue.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 37.3 MB, less than 98.13% of Java online submissions.
     * 
     * 87 / 87 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms
     * Memory Usage: 37.3 MB
     * 
     * Runtime: O(n) - Space: O(1)
     */
    static public void sortColors(int[] nums) {
        
        // **** sanity checks ****
        if (nums.length == 1) return;

        // **** initialization ****
        int len = nums.length;
        int c0  = 0;
        int c1  = 0;
        int c2  = 0;

        // **** count colors - O(n) ****
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) c0++;
            else if (nums[i] == 1) c1++;
            else c2++;
        }

        // ???? ????
        System.out.println("<<< c0: " + c0 + " c1: " + c1 + " c2: " + c2);

        // **** clear nums (all entries are red) ****
        Arrays.fill(nums, 0);

        // **** restore white ***
        if (c1 != 0) Arrays.fill(nums, c0, c0 + c1, 1);

        // ???? ????
        System.out.println("<<< nums: " + Arrays.toString(nums));

        // **** restore blue ****
        if (c2 != 0) Arrays.fill(nums, c0 + c1, len, 2);
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read int[] nums ****
        int[] nums = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<<   nums: " + Arrays.toString(nums));

        // **** call function of interest ****
        sortColors(nums);

        // **** display int[] nums array ****
        System.out.println("main <<< output: " + Arrays.toString(nums));
    }
}