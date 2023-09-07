import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Person_Generator {
    public static void main(String[] args) {

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        String persRec = "";
        String ID = "";
        String fName = "";
        String lName = "";
        String title = "";
        int YOB = 0;

        boolean done = false;
        Scanner  in = new Scanner(System.in);
        ArrayList<Person> PersonData = new ArrayList<>();

        do {
            ID = SafeInput.getNonZeroLenString(in, "Please enter your ID number");
            fName = SafeInput.getNonZeroLenString(in, "Please enter your first name");
            lName = SafeInput.getNonZeroLenString(in, "Please enter your last name");
            title = SafeInput.getNonZeroLenString(in, "Please enter your title (Mr, Mrs, Ms, etc.) ");
            YOB = SafeInput.getRangedInt(in, "Enter your year of birth", 1950, 2005);


            Person toAdd = new Person(ID, fName, lName, title, YOB);

            done = SafeInput.getYNConfirm(in, "Are you done?");

            PersonData.add(toAdd);

            System.out.println(toAdd.getFullName());

            System.out.println(toAdd.getFormalName());

            System.out.println(toAdd.getAge());

            System.out.println(toAdd.getAge());

        }while(!done);

        for(Person p: PersonData)
            System.out.println(p);

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Person p : PersonData)
            {
                persRec = p.toCSV();
                writer.write(persRec,0, persRec.length());  // stupid syntax for write rec
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

