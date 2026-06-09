import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            String expr = sc.next();
            System.out.println(convertToRPN(expr));
        }
        sc.close();
    }

    public static String convertToRPN(String expr) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            
            if (Character.isLetter(c)) {
                output.append(c);
            } 
            
            else if (c == '(') {
                stack.push(c);
            } 
            
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            } 
            
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    output.append(stack.pop());
                }
                stack.push(c);
            }
        }

        
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    private static int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1; // For '('
        }
    }
}
