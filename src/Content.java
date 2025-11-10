import java.util.ArrayList;
import java.util.Scanner;

public class Content {
    private ArrayList<String> category;
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ArrayList<Show> showList = new ArrayList<>();
    FileIO io = new FileIO();

    public Content (ArrayList<String> categories){
        this.category = new ArrayList<>();
    }

    public ArrayList<String> createCategoryList(){
        for(int i = 0;  ; i++){
            io.readMediaFile("data/movies.csv");
            io.readMediaFile("data/shows.csv");
            ArrayList<String> category = new ArrayList<>();

            //Scanner scanner = new Scanner()
            //if ()

            //løb liste igennem (med fileio)
            //HVIS kategori ikke allerede er på vores arraylist
            //TILFØJ til arraylist

        }
    }

    public void createMovieList() {
        ArrayList<Movie> movieList = this.io.readMovieCsv("data/movies.csv");
        //skal vi ændre ArrayList<Movie> til ArrayList<String>? Hvis ikke, skal noget ændres i FileIO.

    }

    public void createShowList() {
        ArrayList<Show> showList = this.io.readShowsCsv("data/shows.csv");
        //skal vi ændre ArrayList<Show> til ArrayList<String>? Hvis ikke, skal noget ændres i FileIO.

    }

    //scanForCategory() Hvad skal denne her metode gøre/bruges til?
}
