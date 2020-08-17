package essential;

import java.util.Scanner;

/**
 * Created by Asus on 24.10.2019.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        String a = Integer.toString(x1);
        int u = a.length()-1;
        int x2 = x1>>u<<u;
        if(x1==x2){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

}
