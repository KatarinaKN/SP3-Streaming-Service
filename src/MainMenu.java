import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    User user;
    TextUI ui = new TextUI();
    Content content = new Content();
    ArrayList<String> list = content.getCategory();
    ArrayList<Movie> movieList = content.getMovieList();
    ArrayList<Show> showList = content.getShowList();

    public void displayMenu(User user){
        this.user=user;
        ui.displayMessage("Hello " + user.getName() + " you have the following options: \n \t 1. Display Movies \n \t 2. Display Shows \n \t 3. Search Category \n \t 4. To-Watch Movie List \n \t 5. to-Watch Show List");
        int choice = ui.promptNumeric("Select the number of what you wish to do:");
        switch(choice){
            case 1:
                searchMovie();
                break;
            case 2:
                searchShow();
                break;
            case 3:
                searchCategory();
                break;
            case 4:
                searchMoviesToWatch(user);
                break;
            case 5:
                searchShowsToWatch(user);
                break;
            default:
                ui.displayMessage("Error with selected number.");
                displayMenu(user);
        }
    }

    public void searchMovie(){
        ui.displayMessage("These Movies are available to watch:");
        for (int i=0; i<movieList.size(); i++){
            ui.displayMessage(i+1 + ": " + movieList.get(i));
        }
        int choice = ui.promptNumeric("Select the number of the Movie you wish to watch:");
        play(movieList.get(choice-1));
    }

    public void searchShow(){
        ui.displayMessage("These Shows are available to watch:");
        for (int i=0; i<showList.size(); i++){
            ui.displayMessage(i+1 + ": " + showList.get(i));
        }
        int choice = ui.promptNumeric("Select the number of the Movie you wish to watch:");
        play(showList.get(choice-1));
    }

    public void searchCategory(){
        ui.displayMessage("Please choose a category:");
        for (int i=0; i<list.size(); i++){
            ui.displayMessage(i+1 + list.get(i));
        }
        int input = ui.promptNumeric("Select number of the Category you wish to watch: ");
        try {
            ui.displayMessage("You have selected" + list.get(input-1));
            ui.promptText("");
            String answer = ui.promptText("Do you wish to see a Movie or a Show?:");
            int counter = 0;
            if (answer.equalsIgnoreCase("Movie")) {
                ArrayList<Movie> movieCategoryList = new ArrayList<>();
                for (int j = 0; j < movieList.size(); j++) {
                    Movie movie = movieList.get(j);
                    String[] categories = movie.getCategory();
                    for (int k = 0; k < categories.length; k++) {
                        if (categories[k].equalsIgnoreCase(list.get(input-1))) {
                            counter++;
                            ui.displayMessage(counter + ": " + movie.toString());
                            movieCategoryList.add(movie);
                        }
                    }
                }
                int selection = ui.promptNumeric("Select the number you wish to watch:");
                ui.promptText("");
                String decision = ui.promptText("Watch now or save for later?: (Now/Later): ");
                if (decision.equalsIgnoreCase("Now")){
                    play(movieCategoryList.get(selection-1));
                } else if (decision.equalsIgnoreCase("Later")){
                    ui.displayMessage(movieCategoryList.get(selection-1).getName() + " has been added to your To-See list.");
                    user.addMovieToUserList(movieCategoryList.get(selection-1));
                }

            } else if (answer.equalsIgnoreCase("Show")){
                ArrayList<Show> showCategoryList = new ArrayList<>();
                for (int h = 0; h < showList.size(); h++) {
                    Show show = showList.get(h);
                    String[] categories = show.getCategory();
                    for (int g = 0; g < categories.length; g++) {
                        if (categories[g].equalsIgnoreCase(list.get(input-1))) {
                            counter++;
                            ui.displayMessage(counter + ": " + show.toString());
                            showCategoryList.add(show);
                        }
                    }
                }
                int selection = ui.promptNumeric("Select the number you wish to watch:");
                ui.promptText("");
                String decision = ui.promptText("Watch now or save for later?: (Now/Later): ");
                if (decision.equalsIgnoreCase("Now")){
                    play(showCategoryList.get(selection-1));
                } else if (decision.equalsIgnoreCase("Later")){
                    ui.displayMessage(showCategoryList.get(selection-1).getName() +" has been added to your To-See list.");
                    user.addShowToUserList(showCategoryList.get(selection-1));
                }
            }
        }
        catch (IndexOutOfBoundsException e){
            ui.displayMessage("Error with selected number.");
        }

    }

    public void searchMoviesToWatch(User user){
        ArrayList<Movie> list = user.getMoviesToWatch();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ui.displayMessage(i + 1 + list.get(i).toString());
            }
            int input = ui.promptNumeric("Select number of the Movie you wish to watch:");
            try {
                ui.displayMessage("You have selected " + list.get(input - 1).toString());
                play(list.get(input - 1));
            } catch (IndexOutOfBoundsException e) {
                ui.displayMessage("Error with selected number.");
            }
        } else {
            ui.displayMessage("Movie To-Watch list is empty.");
        }
    }

    public void searchShowsToWatch(User user){
        ArrayList<Show> list = user.getShowsToWatch();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ui.displayMessage(i + 1 + list.get(i).toString());
            }
            int input = ui.promptNumeric("Select number of the Show you wish to watch:");
            try {
                ui.displayMessage("You have selected " + list.get(input - 1).toString());
                play(list.get(input - 1));
            } catch (IndexOutOfBoundsException e) {
                ui.displayMessage("Error with selected number.");
            }
        } else {
            ui.displayMessage("Show To-Watch list is empty.");
        }
    }

    public void play (Media media){
        ui.displayMessage("You are now watching " + media.getName());
        if (media instanceof Movie){
            user.addMovieToHistory((Movie)media);
        } else if (media instanceof Show){
            user.addShowToHistory((Show)media);
        }
    }
}
