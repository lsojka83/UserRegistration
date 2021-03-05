import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

        boolean programIsRunning = true;


        //program loop
        while (programIsRunning) {

            String command , name;
            FileHandler fileHandler = new FileHandler(); //external class for file operations

            int age;

            //regex pattern setup
            String regexAdd = "addUser\\(\"(\\w+)\",(\\d{1,1000})\\)";
            String regexRemove = "removeUser\\(\"(\\w+)\"\\)";


            //
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter:\n<<addUser(\"name\",age)>> to add a new user, \n"
                    +"<<deleteUser(\"name\")>> to remove a user by its name.\n"
                    +"<<showfile>> to view current user list,\n"
                    +"<<quit>> to quit the program.");

            command = scanner.nextLine();

            // check if to add or remove
            Pattern patternAdd = Pattern.compile(regexAdd);
            Matcher matcherAdd = patternAdd.matcher(command);
            Pattern patternRemove = Pattern.compile(regexRemove);
            Matcher matcherRemove = patternRemove.matcher(command);

            // if to add
            boolean isMatchingForAdding = matcherAdd.matches(), isMatchingForRemoving = matcherRemove.matches();
            if (isMatchingForAdding)
            {
                name = matcherAdd.group(1);
                age = Integer.parseInt(matcherAdd.group(2));
                fileHandler.addUserToFile(name, age);
                //  if to remove
            } else if (isMatchingForRemoving)
            {
                name = matcherRemove.group(1);
                fileHandler.removeUserFromFile(name);

            }
            //  show file printout
            else if(command.equals("showfile"))
            {
                fileHandler.showFile();
            }
            //  quit program loop
            else if(command.equals("quit"))
            {
                System.out.println("Quitting");
                programIsRunning = false;
            }

            else
                System.out.println("Incorrect command");

        }
    }


}
