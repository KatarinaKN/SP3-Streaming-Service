import java.util.ArrayList;

public class Show extends Media {

    private String duration;
    private String seasons;

    public Show(String name, String year, String[] category, double rating, String seasons) {
        super(name, category, rating);
        this.duration = year;
        this.seasons = seasons;
    }

    public String toString(){
        String msg =  super.getName() + ", " + duration + ", ";
        for (String s: super.getCategory()){
            msg += s+", ";
        }
        msg += super.getRating() +", ";
        msg += seasons;
        return msg;
    }
}
