import java.util.*;

public class LeackyBucket{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Bucket Capacity: ");
        int bucket = in.nextInt();
        System.out.print("Enter Leak Rate: ");
        int rate = in.nextInt();
        System.out.print("Enter Number of Packets: ");
        int n = in.nextInt();

        System.out.println("Time\tPacket\tSent\tRemaining");
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++){
            int packet = new Random().nextInt(10) + 1;
            if (q.size() < bucket) q.add(packet);
            int sent = Math.min(rate, q.isEmpty() ? 0: q.poll());
            System.out.println(i + "\t" + packet + "\t" + sent + "\t" + q.size());
        }
    }
}
