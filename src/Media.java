import java.util.ArrayList;

public abstract class Media {
    private String name;
    private int year;
    private ArrayList<String> category;
    private double rating;

public Media (String name, int year, ArrayList<String> category, double rating){
    this.name = name;
    this.year = year;
    this.category = category;
    this.rating = rating;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
