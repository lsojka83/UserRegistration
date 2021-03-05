import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean programIsRunning = true;
        String userInput, command , name;
        int age;

        //program loop
        while (programIsRunning) {
            //
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter:\n<<addUser(\"name\",age)>> to add a new user, \n"
                    +"<<deleteUser(\"name\")>> to remove a user by its name.\n"
                    +"<<showfile>> to view current user list,\n"
                    +"<<quit>> to quit the program.");

            userInput = scanner.nextLine();
            FileHandler fileHandler = new FileHandler(); //external class for file operations
            Validation validation = new Validation(userInput);
//            validation.setInput(userInput);

            command = validation.getCommand();
//            System.out.println(command);
            name = validation.getName();
            age = validation.getAge();

            switch (command) {
                case "addUser":             // if to add
                    fileHandler.addUserToFile(name, age);
                    break;

                case "removeUser":                    //  if to remove
                    fileHandler.removeUserFromFile(name);
                    break;
                case "showfile":                //  show file printout
                    fileHandler.showFile();
                    break;
                case "quit":                //  quit program loop
                    System.out.println("Quitting");
                    programIsRunning = false;
                    break;
                case "Incorrect command":
                    System.out.println("Incorrect command");
                    break;
            }
        }
    }
}
