import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;

public class Primer3 {
    public static void readAllyByArray(InputStream in) throws IOException {
        byte[] buff = new byte[5];
        while (true) {
            int count = in.read(buff);
            if (count != -1) {
                System.out.println("количество = " + count + ", buff = "
                        + Arrays.toString(buff) + ", str = "
                        + new String(buff, 0, count, "cp1251"));
            } else {
                break;
            }
        }
    }

public static void main(String[] args) throws IOException {
    String fileName = "E:\\MyFile1.txt";
    try (InputStream inFile = new FileInputStream(fileName)) {
        readAllyByArray(inFile);
    } catch (IOException e) {
        System.out.println("Ошибка открытия-закрытия файла " + fileName + e);
    }
}
}
