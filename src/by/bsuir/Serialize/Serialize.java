package by.bsuir.Serialize;

import java.io.*;
import java.util.ArrayList;

/**
 * The type Serialize.
 *
 * @param <T> the type parameter
 */
public class Serialize<T> implements ISerialize<T>{

    /**
     * Deserialize array list.
     *
     * @param filePath the file path
     * @return the array list
     */
    @SuppressWarnings("unchecked")
    public ArrayList<T> deserialize(String filePath){
        ArrayList<T> list = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            list = (ArrayList<T>)in.readObject();

            in.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return list;
    }

    /**
     * Serialize.
     *
     * @param filePath the file path
     * @param list     the list
     */
    public void serialize(String filePath, ArrayList<T> list){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(list);

            out.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
