import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private final ArrayList<Line> lines = new ArrayList<Line>();

    public void addLine(Line line) {
        if (getLines() > 15) {
            throw new IllegalArgumentException("Too many code lines");
        }
        lines.add(line);
    }

    public int getLines() {
        return lines.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("address: contents    # assembly\n" +
                "---------------------------------\n");
        for (Line l : lines) {
            result.append(l.toString() + "\n");
        }
        return result.toString();
    }

    public void readFile(Scanner sc) {

        while (sc.hasNextLine()) {
            Scanner line = new Scanner(sc.nextLine());
            if (line.hasNextInt()) {
                addLine(new Line(getLines(), line.nextInt()));
            } else if (line.hasNext()) {
                Opcode instruction = Opcode.NULL;
                try {
                    instruction =
                            Opcode.valueOf(line.next());
                } catch (IllegalArgumentException e) {

                }
                int operand = 0;
                if (line.hasNextInt()) {
                    operand = line.nextInt();
                }
                addLine(new Line(getLines(), instruction, operand));
            }
        }
    }

    public void writeFile(String outputFileName) {
        try {
            PrintWriter writer = new PrintWriter(outputFileName + ".txt");
            StringBuilder file = new StringBuilder(this.toString());
            writer.print(file);
            writer.close();
            System.out.println("Saved as " + outputFileName + ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("Output file could not be saved. " + e.getMessage());
        }
    }
}
