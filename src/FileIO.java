import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {


    //------Movies og shows bruger IKKE samme metode til at læse fra fil:------
    public ArrayList<Movie> readMovieFile() {
        ArrayList<Movie> movies = new ArrayList<>();
        File file = new File("data/movies.csv");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(";");
                String name = elements[0].trim();
                int year = Integer.parseInt(elements[1]);
                String[] category = elements[2].split(",");
                double rating = elements[3];
                Movie m = new Movie(name,year, category, rating);
                movies.add(m);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet: " +  "("+e.getMessage()+")");
        }
        return movies;
    }

    public ArrayList<Show> readShowFile() {
        ArrayList<Show> shows = new ArrayList<>();
        File file = new File("data/shows.csv");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(";");
                String name = elements[0].trim();
                int year = Integer.parseInt(elements[1]);
                String[] category = elements[2].split(",");
                double rating = elements[3];
                int seasons = Integer.parseInt(elements[4]);
                int episodes = Integer.parseInt(elements[5]);

                Show s = new Show(name,year, category, rating, seasons, episodes);
                shows.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet: " +  "("+e.getMessage()+")");
        }
        return shows;
    }

    //------Movies og shows bruger samme metode til at tilføje til fil:------
    public void addMediaToFile(ArrayList<String> list, String path) {
        try (FileWriter writer = new FileWriter(path, true)) { //append: true tilføjer isf at overskrive
            for (String s : list) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            System.out.println("Fejl under læsning eller skrivning: " + path +  "("+e.getMessage()+")");
        }
    }

    public void saveUserData(ArrayList<User> list, String pathUser) { //HER: indsæt header hvis det er i user.csv
        try (FileWriter writer = new FileWriter(pathUser, true)) {
            for (User u : list) {
                writer.write(u.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Fejl: Brugerdata kunne ikke gemmes til: " + pathUser +  "("+e.getMessage()+")");
        }
    }

    public ArrayList<User> readUser() {
        ArrayList<User> user = new ArrayList<>();
        File file = new File("data/user.csv");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(";");
                String name = elements[0].trim();
                int age = Integer.parseInt(elements[1]);
                String password = elements[2].trim();
                User u = new User(name, age, password);
                user.add(u);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet: " + "data/user.csv" +  "("+e.getMessage()+")");
        }
        return user;
    }


    public void addMovieCsv(ArrayList<String> list, String pathMovie) {
        addMediaToFile(list, pathMovie);
    }

    public void addShowsCsv(ArrayList<String> list, String pathShows) {
        addMediaToFile(list, pathShows);
    }
}
