import java.util.ArrayList;
import java.util.Scanner;

public class Content {
    private ArrayList<String> category;
    private ArrayList<Movie> movieList;
    private ArrayList<Show> showList;
    private ArrayList<String> movieCategoryList = new ArrayList<>();
    private ArrayList<String> showCategoryList = new ArrayList<>();
    FileIO io = new FileIO();

    public Content (ArrayList<String> categories){
        this.category = new ArrayList<>();
        movieList = createMovieList();
        showList = createShowList();
    }

    public ArrayList<String> createCategoryList(){
        for(int i = 0; i<movieList.size() ; i++) {
            // movie getters
            // check om listen har den
        }
        for (int i = 0; i<showList.size(); i++) {
            // show getters
            // check om lisdten har den
        }
            //HVIS kategori ikke allerede er på vores arraylist
            //TILFØJ til arraylist

    }

    public void createMovieList() {
         movieList = io.readMovieFile();

    }

    public void createShowList() {
        ArrayList<Show> showList = this.io.readShowsCsv("data/shows.csv");
        //skal vi ændre ArrayList<Show> til ArrayList<String>? Hvis ikke, skal noget ændres i FileIO.

    }
}
