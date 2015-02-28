package modules;

import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;
import main.MainClass;

public class UserInterface {

    protected static ResourceBundle stringsBundle = null;
    private static PrintWriter out = new PrintWriter(System.out, true);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void init() {chooseLocale();}

    private static void chooseLocale() {
        stringsBundle = ResourceBundle.getBundle("strings_en", Locale.ENGLISH);
        out.println(stringsBundle.getString("START_CHOICE"));

        int choice = 0;
        try {
            choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    stringsBundle = ResourceBundle.getBundle("strings_ru", new Locale("ru", ""));
                    mainMenu();
                    break;
                case 2:
                    mainMenu();
                    break;
                default:
                    out.println(stringsBundle.getString("WRONG_CHOICE")); break;
            }
        }
        catch (NumberFormatException ex) { out.println(stringsBundle.getString("WRONG_CHOICE"));}
        catch (IOException ex) {out.println(stringsBundle.getString("IO_ERROR"));}
    }

    private static void mainMenu() {
        out.println(stringsBundle.getString("MAIN_MENU"));
        int choice = 0;
        try {
            choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    searchMenu();
                    break;
                case 3:
                    showMenu(); break;
                case 4:
                    help(); break;
                case 5:
                    System.exit(0);
                default:
                    out.println(stringsBundle.getString("WRONG_CHOICE")); break;
            }
        }
        catch (NumberFormatException ex) { out.println(stringsBundle.getString("WRONG_CHOICE"));}
        catch (IOException e) { out.println(stringsBundle.getString("IO_ERROR"));}
    }

    private static void addMenu() {
        out.println(stringsBundle.getString("ADD_MENU"));
        int choice = 0;
        try {
            choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    addHoliday(); break;
                case 2:
                    addCountry(); break;
                case 3:
                    mainMenu(); break;
                default:
                    out.println(stringsBundle.getString("WRONG_CHOICE")); break;
            }
        }
        catch (NumberFormatException ex) { out.println(stringsBundle.getString("WRONG_CHOICE"));}
        catch (IOException e) {out.println(stringsBundle.getString("IO_ERROR")); }
    }

    private static void searchMenu() {
        out.println(stringsBundle.getString("SEARCH_MENU"));
        int choice = 0;
        try {
            choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    search(); break;
                case 2:
                    maskSearch(); break;
                case 3:
                    mainMenu(); break;
                default:
                    out.println(stringsBundle.getString("WRONG_CHOICE")); break;
            }
        }
        catch (NumberFormatException ex) { out.println(stringsBundle.getString("WRONG_CHOICE"));}
        catch (IOException e) {out.println(stringsBundle.getString("IO_ERROR")); }
    }

    private static void showMenu() {
        out.println(stringsBundle.getString("SHOW_MENU"));
        int choice = 0;
        try {
            choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    printByToday(); break;
                case 2:
                    printByDate(); break;
                case 3:
                    printByType(); break;
                case 4:
                    printByCountry(); break;
                case 5:
                    printAll(); break;
                case 6:
                    mainMenu(); break;
                default:
                    out.println(stringsBundle.getString("WRONG_CHOICE")); break;
            }
        }
        catch (NumberFormatException ex) { out.println(stringsBundle.getString("WRONG_CHOICE"));}
        catch (IOException e) {out.println(stringsBundle.getString("IO_ERROR")); }
    }

    private static void help() {
        File helpFile;
        if (stringsBundle.getLocale() == Locale.ENGLISH) helpFile = new File("resources\\help_en.txt");
        else helpFile = new File("resources\\help_ru.txt");
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(helpFile));
            while (fileReader.ready()) out.println(fileReader.readLine());
            out.println(stringsBundle.getString("HELP_MENU"));
            int choice = Integer.parseInt(reader.readLine());
            switch(choice) {
                case 1: mainMenu(); break;
                case 2: System.exit(0);
                default: out.println(stringsBundle.getString("WRONG_CHOICE"));
            }
        }
        catch (FileNotFoundException e) {
            out.println(stringsBundle.getString("HELP_FILE_ERROR"));
        }
        catch (IOException e) {
            out.println(stringsBundle.getString("IO_ERROR"));
        }
        catch (NumberFormatException ex) { out.println(stringsBundle.getString("WRONG_CHOICE"));}
    }

    protected static void addHoliday() {}

    protected static void addCountry() {}

    private static void print() {}

    private static void printAll() {
        for (int i = 0; i < MainClass.holidays.size(); i++) {
            out.println(MainClass.holidays.get(i).toString());
        }
    }

    private static void printByCountry() {}

    private static void printByType() {}

    private static void printByToday() {}

    private static void printByDate() {}

    protected static void search() {}

    protected static void maskSearch() {}
}
