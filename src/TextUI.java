import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {

    Scanner scanner = new Scanner(System.in);

    //viser tekst til brugeren.
    public void displayMessage(String msg){
        System.out.println(msg);
    }

    //promptBinary Hvorfor hedder den binary, når det ikke er 0 og 1?...
    //jeg har (midlertidigt) omdøbt den, fordi dens oprindelige navn forvirrede mig :)
    public boolean promptYesOrNo(String msg){
        displayMessage(msg);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Y")){
            return true;
        }
        else if (input.equalsIgnoreCase("N")){
            return false;
        }
        else {
            displayMessage("Answer Y or N");
            return promptYesOrNo(msg);
        }
    }

    //beder brugeren om et tal.
    public int promptNumeric(String msg){
        displayMessage(msg);
        int input = scanner.nextInt();
        return input;

        /* eller
        return scanner.nextInt();
         */
    }

    //beder brugeren om et tekst-svar (kan bruges ved oprettelse af ny bruger og ved søgning efter film/serier?)
    public String promptText(String msg){
        displayMessage(msg);
        String input = scanner.nextLine();
        return input;
    }

}
