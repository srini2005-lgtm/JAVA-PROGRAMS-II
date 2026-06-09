import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of test cases
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            
            int pagesNeeded = x - y;
            boolean canBuy = false;
            
            
            for (int i = 0; i < n; i++) {
                int p = scanner.nextInt(); 
                int c = scanner.nextInt(); 
                
                
                if (p >= pagesNeeded && c <= k) {
                    canBuy = true;
                }
            }
            
            
            if (canBuy) {
                System.out.println("LuckyChef");
            } else {
                System.out.println("UnluckyChef");
            }
        }
        
        scanner.close();
    }
}
