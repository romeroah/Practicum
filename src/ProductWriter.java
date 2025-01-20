import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {

    public static void main(String[] args)
    {

        boolean done = false;

        Scanner in = new Scanner(System.in);
        String id;
        String name;
        String desc;
        double cost;
        String rec;

        ArrayList<String> products = new ArrayList <> ();

            do {
                id = SafeInput.getNonZeroLenString(in, "Please enter the product's ID");
                System.out.println("Entered: " + id);
                name = SafeInput.getNonZeroLenString(in, "Please enter the product's name");
                System.out.println("Entered: " + name);
                desc = SafeInput.getNonZeroLenString(in, "Please enter the product's description");
                System.out.println("Entered: " + desc);
                cost = SafeInput.getRangedInt(in, "Please enter the Person's birth year", 1000, 9999);
                System.out.println("Entered: " + cost);

                rec = id+", "+name+", "+desc+", "+cost;
                products.add(rec);
                done = SafeInput.getYNConfirm(in, "Close Program?");

        }while(!done);
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String product : products)
            {
                writer.write(product, 0, product.length());  // stupid syntax for write rec
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
