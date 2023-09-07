import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Product_Generator {
    public static void main(String[] args) {

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        String itemRec = "";
        String ID = "";
        String name = "";
        String description = "";
        double cost = 0;

        boolean done = false;
        Scanner  in = new Scanner(System.in);
        ArrayList<Product> ProductData = new ArrayList<>();

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the item ID");
            name = SafeInput.getNonZeroLenString(in, "Enter the item name");
            description = SafeInput.getNonZeroLenString(in, "Enter a description of the item");
            cost = SafeInput.getDouble(in, "Enter item cost");


            Product toAdd = new Product(ID, name, description, cost);

            done = SafeInput.getYNConfirm(in, "Are you done?");

            ProductData.add(toAdd);

            System.out.println(toAdd.getproductName());

            System.out.println(toAdd.toCSV());

            System.out.println(toAdd.getDescription());

            System.out.println(toAdd.getCost());

        }while(!done);

        for(Product p: ProductData)
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

            for(Product p : ProductData)
            {
                itemRec = p.toCSV();
                writer.write(itemRec,0, itemRec.length());  // stupid syntax for write rec
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