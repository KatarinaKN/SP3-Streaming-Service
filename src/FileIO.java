import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public ArrayList<String> readMovieCsv(String pathMovie) {
        return readMediaFile(pathMovie);
    }

    public ArrayList<String> readShowsCsv(String pathShows) {
        return readMediaFile(pathShows);
    }

    //------Movies og shows bruger samme metode til at læse fra fil:------
    private ArrayList<String> readMediaFile(String path) {
        ArrayList<String> media = new ArrayList<>();
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                media.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet: " + path +  "("+e.getMessage()+")");
        }
        return media;
    }

    public void addMovieCsv(ArrayList<String> list, String pathMovie) {
        addMediaToFile(list, pathMovie);
    }

    public void addShowsCsv(ArrayList<String> list, String pathShows) {
        addMediaToFile(list, pathShows);
    }

    //------Movies og shows bruger samme metode til at tilføje til fil:------
    private void addMediaToFile(ArrayList<String> list, String path) {
        try (FileWriter writer = new FileWriter(path, true)) { //append: true tilføjer isf at overskrive
            for (String s : list) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            System.out.println("Fejl under læsning eller skrivning: " + path +  "("+e.getMessage()+")");
        }
    }

    public void saveUserData(ArrayList<String> list, String pathUser) { //HER: indsæt header hvis det er i user.csv
        try (FileWriter writer = new FileWriter(pathUser, true)) {
            for (String s : list) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            System.out.println("Fejl: Brugerdata kunne ikke gemmes til: " + pathUser +  "("+e.getMessage()+")");
        }
    }

    public ArrayList<String> readUser(String pathUser) {
        ArrayList<String> user = new ArrayList<>();
        File file = new File(pathUser);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                user.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet: " + pathUser +  "("+e.getMessage()+")");
        }
        return user;
    }
}
