import java.util.ArrayList;

public class Show extends Media {

    private int seasons;
    private int episodes;

    public Show(String name, int year, ArrayList<String> category, double rating, int seasons, int episodes) {
        super(name, year, category, rating);
        this.seasons = seasons;
        this.episodes = episodes;
    }
}
