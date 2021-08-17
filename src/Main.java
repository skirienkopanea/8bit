import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File(args[0] + ".txt"));
            Program p = new Program();
            p.readFile(file);
            System.out.println(p);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist at " + (new File(args[0] + ".txt")).getAbsolutePath());
            e.printStackTrace();
        }
    }
}
