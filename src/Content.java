import java.util.ArrayList;
import java.util.Scanner;

public class Content {
    private ArrayList<String> category = new ArrayList<>();
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ArrayList<Show> showList = new ArrayList<>();
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
}
