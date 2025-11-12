import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    TextUI ui = new TextUI();
    ArrayList<String> list = Content.getCategory();
    ArrayList<Movie> movieList = Content.getMovieList();
    ArrayList<Show> showList = Content.getShowList();

    public void displayMenu(User user){
        ui.displayMessage("Hello " + user.getName() + " you have the following options: \n \t 1. Display Movies \n \t 2. Display Shows \n \t + 3. Search Category \n \t 4. To-Watch Movie List \n \t 5. to-Watch Show List");
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
                searchMoviesToWatch(this.user);
                break;
            case 5:
                searchShowsToWatch(this.user);
                break;
            default:
                ui.displayMessage("Error with selected number.");
        }
    }

    public void searchMovie(){
        ui.displayMessage("These Movies are available to watch:");
        for (Movie m: movieList){
            ui.displayMessage(m.toString());
        }
    }

    public void searchShow(){
        ui.displayMessage("These Shows are available to watch:");
        for (Show s: showList){
            ui.displayMessage(s.toString());
        }
    }

    public void searchCategory(){
        for (int i=0; i<list.size(); i++){
            ui.displayMessage(i+1 + list.get(i));
        }
        int input = ui.promptNumeric("Select number of the Category you wish to watch:");
        try {
            ui.displayMessage("You have selected " + list.get(input-1));
        }
        catch (IndexOutOfBoundsException e){
            ui.displayMessage("Error with selected number.");
        }
        String answer = ui.promptText("Do you wish to see a Movie or a Show?:");
        if (answer.equalsIgnoreCase("Movie")) {
            ArrayList<Movie> movieCategoryList = new ArrayList<>();
            for (int j = 0; j < movieList.size(); j++) {
                Movie movie = movieList.get(j);
                String[] categories = movie.getCategory();
                for (int k = 0; k < categories.length; k++) {
                    if (categories[k].equalsIgnoreCase(list.get(input-1))) {
                        ui.displayMessage(j+1 + movie.toString());
                        movieCategoryList.add(movie);
                    }
                }
            }
            int selection = ui.promptNumeric("Select the number you wish to watch:");
            play(movieList.get(selection));
        } else if (answer.equalsIgnoreCase("Show")){
            ArrayList<Show> showCategoryList = new ArrayList<>();
            for (int h = 0; h < showList.size(); h++) {
                Show show = showList.get(h);
                String[] categories = show.getCategory();
                for (int g = 0; g < categories.length; g++) {
                    if (categories[g].equalsIgnoreCase(list.get(input-1))) {
                        ui.displayMessage(h+1 + show.toString());
                        showCategoryList.add(show);
                    }
                }
            }
            int selection = ui.promptNumeric("Select the number you wish to watch:");
            play(showList.get(selection));
        }
    }

    public void searchMoviesToWatch(User user){
        ArrayList<Movie> list = user.getMoviesToWatch();
        for (int i=0; i<list.size(); i++){
            ui.displayMessage(i+1 + list.get(i).toString());
        }
        int input = ui.promptNumeric("Select number of the Movie you wish to watch:");
        try {
            ui.displayMessage("You have selected " + list.get(input-1).toString());
            play(list.get(input-1));
        }
        catch (IndexOutOfBoundsException e){
            ui.displayMessage("Error with selected number.");
        }
    }

    public void searchShowsToWatch(User user){
        ArrayList<Show> list = user.getShowsToWatch();
        for (int i=0; i<list.size(); i++){
            ui.displayMessage(i+1 + list.get(i).toString());
        }
        int input = ui.promptNumeric("Select number of the Show you wish to watch:");
        try {
            ui.displayMessage("You have selected " + list.get(input-1).toString());
            play(list.get(input-1));
        }
        catch (IndexOutOfBoundsException e){
            ui.displayMessage("Error with selected number.");
        }
    }

    public void play (Media media){
        ui.displayMessage("you are now watching " + media.getName());
    }
}
