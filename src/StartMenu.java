import java.util.ArrayList;

public class StartMenu {

    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    private ArrayList<User> users;
    private int maxUsers;

    public StartMenu() {
        this.users = new ArrayList<>();
    }

    public void startSession() {
        this.ui.displayMessage("Welcome to Børge's Streaming Service");
        ArrayList<User> user = this.io.readUser();
        if (!user.isEmpty() && this.ui.promptYesOrNo("Do you have a login? (Y/N)")) {
            login();

        } else {
            registerUser();
        }

    }

    public void login() {
        String inputName = this.ui.promptText("Enter your name: ");
        ArrayList<User> user = this.io.readUser();

        if (user.contains(inputName)) {
            String inputPassword = this.ui.promptText("Hello " + inputName + ". Enter your password: ");
            if (user.contains(inputPassword)) {
                displayMenu();

            } else {
                for (int i = 0; i < 2; i++) {
                    this.ui.promptText("Password not correct, please try again");
                }

                this.ui.displayMessage("Access denied.");
                this.ui.promptYesOrNo(" Would you like to create a user? (Y/N)");
                registerUser();
            }
        }

        //Hvordan tjekker vi, om det er et rigtige password? som også passer til den bruger,
        //der prøver at logge ind...


    }


public void registerUser() {
    String userName = this.ui.promptText("Please enter your name: ");
    int userAge = this.ui.promptNumeric("Please enter your age: ");
    String userPassword = this.ui.promptText("Please enter a password: ");

    User u = new User(userName, userAge, userPassword);
    this.users.add(u);

    this.io.saveUserData(users, "data/user.csv");
}

public void displayUser() {
    for (User u : this.users) {
        System.out.println(u);
    }
}

public void endSession() {
    this.ui.displayMessage("Ending Børge's Streaming Service.");

}

}
