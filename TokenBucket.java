import java.util.*;

public class TokenBucket{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bucket Capacity: ");
        int bucket = sc.nextInt();
        System.out.print("Enter Token generation rate: ");
        int rate = sc.nextInt();
        System.out.print("Enter Number of Cycles: ");
        int n = sc.nextInt();

        int tokens = 0;
        System.out.println("Time\tRequested\tSent\tRemaining");
        for (int i = 1; i <= n; i++){
            tokens = Math.min(bucket, rate + tokens);
            sent = Math.min(rate, tokens);
            tokens -= sent;
            System.out.println(i+"\t"+rate+"\t"+sent+"\t"+tokens);
        }
    }
}
