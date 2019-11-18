package by.bsuir;

import by.bsuir.autobase.entity.*;
import by.bsuir.autobase.presentation.View;

import java.io.*;

public class Main {

    public static void main(String[] args){

        View.chooseActionLoop();

    }

    private static AutoBase loadAutoBase()
    {
        try(
                // Reading the object from a file
                FileInputStream file = new FileInputStream("AutoBase.ser");
                ObjectInputStream in = new ObjectInputStream(file);
                )
        {
            // Method for deserialization of object
            return (AutoBase)in.readObject();
        }

        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    // Method for serialization of object
    private static void saveAutoBase(AutoBase autoBase)
    {
        try(
                //Saving the object in a file
                FileOutputStream file = new FileOutputStream("AutoBase.ser");
                ObjectOutputStream out = new ObjectOutputStream(file);
                )
        {
            out.writeObject(autoBase);
        }

        catch(IOException ex)
        {

            System.out.println(ex.getMessage());
        }


    }
}
