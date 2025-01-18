import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {

    public static void main(String[] args)
    {

        boolean done = false;

        Scanner in = new Scanner(System.in);
        String id;
        String fName;
        String lName;
        String title;
        int birthYear;
        String rec;

        ArrayList<String> people = new ArrayList <> ();

            do {
                id = SafeInput.getNonZeroLenString(in, "Please enter the Person's ID");
                System.out.println("Entered: " + id);
                fName = SafeInput.getNonZeroLenString(in, "Please enter the Person's first name");
                System.out.println("Entered: " + fName);
                lName = SafeInput.getNonZeroLenString(in, "Please enter the Person's last name");
                System.out.println("Entered: " + lName);
                title = SafeInput.getNonZeroLenString(in, "Please enter the Person's title");
                System.out.println("Entered: " + title);
                birthYear = SafeInput.getRangedInt(in, "Please enter the Person's birth year", 1000, 9999);
                System.out.println("Entered: " + birthYear);

                rec = id+", "+fName+", "+lName+", "+title+", "+birthYear;
                people.add(rec);
                done = SafeInput.getYNConfirm(in, "Close Program?");

        }while(!done);
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String person : people)
            {
                writer.write(person, 0, person.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // person. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
