// Ques - Find the Kth Largest Integer in the array

public String kthLargestNumber(String[] nums, int k) {
    Arrays.sort(nums, (String num1, String num2) -> {
        if (num1.length() == num2.length()) {
            return num2.compareTo(num1);
        }
        return num2.length() - num1.length();
    });
    
    return nums[k - 1];
}