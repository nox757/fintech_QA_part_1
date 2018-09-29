import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final Random rd = new Random();

    public static String randName() {
        int length = rd.nextInt(20) + 1;
        return rd.ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());
    }

    public static void createRandFolderWithTxt() {
        File dir = new File(randName());
        dir.mkdir();
        try {
            new File(dir, randName() + ".txt").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createRandFolderWithTxt();
    }
}
