import java.util.ArrayList;
import java.util.Scanner;

public class Content {
    private static ArrayList<String> category;
    private static ArrayList<Movie> movieList;
    private static ArrayList<Show> showList;
    FileIO io = new FileIO();

    public Content (){
        movieList = createMovieList();
        showList = createShowList();
        category = createCategoryList();
    }


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
