import java.util.ArrayList;


public class StartMenu {

    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    MainMenu menu = new MainMenu();

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
        boolean foundUser = false;

        for (int i = 0; i < user.size(); i++) {
            int counter = 0;
            if (user.get(i).getName().equalsIgnoreCase(inputName)) {
                String inputPassword = this.ui.promptText("Hello " + inputName + ". Enter your password: ");
                if (user.get(i).getPassword().equals(inputPassword)) {
                    foundUser = true;
                    menu.displayMenu(user.get(i));
                } else {
                    while(counter<3) {
                        this.ui.promptText("Password not correct, please try again.");
                        counter++;
                    }
                    if (counter == 3) {
                        this.ui.displayMessage("Access denied. Register new user.");
                        registerUser();
                    }
                }
            }
        }
        if (!foundUser) {
            boolean wantToRetry = ui.promptYesOrNo("Name not found in our database, would you like to re-try? (Y/N)");
            if (wantToRetry) {
                login();
            }
        }
    }


public void registerUser() {
    String userName = this.ui.promptText("Please enter your name: ");
    int userAge = this.ui.promptNumeric("Please enter your age: ");
    this.ui.promptText("");
    String userPassword = this.ui.promptText("Please enter a password: ");
    this.ui.displayMessage("User created.");
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
