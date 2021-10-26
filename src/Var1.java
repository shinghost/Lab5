import java.io.*;
import java.util.Scanner;

public class Var1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DataOutputStream dout = null;
        DataInputStream din = null;
        DataOutputStream dout2 = null;
        DataInputStream din2 = null;
        try {
            File f1 = new File("src.txt");
            if (f1.exists()) f1.delete();
            f1.createNewFile();
            dout = new DataOutputStream(new FileOutputStream(f1));
            System.out.println("количество чисел: ");
            int count = sc.nextInt();
            System.out.println("введите числa: ");
            for (int i = 0; i < count; i++) {
                int k = sc.nextInt();
                dout.writeInt(k);
            }
            File f2 = new File("result.txt");
            if (f2.exists()) f2.delete();
            f2.createNewFile();
            dout2 = new DataOutputStream(new FileOutputStream(f2));
            din = new DataInputStream(new FileInputStream(f1));

            int n = 0;
            for (int i = 0; i < count; i++) {
                int k = din.readInt();
                if (k % 2 == 0) {
                    dout2.writeInt(k);
                    n++;
                }
            }
            if (n != 0) {
                din2 = new DataInputStream(new FileInputStream(f2));
                System.out.println("Четные числа: ");
                for (int j = 0; j < n; j++) {
                    System.out.println(din2.readInt());
                }
            }
        }
        catch(IOException io){
            io.printStackTrace();
        }
        finally{
            dout.flush();
            dout.close();
            din.close();
            din2.close();
            dout2.flush();
            dout2.close();
        }
    }
}