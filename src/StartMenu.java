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

        if (!user.isEmpty() && this.ui.promptYesOrNo("Do you have a login? (Y/N)")){
            String inputName = this.ui.promptText("Enter your name: ");
            if (user.contains(inputName)){
                String inputPassword = this.ui.promptText("Enter your password: ");
                //Hvordan tjekker vi, om det er et rigtige password? som også passer til den bruger,
                //der prøver at logge ind...
                //Hvad skal der ske, hvis password er forkert?
                //if (!inputPassword) hvis password er forkert...
                //... bed om password igen. (måske kun tre gange).
            }
            else {
                registerUser();
            }
            //Vælg en bruger fra en liste.
            //noget med at indtaste password og at programmet tjekker, om det stemmer overens... equals...
        }
        else {
            registerUser();
        }
    }

    //hvis ja til at man har login, startsession kald på login-metode

    public void registerUser(){
        String userName = this.ui.promptText("Please enter your name: ");
        int userAge = this.ui.promptNumeric("Please enter your age: ");
        String userPassword = this.ui.promptText("Please enter a password: ");

        User u = new User(userName, userAge, userPassword);
        this.users.add(u);

        this.io.saveUserData(users, "data/user.csv");
    }

    public void displayUser(){
        for(User u : this.users){
            System.out.println(u);
        }
    }

    public void endSession(){
        this.ui.displayMessage("Ending Børge's Streaming Service.");

    }

}
