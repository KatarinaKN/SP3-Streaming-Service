import java.util.ArrayList;

public class Media {
    private String name;
    private int year;
    private ArrayList<String> category;
    private double rating;

    public Media(String name, int year, ArrayList<String> category, double rating) {
        this.name = name;
        this.year= year;
        this.category = category;
        this.rating = rating;
    }
}
