package testing;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.ArrayList;



public class Promo {
	public static void main(String[] args) throws Exception {
		
		// 1 reverse string
		String str = " Java is a simple langauge ";
		System.out.println(" 1.  Reverse The String :" + reverse(str));

		// 2 palindrome
		System.out.println(" 2. Check Palindrome :" + palindrome("Gagag"));

		// 3 count words
		System.out.println(" 3. Count of no : " + wordCount(str));

		// 4 Square root
		System.out.println(" 4. Squre root : " + squareRoot(49));

		// 5Non Repeating Number in Array
		Integer[] arr = { 1, 2, 3, 5, 5, 2, 1, 8, 8, 9, 0, 9, 0 };
		System.out.println(" 5. Non Repeating Number in Array : " + singleNo(arr));

		// 6 Check Two String Are Anagram String
		System.out.println(" 6. Check Two String Are Anagram String : " + anagram("as", "sa"));

		// 7 Fibionaci series
		System.out.println(" 7. Fibionaci series : " + fibionaci(9));

		// 8 Count Frequency Of Characters In String
		System.out.println(" 8. Count Frequency Of Characters In String : " + countChar(str));

		// 9 Non Repeating Characters In String
		System.out.println(" 9. Non Repeating Characters In String : " + nonRepeatingChar(str));

		// 10 Is No Is Automorphic
		System.out.println(" 10. Is No Is Automorphic : " + noIsAutomorphic(25));

		// 11 Sort Withoutusing sirt method
		System.out.println(" 11. Sort Without Using Sort Method : " + bubbleSort(arr));

		// 12 Remove Space From String
		System.out.println(" 12. Remove Space From String : " + removeSpace(str));

		// 13 Factorial With Recursion
		System.out.println(" 13 Factorial of " + 5 + " is " + factorial(5));

		// 14 Climbing Stairs with 1 and 2 at a time
		System.out.println(
				" 14 No  Of Ways To Climb " + 29 + " Stairs using 1 and 2 step at a time " + " is " + climbStairs(29));

		// 15 Rotate Array to Left n Times
		System.out.println(" 15 Rotate Array to Left " + 8 + " Times" + Arrays.asList(rotateArray(arr, 15)));

	}

	// 1 reverse string
	private static String reverse(String str) {
		String output = "";
		for (char i : str.toCharArray()) {
			output = i + output;
		}
		return output;
	}

	// 2 palimdrome
	private static boolean palindrome(String str) {
		StringBuffer buff = new StringBuffer(str);
		return buff.reverse().toString().equalsIgnoreCase(str);
	}

	// 3 word count
	private static int wordCount(String str) {
		System.out.println(str.replaceAll( "[^a-zA-Z0-9]",""));
		return str.trim().split(" ").length;
	}

	// 4 Square root of no
	private static double squareRoot(int no) {
		return Math.sqrt(no);
	}

	// 5 Non Repeating Number in Array
	private static int singleNo(Integer[] arr) {
		int output = 0;
		for (int i : arr) {
			output ^= i;
		}
		return output;
	}

	// 6 Check Two String Are Anagram String
	private static boolean anagram(String str1, String str2) {
		String[] arr1 = str1.split("");
		String[] arr2 = str2.split("");
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
	}

	// 7 Fibionaci Series
	private static List<Integer> fibionaci(int num) {
		int a = 0;
		int b = 1;
		int next;
		List<Integer> output = new ArrayList<>();
		output.add(a);
		output.add(b);
		for (int i = 2; i < num; i++) {
			next = a + b;
			a = b;
			b = next;
			output.add(next);
		}
		return output;

	}

	// 8 Count Frequency Of Characters In String
	private static Map<String, Long> countChar(String str) {

		return Arrays.asList(str.split("")).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	// 9 Non Repeating Characters In String
	private static List<String> nonRepeatingChar(String str) {
		Map<String, Long> map = Arrays.asList(str.split("")).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return map.entrySet().stream().filter((a) -> a.getValue() == 1).map((a) -> a.getKey())
				.collect(Collectors.toList());
	}

	// 10 Is No Is Automorphic
	private static boolean noIsAutomorphic(int i) {
		String no = Integer.toString(i);
		String noSq = Integer.toString(i * i);
		return no.contains(noSq.substring(noSq.length() - no.length(), noSq.length()));
	}

	// 11 Sort Without Using Sort Method
	private static List<Integer> bubbleSort(Integer[] arr) {

		int length = arr.length;
		int extra = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (arr[i] < arr[j]) {
					extra = arr[i];
					arr[i] = arr[j];
					arr[j] = extra;
				}
			}
		}
		return Arrays.asList(arr);
	}
 
	// 12 Remove Space From String
	private static String removeSpace(String str) {
		return String.join("", str.trim().split(" "));
	}

	// 13 Factorial with Recursion
	private static int factorial(int n) {
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}

	// 14 Climbing Stairs with 1 and 2 at a time
	private static int climbStairs(int n) {
		if (n <= 1) {
			return n;
		}
		int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}

	// 15 Rotate Array to Left n Times
	private static Integer[] rotateArray(Integer[] arr, int n) {
		if (n >= arr.length) {
			if (n % arr.length == 0) {
				return arr;
			}
			n = n % arr.length;
		}

		arr = reverse(arr, 0, arr.length - 1);
		arr = reverse(arr, 0, arr.length - 1 - n);
		arr = reverse(arr, arr.length - n, arr.length - 1);

		return arr;
	}

	// Function to Reverse Array
	private static Integer[] reverse(Integer[] arr, int start, int end) {

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

		return arr;

	}

}