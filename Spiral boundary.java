import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String tLine = br.readLine();
        if (tLine == null) return;
        int t = Integer.parseInt(tLine.trim());
        
        StringBuilder output = new StringBuilder();
        
        while (t-- > 0) {
            // Read matrix dimensions: N (rows) and M (columns)
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[][] matrix = new int[n][m];
            
            // Populate the matrix
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // Set up boundaries
            int top = 0, bottom = n - 1;
            int left = 0, right = m - 1;
            
            // Traverse in a spiral path
            while (top <= bottom && left <= right) {
                // 1. Left to Right
                for (int i = left; i <= right; i++) {
                    output.append(matrix[top][i]).append(" ");
                }
                top++;
                
                // 2. Top to Bottom
                for (int i = top; i <= bottom; i++) {
                    output.append(matrix[i][right]).append(" ");
                }
                right--;
                
                // 3. Right to Left (only if rows remain)
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        output.append(matrix[bottom][i]).append(" ");
                    }
                    bottom--;
                }
                
                // 4. Bottom to Top (only if columns remain)
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        output.append(matrix[i][left]).append(" ");
                    }
                    left++;
                }
            }
            output.append("\n"); // Move to next line for the next testcase
        }
        
        // Print everything to standard output at once
        System.out.print(output);
    }
}
