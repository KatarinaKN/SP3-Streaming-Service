import java.util.ArrayList;

public class StartMenu {

    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    private ArrayList<User> users;
    private int maxUsers;

    public StartMenu (){
        this.users = new ArrayList<>();
    }

    public void startSession(){
        this.ui.displayMessage("Welcome to Børge's Streaming Service");
        ArrayList<String> user = this.io.readUser("data/user.csv");

        if (!user.isEmpty() && ui.promptYesOrNo("Do you have a login? (Y/N)")){
            //Vælg en bruger fra en liste.
            //noget med at indtaste password og at programmet tjekker, om det stemmer overens... equals...
        }
        else {
            registerUser();
        }
    }


    public void registerUser(){
        String userName = this.ui.promptText("Please enter your name: ");
        int userAge = this.ui.promptNumeric("Please enter your age: ");
        String userPassword = this.ui.promptText("Please enter a password: ");

        User u = new User(userName, userAge, userPassword);
        this.users.add(u);
    }

    public void displayUser(){
        for(User u : this.users){
            System.out.println(u);
        }
    }

    public void endSession(){

    }

    //startSession() + login()
    //endSession()
}
