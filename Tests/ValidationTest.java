import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationTest {

    String[] expectedCommand = {"addUser","removeUser",
            "showfile", "quit",
            "Incorrect command","Incorrect command",
            "Incorrect command",  "Incorrect command"},
            
    expectedName = {"Peter", "Peter", null, null, null, null, null, null},

            acctualCommand = new String[]{
                    new Validation("addUser(\"Peter\",15)").getCommand(),
                    new Validation("removeUser(\"Peter\")").getCommand(),
                    new Validation("showfile").getCommand(),
                    new Validation("quit").getCommand(),
                    new Validation("werwerfsf").getCommand(),
                    new Validation("addUser(Peter,15)").getCommand(),
                    new Validation("addUser(Peter,15").getCommand(),
                    new Validation("addUser(\"Peter\",scsdc)").getCommand(),
                    },
             acctualName = new String[]{
                     new Validation("addUser(\"Peter\",15)").getName(),
                     new Validation("removeUser(\"Peter\")").getName(),
                     new Validation("showfile").getName(),
                     new Validation("quit").getName(),
                     new Validation("werwerfsf").getName(),
                     new Validation("addUser(Peter,15)").getName(),
                     new Validation("addUser(Peter,15").getName(),
                     new Validation("addUser(\"Peter\",scsdc)").getName(),
                };


    @Test
    public void getCommand() throws Exception{
              assertArrayEquals(expectedCommand, acctualCommand);
                  }

    @Test
    public void getName() throws Exception{
        assertArrayEquals(expectedName, acctualName);
    }

    @Test
    public void getAge() throws Exception
    {

    }
}