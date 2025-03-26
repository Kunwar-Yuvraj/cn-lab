import java.util.*;

public class RED {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Max Packets: ");
        int maxPackets = sc.nextInt();
        System.out.print("Queue Size: ");
        int queueSize = sc.nextInt();
        System.out.print("Max Probability: ");
        double maxProb = sc.nextDouble();
        System.out.print("Min Probability: ");
        double minProb = sc.nextDouble();
        System.out.print("Threshold: ");
        int threshold = sc.nextInt();

        int queueLength = 0;
        for (int i = 1; i <= maxPackets; i++) {
            double dropProb = (queueLength >= threshold) ? minProb + (maxProb - minProb) * (queueLength - threshold) / (queueSize - threshold) : 0;

            if (queueLength >= queueSize || (queueLength >= threshold && rand.nextDouble() < dropProb)) {
                System.out.println("Packet " + i + ": Dropped");
            } else {
                System.out.println("Packet " + i + ": Accepted");
                queueLength++;
            }
        }
        sc.close();
    }
}
