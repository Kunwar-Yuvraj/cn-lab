import java.util.*;

public class CRC16CCITT{
    public static String crc16(String data, String poly){
        int crc = 0b1111111111111111;

        for (char c: data.toCharArray()){
            crc ^= (crc << 8);
            for (int i = 0; i < 8; i++){
                if ((crc & 0b1000000000000000) != 0)
                    crc = (crc << 1) ^ Integer.parseInt(poly, 2);
                else
                    crc = (crc << 1);

                crc &= 0b1111111111111111;
            }

        }

        return String.format("%16s", Integer.toBinaryString(crc)).replace(' ', '0');
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String msg = sc.nextLine();
        System.out.print("Enter generator code: ");
        String gen = sc.nextLine();

        String checksum = crc16(msg, gen);
        System.out.println("Checksum generated: " + checksum);

        System.out.print("Enter received checksum: ");
        String rcvChecksum = sc.nextLine();
        System.out.print("Enter generator code: ");
        String rcvGen = sc.nextLine();

        if (rcvGen.equals(gen) && rcvChecksum.equals(checksum))
            System.out.println("Data is valid!");
        else
            System.out.print("Data is invalid!");

        sc.close();
    }
}
