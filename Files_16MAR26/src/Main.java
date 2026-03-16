import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            FileWriter myWriter = new FileWriter("INSTRUCTION/Files_16MAR26/src/filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!\n");
            myWriter.write("another line");
            myWriter.close();  // must close manually
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }


        File myObj = new File("INSTRUCTION/Files_16MAR26/src/filename.txt");

        // Print output in terminal
        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}