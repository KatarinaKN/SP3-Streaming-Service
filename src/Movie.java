import java.util.ArrayList;

public class Movie extends Media {

    TextUI ui = new TextUI();
    private int year;

    public Movie (String name, int year, String[] category, double rating){
        this.year = year;
        super(name, category, rating);
    }

    public String toString(){
        String msg =  super.getName() + ", " + year + ",";
        for (String s: super.getCategory()){
            msg += s+",";
        }
        msg += " "+super.getRating();
        return msg;
    }
}
