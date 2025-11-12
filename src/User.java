import java.util.ArrayList;


public class User {
    private String name;
    private int age;
    private String password;
    private ArrayList<Movie> moviesToWatch;
    private ArrayList<Show> showsToWatch;
    private ArrayList<Movie> movieHistory;
    private ArrayList<Show> showHistory;
    TextUI ui = new TextUI();

    public User(String name, int age, String password){
        this.name = name;
        this.age = age;
        this.password = password;
        moviesToWatch = new ArrayList<>();
        showsToWatch = new ArrayList<>();
        movieHistory = new ArrayList<>();
        showHistory = new ArrayList<>();
    }

    public void addMovieToUserList(Movie movie){
        if (!moviesToWatch.contains(movie)){
            moviesToWatch.add(movie);
        }
    }

    public void addShowToUserList(Show show){
        if (!showsToWatch.contains(show)){
            showsToWatch.add(show);
        }
    }

    public void addMovieToHistory(Movie movie){
        if (!movieHistory.contains(movie)){
            movieHistory.add(movie);
        }
    }

    public void addShowToHistory(Show show){
        if (!showHistory.contains(show)){
            showHistory.add(show);
        }
    }

    //Bør ligge i MainMenu. Kommunikation med brugeren skal ligge i forretningskoden,
    //så den ikke er afhængig af, at man har instantieret en bruger.
    public void displayToWatch(){
        while(true) {
            String answer = ui.promptText("Display Movie or Show list? (Movie/Show): ");
            if (answer.equalsIgnoreCase("movie")) {
                for (Movie m : moviesToWatch) {
                    ui.displayMessage(m.toString());
                }
                break;
            } else if (answer.equalsIgnoreCase("show")) {
                for (Show s : showsToWatch) {
                    ui.displayMessage(s.toString());
                }
                break;
            } else {
                ui.displayMessage("Please choose between Movie or Show.");
            }
        }
    }

    public void displayHistory(){
        while(true) {
            String answer = ui.promptText("Display Movie history or Show history?? (Movie/Show): ");
            if (answer.equalsIgnoreCase("movie")) {
                for (Movie m : movieHistory) {
                    ui.displayMessage(m.toString());
                }
                break;
            } else if (answer.equalsIgnoreCase("show")) {
                for (Show s : showHistory) {
                    ui.displayMessage(s.toString());
                }
                break;
            } else {
                ui.displayMessage("Please choose between Movie or Show.");
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Movie> getMoviesToWatch() {
        return moviesToWatch;
    }

    public void setMoviesToWatch(ArrayList<Movie> moviesToWatch) {
        this.moviesToWatch = moviesToWatch;
    }

    public ArrayList<Show> getShowsToWatch() {
        return showsToWatch;
    }

    public void setShowsToWatch(ArrayList<Show> showsToWatch) {
        this.showsToWatch = showsToWatch;
    }

    public ArrayList<Movie> getMovieHistory() {
        return movieHistory;
    }

    public void setMovieHistory(ArrayList<Movie> movieHistory) {
        this.movieHistory = movieHistory;
    }

    public ArrayList<Show> getShowHistory() {
        return showHistory;
    }

    public void setShowHistory(ArrayList<Show> showHistory) {
        this.showHistory = showHistory;
    }

    public String toString(){
        return name +";" + age + ";" + password;
    }
}
