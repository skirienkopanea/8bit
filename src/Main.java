import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //If no arg, then prompt input name on terminal, if arg, then take arg
        //if 2 args save it with arg name, if no second arg then don't save

        String inputFileName = "";
        if (args.length > 0) {
            inputFileName = args[0];
        } else {
            Scanner input = new Scanner(System.in);
            input.useDelimiter("\n");
            System.out.print("Enter file name: ");

            inputFileName = input.next();
        }

        String outputFileName = null;
        if (args.length > 1) {
            outputFileName = args[1];
        }

        try {
            Scanner file = new Scanner(new File(inputFileName + ".txt"));
            Program p = new Program();
            p.readFile(file);
            System.out.println(p);
            if (outputFileName != null) {
                p.writeFile(outputFileName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found at " + (new File(inputFileName + ".txt")).getAbsolutePath());
            e.printStackTrace();
        }
    }
}
