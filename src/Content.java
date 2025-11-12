import java.util.ArrayList;
import java.util.Scanner;

public class Content {
    private static ArrayList<String> category = new ArrayList<>();
    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Show> showList = new ArrayList<>();
    FileIO io = new FileIO();

    public Content (){
        movieList = createMovieList();
        showList = createShowList();
        category = createCategoryList();
    }


    public ArrayList<String> createCategoryList() {
        for (int i = 0; i < movieList.size(); i++) {
            String[] categories = movieList.get(i).getCategory();
            for (int h = 0; h < categories.length; h++) {
                if (!category.contains(categories[h])) {
                    category.add(categories[h]);
                }
            }
            for (int j = 0; j < showList.size(); j++) {
                String[] showCategories = showList.get(j).getCategory();
                for (int g = 0; g < showCategories.length; g++) {
                    if (!category.contains(showCategories[g])) {
                        category.add(showCategories[g]);
                    }
                }
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
