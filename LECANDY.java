import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of test cases
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            
            // Process each test case
            for (int i = 0; i < t; i++) {
                int n = scanner.nextInt();
                int c = scanner.nextInt();
                
                long totalRequiredCandies = 0;
                
                // Read the candies needed for each elephant and calculate the sum
                for (int j = 0; j < n; j++) {
                    totalRequiredCandies += scanner.nextInt();
                }
                
                // Check if the total available candies are enough
                if (c >= totalRequiredCandies) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        scanner.close();
    }
}
