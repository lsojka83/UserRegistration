import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileHandler {

    //file setup
    String fileName = "user_register.bin";
    File file;

    public FileHandler()
    {
        file = new File(fileName);
    }

    boolean fileExists = false;

    HashMap<String,Integer> userRegisterMap = new HashMap<>();

    public void addUserToFile(String name, int age)
    {
        //open the file

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

    public void removeUserFromFile(String name)
    {
        //File open
            loadFromFile();

            if(fileExists)

            //check if user exists
            if(userRegisterMap.containsKey(name)) {
                userRegisterMap.remove(name);
                saveToFile();
                System.out.println("Following user removed:" + name);
            }

            else
                System.out.println("No user named: "+name);

    }

    public void showFile()
    {

            loadFromFile();
            for(Map.Entry<String,Integer> m: userRegisterMap.entrySet())
                System.out.println(m.getKey()+", "+m.getValue());

    }

    private void loadFromFile() {

        if (chechIfFileExist()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            userRegisterMap = (HashMap<String, Integer>) objectInputStream.readObject();
                userRegisterMap = (HashMap<String, Integer>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                System.out.println("Can't load to file.");
            }
        }
        else
            System.out.println("File doesn't exist.");

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

            if(!fileExists)
                System.out.println("Creating a file.");
        }
        catch (Exception e){
            System.out.println("Can't save to file.");
        }
    }

    private boolean chechIfFileExist()
    {
        fileExists = file.exists();
        return fileExists;
    }
}
