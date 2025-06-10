package axsos.academy;
import java.util.Scanner;

public class Find_the_Earliest_Repeating_Character {




	    // Function to find the first repeating character in the string
	    public static String firstRepChar(String s) {
	        int n = s.length();

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < i; j++) {
	                if (s.charAt(i) == s.charAt(j)) {
	                    return Character.toString(s.charAt(i));
	                }
	            }
	        }

	        return "-1"; // No repeating character
	    }

	    public static void main(String[] args) {
	        try (Scanner scanner = new Scanner(System.in)) {
				String input;

				System.out.println("Enter strings (type 'exit' to quit):");

				while (true) {
				    System.out.print("Input: ");
				    input = scanner.nextLine();

				    if (input.equalsIgnoreCase("exit")) {
				        break;
				    }

				    String result = firstRepChar(input);
				    if (!result.equals("-1")) {
				        System.out.println("First repeating character: " + result);
				    } else {
				        System.out.println("No repeating characters found.");
				    }
				}
			}
	        System.out.println("Program exited.");
	    }
	}
