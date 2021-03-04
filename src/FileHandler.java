import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileHandler {

    //file creation
    String fileName = "user_register.txt";
    File file = null;

    HashMap<String,Integer> userRegisterMap = new HashMap<>();

    public void addUserToFile(String name, int age)
    {
        //open the file
        try
        {
            loadFromFile();

            //check if user exists
            if(userRegisterMap.containsKey(name))
                System.out.println("Such user already exists. Please enter a different name.");

            else {
                userRegisterMap.put(name, age);
                saveToFile();
                System.out.println("Following user added: name: " + name + ", age: " + age);
            }
        }
        catch (Exception e)
        {}
    }

    public void removeUserFromFile(String name)
    {
        try
        {
            //File open
            loadFromFile();

            //check if user exists
            if(userRegisterMap.containsKey(name)) {
                userRegisterMap.remove(name);
                saveToFile();
                System.out.println("Following user removed:" + name);
            }
            else
                System.out.println("No user named: "+name);
        }
        catch (Exception e){}
    }

    public void showFile()
    {
        try
        {
        //uses a Map
            loadFromFile();

            for(Map.Entry<String,Integer> m: userRegisterMap.entrySet())
                System.out.println(m.getKey()+", "+m.getValue());
        }
        catch (Exception e){}
    }

    private void loadFromFile()
    {
        try {
            file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            userRegisterMap = (HashMap<String, Integer>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }
        catch (Exception e){}
    }

    private void saveToFile()
    {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userRegisterMap);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (Exception e){}
        }
}
