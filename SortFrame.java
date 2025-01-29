import java.util.*;


class Frame{
    int val;
    String data;

    Frame(int val, String data){
        this.val = val;
        this.data = data;
    }
}


public class SortFrame{
    public static void bubbleSort(Frame[] f){
        for (int i = 0; i < f.length - 1; i++){
            boolean swapped = false;
            for (int j = 0; j < f.length - i - 1; j++){
                if (f[j].val > f[j + 1].val){
                    var tmp = f[j];
                    f[j] = f[j + 1];
                    f[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Frames: ");
        var frames = new Frame[sc.nextInt()];

        for (int i = 0; i < frames.length; i++)
            frames[i] = new Frame(sc.nextInt(), sc.next());
        
        bubbleSort(frames);

        

        for (Frame f: frames)
            System.out.print(f.data + " ");
    }
}
