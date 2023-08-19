// Euclidean Algorithm


import java.util.Scanner;

class GcdSolution{

    public int gcd(int a, int b){
        if(a == 0) return b;
        else{
            return gcd(b%a, a);
        }
    }

    public void findgcd(int a,int b){
        int ans = gcd(a, b);
        System.out.println(ans);
    }
}

public class gcd {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        GcdSolution solution = new GcdSolution();
        solution.findgcd(a,b);
        
    }
}
