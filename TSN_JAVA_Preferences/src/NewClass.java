
import java.util.Scanner;

/*

 */
public class NewClass {
    
    public static void main(String[] args){
        System.out.println("Введите число");
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
            for (int j = 1; j<=n;j++){
                if(i == j)
                    System.out.print(i + " ");
                else
                    System.out.print(" 0 ");
                
            }
        System.out.println(" ");
        }
        
    }
}
