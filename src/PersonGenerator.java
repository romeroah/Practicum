import java.util.ArrayList;
import java.util.Scanner;

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

                people.add(id+", "+fName+", "+lName+", "+title+", "+birthYear);
                done = SafeInput.getYNConfirm(in, "Close Program? [Y/N]");

        }while(!done);
    }
}
