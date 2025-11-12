import java.util.ArrayList;
import java.util.Scanner;

public class Content {
    private static ArrayList<String> category = new ArrayList<>();
    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Show> showList = new ArrayList<>();
    //private ArrayList<String> movieCategoryList = new ArrayList<>();
    //private ArrayList<String> showCategoryList = new ArrayList<>();
    FileIO io = new FileIO();


    public ArrayList<String> createCategoryList() {
        for (int i = 0; i < movieList.size(); i++) {
            String[] categories = movieList.get(i).getCategory();
            if (!category.contains(categories[0])) {
                category.add(categories[0]);
            } else {
                //skip linje
            }
        }

        for (int j = 0; j < showList.size(); j++) {
            String[] categories = showList.get(j).getCategory();
                if (!category.contains(categories[0])) {
                    category.add(categories[0]);
                } else {
                    //skip linje
                }
            }

        return category;
    }

    public ArrayList<Movie> createMovieList() {
         movieList = io.readMovieFile();
         return movieList;
    }

    public ArrayList<Show> createShowList() {
        showList = io.readShowFile();
        return showList;
    }

    public static ArrayList<String> getCategory() {
        return category;
    }

    public static ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public static ArrayList<Show> getShowList() {
        return showList;
    }
}
