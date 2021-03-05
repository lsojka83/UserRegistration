import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private final String userInput;
    private String command;
    private String name;
    private int age;


    public Validation(String userInput)
    {
        this.userInput = userInput;
        validateCommand(userInput);
    }

    private void validateCommand(String input)
    {
        //regex pattern setup
        String regexAdd = "addUser\\(\"(\\w+)\",(\\d{1,1000})\\)";
        String regexRemove = "removeUser\\(\"(\\w+)\"\\)";

        // check if to add or remove
        Pattern patternAdd = Pattern.compile(regexAdd);
        Matcher matcherAdd = patternAdd.matcher(input);
        Pattern patternRemove = Pattern.compile(regexRemove);
        Matcher matcherRemove = patternRemove.matcher(input);

        boolean isMatchingForAdding = matcherAdd.matches(),
                isMatchingForRemoving = matcherRemove.matches();


        if(isMatchingForAdding) {
            command = "addUser";
            name = matcherAdd.group(1);
            age = Integer.parseInt(matcherAdd.group(2));
        }
        else if(isMatchingForRemoving)
        {
            command = "removeUser";

            name = matcherRemove.group(1);
        }
        else if(userInput.equals("showfile"))
        {
            command = "showfile";
        }
        //  quit program loop
        else if(userInput.equals("quit"))
        {
            command ="quit";
        }
        else command = "Incorrect command";

    }


//    public void setInput(String input) {
//        this.userInput = input;
//    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
